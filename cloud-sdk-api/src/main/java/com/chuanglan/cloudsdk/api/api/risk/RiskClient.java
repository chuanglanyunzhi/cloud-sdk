package com.chuanglan.cloudsdk.api.api.risk;

import com.chuanglan.cloudsdk.api.api.ApiClient;
import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.HttpTransport;
import com.chuanglan.cloudsdk.core.SyncResponse;

/**
 * 253 风控业务 SDK 入口（防骚扰黑名单、羊毛党检测等）。
 */
public class RiskClient extends ApiClient<RiskConfig> {

    private static final String BFORBID_PATH = "/api/v2/risk/riskMobile/bforbid";
    private static final String WOOL_CHECK_PATH = "/api/v2/sdk/wool/wcheck";

    public RiskClient(RiskConfig config) {
        super(config);
    }

    public RiskClient(RiskConfig config, HttpTransport httpTransport) {
        super(config, httpTransport);
    }

    /**
     * 防骚扰黑名单查询。
     */
    public RiskAntiHarassmentResponse bforbid(String appId, String appSecret, RiskAntiHarassmentRequest request) throws CloudSdkException {
        return bforbid(appId, appSecret, request, null);
    }

    /**
     * 防骚扰黑名单查询，支持自定义链路追踪 ID。
     */
    public RiskAntiHarassmentResponse bforbid(String appId, String appSecret, RiskAntiHarassmentRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "RiskAntiHarassmentRequest 不能为空", null, 0);
        }
        if (request.mobiles == null || request.mobiles.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobiles 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + BFORBID_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), RiskAntiHarassmentResponse.class);
    }

    /**
     * 羊毛党检测。
     */
    public RiskWoolCheckResponse woolCheck(String appId, String appSecret, RiskWoolCheckRequest request) throws CloudSdkException {
        return woolCheck(appId, appSecret, request, null);
    }

    /**
     * 羊毛党检测，支持自定义链路追踪 ID。
     */
    public RiskWoolCheckResponse woolCheck(String appId, String appSecret, RiskWoolCheckRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "RiskWoolCheckRequest 不能为空", null, 0);
        }
        if (request.mobile == null || request.mobile.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.woolEndpoint + WOOL_CHECK_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), RiskWoolCheckResponse.class);
    }
}
