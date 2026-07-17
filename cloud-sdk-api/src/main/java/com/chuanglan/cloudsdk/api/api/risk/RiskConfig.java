package com.chuanglan.cloudsdk.api.api.risk;

import com.chuanglan.cloudsdk.api.api.ApiConfig;

/**
 * 风控业务非鉴权配置。
 */
public class RiskConfig extends ApiConfig {

    /**
     * 风控业务默认接入地址。
     */
    public static final String DEFAULT_ENDPOINT = "https://wsrisk.253.com";

    /**
     * 羊毛党检测默认接入地址。
     */
    public static final String DEFAULT_WOOL_ENDPOINT = "https://wsapi.253.com";

    /**
     * 羊毛党检测接入地址。
     */
    public String woolEndpoint = DEFAULT_WOOL_ENDPOINT;

    public RiskConfig() {
        this.endpoint = DEFAULT_ENDPOINT;
    }

    public RiskConfig setWoolEndpoint(String woolEndpoint) {
        this.woolEndpoint = woolEndpoint;
        return this;
    }

    @Override
    public RiskConfig setEndpoint(String endpoint) {
        super.setEndpoint(endpoint);
        return this;
    }

    @Override
    public RiskConfig setConnectTimeout(Integer connectTimeout) {
        super.setConnectTimeout(connectTimeout);
        return this;
    }

    @Override
    public RiskConfig setReadTimeout(Integer readTimeout) {
        super.setReadTimeout(readTimeout);
        return this;
    }
}
