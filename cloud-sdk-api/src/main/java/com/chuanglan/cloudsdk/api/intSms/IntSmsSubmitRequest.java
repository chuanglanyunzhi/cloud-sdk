package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信发送请求。
 */
public class IntSmsSubmitRequest extends CloudSdkModel {

    /**
     * 短信类型：notify（验证码）、marketing（营销）等。
     */
    public String productType;

    /**
     * 短信内容，长度 ≤ 3000 字符。
     */
    public String message;

    /**
     * 接收手机号，支持带国家码，多个用英文逗号分隔。
     */
    public String phoneNumbers;

    /**
     * 接入号 / SenderId，长度 ≤ 20。
     */
    public String sender;

    /**
     * 业务方流水号 / 交易 id，长度 ≤ 128。
     */
    public String uid;

    /**
     * 短信状态报告异步回调地址。
     */
    public String callBackUrl;

    /**
     * 退订标识：1 = 开启，0 或 null = 关闭。
     */
    public Integer tdFlag;

    /**
     * 短信过期时间，相对格式：[+-]YYMMDDhhmm。
     */
    public String validityPeriod;

    public IntSmsSubmitRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public IntSmsSubmitRequest setMessage(String message) {
        this.message = message;
        return this;
    }

    public IntSmsSubmitRequest setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public IntSmsSubmitRequest setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public IntSmsSubmitRequest setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public IntSmsSubmitRequest setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
        return this;
    }

    public IntSmsSubmitRequest setTdFlag(Integer tdFlag) {
        this.tdFlag = tdFlag;
        return this;
    }

    public IntSmsSubmitRequest setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
        return this;
    }
}
