package com.chuanglan.cloudsdk.api.api.number;

/**
 * 号码实时基础版查询响应。
 */
public class NumberMobStatusBasicResponse extends NumberCommonResponse {

    /**
     * 1：收费；0：不收费。
     */
    public Integer chargeStatus;

    /**
     * 计费条数。
     */
    public Integer chargeCount;

    /**
     * 号码实时基础版业务数据。
     */
    public NumberMobStatusBasicResponseData data;

    public NumberMobStatusBasicResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public NumberMobStatusBasicResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public NumberMobStatusBasicResponse setData(NumberMobStatusBasicResponseData data) {
        this.data = data;
        return this;
    }
}
