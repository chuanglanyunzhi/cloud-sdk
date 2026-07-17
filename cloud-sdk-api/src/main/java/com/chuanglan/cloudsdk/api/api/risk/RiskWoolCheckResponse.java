package com.chuanglan.cloudsdk.api.api.risk;

/**
 * 羊毛党检测响应。
 */
public class RiskWoolCheckResponse extends RiskCommonResponse {

    /**
     * 1：收费；0：不收费。
     */
    public Integer chargeStatus;

    /**
     * 计费条数。
     */
    public Integer chargeCount;

    /**
     * 返回结果对象。
     */
    public RiskWoolCheckResponseData data;

    public RiskWoolCheckResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public RiskWoolCheckResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public RiskWoolCheckResponse setData(RiskWoolCheckResponseData data) {
        this.data = data;
        return this;
    }
}
