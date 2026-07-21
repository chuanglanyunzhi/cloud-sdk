package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.api.sms.qualification.*;
import com.chuanglan.cloudsdk.api.sms.signature.*;
import com.chuanglan.cloudsdk.api.sms.template.*;
import com.chuanglan.cloudsdk.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 253 短信服务 SDK 入口。
 */
public class SmsClient implements AutoCloseable {

    private static final String BATCH_SEND_PATH = "/sms/v2/batchSend";

    private final SmsConfig config;
    private final HttpTransport httpTransport;
    private final ObjectMapper objectMapper;
    /** 仅当自行创建 httpTransport 时才在 close() 中释放，避免误关闭外部注入的共享连接池。 */
    private final boolean ownsTransport;

    public SmsClient() {
        this(new SmsConfig());
    }

    public SmsClient(SmsConfig config) {
        this(config, null);
    }

    public SmsClient(SmsConfig config, HttpTransport httpTransport) {
        if (config == null) {
            throw new IllegalArgumentException("SmsConfig must not be null");
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

    // ================== 短信发送 ==================

    public SmsBatchSendResponse batchSend(String appId, String appSecret, SmsBatchSendRequest request) throws CloudSdkException {
        return batchSend(appId, appSecret, request, null);
    }

    public SmsBatchSendResponse batchSend(String appId, String appSecret, SmsBatchSendRequest request, String traceId) throws CloudSdkException {
        validateBatchSendRequest(request);
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + BATCH_SEND_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), SmsBatchSendResponse.class);
    }

    // ================== 资质管理 ==================

    public SmsQualificationAddResponse addQualification(String appId, String appSecret, SmsQualificationAddRequest request) throws CloudSdkException {
        return addQualification(appId, appSecret, request, null);
    }

    public SmsQualificationAddResponse addQualification(String appId, String appSecret, SmsQualificationAddRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsQualificationAddRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/qualification/add", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsQualificationAddResponse.class);
    }

    public SmsQualificationListResponse listQualification(String appId, String appSecret, SmsQualificationListRequest request) throws CloudSdkException {
        return listQualification(appId, appSecret, request, null);
    }

    public SmsQualificationListResponse listQualification(String appId, String appSecret, SmsQualificationListRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsQualificationListRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/qualification/list", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsQualificationListResponse.class);
    }

    public SmsQualificationUpdateResponse updateQualification(String appId, String appSecret, SmsQualificationUpdateRequest request) throws CloudSdkException {
        return updateQualification(appId, appSecret, request, null);
    }

    public SmsQualificationUpdateResponse updateQualification(String appId, String appSecret, SmsQualificationUpdateRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsQualificationUpdateRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/qualification/update", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsQualificationUpdateResponse.class);
    }

    public SmsQualificationDeleteResponse deleteQualification(String appId, String appSecret, SmsQualificationDeleteRequest request) throws CloudSdkException {
        return deleteQualification(appId, appSecret, request, null);
    }

    public SmsQualificationDeleteResponse deleteQualification(String appId, String appSecret, SmsQualificationDeleteRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsQualificationDeleteRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/qualification/delete", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsQualificationDeleteResponse.class);
    }

    // ================== 签名管理 ==================

    public SmsSignatureAddResponse addSignature(String appId, String appSecret, SmsSignatureAddRequest request) throws CloudSdkException {
        return addSignature(appId, appSecret, request, null);
    }

    public SmsSignatureAddResponse addSignature(String appId, String appSecret, SmsSignatureAddRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsSignatureAddRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/signature/add", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsSignatureAddResponse.class);
    }

    public SmsSignatureGetResponse getSignature(String appId, String appSecret, SmsSignatureGetRequest request) throws CloudSdkException {
        return getSignature(appId, appSecret, request, null);
    }

    public SmsSignatureGetResponse getSignature(String appId, String appSecret, SmsSignatureGetRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsSignatureGetRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/signature/getSingleSignatureInfo", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsSignatureGetResponse.class);
    }

    public SmsSignatureListResponse listSignature(String appId, String appSecret, SmsSignatureListRequest request) throws CloudSdkException {
        return listSignature(appId, appSecret, request, null);
    }

    public SmsSignatureListResponse listSignature(String appId, String appSecret, SmsSignatureListRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsSignatureListRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/signature/list", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsSignatureListResponse.class);
    }

    public SmsSignatureOperatorRejectReasonResponse getSignatureOperatorRejectReason(String appId, String appSecret, SmsSignatureOperatorRejectReasonRequest request) throws CloudSdkException {
        return getSignatureOperatorRejectReason(appId, appSecret, request, null);
    }

    public SmsSignatureOperatorRejectReasonResponse getSignatureOperatorRejectReason(String appId, String appSecret, SmsSignatureOperatorRejectReasonRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsSignatureOperatorRejectReasonRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/signature/operatorRejectReason", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsSignatureOperatorRejectReasonResponse.class);
    }

    public SmsSignatureRealNameUpdateResponse updateSignatureRealName(String appId, String appSecret, SmsSignatureRealNameUpdateRequest request) throws CloudSdkException {
        return updateSignatureRealName(appId, appSecret, request, null);
    }

    public SmsSignatureRealNameUpdateResponse updateSignatureRealName(String appId, String appSecret, SmsSignatureRealNameUpdateRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsSignatureRealNameUpdateRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/signature/realNameUpdate", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsSignatureRealNameUpdateResponse.class);
    }

