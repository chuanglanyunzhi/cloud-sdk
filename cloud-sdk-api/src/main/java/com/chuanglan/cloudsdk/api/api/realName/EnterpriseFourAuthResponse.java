package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 企业四要素核验响应。
 */
public class EnterpriseFourAuthResponse extends RealNameCommonResponse {

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
    private EnterpriseFourAuthResponseData data;

    public EnterpriseFourAuthResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public EnterpriseFourAuthResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public EnterpriseFourAuthResponse setData(EnterpriseFourAuthResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public EnterpriseFourAuthResponseData getData() {
        return this.data;
    }
}
