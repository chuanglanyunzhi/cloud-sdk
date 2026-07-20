package com.chuanglan.cloudsdk.api.api.business;

/**
 * IP 归属地查询 V6 响应。
 */
public class IpAddressOriginV6Response extends BusinessCommonResponse {

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
    private IpAddressOriginV6ResponseData data;

    public IpAddressOriginV6Response setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public IpAddressOriginV6Response setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public IpAddressOriginV6Response setData(IpAddressOriginV6ResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public IpAddressOriginV6ResponseData getData() {
        return this.data;
    }
}
