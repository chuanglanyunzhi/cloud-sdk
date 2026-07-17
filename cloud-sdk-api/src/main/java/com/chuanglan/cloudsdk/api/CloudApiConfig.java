package com.chuanglan.cloudsdk.api;

import com.chuanglan.cloudsdk.api.intSms.IntSmsConfig;
import com.chuanglan.cloudsdk.api.rcsSms.RcsSmsConfig;
import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 253 云 SDK 统一配置，聚合全部业务接入地址与公共运行时参数。
 */
public class CloudApiConfig extends CloudSdkModel {

    /**
     * 号码业务默认接入地址。
     */
    public static final String DEFAULT_NUMBER_ENDPOINT = "https://wskh.253.com";

    /**
     * 号码运营商业务默认接入地址。
     */
    public static final String DEFAULT_NUMBER_CARRIER_ENDPOINT = "https://wscarrier.253.com";

    /**
     * 风控业务默认接入地址。
     */
    public static final String DEFAULT_RISK_ENDPOINT = "https://wsrisk.253.com";

    /**
     * 携号转网业务默认接入地址。
     */
    public static final String DEFAULT_MNP_ENDPOINT = "https://wsmnp.253.com";

    /**
     * 短信业务默认接入地址。
     */
    public static final String DEFAULT_SMS_ENDPOINT = "https://smssh.253.com";

    /**
     * 短信管理类接口默认接入地址。
     */
    public static final String DEFAULT_SMS_API_ENDPOINT = "https://api.chuanglan.com";

    /**
     * 号码业务接入地址。
     */
    public String numberEndpoint = DEFAULT_NUMBER_ENDPOINT;

    /**
     * 号码运营商业务接入地址。
     */
    public String numberCarrierEndpoint = DEFAULT_NUMBER_CARRIER_ENDPOINT;

    /**
     * 风控业务接入地址。
     */
    public String riskEndpoint = DEFAULT_RISK_ENDPOINT;

    /**
     * 携号转网业务接入地址。
     */
    public String mnpEndpoint = DEFAULT_MNP_ENDPOINT;

    /**
     * 短信业务接入地址。
     */
    public String smsEndpoint = DEFAULT_SMS_ENDPOINT;

    /**
     * 短信管理类接口接入地址。
     */
    public String smsApiEndpoint = DEFAULT_SMS_API_ENDPOINT;

    /**
     * 国际短信节点地址，默认上海节点。
     */
    public String intSmsEndpoint = IntSmsConfig.SHANGHAI_ENDPOINT;

    /**
     * 视频短信（RCS）接入地址。
     */
    public String rcsSmsEndpoint = RcsSmsConfig.DEFAULT_ENDPOINT;

    /**
     * 实名认证业务默认接入地址。
     */
    public static final String DEFAULT_REAL_NAME_ENDPOINT = "https://wsauth.253.com";

    /**
     * 实名认证业务接入地址。
     */
    public String realNameEndpoint = DEFAULT_REAL_NAME_ENDPOINT;

    /**
     * 实名认证业务详细版 API 默认接入地址。
     */
    public static final String DEFAULT_REAL_NAME_API_ENDPOINT = "https://api.253.com";

    /**
     * 实名认证业务详细版 API 接入地址。
     */
    public String realNameApiEndpoint = DEFAULT_REAL_NAME_API_ENDPOINT;

    /**
     * 羊毛党检测默认接入地址。
     */
    public static final String DEFAULT_WOOL_ENDPOINT = "https://wsapi.253.com";

    /**
     * 羊毛党检测接入地址。
     */
    public String woolEndpoint = DEFAULT_WOOL_ENDPOINT;

    /**
     * 业务线默认接入地址。
     */
    public static final String DEFAULT_BUSINESS_ENDPOINT = "https://wsapi.253.com";

    /**
     * 业务线接入地址。
     */
    public String businessEndpoint = DEFAULT_BUSINESS_ENDPOINT;

    /**
     * 连接超时，单位毫秒。
     */
    public Integer connectTimeout = 10000;

    /**
     * 读取超时，单位毫秒。
     */
    public Integer readTimeout = 10000;

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