    public SmsSignatureDeleteResponse deleteSignature(String appId, String appSecret, SmsSignatureDeleteRequest request) throws CloudSdkException {
        return deleteSignature(appId, appSecret, request, null);
    }

    public SmsSignatureDeleteResponse deleteSignature(String appId, String appSecret, SmsSignatureDeleteRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsSignatureDeleteRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/signature/delete", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsSignatureDeleteResponse.class);
    }

    // ================== 模板管理 ==================

    public SmsTemplateAddResponse addTemplate(String appId, String appSecret, SmsTemplateAddRequest request) throws CloudSdkException {
        return addTemplate(appId, appSecret, request, null);
    }

    public SmsTemplateAddResponse addTemplate(String appId, String appSecret, SmsTemplateAddRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsTemplateAddRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/template/add", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsTemplateAddResponse.class);
    }

    public SmsTemplateTypeEnumResponse queryTemplateTypeEnum(String appId, String appSecret, SmsTemplateTypeEnumRequest request) throws CloudSdkException {
        return queryTemplateTypeEnum(appId, appSecret, request, null);
    }

    public SmsTemplateTypeEnumResponse queryTemplateTypeEnum(String appId, String appSecret, SmsTemplateTypeEnumRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsTemplateTypeEnumRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/template/queryTypeEnum", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsTemplateTypeEnumResponse.class);
    }

    public SmsTemplateListResponse listTemplate(String appId, String appSecret, SmsTemplateListRequest request) throws CloudSdkException {
        return listTemplate(appId, appSecret, request, null);
    }

    public SmsTemplateListResponse listTemplate(String appId, String appSecret, SmsTemplateListRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsTemplateListRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/template/list", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsTemplateListResponse.class);
    }

    public SmsTemplateGetResponse getTemplate(String appId, String appSecret, SmsTemplateGetRequest request) throws CloudSdkException {
        return getTemplate(appId, appSecret, request, null);
    }

    public SmsTemplateGetResponse getTemplate(String appId, String appSecret, SmsTemplateGetRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsTemplateGetRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/template/getSingleTemplateInfo", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsTemplateGetResponse.class);
    }

    public SmsTemplateOperatorRejectReasonResponse getTemplateOperatorRejectReason(String appId, String appSecret, SmsTemplateOperatorRejectReasonRequest request) throws CloudSdkException {
        return getTemplateOperatorRejectReason(appId, appSecret, request, null);
    }

    public SmsTemplateOperatorRejectReasonResponse getTemplateOperatorRejectReason(String appId, String appSecret, SmsTemplateOperatorRejectReasonRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsTemplateOperatorRejectReasonRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/template/operatorRejectReason", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsTemplateOperatorRejectReasonResponse.class);
    }

    public SmsTemplateUpdateResponse updateTemplate(String appId, String appSecret, SmsTemplateUpdateRequest request) throws CloudSdkException {
        return updateTemplate(appId, appSecret, request, null);
    }

    public SmsTemplateUpdateResponse updateTemplate(String appId, String appSecret, SmsTemplateUpdateRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsTemplateUpdateRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/template/update", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsTemplateUpdateResponse.class);
    }

    public SmsTemplateDeleteResponse deleteTemplate(String appId, String appSecret, SmsTemplateDeleteRequest request) throws CloudSdkException {
        return deleteTemplate(appId, appSecret, request, null);
    }

    public SmsTemplateDeleteResponse deleteTemplate(String appId, String appSecret, SmsTemplateDeleteRequest request, String traceId) throws CloudSdkException {
        validateBaseRequest(request, "SmsTemplateDeleteRequest");
        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret,
                config.getEndpoint() + "/sms/v2/template/delete", body, traceId);
        return parseResponse(syncResponse.getBody(), SmsTemplateDeleteResponse.class);
    }

    // ================== 通用方法 ==================

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
        String nonce = SmsSignatureUtil.generateNonce();
        String curTime = SmsSignatureUtil.currentTimestamp();
        String checksum = SmsSignatureUtil.checksum(appSecret, nonce, curTime);

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

    private <T extends SmsCommonResponse> T parseResponse(String body, Class<T> responseClass) throws CloudSdkException {
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
            return objectMapper.convertValue(map, responseClass);
        } catch (Exception e) {
            throw new CloudSdkException("ParseResponseError", "响应解析失败: " + e.getMessage(), null, 0, e);
        }
    }

    private void validateBatchSendRequest(SmsBatchSendRequest request) {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "SmsBatchSendRequest 不能为空", null, 0);
        }
        if (request.getProductType() == null || request.getProductType().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "productType 不能为空", null, 0);
        }
        if (request.getPhoneNumbers() == null || request.getPhoneNumbers().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "phoneNumbers 不能为空", null, 0);
        }
        if (request.getTemplateCode() == null || request.getTemplateCode().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "templateCode 不能为空", null, 0);
        }
    }

    private void validateBaseRequest(CloudSdkModel request, String name) {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", name + " 不能为空", null, 0);
        }
        try {
            Map<String, Object> map = request.toMap();
            Object productType = map.get("productType");
            if (productType == null || productType.toString().isEmpty()) {
                throw new CloudSdkException("ParameterMissing", "productType 不能为空", null, 0);
            }
        } catch (CloudSdkException e) {
            throw e;
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
