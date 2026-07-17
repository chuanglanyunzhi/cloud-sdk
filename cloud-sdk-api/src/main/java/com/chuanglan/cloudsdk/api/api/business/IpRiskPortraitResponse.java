package com.chuanglan.cloudsdk.api.api.business;

/**
 * IP 风险画像响应。
 */
public class IpRiskPortraitResponse extends BusinessCommonResponse {

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
    public IpRiskPortraitResponseData data;

    public IpRiskPortraitResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public IpRiskPortraitResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public IpRiskPortraitResponse setData(IpRiskPortraitResponseData data) {
        this.data = data;
        return this;
    }
}
