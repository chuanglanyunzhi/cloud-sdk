package com.chuanglan.cloudsdk.core;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;
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
        StringBuilder sb = new StringBuilder();
        sb.append("[CloudSdk HTTP Request] method=").append(httpRequest.method())
                .append(", url=").append(httpRequest.url());
        okhttp3.Headers headers = httpRequest.headers();
        sb.append(", headers={");
        for (String name : headers.names()) {
            sb.append(name).append("=").append(headers.values(name)).append(", ");
        }
        sb.append("}");
        sb.append(", body=").append(body != null ? body : "");
        LOGGER.info(sb.toString());
    }

    private void logResponse(int statusCode, Map<String, String> headers, String body) {
        StringBuilder sb = new StringBuilder();
        sb.append("[CloudSdk HTTP Response] status=").append(statusCode)
                .append(", headers=").append(headers)
                .append(", body=").append(body != null ? body : "");
        LOGGER.info(sb.toString());
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
