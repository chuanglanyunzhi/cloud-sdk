package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 253 国际短信服务 SDK 入口。
 */
public class IntSmsClient {

    private static final String SUBMIT_PATH = "/intsms/v2/sms/submit";

    private static final String BALANCE_PATH = "/intsms/v2/accounts/balance/getinfo";

    private static final String COST_PATH = "/intsms/v2/accounts/costs/getlist";

    private static final String PRICE_PATH = "/intsms/v2/prices/getlist";

    private static final String REPORT_PULL_PATH = "/intsms/v2/pull/report";

    private static final String REPLY_PULL_PATH = "/intsms/v2/pull/mo";

    private final IntSmsConfig config;
    private final HttpTransport httpTransport;
    private final ObjectMapper objectMapper;

    public IntSmsClient(IntSmsConfig config) {
        if (config == null) {
            throw new IllegalArgumentException("IntSmsConfig must not be null");
        }
        this.config = config;
        this.httpTransport = new HttpTransport();
        this.objectMapper = CloudSdkModel.getMapper();
    }

    public IntSmsClient(IntSmsConfig config, HttpTransport httpTransport) {
        if (config == null) {
            throw new IllegalArgumentException("IntSmsConfig must not be null");
        }
        this.config = config;
        this.httpTransport = httpTransport != null ? httpTransport : new HttpTransport();
        this.objectMapper = CloudSdkModel.getMapper();
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
    public IntSmsBalanceResponse balanceQuery(String appId, String appSecret, String endpoint) throws CloudSdkException {
        return balanceQuery(appId, appSecret, endpoint, null);
    }

    /**
     * 账户余额查询，支持自定义链路追踪 ID。
     */
    public IntSmsBalanceResponse balanceQuery(String appId, String appSecret, String endpoint, String traceId) throws CloudSdkException {
        validateEndpoint(endpoint);
        validateCredentials(appId, appSecret);
        String body = "{}";
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
    public IntSmsPriceResponse priceQuery(String appId, String appSecret, String endpoint) throws CloudSdkException {
        return priceQuery(appId, appSecret, endpoint, null, null);
    }

    /**
     * 发送价格查询（指定国家）。
     */
    public IntSmsPriceResponse priceQuery(String appId, String appSecret, String endpoint, IntSmsPriceRequest request) throws CloudSdkException {
        return priceQuery(appId, appSecret, endpoint, request, null);
    }

    /**
     * 发送价格查询（指定国家），支持自定义链路追踪 ID。
     */
    public IntSmsPriceResponse priceQuery(String appId, String appSecret, String endpoint, IntSmsPriceRequest request, String traceId) throws CloudSdkException {
        validateEndpoint(endpoint);
        String body = (request == null) ? "{}" : serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + PRICE_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IntSmsPriceResponse.class);
    }

    /**
     * 状态报告拉取。
     */
    public IntSmsReportPullResponse reportPull(String appId, String appSecret, String endpoint) throws CloudSdkException {
        return reportPull(appId, appSecret, endpoint, null);
    }

    /**
     * 状态报告拉取（指定条数）。
     */
    public IntSmsReportPullResponse reportPull(String appId, String appSecret, String endpoint, IntSmsReportPullRequest request) throws CloudSdkException {
        return reportPull(appId, appSecret, endpoint, request, null);
    }

    /**
     * 状态报告拉取，支持自定义链路追踪 ID。
     */
    public IntSmsReportPullResponse reportPull(String appId, String appSecret, String endpoint, IntSmsReportPullRequest request, String traceId) throws CloudSdkException {
        validateEndpoint(endpoint);
        String body = (request == null) ? "{}" : serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + REPORT_PULL_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IntSmsReportPullResponse.class);
    }

    /**
     * 上行回复拉取。
     */
    public IntSmsReplyPullResponse replyPull(String appId, String appSecret, String endpoint) throws CloudSdkException {
        return replyPull(appId, appSecret, endpoint, null);
    }

    /**
     * 上行回复拉取（指定条数）。
     */
    public IntSmsReplyPullResponse replyPull(String appId, String appSecret, String endpoint, IntSmsReplyPullRequest request) throws CloudSdkException {
        return replyPull(appId, appSecret, endpoint, request, null);
    }

    /**
     * 上行回复拉取，支持自定义链路追踪 ID。
     */
    public IntSmsReplyPullResponse replyPull(String appId, String appSecret, String endpoint, IntSmsReplyPullRequest request, String traceId) throws CloudSdkException {
        validateEndpoint(endpoint);
        String body = (request == null) ? "{}" : serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + REPLY_PULL_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IntSmsReplyPullResponse.class);
    }

    private SyncResponse execute(String appId, String appSecret, String url, String body, String traceId) throws CloudSdkException {
        validateCredentials(appId, appSecret);
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

        Request sdkRequest = Request.builder()
                .method("POST")
                .url(url)
                .headers(headers)
                .body(body)
                .build();

        RuntimeOptions runtime = new RuntimeOptions();
        if (config.connectTimeout != null) {
            runtime.connectTimeout = config.connectTimeout;
        }
        if (config.readTimeout != null) {
            runtime.readTimeout = config.readTimeout;
        }
        RetryPolicy retryPolicy = new ExponentialBackoffRetryPolicy(
                runtime.getMaxAttempts(), runtime.getBackoffPeriod(), runtime.getMaxBackoff());

        return httpTransport.send(sdkRequest, runtime, retryPolicy);
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
        if (request.productType == null || request.productType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "productType 不能为空", null, 0);
        }
        if (request.message == null || request.message.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "message 不能为空", null, 0);
        }
        if (request.phoneNumbers == null || request.phoneNumbers.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "phoneNumbers 不能为空", null, 0);
        }
    }

    private void validateCostRequest(IntSmsCostRequest request) {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IntSmsCostRequest 不能为空", null, 0);
        }
        if (request.startDate == null || request.startDate.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "startDate 不能为空", null, 0);
        }
        if (request.endDate == null || request.endDate.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "endDate 不能为空", null, 0);
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
