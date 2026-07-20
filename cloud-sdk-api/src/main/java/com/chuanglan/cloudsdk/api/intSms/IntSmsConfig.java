package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信非鉴权配置（appId / appSecret 由调用方直接传入 IntSmsClient）。
 */
public class IntSmsConfig extends CloudSdkModel {

    public static final String SHANGHAI_ENDPOINT = "https://intapi.tig253.com";
    public static final String SINGAPORE_ENDPOINT = "https://sg-intapi.tig253.com";
    public static final String INDONESIA_ENDPOINT = "https://id-api.tig253.com";

    private Integer connectTimeout = 10000;
    private Integer readTimeout = 10000;

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public IntSmsConfig setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public IntSmsConfig setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }
}
