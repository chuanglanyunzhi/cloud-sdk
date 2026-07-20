package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 253 视频短信（RCS）服务 SDK 入口。
 */
public class RcsSmsClient implements AutoCloseable {

    private static final String ADD_VIDEO_TEMPLATE_PATH = "/rcs/api/v2/template/addVideo";
    private static final String FIND_VIDEO_TEMPLATE_PATH = "/rcs/api/v2/template/findTemplate";
    private static final String LIST_VIDEO_TEMPLATE_PATH = "/rcs/api/v2/template/listVideoTemplate";
    private static final String LIST_SIGN_PATH = "/rcs/api/v2/template/listSign";
    private static final String UPDATE_VIDEO_TEMPLATE_PATH = "/rcs/api/v2/template/updateVideo";
    private static final String SUBMIT_VIDEO_TEMPLATE_PATH = "/rcs/api/v2/msg/submitVideoTemplate";
    private static final String PULL_REPORT_PATH = "/rcs/api/v2/report/pull";
    private static final String PULL_REPLY_PATH = "/rcs/api/v2/reply/pull";
    private static final String GET_BALANCE_PATH = "/rcs/api/internal/balance/getBalance";
    private static final String ADD_SIGN_PATH = "/rcs/api/sign/add_sign";
    private static final String UPDATE_ADDRESS_PATH = "/rcs/api/account/update_address";

    private final RcsSmsConfig config;
    private final String endpoint;
    private final HttpTransport httpTransport;
    private final ObjectMapper objectMapper;
    /** 仅当自行创建 httpTransport 时才在 close() 中释放，避免误关闭外部注入的共享连接池。 */
    private final boolean ownsTransport;

    public RcsSmsClient(RcsSmsConfig config) {
        this(config, null);
    }

    public RcsSmsClient(RcsSmsConfig config, HttpTransport httpTransport) {
        if (config == null) {
            throw new IllegalArgumentException("RcsSmsConfig must not be null");
        }
        this.config = config;
        this.endpoint = (config.getEndpoint() != null && !config.getEndpoint().isEmpty())
                ? config.getEndpoint()
                : RcsSmsConfig.DEFAULT_ENDPOINT;
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

    // ================== 视频模板管理 ==================

    public RcsSmsTemplateAddResponse addVideoTemplate(String appId, String appSecret, RcsSmsTemplateAddRequest request) throws CloudSdkException {
        return addVideoTemplate(appId, appSecret, request, null);
    }

    public RcsSmsTemplateAddResponse addVideoTemplate(String appId, String appSecret, RcsSmsTemplateAddRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsTemplateAddRequest");
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + ADD_VIDEO_TEMPLATE_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsTemplateAddResponse.class);
    }

    public RcsSmsTemplateFindResponse findVideoTemplate(String appId, String appSecret, RcsSmsTemplateFindRequest request) throws CloudSdkException {
        return findVideoTemplate(appId, appSecret, request, null);
    }

