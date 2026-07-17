package com.chuanglan.cloudsdk.api.api.business;

/**
 * 动态活体检测响应。
 */
public class LifeCheckResponse extends BusinessCommonResponse {

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
    public LifeCheckData data;

    public LifeCheckResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public LifeCheckResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public LifeCheckResponse setData(LifeCheckData data) {
        this.data = data;
        return this;
    }
}
