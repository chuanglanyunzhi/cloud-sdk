package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.api.api.ApiClient;
import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.HttpTransport;
import com.chuanglan.cloudsdk.core.SyncResponse;

/**
 * 253 号码业务 SDK 入口。
 */
public class NumberClient extends ApiClient<NumberConfig> {

    private static final String BATCH_UCHECK_PATH = "/api/v2/credit/unn/batch-ucheck";

    private static final String PHONE_ATTRIBUTION_V2_PATH = "/api/v2/credit/unn/teladressPlusV2";

    public NumberClient(NumberConfig config) {
        super(config);
    }

    public NumberClient(NumberConfig config, HttpTransport httpTransport) {
        super(config, httpTransport);
    }

    /**
     * 号码状态检测（批量）。
     */
    public NumberStatusCheckResponse batchUcheck(String appId, String appSecret, NumberStatusCheckRequest request) throws CloudSdkException {
        return batchUcheck(appId, appSecret, request, null);
    }

    /**
     * 号码状态检测（批量），支持自定义链路追踪 ID。
     */
    public NumberStatusCheckResponse batchUcheck(String appId, String appSecret, NumberStatusCheckRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "NumberStatusCheckRequest 不能为空", null, 0);
        }
        if (request.getMobiles() == null || request.getMobiles().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobiles 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BATCH_UCHECK_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), NumberStatusCheckResponse.class);
    }

    /**
     * 手机号码归属地查询（升级版 V2）。
     */
    public NumberPhoneAttributionV2Response phoneAttributionV2(String appId, String appSecret, NumberPhoneAttributionV2Request request) throws CloudSdkException {
        return phoneAttributionV2(appId, appSecret, request, null);
    }

    /**
     * 手机号码归属地查询（升级版 V2），支持自定义链路追踪 ID。
     */
    public NumberPhoneAttributionV2Response phoneAttributionV2(String appId, String appSecret, NumberPhoneAttributionV2Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "NumberPhoneAttributionV2Request 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }
        if (request.getOrderNo() == null || request.getOrderNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "orderNo 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + PHONE_ATTRIBUTION_V2_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), NumberPhoneAttributionV2Response.class);
    }
}
