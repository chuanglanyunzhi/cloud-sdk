package com.chuanglan.cloudsdk.api;

import com.chuanglan.cloudsdk.api.intSms.IntSmsConfig;
import com.chuanglan.cloudsdk.api.rcsSms.RcsSmsConfig;
import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 253 云 SDK 统一配置，聚合全部业务接入地址与公共运行时参数。
 */
public class CloudApiConfig extends CloudSdkModel {

    public static final String DEFAULT_NUMBER_ENDPOINT = "https://wskh.253.com";
    public static final String DEFAULT_NUMBER_CARRIER_ENDPOINT = "https://wscarrier.253.com";
    public static final String DEFAULT_RISK_ENDPOINT = "https://wsrisk.253.com";
    public static final String DEFAULT_MNP_ENDPOINT = "https://wsmnp.253.com";
    public static final String DEFAULT_SMS_ENDPOINT = "https://smssh.253.com";
    public static final String DEFAULT_SMS_API_ENDPOINT = "https://api.chuanglan.com";
    public static final String DEFAULT_REAL_NAME_ENDPOINT = "https://wsauth.253.com";
    public static final String DEFAULT_REAL_NAME_API_ENDPOINT = "https://api.253.com";
    public static final String DEFAULT_WOOL_ENDPOINT = "https://wsapi.253.com";
    public static final String DEFAULT_BUSINESS_ENDPOINT = "https://wsapi.253.com";

    private String numberEndpoint = DEFAULT_NUMBER_ENDPOINT;
    private String numberCarrierEndpoint = DEFAULT_NUMBER_CARRIER_ENDPOINT;
    private String riskEndpoint = DEFAULT_RISK_ENDPOINT;
    private String mnpEndpoint = DEFAULT_MNP_ENDPOINT;
    private String smsEndpoint = DEFAULT_SMS_ENDPOINT;
    private String smsApiEndpoint = DEFAULT_SMS_API_ENDPOINT;
    private String intSmsEndpoint = IntSmsConfig.SHANGHAI_ENDPOINT;
    private String rcsSmsEndpoint = RcsSmsConfig.DEFAULT_ENDPOINT;
    private String realNameEndpoint = DEFAULT_REAL_NAME_ENDPOINT;
    private String realNameApiEndpoint = DEFAULT_REAL_NAME_API_ENDPOINT;
    private String woolEndpoint = DEFAULT_WOOL_ENDPOINT;
    private String businessEndpoint = DEFAULT_BUSINESS_ENDPOINT;
    private Integer connectTimeout = 10000;
    private Integer readTimeout = 10000;

    public String getNumberEndpoint() {
        return numberEndpoint;
    }

    public String getNumberCarrierEndpoint() {
        return numberCarrierEndpoint;
    }

    public String getRiskEndpoint() {
        return riskEndpoint;
    }

    public String getMnpEndpoint() {
        return mnpEndpoint;
    }

    public String getSmsEndpoint() {
        return smsEndpoint;
    }

    public String getSmsApiEndpoint() {
        return smsApiEndpoint;
    }

    public String getIntSmsEndpoint() {
        return intSmsEndpoint;
    }

    public String getRcsSmsEndpoint() {
        return rcsSmsEndpoint;
    }

    public String getRealNameEndpoint() {
        return realNameEndpoint;
    }

    public String getRealNameApiEndpoint() {
        return realNameApiEndpoint;
    }

    public String getWoolEndpoint() {
        return woolEndpoint;
    }

    public String getBusinessEndpoint() {
        return businessEndpoint;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public CloudApiConfig setNumberEndpoint(String numberEndpoint) {
        this.numberEndpoint = numberEndpoint;
        return this;
    }

    public CloudApiConfig setNumberCarrierEndpoint(String numberCarrierEndpoint) {
        this.numberCarrierEndpoint = numberCarrierEndpoint;
        return this;
    }

    public CloudApiConfig setRiskEndpoint(String riskEndpoint) {
        this.riskEndpoint = riskEndpoint;
        return this;
    }

    public CloudApiConfig setMnpEndpoint(String mnpEndpoint) {
        this.mnpEndpoint = mnpEndpoint;
        return this;
    }

    public CloudApiConfig setSmsEndpoint(String smsEndpoint) {
        this.smsEndpoint = smsEndpoint;
        return this;
    }

    public CloudApiConfig setSmsApiEndpoint(String smsApiEndpoint) {
        this.smsApiEndpoint = smsApiEndpoint;
        return this;
    }


    public CloudApiConfig setIntSmsEndpoint(String intSmsEndpoint) {
        this.intSmsEndpoint = intSmsEndpoint;
        return this;
    }

    public CloudApiConfig setRcsSmsEndpoint(String rcsSmsEndpoint) {
        this.rcsSmsEndpoint = rcsSmsEndpoint;
        return this;
    }

    public CloudApiConfig setRealNameEndpoint(String realNameEndpoint) {
        this.realNameEndpoint = realNameEndpoint;
        return this;
    }

    public CloudApiConfig setRealNameApiEndpoint(String realNameApiEndpoint) {
        this.realNameApiEndpoint = realNameApiEndpoint;
        return this;
    }

    public CloudApiConfig setWoolEndpoint(String woolEndpoint) {
        this.woolEndpoint = woolEndpoint;
        return this;
    }

    public CloudApiConfig setBusinessEndpoint(String businessEndpoint) {
        this.businessEndpoint = businessEndpoint;
        return this;
    }

    public CloudApiConfig setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public CloudApiConfig setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }
}
