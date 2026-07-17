package com.chuanglan.cloudsdk.core;

import okhttp3.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import java.util.logging.Logger;

/**
 * HTTP 传输层，基于 OkHttp 3/4。
 *
 * <p>内部维护单一共享 {@link OkHttpClient}，不同请求通过 {@link OkHttpClient#newBuilder()} 派生，
 * 共享底层连接池与 Dispatcher，仅覆盖超时配置，避免为每个超时组合创建独立连接池。
 *
 * <p>默认配置面向高并发场景：
 * <ul>
 *     <li>连接池：50 个空闲连接，5 分钟 keep-alive</li>
 *     <li>Dispatcher：maxRequests=200，maxRequestsPerHost=100</li>
 *     <li>callTimeout：默认 30s（可由 {@link RuntimeOptions#getCallTimeout()} 覆盖），防止请求永久挂起</li>
 *     <li>retryOnConnectionFailure=false（SDK 层已重试，避免与 OkHttp 自带重试叠加）</li>
 * </ul>
 *
 * <p>实现 {@link AutoCloseable}，业务方应在生命周期结束时调用 {@link #close()} 释放连接池
 * 与 Dispatcher 线程池。
 */
public class HttpTransport implements AutoCloseable {

    private static final Logger LOGGER = Logger.getLogger(HttpTransport.class.getName());

    /** 默认连接池空闲连接数（OkHttp 默认 5，对高并发场景不足）。 */
    private static final int DEFAULT_MAX_IDLE_CONNECTIONS = 50;
    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 5 * 60 * 1000L;

    /** 默认 Dispatcher 并发上限（OkHttp 默认 maxRequests=64, perHost=5）。 */
    private static final int DEFAULT_MAX_REQUESTS = 200;
    private static final int DEFAULT_MAX_REQUESTS_PER_HOST = 100;

    /**
     * 系统属性开关：设置为 true 时输出完整 headers 与 body（包含敏感字段），仅用于本地调试。
     * 默认关闭，避免敏感数据（手机号、身份证号、CheckSum 等）泄露到生产日志。
     */
    private static final boolean FULL_LOG = Boolean.getBoolean("cloudsdk.log.fullBody");

    /**
     * 敏感请求头名称（小写匹配），日志输出时做部分遮蔽。
     */
    private static final Set<String> SENSITIVE_HEADERS = new HashSet<>(Arrays.asList(
            "appid", "checksum", "signature", "authorization", "cookie", "set-cookie",
            "x-custom-traceid", "appkey", "appsecret", "token"
    ));

    /**
     * 异常 message 中 body 的最大保留长度，超过此长度则只记录 bodySize，避免敏感信息泄露到日志。
     */
    private static final int ERROR_BODY_LIMIT = 200;

    /** close 时等待 Dispatcher 优雅退出的最大时长。 */
    private static final long CLOSE_AWAIT_MS = 5000L;

    private final OkHttpClient sharedClient;
    private final boolean ownedClient;

    public HttpTransport() {
        this.sharedClient = buildDefaultClient();
        this.ownedClient = true;
    }

    /**
     * 注入自定义 OkHttpClient（测试或高级用法）。调用方负责关闭传入的 client。
     */
    public HttpTransport(OkHttpClient sharedClient) {
        this.sharedClient = sharedClient;
        this.ownedClient = false;
    }

    private static OkHttpClient buildDefaultClient() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(DEFAULT_MAX_REQUESTS);
        dispatcher.setMaxRequestsPerHost(DEFAULT_MAX_REQUESTS_PER_HOST);

