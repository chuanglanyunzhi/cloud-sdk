package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 253 国际短信服务 SDK 入口。
 */
public class IntSmsClient implements AutoCloseable {

    private static final String SUBMIT_PATH = "/intsms/v2/sms/submit";

    private static final String BALANCE_PATH = "/intsms/v2/balance/getinfo";

    private static final String COST_PATH = "/intsms/v2/fee/getlist";

    private static final String PRICE_PATH = "/intsms/v2/prices/getlist";

    private final IntSmsConfig config;
    private final HttpTransport httpTransport;
    private final ObjectMapper objectMapper;
    /** 仅当自行创建 httpTransport 时才在 close() 中释放，避免误关闭外部注入的共享连接池。 */
    private final boolean ownsTransport;

    public IntSmsClient(IntSmsConfig config) {
        this(config, null);
    }

    public IntSmsClient(IntSmsConfig config, HttpTransport httpTransport) {
        if (config == null) {
            throw new IllegalArgumentException("IntSmsConfig must not be null");
        }
        this.config = config;
        this.ownsTransport = httpTransport == null;
        this.httpTransport = httpTransport != null ? httpTransport : new HttpTransport();
        this.objectMapper = CloudSdkModel.getMapper();
    }

    /**
     * 释放本实例自行创建的底层 OkHttp 连接池；若 httpTransport 由外部注入则不关闭。
     */
    @Override
    public void close() {
        if (ownsTransport) {
            httpTransport.close();
        }
    }

    /**
     * 国际短信发送（单条 / 批量）。
     */
    public IntSmsSubmitResponse submit(String appId, String appSecret, String endpoint, IntSmsSubmitRequest request) throws CloudSdkException {
        return submit(appId, appSecret, endpoint, request, null);
    }

