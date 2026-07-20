package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.api.api.ApiConfig;

/**
 * 业务线配置。支持两种用法：
 *
 * <p>1. 传统方式：只设 endpoint，每次调用传 appId/appSecret
 * <pre>{@code
 * BusinessConfig config = new BusinessConfig();
 * client.ipAddressOriginV4(appId, appSecret, request);
 * }</pre>
 *
 * <p>2. 推荐方式：构造时绑定凭证，调用时无需重复传入
 * <pre>{@code
 * BusinessConfig config = BusinessConfig.builder()
 *     .appId("xxx")
 *     .appSecret("yyy")
 *     .build();
 * client.ipAddressOriginV4(request);
 * }</pre>
 */
public class BusinessConfig extends ApiConfig {

    public static final String DEFAULT_ENDPOINT = "https://wsapi.253.com";

    private String appId;
    private String appSecret;

    public BusinessConfig() {
        super.setEndpoint(DEFAULT_ENDPOINT);
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public BusinessConfig setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public BusinessConfig setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String endpoint = DEFAULT_ENDPOINT;
        private String appId;
        private String appSecret;
        private Integer connectTimeout;
        private Integer readTimeout;

        public Builder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder appSecret(String appSecret) {
            this.appSecret = appSecret;
            return this;
        }

        public Builder connectTimeout(Integer connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder readTimeout(Integer readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public BusinessConfig build() {
            BusinessConfig config = new BusinessConfig();
            config.setEndpoint(this.endpoint);
            config.appId = this.appId;
            config.appSecret = this.appSecret;
            if (this.connectTimeout != null) {
                config.setConnectTimeout(this.connectTimeout);
            }
            if (this.readTimeout != null) {
                config.setReadTimeout(this.readTimeout);
            }
            return config;
        }
    }
}
