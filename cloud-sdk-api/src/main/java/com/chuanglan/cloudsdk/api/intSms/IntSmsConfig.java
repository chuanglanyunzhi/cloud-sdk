package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信非鉴权配置（appId / appSecret 由调用方直接传入 IntSmsClient）。
 */
public class IntSmsConfig extends CloudSdkModel {

    /** 上海节点。 */
    public static final String SHANGHAI_ENDPOINT = "https://intapi.tig253.com";

    /** 新加坡节点。 */
    public static final String SINGAPORE_ENDPOINT = "https://sg-intapi.tig253.com";

    /** 印尼节点。 */
    public static final String INDONESIA_ENDPOINT = "https://id-api.tig253.com";

    /**
     * 连接超时，单位毫秒。
     */
    public Integer connectTimeout = 10000;

    /**
     * 读取超时，单位毫秒。
     */
    public Integer readTimeout = 10000;

    public IntSmsConfig setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public IntSmsConfig setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }
}
