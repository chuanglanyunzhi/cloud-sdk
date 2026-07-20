package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.SyncResponse;

/**
 * 测试用 BusinessClient 子类，用于验证基类请求发送能力。
 */
class TestableBusinessClient extends BusinessClient {

    TestableBusinessClient(BusinessConfig config) {
        super(config);
    }

    public BusinessCommonResponse invoke(String appId, String appSecret, String path, String body, String traceId) throws CloudSdkException {
        SyncResponse response = execute(appId, appSecret, config.getEndpoint() + path, body, traceId);
        return parseResponse(response.getBody(), BusinessCommonResponse.class);
    }
}
