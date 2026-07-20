package com.chuanglan.cloudsdk.api.api.number;

/**
 * 二次号查询响应。
 */
public class NumberSecondHandResponse extends NumberCommonResponse {

    /**
     * 1：收费；0：不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private Integer chargeCount;

    /**
     * 二次号业务数据。
     */
    private NumberSecondHandResponseData data;

    public NumberSecondHandResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public NumberSecondHandResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public NumberSecondHandResponse setData(NumberSecondHandResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public NumberSecondHandResponseData getData() {
        return this.data;
    }
}
