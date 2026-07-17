package com.chuanglan.cloudsdk.api.api;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * API 业务非鉴权配置基类。
 */
public class ApiConfig extends CloudSdkModel {

    /**
     * 业务接入地址。
     */
    public String endpoint;

    /**
     * 连接超时，单位毫秒。
     */
    public Integer connectTimeout = 10000;

    /**
     * 读取超时，单位毫秒。
     */
    public Integer readTimeout = 10000;

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
