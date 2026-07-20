package com.chuanglan.cloudsdk.api.api.business;

/**
 * 驾驶证 OCR 识别响应。
 */
public class DrivingLicenseResponse extends BusinessCommonResponse {

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
    private DrivingLicenseData data;

    public DrivingLicenseResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public DrivingLicenseResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public DrivingLicenseResponse setData(DrivingLicenseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public DrivingLicenseData getData() {
        return this.data;
    }
}
