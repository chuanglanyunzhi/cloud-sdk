package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.api.api.ApiConfig;

/**
 * 实名认证业务非鉴权配置（appId / appSecret 由调用方直接传入 RealNameClient）。
 */
public class RealNameConfig extends ApiConfig {

    /**
     * 实名认证业务默认接入地址。
     */
    public static final String DEFAULT_ENDPOINT = "https://wsauth.253.com";

    /**
     * 实名认证业务详细版 API 默认接入地址。
     */
    public static final String DEFAULT_API_ENDPOINT = "https://api.253.com";

    private String apiEndpoint = DEFAULT_API_ENDPOINT;

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public RealNameConfig() {
        super.setEndpoint(DEFAULT_ENDPOINT);
    }

    @Override
    public RealNameConfig setEndpoint(String endpoint) {
        super.setEndpoint(endpoint);
        return this;
    }

    public RealNameConfig setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
        return this;
    }

    @Override
    public RealNameConfig setConnectTimeout(Integer connectTimeout) {
        super.setConnectTimeout(connectTimeout);
        return this;
    }

    @Override
    public RealNameConfig setReadTimeout(Integer readTimeout) {
        super.setReadTimeout(readTimeout);
        return this;
    }
}
