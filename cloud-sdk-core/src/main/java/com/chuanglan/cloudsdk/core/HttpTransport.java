package com.chuanglan.cloudsdk.core;

import okhttp3.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import java.util.logging.Logger;

/**
 * HTTP 传输层，基于 OkHttp 3/4。
 */
public class HttpTransport {

    private static final Logger LOGGER = Logger.getLogger(HttpTransport.class.getName());

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

    private final Map<String, OkHttpClient> clientCache = new ConcurrentHashMap<>();

    public HttpTransport() {
    }

    /**
     * 同步发送请求，内置重试。
     */
    public SyncResponse send(Request request, RuntimeOptions runtime, RetryPolicy retryPolicy) throws CloudSdkException {
        int attempt = 0;
        Exception lastException = null;
        while (attempt < retryPolicy.maxAttempts()) {
            attempt++;
            try {
                return doSend(request, runtime);
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
     * 异步发送请求。
     */
    public CompletableFuture<SyncResponse> sendAsync(Request request, RuntimeOptions runtime) {
        CompletableFuture<SyncResponse> future = new CompletableFuture<>();
        OkHttpClient client = getClient(runtime);
        okhttp3.Request httpRequest = buildHttpRequest(request, runtime);
        logRequest(httpRequest, request.getBody());
        client.newCall(httpRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LOGGER.warning("[CloudSdk HTTP Response] 异步请求失败: " + e.getMessage());
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

    private OkHttpClient getClient(RuntimeOptions runtime) {
        long connectTimeout = runtime.getConnectTimeout().toMillis();
        long readTimeout = runtime.getReadTimeout().toMillis();
        String key = connectTimeout + ":" + readTimeout;
        return clientCache.computeIfAbsent(key, k -> new OkHttpClient.Builder()
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .build());
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
            throw new CloudSdkException(code, "HTTP " + statusCode + ": " + body, requestId, statusCode);
        }
        return new SyncResponse(statusCode, headers, body);
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
}
