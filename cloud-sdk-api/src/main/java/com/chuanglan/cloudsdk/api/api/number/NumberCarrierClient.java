package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.api.api.ApiClient;
import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.HttpTransport;
import com.chuanglan.cloudsdk.core.SyncResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 253 号码运营商业务 SDK 入口（二次号、号码实时基础版等）。
 */
public class NumberCarrierClient extends ApiClient<NumberCarrierConfig> {

    private static final String MORESALE_PATH = "/api/v2/carrier/unn/moresale";
    private static final String MOB_STATUS_BASIC_PATH = "/api/v2/carrier/mobstatus/mobstatus-query-basic";
    private static final String ONLINE_DURATION_PATH = "/api/v2/carrier/yysnl/yhzwsc";
    private static final String NET_STATUS_PATH = "/api/v2/carrier/zwsjmd/mobile_netstatus";

    public NumberCarrierClient(NumberCarrierConfig config) {
        super(config);
    }

    public NumberCarrierClient(NumberCarrierConfig config, HttpTransport httpTransport) {
        super(config, httpTransport);
    }

    /**
     * 二次号查询。
     */
    public NumberSecondHandResponse moresale(String appId, String appSecret, NumberSecondHandRequest request) throws CloudSdkException {
        return moresale(appId, appSecret, request, null);
    }

    /**
     * 二次号查询，支持自定义链路追踪 ID。
     */
    public NumberSecondHandResponse moresale(String appId, String appSecret, NumberSecondHandRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "NumberSecondHandRequest 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }
        if (request.getSinceDate() == null || request.getSinceDate().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "sinceDate 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + MORESALE_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), NumberSecondHandResponse.class);
    }

    /**
     * 号码实时基础版查询。
     */
    public NumberMobStatusBasicResponse mobStatusBasicQuery(String appId, String appSecret, NumberMobStatusBasicRequest request) throws CloudSdkException {
        return mobStatusBasicQuery(appId, appSecret, request, null);
    }

    /**
     * 号码实时基础版查询，支持自定义链路追踪 ID。
     */
    public NumberMobStatusBasicResponse mobStatusBasicQuery(String appId, String appSecret, NumberMobStatusBasicRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "NumberMobStatusBasicRequest 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }
        if (request.getOrderNo() == null || request.getOrderNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "orderNo 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + MOB_STATUS_BASIC_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), NumberMobStatusBasicResponse.class);
    }

    /**
     * 号码在网时长查询。
     */
    public NumberOnlineDurationResponse onlineDurationQuery(String appId, String appSecret, NumberOnlineDurationRequest request) throws CloudSdkException {
        return onlineDurationQuery(appId, appSecret, request, null);
    }

    /**
     * 号码在网时长查询，支持自定义链路追踪 ID。
     */
    public NumberOnlineDurationResponse onlineDurationQuery(String appId, String appSecret, NumberOnlineDurationRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "NumberOnlineDurationRequest 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = buildFormBody(request.toMap());
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + ONLINE_DURATION_PATH, body, traceId, "application/x-www-form-urlencoded");
        return parseResponse(syncResponse.getBody(), NumberOnlineDurationResponse.class);
    }

    /**
     * 号码在网状态查询。
     */
    public NumberNetStatusResponse netStatus(String appId, String appSecret, NumberNetStatusRequest request) throws CloudSdkException {
        return netStatus(appId, appSecret, request, null);
    }

    /**
     * 号码在网状态查询，支持自定义链路追踪 ID。
     */
    public NumberNetStatusResponse netStatus(String appId, String appSecret, NumberNetStatusRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "NumberNetStatusRequest 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + NET_STATUS_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), NumberNetStatusResponse.class);
    }

    private String buildFormBody(Map<String, Object> params) throws CloudSdkException {
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"))
                        .append("=")
                        .append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new CloudSdkException("SerializeRequestError", "表单编码失败: " + e.getMessage(), null, 0, e);
        }
    }
}