        return new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(
                        DEFAULT_MAX_IDLE_CONNECTIONS,
                        DEFAULT_KEEP_ALIVE_DURATION_MS,
                        TimeUnit.MILLISECONDS))
                .dispatcher(dispatcher)
                .retryOnConnectionFailure(false)  // SDK 层已重试，避免与 OkHttp 自带重试叠加
                .build();
    }

    /**
     * 同步发送请求，内置重试。每次重试会重新调用 {@code requestSupplier.get()} 取最新 Request，
     * 业务方可在 supplier 中刷新签名（如 Nonce/CurTime/CheckSum）以规避服务端时间窗校验失败。
     */
    public SyncResponse send(Supplier<Request> requestSupplier, RuntimeOptions runtime, RetryPolicy retryPolicy) throws CloudSdkException {
        int attempt = 0;
        Exception lastException = null;
        while (attempt < retryPolicy.maxAttempts()) {
            attempt++;
            try {
                return doSend(requestSupplier.get(), runtime);
            } catch (Exception e) {
                lastException = e;
                if (!retryPolicy.shouldRetry(e, attempt)) {
                    break;
                }
                if (attempt < retryPolicy.maxAttempts()) {
                    sleep(retryPolicy.computeDelay(attempt));
                }
            }
        }
        if (lastException instanceof CloudSdkException) {
            throw (CloudSdkException) lastException;
        }
        throw new CloudSdkException("RequestError",
                "请求最终失败，已尝试 " + attempt + " 次: " + lastException.getMessage(),
                null, 0, lastException);
    }

    /**
     * 同步发送请求（兼容旧 API）。重试时使用同一 Request 对象，签名不会刷新。
     * 新代码建议使用 {@link #send(Supplier, RuntimeOptions, RetryPolicy)} 以支持重试时重新签名。
     */
    public SyncResponse send(Request request, RuntimeOptions runtime, RetryPolicy retryPolicy) throws CloudSdkException {
        return send(() -> request, runtime, retryPolicy);
    }

    /**
     * 异步发送请求。底层通过 {@code callTimeout} 防止请求永久挂起。
     */
    public CompletableFuture<SyncResponse> sendAsync(Request request, RuntimeOptions runtime) {
        return sendAsync(() -> request, runtime);
    }

    /**
     * 异步发送请求（supplier 版本，便于将来扩展重试）。
     */
    public CompletableFuture<SyncResponse> sendAsync(Supplier<Request> requestSupplier, RuntimeOptions runtime) {
        CompletableFuture<SyncResponse> future = new CompletableFuture<>();
        Request request = requestSupplier.get();
        OkHttpClient client = getClient(runtime);
        okhttp3.Request httpRequest = buildHttpRequest(request, runtime);
        logRequest(httpRequest, request.getBody());
        client.newCall(httpRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LOGGER.warning("[CloudSdk HTTP Response] 异步请求失败 url="
                        + httpRequest.url() + ", error=" + e.getMessage());
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                try {
                    future.complete(handleResponse(response));
                } catch (CloudSdkException e) {
                    future.completeExceptionally(e);
                }
            }
        });
        return future;
    }

    private SyncResponse doSend(Request request, RuntimeOptions runtime) throws IOException, CloudSdkException {
        OkHttpClient client = getClient(runtime);
        okhttp3.Request httpRequest = buildHttpRequest(request, runtime);
        logRequest(httpRequest, request.getBody());
        try (okhttp3.Response response = client.newCall(httpRequest).execute()) {
            return handleResponse(response);
        }
    }

    /**
     * 通过 {@link OkHttpClient#newBuilder()} 派生新的 client，仅覆盖超时配置；
     * 底层连接池与 Dispatcher 仍由 {@link #sharedClient} 共享。
     */
    private OkHttpClient getClient(RuntimeOptions runtime) {
        long connectTimeout = runtime.getConnectTimeout().toMillis();
        long readTimeout = runtime.getReadTimeout().toMillis();
        OkHttpClient.Builder builder = sharedClient.newBuilder()
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(readTimeout, TimeUnit.MILLISECONDS);
        Duration callTimeout = runtime.getCallTimeout();
        if (callTimeout != null) {
            builder.callTimeout(callTimeout.toMillis(), TimeUnit.MILLISECONDS);
        }
        return builder.build();
    }

    private okhttp3.Request buildHttpRequest(Request request, RuntimeOptions runtime) {
        String fullUrl = buildUrl(request);
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder()
                .url(fullUrl);

        // 默认请求头，调用方可以覆盖
        builder.header("Accept", "application/json");
        builder.header("User-Agent", "chuanglan-cloud-sdk-java/1.0.0");
        if (request.getHeaders() != null) {
            request.getHeaders().forEach(builder::header);
        }

        String method = request.getMethod().toUpperCase();
        String body = request.getBody();
        if (body == null || body.isEmpty()) {
            builder.method(method, null);
        } else {
            String contentType = request.getHeaders() != null ? request.getHeaders().get("Content-Type") : null;
            if (contentType == null) {
                contentType = "application/x-www-form-urlencoded";
                builder.header("Content-Type", contentType);
            }
            builder.method(method, RequestBody.create(MediaType.parse(contentType), body));
        }
        return builder.build();
    }

    private String buildUrl(Request request) {
        String url = request.getUrl();
        if (request.getQuery() != null && !request.getQuery().isEmpty()) {
            String query = request.getQuery().entrySet().stream()
                    .map(e -> e.getKey() + "=" + e.getValue())
                    .collect(Collectors.joining("&"));
            url = url + (url.contains("?") ? "&" : "?") + query;
        }
        return url;
    }

    private SyncResponse handleResponse(okhttp3.Response response) throws IOException, CloudSdkException {
        int statusCode = response.code();
        Map<String, String> headers = response.headers().toMultimap().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> String.join(",", e.getValue())));
        String body;
        try (okhttp3.ResponseBody responseBody = response.body()) {
            body = responseBody != null ? responseBody.string() : "";
        }
        logResponse(statusCode, headers, body);
        if (statusCode >= 400) {
            String code = "HttpError";
            String requestId = null;
            try {
                Map<String, Object> err = CloudSdkModel.parseJson(body);
                code = getStringIgnoreCase(err, "code", "HttpError");
                requestId = getStringIgnoreCase(err, "requestId", null);
            } catch (CloudSdkException ignored) {
                // body 不是 JSON，使用默认错误码
            }
            throw new CloudSdkException(code, buildErrorMessage(statusCode, code, body), requestId, statusCode);
        }
        return new SyncResponse(statusCode, headers, body);
    }

    /**
     * 构造异常 message：完整 body 较长时只保留长度，避免敏感字段（手机号、身份证号等）泄露到日志。
     */
    private static String buildErrorMessage(int statusCode, String code, String body) {
        if (body == null || body.isEmpty()) {
            return "HTTP " + statusCode + " (" + code + ")";
        }
        if (body.length() <= ERROR_BODY_LIMIT) {
            return "HTTP " + statusCode + " (" + code + "): " + body;
        }
        return "HTTP " + statusCode + " (" + code + "), bodySize=" + body.length();
    }

    private String getStringIgnoreCase(Map<String, Object> map, String key, String defaultValue) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(key) && entry.getValue() != null) {
                return entry.getValue().toString();
            }
        }
        return defaultValue;
    }

    private void logRequest(okhttp3.Request httpRequest, String body) {
        String method = httpRequest.method();
        String url = httpRequest.url().toString();
        int bodySize = body == null ? 0 : body.length();

        if (FULL_LOG) {
            LOGGER.info("[CloudSdk HTTP Request] method=" + method
                    + ", url=" + url
                    + ", headers=" + formatHeaders(httpRequest.headers(), false)
                    + ", body=" + (body != null ? body : ""));
        } else {
            LOGGER.info("[CloudSdk HTTP Request] method=" + method
                    + ", url=" + url
                    + ", bodySize=" + bodySize);
            if (LOGGER.isLoggable(java.util.logging.Level.FINE)) {
                LOGGER.fine("[CloudSdk HTTP Request Detail] headers="
                        + formatHeaders(httpRequest.headers(), true));
            }
        }
    }

    private void logResponse(int statusCode, Map<String, String> headers, String body) {
        int bodySize = body == null ? 0 : body.length();

        if (FULL_LOG) {
            LOGGER.info("[CloudSdk HTTP Response] status=" + statusCode
                    + ", headers=" + headers
                    + ", body=" + (body != null ? body : ""));
        } else {
            LOGGER.info("[CloudSdk HTTP Response] status=" + statusCode
                    + ", bodySize=" + bodySize);
            if (LOGGER.isLoggable(java.util.logging.Level.FINE)) {
                LOGGER.fine("[CloudSdk HTTP Response Detail] body="
                        + (body != null ? body : ""));
            }
        }
    }

    private String formatHeaders(okhttp3.Headers headers, boolean mask) {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (String name : headers.names()) {
            if (!first) {
                sb.append(", ");
            }
            first = false;
            String value = String.join(",", headers.values(name));
            sb.append(name).append("=").append(mask ? maskHeader(name, value) : value);
        }
        return sb.append("}").toString();
    }

    private static String maskHeader(String name, String value) {
        if (name == null || value == null) {
            return value;
        }
        if (!SENSITIVE_HEADERS.contains(name.toLowerCase())) {
            return value;
        }
        if (value.length() <= 8) {
            return "***";
        }
        return value.substring(0, 4) + "***" + value.substring(value.length() - 4);
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 释放底层连接池与 Dispatcher 线程池，等待最多 5 秒让在飞请求完成。
     * 仅当本实例拥有 client（默认构造）时才关闭，注入 client 的场景由调用方负责关闭。
     */
    @Override
    public void close() {
        if (!ownedClient) {
            return;
        }
        sharedClient.connectionPool().evictAll();
        ExecutorService es = sharedClient.dispatcher().executorService();
        es.shutdown();
        try {
            if (!es.awaitTermination(CLOSE_AWAIT_MS, TimeUnit.MILLISECONDS)) {
                es.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            es.shutdownNow();
        }
    }
}
