package com.chuanglan.cloudsdk.api.api.business;

/**
 * IP 应用场景识别响应。
 */
public class IpApplicationScenariosResponse extends BusinessCommonResponse {

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
    private IpApplicationScenariosResponseData data;

    public IpApplicationScenariosResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public IpApplicationScenariosResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public IpApplicationScenariosResponse setData(IpApplicationScenariosResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public IpApplicationScenariosResponseData getData() {
        return this.data;
    }
}
