package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 运营商二要素（身份证版）核验响应。
 */
public class CarriersTwoAuthIdNumResponse extends RealNameCommonResponse {

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
    public CarriersTwoAuthIdNumResponseData data;

    public CarriersTwoAuthIdNumResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public CarriersTwoAuthIdNumResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public CarriersTwoAuthIdNumResponse setData(CarriersTwoAuthIdNumResponseData data) {
        this.data = data;
        return this;
    }
}
