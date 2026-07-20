package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 253 短信服务非鉴权配置（appId / appSecret 由调用方直接传入 SmsClient）。
 */
public class SmsConfig extends CloudSdkModel {

    private String endpoint = "https://smssh.253.com";
    private String apiEndpoint = "https://api.chuanglan.com";
    private Integer connectTimeout = 10000;
    private Integer readTimeout = 10000;

    public String getEndpoint() {
        return endpoint;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

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
