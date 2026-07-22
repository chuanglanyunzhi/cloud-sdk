package com.chuanglan.cloudsdk.api.api.mnp;

import com.chuanglan.cloudsdk.api.api.ApiClient;
import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.HttpTransport;
import com.chuanglan.cloudsdk.core.SyncResponse;

/**
 * 253 携号转网业务 SDK 入口。
 */
public class MnpClient extends ApiClient<MnpConfig> {

    private static final String CARRIERS_NEW_SFTP_PATH = "/api/v2/mnp/carriers/sftp";

    public MnpClient(MnpConfig config) {
        super(config);
    }

    public MnpClient(MnpConfig config, HttpTransport httpTransport) {
        super(config, httpTransport);
    }

    /**
     * 携号转网 V1 查询。
     */
    public MnpCarriersSftpResponse carriersSftp(String appId, String appSecret, MnpCarriersSftpRequest request) throws CloudSdkException {
        return carriersSftp(appId, appSecret, request, null);
    }

    /**
     * 携号转网 V1 查询，支持自定义链路追踪 ID。
     */
    public MnpCarriersSftpResponse carriersSftp(String appId, String appSecret, MnpCarriersSftpRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "MnpCarriersSftpRequest 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + CARRIERS_NEW_SFTP_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), MnpCarriersSftpResponse.class);
    }

}
