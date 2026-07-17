package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.api.api.ApiConfig;

/**
 * 业务线非鉴权配置。
 * 后续新增业务接口统一使用此配置，默认接入地址为 wsapi.253.com。
 */
public class BusinessConfig extends ApiConfig {

    /**
     * 业务线默认接入地址。
     */
    public static final String DEFAULT_ENDPOINT = "https://wsapi.253.com";

    public BusinessConfig() {
        this.endpoint = DEFAULT_ENDPOINT;
    }

    @Override
    public BusinessConfig setEndpoint(String endpoint) {
        super.setEndpoint(endpoint);
        return this;
    }

    @Override
    public BusinessConfig setConnectTimeout(Integer connectTimeout) {
        super.setConnectTimeout(connectTimeout);
        return this;
    }

    @Override
    public BusinessConfig setReadTimeout(Integer readTimeout) {
        super.setReadTimeout(readTimeout);
        return this;
    }
}
