package com.chuanglan.cloudsdk.api.api.business;

/**
 * 行驶证 OCR V2 识别响应。
 */
public class VehicleLicenseOcrV2Response extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    public Integer chargeStatus;

    /**
     * 扣费条数。
     */
    public Integer chargeCount;

    /**
     * 返回数据。
     */
    public VehicleLicenseOcrV2Data data;

    public VehicleLicenseOcrV2Response setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public VehicleLicenseOcrV2Response setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public VehicleLicenseOcrV2Response setData(VehicleLicenseOcrV2Data data) {
        this.data = data;
        return this;
    }
}
