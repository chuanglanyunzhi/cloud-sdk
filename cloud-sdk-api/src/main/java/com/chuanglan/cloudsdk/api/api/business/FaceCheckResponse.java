package com.chuanglan.cloudsdk.api.api.business;

/**
 * 静态活体检测响应。
 */
public class FaceCheckResponse extends BusinessCommonResponse {

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
    public FaceCheckData data;

    public FaceCheckResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public FaceCheckResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public FaceCheckResponse setData(FaceCheckData data) {
        this.data = data;
        return this;
    }
}
