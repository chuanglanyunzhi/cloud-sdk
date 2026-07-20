package com.chuanglan.cloudsdk.api.api.number;

/**
 * 手机号码归属地（升级版 V2）响应。
 */
public class NumberPhoneAttributionV2Response extends NumberCommonResponse {

    /**
     * 1：收费；0：不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private Integer chargeCount;

    /**
     * 归属地业务数据。
     */
    private NumberPhoneAttributionV2ResponseData data;

    public NumberPhoneAttributionV2Response setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public NumberPhoneAttributionV2Response setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public NumberPhoneAttributionV2Response setData(NumberPhoneAttributionV2ResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public NumberPhoneAttributionV2ResponseData getData() {
        return this.data;
    }
}
