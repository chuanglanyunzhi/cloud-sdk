package com.chuanglan.cloudsdk.api.api.business;

/**
 * 行驶证 OCR 识别响应。
 */
public class VehicleLicenseResponse extends BusinessCommonResponse {

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
    public VehicleLicenseData data;

    public VehicleLicenseResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public VehicleLicenseResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public VehicleLicenseResponse setData(VehicleLicenseData data) {
        this.data = data;
        return this;
    }
}
