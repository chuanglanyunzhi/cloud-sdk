package com.chuanglan.cloudsdk.api.api.business;

/**
 * IP 真人识别响应。
 */
public class IpFacialRecognitionResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private Integer chargeCount;

    /**
     * 返回数据。
     */
    private IpFacialRecognitionResponseData data;

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

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public IpFacialRecognitionResponseData getData() {
        return this.data;
    }
}