    /**
     * 国际短信发送（单条 / 批量），支持自定义链路追踪 ID。
     */
    public IntSmsSubmitResponse submit(String appId, String appSecret, String endpoint, IntSmsSubmitRequest request, String traceId) throws CloudSdkException {
        validateEndpoint(endpoint);
        validateSubmitRequest(request);
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + SUBMIT_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IntSmsSubmitResponse.class);
    }

    /**
     * 账户余额查询。
     */
    public IntSmsBalanceResponse balanceQuery(String appId, String appSecret, String endpoint, IntSmsBalanceRequest request) throws CloudSdkException {
        return balanceQuery(appId, appSecret, endpoint, request, null);
    }

    /**
     * 账户余额查询，支持自定义链路追踪 ID。
     */
    public IntSmsBalanceResponse balanceQuery(String appId, String appSecret, String endpoint, IntSmsBalanceRequest request, String traceId) throws CloudSdkException {
        validateEndpoint(endpoint);
        validateBalanceRequest(request);
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + BALANCE_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IntSmsBalanceResponse.class);
    }

    /**
     * 账户消耗查询。
     */
    public IntSmsCostResponse costQuery(String appId, String appSecret, String endpoint, IntSmsCostRequest request) throws CloudSdkException {
        return costQuery(appId, appSecret, endpoint, request, null);
    }

    /**
     * 账户消耗查询，支持自定义链路追踪 ID。
     */
    public IntSmsCostResponse costQuery(String appId, String appSecret, String endpoint, IntSmsCostRequest request, String traceId) throws CloudSdkException {
        validateEndpoint(endpoint);
        validateCostRequest(request);
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + COST_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IntSmsCostResponse.class);
    }

    /**
     * 发送价格查询。
     */
    public IntSmsPriceResponse priceQuery(String appId, String appSecret, String endpoint, IntSmsPriceRequest request) throws CloudSdkException {
        return priceQuery(appId, appSecret, endpoint, request, null);
    }

    /**
     * 发送价格查询，支持自定义链路追踪 ID。
     */
    public IntSmsPriceResponse priceQuery(String appId, String appSecret, String endpoint, IntSmsPriceRequest request, String traceId) throws CloudSdkException {
        validateEndpoint(endpoint);
        validatePriceRequest(request);
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + PRICE_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IntSmsPriceResponse.class);
    }

    private SyncResponse execute(String appId, String appSecret, String url, String body, String traceId) throws CloudSdkException {
        validateCredentials(appId, appSecret);

        RuntimeOptions runtime = new RuntimeOptions();
        if (config.getConnectTimeout() != null) {
            runtime.setConnectTimeout(config.getConnectTimeout());
        }
        if (config.getReadTimeout() != null) {
            runtime.setReadTimeout(config.getReadTimeout());
        }
        RetryPolicy retryPolicy = new ExponentialBackoffRetryPolicy(
                runtime.getMaxAttempts(), runtime.getBackoffPeriod(), runtime.getMaxBackoff());

        // 每次重试重新签名，刷新 Nonce/CurTime/CheckSum
        return httpTransport.send(
                () -> buildSignedRequest(appId, appSecret, url, body, traceId),
                runtime, retryPolicy);
    }

    private Request buildSignedRequest(String appId, String appSecret, String url, String body, String traceId) {
        String nonce = IntSmsSignatureUtil.generateNonce();
        String curTime = IntSmsSignatureUtil.currentTimestamp();
        String checksum = IntSmsSignatureUtil.checksum(appSecret, nonce, curTime);

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("AppID", appId);
        headers.put("Nonce", nonce);
        headers.put("CurTime", curTime);
        headers.put("CheckSum", checksum);
        if (traceId != null && !traceId.isEmpty()) {
            headers.put("X-Custom-TraceId", traceId);
        }

        return Request.builder()
                .method("POST")
                .url(url)
                .headers(headers)
                .body(body)
                .build();
    }

    private String serializeRequest(Object request) throws CloudSdkException {
        try {
            return objectMapper.writeValueAsString(request);
        } catch (Exception e) {
            throw new CloudSdkException("SerializeRequestError", "请求体序列化失败: " + e.getMessage(), null, 0, e);
        }
    }

    private <T extends IntSmsCommonResponse> T parseResponse(String body, Class<T> responseClass) throws CloudSdkException {
        if (body == null || body.isEmpty()) {
            body = "{}";
        }
        try {
            Map<String, Object> map = CloudSdkModel.parseJson(body);
            // 兼容部分失败响应使用 message 字段的场景
            if (!map.containsKey("msg") && map.containsKey("message")) {
                map.put("msg", map.get("message"));
            }
            return objectMapper.convertValue(map, responseClass);
        } catch (Exception e) {
            throw new CloudSdkException("ParseResponseError", "响应解析失败: " + e.getMessage(), null, 0, e);
        }
    }

    private void validateSubmitRequest(IntSmsSubmitRequest request) {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IntSmsSubmitRequest 不能为空", null, 0);
        }
        if (request.getProductType() == null || request.getProductType().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "productType 不能为空", null, 0);
        }
        if (request.getMessage() == null || request.getMessage().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "message 不能为空", null, 0);
        }
        if (request.getPhoneNumbers() == null || request.getPhoneNumbers().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "phoneNumbers 不能为空", null, 0);
        }
    }

    private void validateCostRequest(IntSmsCostRequest request) {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IntSmsCostRequest 不能为空", null, 0);
        }
        if (request.getProductType() == null || request.getProductType().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "productType 不能为空", null, 0);
        }
        if (request.getStartDate() == null || request.getStartDate().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "startDate 不能为空", null, 0);
        }
        if (request.getEndDate() == null || request.getEndDate().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "endDate 不能为空", null, 0);
        }
    }

    private void validateBalanceRequest(IntSmsBalanceRequest request) {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IntSmsBalanceRequest 不能为空", null, 0);
        }
        if (request.getProductType() == null || request.getProductType().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "productType 不能为空", null, 0);
        }
    }

    private void validatePriceRequest(IntSmsPriceRequest request) {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IntSmsPriceRequest 不能为空", null, 0);
        }
        if (request.getProductType() == null || request.getProductType().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "productType 不能为空", null, 0);
        }
    }
    private void validateEndpoint(String endpoint) {
        if (endpoint == null || endpoint.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "endpoint 不能为空", null, 0);
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
