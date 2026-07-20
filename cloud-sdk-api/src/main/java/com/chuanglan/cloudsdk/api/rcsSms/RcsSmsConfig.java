package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 253 视频短信（RCS）非鉴权配置（appId / appSecret 由调用方直接传入 RcsSmsClient）。
 */
public class RcsSmsConfig extends CloudSdkModel {

    public static final String DEFAULT_ENDPOINT = "https://rcs.253.com";

    private String endpoint = DEFAULT_ENDPOINT;
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

    public RcsSmsConfig setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public RcsSmsConfig setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public RcsSmsConfig setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }
}
