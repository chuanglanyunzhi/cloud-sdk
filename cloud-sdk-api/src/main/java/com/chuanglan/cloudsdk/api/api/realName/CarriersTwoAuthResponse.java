package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 运营商二要素核验响应。
 */
public class CarriersTwoAuthResponse extends RealNameCommonResponse {

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
    public CarriersTwoAuthResponseData data;

    public CarriersTwoAuthResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public CarriersTwoAuthResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public CarriersTwoAuthResponse setData(CarriersTwoAuthResponseData data) {
        this.data = data;
        return this;
    }
}
