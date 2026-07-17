package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.api.api.ApiConfig;

/**
 * 号码运营商业务（二次号、号码实时基础版等）非鉴权配置。
 */
public class NumberCarrierConfig extends ApiConfig {

    /**
     * 号码运营商业务默认接入地址。
     */
    public static final String DEFAULT_ENDPOINT = "https://wscarrier.253.com";

    public NumberCarrierConfig() {
        this.endpoint = DEFAULT_ENDPOINT;
    }

    @Override
    public NumberCarrierConfig setEndpoint(String endpoint) {
        super.setEndpoint(endpoint);
        return this;
    }

    @Override
    public NumberCarrierConfig setConnectTimeout(Integer connectTimeout) {
        super.setConnectTimeout(connectTimeout);
        return this;
    }

    @Override
    public NumberCarrierConfig setReadTimeout(Integer readTimeout) {
        super.setReadTimeout(readTimeout);
        return this;
    }
}
