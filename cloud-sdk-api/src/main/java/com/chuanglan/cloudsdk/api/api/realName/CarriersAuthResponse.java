package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 运营商三要素核验响应。
 */
public class CarriersAuthResponse extends RealNameCommonResponse {

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
    private CarriersAuthResponseData data;

    public CarriersAuthResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public CarriersAuthResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public CarriersAuthResponse setData(CarriersAuthResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public CarriersAuthResponseData getData() {
        return this.data;
    }
}
