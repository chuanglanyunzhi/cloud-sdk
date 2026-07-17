package com.chuanglan.cloudsdk.api.api.number;

/**
 * 手机号码归属地（升级版 V2）响应。
 */
public class NumberPhoneAttributionV2Response extends NumberCommonResponse {

    /**
     * 1：收费；0：不收费。
     */
    public Integer chargeStatus;

    /**
     * 计费条数。
     */
    public Integer chargeCount;

    /**
     * 归属地业务数据。
     */
    public NumberPhoneAttributionV2ResponseData data;

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
}
