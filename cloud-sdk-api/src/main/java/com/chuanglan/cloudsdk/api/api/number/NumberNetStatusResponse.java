package com.chuanglan.cloudsdk.api.api.number;

/**
 * 号码在网状态查询响应。
 */
public class NumberNetStatusResponse extends NumberCommonResponse {

    /**
     * 1：收费；0：不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private Integer chargeCount;

    /**
     * 号码在网状态业务数据。
     */
    private NumberNetStatusResponseData data;

    public NumberNetStatusResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public NumberNetStatusResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public NumberNetStatusResponse setData(NumberNetStatusResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public NumberNetStatusResponseData getData() {
        return this.data;
    }
}
