package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 运营商三要素详细版 MD5 核验响应。
 */
public class CarriersAuthDetailMd5Response extends RealNameCommonResponse {

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
    private CarriersAuthDetailMd5ResponseData data;

    public CarriersAuthDetailMd5Response setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public CarriersAuthDetailMd5Response setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public CarriersAuthDetailMd5Response setData(CarriersAuthDetailMd5ResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public CarriersAuthDetailMd5ResponseData getData() {
        return this.data;
    }
}
