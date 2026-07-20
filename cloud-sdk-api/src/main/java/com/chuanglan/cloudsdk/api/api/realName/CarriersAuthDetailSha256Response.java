package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 运营商三要素详细版 SHA256 核验响应。
 */
public class CarriersAuthDetailSha256Response extends RealNameCommonResponse {

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
    private CarriersAuthDetailSha256ResponseData data;

    public CarriersAuthDetailSha256Response setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public CarriersAuthDetailSha256Response setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public CarriersAuthDetailSha256Response setData(CarriersAuthDetailSha256ResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public CarriersAuthDetailSha256ResponseData getData() {
        return this.data;
    }
}
