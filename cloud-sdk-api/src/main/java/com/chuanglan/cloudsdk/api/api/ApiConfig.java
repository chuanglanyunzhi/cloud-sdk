package com.chuanglan.cloudsdk.api.api;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * API 业务非鉴权配置基类。
 */
public class ApiConfig extends CloudSdkModel {

    private String endpoint;
    private Integer connectTimeout = 10000;
    private Integer readTimeout = 10000;

    public String getEndpoint() {
        return endpoint;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public ApiConfig setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public ApiConfig setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public ApiConfig setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }
}
