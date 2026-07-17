package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 253 视频短信（RCS）非鉴权配置（appId / appSecret 由调用方直接传入 RcsSmsClient）。
 */
public class RcsSmsConfig extends CloudSdkModel {

    /**
     * 视频短信默认接入地址。
     */
    public static final String DEFAULT_ENDPOINT = "https://rcs.253.com";

    /**
     * 视频短信接入地址，默认为 {@link #DEFAULT_ENDPOINT}。
     */
    public String endpoint = DEFAULT_ENDPOINT;

    /**
     * 连接超时，单位毫秒。
     */
    public Integer connectTimeout = 10000;

    /**
     * 读取超时，单位毫秒。
     */
    public Integer readTimeout = 10000;

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
