package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 运营商三要素详细版核验响应。
 */
public class CarriersAuthDetailResponse extends RealNameCommonResponse {

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
    public CarriersAuthDetailResponseData data;

    public CarriersAuthDetailResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public CarriersAuthDetailResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public CarriersAuthDetailResponse setData(CarriersAuthDetailResponseData data) {
        this.data = data;
        return this;
    }
}
