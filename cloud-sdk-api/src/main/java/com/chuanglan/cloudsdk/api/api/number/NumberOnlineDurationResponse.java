package com.chuanglan.cloudsdk.api.api.number;

/**
 * 号码在网时长查询响应。
 */
public class NumberOnlineDurationResponse extends NumberCommonResponse {

    /**
     * 1：收费；0：不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private Integer chargeCount;

    /**
     * 号码在网时长业务数据。
     */
    private NumberOnlineDurationResponseData data;

    public NumberOnlineDurationResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public NumberOnlineDurationResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public NumberOnlineDurationResponse setData(NumberOnlineDurationResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public NumberOnlineDurationResponseData getData() {
        return this.data;
    }
}
