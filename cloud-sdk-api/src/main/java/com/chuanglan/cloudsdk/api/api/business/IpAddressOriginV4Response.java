package com.chuanglan.cloudsdk.api.api.business;

/**
 * IP 归属地查询 V4 响应。
 */
public class IpAddressOriginV4Response extends BusinessCommonResponse {

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
    public IpAddressOriginV4ResponseData data;

    public IpAddressOriginV4Response setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public IpAddressOriginV4Response setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public IpAddressOriginV4Response setData(IpAddressOriginV4ResponseData data) {
        this.data = data;
        return this;
    }
}
