package com.chuanglan.cloudsdk.api.api.business;

/**
 * IP 真人识别响应。
 */
public class IpFacialRecognitionResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    public Integer chargeStatus;

    /**
     * 计费条数。
     */
    public Integer chargeCount;

    /**
     * 返回数据。
     */
    public IpFacialRecognitionResponseData data;

    public IpFacialRecognitionResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public IpFacialRecognitionResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public IpFacialRecognitionResponse setData(IpFacialRecognitionResponseData data) {
        this.data = data;
        return this;
    }
}
