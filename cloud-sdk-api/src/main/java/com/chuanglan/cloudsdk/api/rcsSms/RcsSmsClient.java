package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 253 视频短信（RCS）服务 SDK 入口。
 */
public class RcsSmsClient implements AutoCloseable {

    private static final String ADD_VIDEO_TEMPLATE_PATH = "/videosms/api/v2/template/add";
    private static final String FIND_VIDEO_TEMPLATE_PATH = "/videosms/api/v2/template/getSingleTemplateInfo";
    private static final String SUBMIT_VIDEO_TEMPLATE_PATH = "/videosms/api/v2/template/send";
    private static final String PULL_REPORT_PATH = "/videosms/api/v2/report/pull";
    private static final String PULL_REPLY_PATH = "/videosms/api/v2/reply/pull";
    private static final String ADD_SIGN_PATH = "/videosms/api/v2/sign/add";

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

    // ================== 视频短信发送 ==================

    public RcsSmsTemplateSubmitResponse submitVideoTemplate(String appId, String appSecret, RcsSmsTemplateSubmitRequest request) throws CloudSdkException {
        return submitVideoTemplate(appId, appSecret, request, null);
    }

    public RcsSmsTemplateSubmitResponse submitVideoTemplate(String appId, String appSecret, RcsSmsTemplateSubmitRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsTemplateSubmitRequest");
        if (request.getSubmitNo() == null || request.getSubmitNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "submitNo 不能为空", null, 0);
        }
        if (request.getTemplateId() == null || request.getTemplateId().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "templateId 不能为空", null, 0);
        }
        boolean hasPhones = request.getPhoneNumbers() != null && !request.getPhoneNumbers().isEmpty();
        boolean hasDynamicVars = request.getPhoneNumberJson() != null && !request.getPhoneNumberJson().isEmpty();
        if (!hasPhones && !hasDynamicVars) {
            throw new CloudSdkException("ParameterMissing", "静态模板发送时 phoneNumbers 必填，动态模板发送时 phoneNumberJson 必填", null, 0);
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

    // ================== 签名 ==================

    public RcsSmsSignAddResponse addSign(String appId, String appSecret, RcsSmsSignAddRequest request) throws CloudSdkException {
        return addSign(appId, appSecret, request, null);
    }

    public RcsSmsSignAddResponse addSign(String appId, String appSecret, RcsSmsSignAddRequest request, String traceId) throws CloudSdkException {
        validateRequest(request, "RcsSmsSignAddRequest");
        if (request.getSign() == null || request.getSign().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "sign 不能为空", null, 0);
        }
        if (request.getCustomerCode() == null || request.getCustomerCode().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "customerCode 不能为空", null, 0);
        }
        if (request.getIndustryCode() == null || request.getIndustryCode().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "industryCode 不能为空", null, 0);
        }
        if (request.getSignType() == null || request.getSignType().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "signType 不能为空", null, 0);
        }
        SyncResponse syncResponse = execute(appId, appSecret, endpoint + ADD_SIGN_PATH, request, traceId);
        return parseResponse(syncResponse.getBody(), RcsSmsSignAddResponse.class);
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

        String checksum = RcsSmsSignatureUtil.checksum(appSecret, nonce, curTime);

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