    public RcsSmsTemplateFindResponse findVideoTemplate(String appId, String appSecret, RcsSmsTemplateFindRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsTemplateFindRequest");
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + FIND_VIDEO_TEMPLATE_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsTemplateFindResponse.class);
    }

    public RcsSmsTemplateListResponse listVideoTemplate(String appId, String appSecret, RcsSmsTemplateListRequest request) throws CloudSdkException {
        return listVideoTemplate(appId, appSecret, request, null);
    }

    public RcsSmsTemplateListResponse listVideoTemplate(String appId, String appSecret, RcsSmsTemplateListRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsTemplateListRequest");
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + LIST_VIDEO_TEMPLATE_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsTemplateListResponse.class);
    }

    public RcsSmsSignListResponse listSign(String appId, String appSecret, RcsSmsSignListRequest request) throws CloudSdkException {
        return listSign(appId, appSecret, request, null);
    }

    public RcsSmsSignListResponse listSign(String appId, String appSecret, RcsSmsSignListRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsSignListRequest");
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + LIST_SIGN_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsSignListResponse.class);
    }

    public RcsSmsTemplateUpdateResponse updateVideoTemplate(String appId, String appSecret, RcsSmsTemplateUpdateRequest request) throws CloudSdkException {
        return updateVideoTemplate(appId, appSecret, request, null);
    }

    public RcsSmsTemplateUpdateResponse updateVideoTemplate(String appId, String appSecret, RcsSmsTemplateUpdateRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsTemplateUpdateRequest");
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + UPDATE_VIDEO_TEMPLATE_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsTemplateUpdateResponse.class);
    }

    // ================== 视频短信发送 ==================

    public RcsSmsTemplateSubmitResponse submitVideoTemplate(String appId, String appSecret, RcsSmsTemplateSubmitRequest request) throws CloudSdkException {
        return submitVideoTemplate(appId, appSecret, request, null);
    }

    public RcsSmsTemplateSubmitResponse submitVideoTemplate(String appId, String appSecret, RcsSmsTemplateSubmitRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsTemplateSubmitRequest");
        if (request.getTemplateId() == null || request.getTemplateId().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "templateId 不能为空", null, 0);
        }
        if (request.getPhoneNumbers() == null || request.getPhoneNumbers().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "phoneNumbers 不能为空", null, 0);
        }
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + SUBMIT_VIDEO_TEMPLATE_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsTemplateSubmitResponse.class);
    }

    // ================== 报告与上行 ==================

    public RcsSmsReportPullResponse pullReport(String appId, String appSecret, RcsSmsReportPullRequest request) throws CloudSdkException {
        return pullReport(appId, appSecret, request, null);
    }

    public RcsSmsReportPullResponse pullReport(String appId, String appSecret, RcsSmsReportPullRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsReportPullRequest");
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + PULL_REPORT_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsReportPullResponse.class);
    }

    public RcsSmsReplyPullResponse pullReply(String appId, String appSecret, RcsSmsReplyPullRequest request) throws CloudSdkException {
        return pullReply(appId, appSecret, request, null);
    }

    public RcsSmsReplyPullResponse pullReply(String appId, String appSecret, RcsSmsReplyPullRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsReplyPullRequest");
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + PULL_REPLY_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsReplyPullResponse.class);
    }

    // ================== 余额与签名、账户 ==================

    public RcsSmsBalanceResponse getBalance(String appId, String appSecret, RcsSmsBalanceRequest request) throws CloudSdkException {
        return getBalance(appId, appSecret, request, null);
    }

    public RcsSmsBalanceResponse getBalance(String appId, String appSecret, RcsSmsBalanceRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            request = new RcsSmsBalanceRequest();
        }
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + GET_BALANCE_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsBalanceResponse.class);
    }

    public RcsSmsSignAddResponse addSign(String appId, String appSecret, RcsSmsSignAddRequest request) throws CloudSdkException {
        return addSign(appId, appSecret, request, null);
    }

    public RcsSmsSignAddResponse addSign(String appId, String appSecret, RcsSmsSignAddRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsSignAddRequest");
        if (request.getSignName() == null || request.getSignName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "signName 不能为空", null, 0);
        }
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + ADD_SIGN_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsSignAddResponse.class);
    }

    public RcsSmsAccountAddressUpdateResponse updateAccountAddress(String appId, String appSecret, RcsSmsAccountAddressUpdateRequest request) throws CloudSdkException {
        return updateAccountAddress(appId, appSecret, request, null);
    }

    public RcsSmsAccountAddressUpdateResponse updateAccountAddress(String appId, String appSecret, RcsSmsAccountAddressUpdateRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsAccountAddressUpdateRequest");
        if (request.getAddress() == null || request.getAddress().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "address 不能为空", null, 0);
        }
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + UPDATE_ADDRESS_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsAccountAddressUpdateResponse.class);
    }

    // ================== 通用方法 ==================

    private SyncResponse execute(String appId, String appSecret, String url, CloudSdkModel request, String traceId) throws CloudSdkException {
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

        // 每次重试重新签名（基于最新 nonce/curTime 重算 HmacSHA256）
        return httpTransport.send(
                () -> buildSignedRequest(appId, appSecret, url, request, traceId),
                runtime, retryPolicy);
    }

    private Request buildSignedRequest(String appId, String appSecret, String url,
                                       CloudSdkModel request, String traceId) throws CloudSdkException {
        String nonce = RcsSmsSignatureUtil.generateNonce();
        String curTime = RcsSmsSignatureUtil.currentTimestamp();

        Map<String, Object> params = new HashMap<>();
        params.put("appId", appId);
        params.put("nonce", nonce);
        params.put("curTime", curTime);
        if (request != null) {
            params.putAll(request.toMap());
        }
        String checksum = RcsSmsSignatureUtil.checksum(appSecret, params);

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
                .body(serializeRequest(request))
                .build();
    }

    private String serializeRequest(Object request) throws CloudSdkException {
        try {
            if (request == null) {
                return "{}";
            }
            return objectMapper.writeValueAsString(request);
        } catch (Exception e) {
            throw new CloudSdkException("SerializeRequestError", "请求体序列化失败: " + e.getMessage(), null, 0, e);
        }
    }

    private <T extends RcsSmsCommonResponse> T parseResponse(String body, Class<T> responseClass) throws CloudSdkException {
        if (body == null || body.isEmpty()) {
            body = "{}";
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

    private void validateRequest(CloudSdkModel request, String name) {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", name + " 不能为空", null, 0);
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
