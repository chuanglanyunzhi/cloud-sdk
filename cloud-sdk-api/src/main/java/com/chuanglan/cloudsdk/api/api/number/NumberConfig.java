package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.api.api.ApiConfig;

/**
 * 号码状态检测非鉴权配置（appId / appSecret 由调用方直接传入 NumberClient）。
 */
public class NumberConfig extends ApiConfig {

    /**
     * 号码业务默认接入地址。
     */
    public static final String DEFAULT_ENDPOINT = "https://wskh.253.com";

    public NumberConfig() {
        this.endpoint = DEFAULT_ENDPOINT;
    }

    @Override
    public NumberConfig setEndpoint(String endpoint) {
        super.setEndpoint(endpoint);
        return this;
    }

    @Override
    public NumberConfig setConnectTimeout(Integer connectTimeout) {
        super.setConnectTimeout(connectTimeout);
        return this;
    }

    @Override
    public NumberConfig setReadTimeout(Integer readTimeout) {
        super.setReadTimeout(readTimeout);
        return this;
    }
}
