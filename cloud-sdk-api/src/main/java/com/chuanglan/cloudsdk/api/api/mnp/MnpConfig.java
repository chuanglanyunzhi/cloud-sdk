package com.chuanglan.cloudsdk.api.api.mnp;

import com.chuanglan.cloudsdk.api.api.ApiConfig;

/**
 * 携号转网业务非鉴权配置。
 */
public class MnpConfig extends ApiConfig {

    /**
     * 携号转网业务默认接入地址。
     */
    public static final String DEFAULT_ENDPOINT = "https://wsmnp.253.com";

    public MnpConfig() {
        this.endpoint = DEFAULT_ENDPOINT;
    }

    @Override
    public MnpConfig setEndpoint(String endpoint) {
        super.setEndpoint(endpoint);
        return this;
    }

    @Override
    public MnpConfig setConnectTimeout(Integer connectTimeout) {
        super.setConnectTimeout(connectTimeout);
        return this;
    }

    @Override
    public MnpConfig setReadTimeout(Integer readTimeout) {
        super.setReadTimeout(readTimeout);
        return this;
    }
}
