package com.chuanglan.cloudsdk.api.api.business;

/**
 * IP 代理识别响应。
 */
public class IpProxyIdentificationResponse extends BusinessCommonResponse {

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
    private IpProxyIdentificationResponseData data;

    public IpProxyIdentificationResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public IpProxyIdentificationResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public IpProxyIdentificationResponse setData(IpProxyIdentificationResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public IpProxyIdentificationResponseData getData() {
        return this.data;
    }
}
