package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 253 短信服务非鉴权配置（appId / appSecret 由调用方直接传入 SmsClient）。
 */
public class SmsConfig extends CloudSdkModel {

    /**
     * 短信业务端点地址，默认 https://smssh.253.com。
     */
    public String endpoint = "https://smssh.253.com";

    /**
     * 资质/签名/模板等管理类端点地址，默认 https://api.chuanglan.com。
     */
    public String apiEndpoint = "https://api.chuanglan.com";

    /**
     * 连接超时，单位毫秒。
     */
    public Integer connectTimeout = 10000;

    /**
     * 读取超时，单位毫秒。
     */
    public Integer readTimeout = 10000;

    public SmsConfig setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public SmsConfig setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
        return this;
    }

    public SmsConfig setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public SmsConfig setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }
}
