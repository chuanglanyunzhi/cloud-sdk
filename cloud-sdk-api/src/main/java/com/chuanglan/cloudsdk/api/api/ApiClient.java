package com.chuanglan.cloudsdk.api.api;

import com.chuanglan.cloudsdk.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * API 业务 SDK 客户端基类，封装通用请求发送、序列化与响应解析逻辑。
 */
public abstract class ApiClient<C extends ApiConfig> {

    protected final C config;
    protected final HttpTransport httpTransport;
    protected final ObjectMapper objectMapper;

    protected ApiClient(C config) {
        this(config, null);
    }

    protected ApiClient(C config, HttpTransport httpTransport) {
        if (config == null) {
            throw new IllegalArgumentException("config must not be null");
        }
        this.config = config;
        this.httpTransport = httpTransport != null ? httpTransport : new HttpTransport();
        this.objectMapper = CloudSdkModel.getMapper();
    }

    /**
     * 执行 JSON 请求，默认 Content-Type 为 application/json; charset=utf-8。
     */
    protected SyncResponse execute(String appId, String appSecret, String url, String body, String traceId) throws CloudSdkException {
        return execute(appId, appSecret, url, body, traceId, "application/json; charset=utf-8");
    }

    /**
     * 执行请求，可指定 Content-Type。
     *
     * <p>每次重试时通过 {@link java.util.function.Supplier} 重新构造 Request，
     * 即重新生成 Nonce/CurTime/CheckSum，避免重试到第 N 次时 CurTime 已超出服务端允许的时间窗。
     */
    protected SyncResponse execute(String appId, String appSecret, String url, String body, String traceId, String contentType) throws CloudSdkException {
        validateCredentials(appId, appSecret);

        RuntimeOptions runtime = new RuntimeOptions();
        if (config.connectTimeout != null) {
            runtime.connectTimeout = config.connectTimeout;
        }
        if (config.readTimeout != null) {
            runtime.readTimeout = config.readTimeout;
        }
        RetryPolicy retryPolicy = new ExponentialBackoffRetryPolicy(
                runtime.getMaxAttempts(), runtime.getBackoffPeriod(), runtime.getMaxBackoff());

        return httpTransport.send(
                () -> buildSignedRequest(appId, appSecret, url, body, traceId, contentType),
                runtime, retryPolicy);
    }

    /**
     * 构造已签名的 Request。每次重试都会调用一次，签名相关字段（Nonce/CurTime/CheckSum）会刷新。
     */
    private Request buildSignedRequest(String appId, String appSecret, String url,
                                       String body, String traceId, String contentType) {
        Map<String, String> headers = ApiSignatureUtil.generateHeaders(appId, appSecret, traceId);
        headers.put("Content-Type", contentType);

        return Request.builder()
                .method("POST")
                .url(url)
                .headers(headers)
                .body(body)
                .build();
    }

    protected String serializeRequest(Object request) throws CloudSdkException {
        try {
            return objectMapper.writeValueAsString(request);
        } catch (Exception e) {
            throw new CloudSdkException("SerializeRequestError", "请求体序列化失败: " + e.getMessage(), null, 0, e);
        }
    }

    protected <T extends ApiCommonResponse> T parseResponse(String body, Class<T> responseClass) throws CloudSdkException {
        if (body == null || body.isEmpty()) {
            try {
                T response = responseClass.getDeclaredConstructor().newInstance();
                response.setCode("EmptyResponse");
                response.setMsg("响应体为空");
                return response;
            } catch (Exception e) {
                throw new CloudSdkException("ParseResponseError", "响应解析失败: " + e.getMessage(), null, 0, e);
            }
        }
        try {
            Map<String, Object> map = CloudSdkModel.parseJson(body);
            if (!map.containsKey("msg") && map.containsKey("message")) {
                map.put("msg", map.get("message"));
            }
            return objectMapper.convertValue(map, responseClass);
        } catch (Exception e) {
            throw new CloudSdkException("ParseResponseError", "响应解析失败: " + e.getMessage(), null, 0, e);
        }
    }

    private void validateCredentials(String appId, String appSecret) {
        if (appId == null || appId.isEmpty()) {
            throw new IllegalArgumentException("appId must not be empty");
        }
        if (appSecret == null || appSecret.isEmpty()) {
            throw new IllegalArgumentException("appSecret must not be empty");
        }
    }
}
