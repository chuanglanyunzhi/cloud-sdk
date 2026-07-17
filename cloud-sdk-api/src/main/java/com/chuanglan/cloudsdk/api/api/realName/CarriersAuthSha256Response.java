package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 运营商三要素 SHA256 核验响应。
 */
public class CarriersAuthSha256Response extends RealNameCommonResponse {

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
    public CarriersAuthSha256ResponseData data;

    public CarriersAuthSha256Response setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public CarriersAuthSha256Response setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public CarriersAuthSha256Response setData(CarriersAuthSha256ResponseData data) {
        this.data = data;
        return this;
    }
}
