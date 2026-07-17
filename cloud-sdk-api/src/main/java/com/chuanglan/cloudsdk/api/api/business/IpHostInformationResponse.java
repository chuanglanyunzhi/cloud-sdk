package com.chuanglan.cloudsdk.api.api.business;

/**
 * IP 宿主信息响应。
 */
public class IpHostInformationResponse extends BusinessCommonResponse {

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
    public IpHostInformationResponseData data;

    public IpHostInformationResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public IpHostInformationResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public IpHostInformationResponse setData(IpHostInformationResponseData data) {
        this.data = data;
        return this;
    }
}
