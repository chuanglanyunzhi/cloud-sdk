package com.chuanglan.cloudsdk.api.api.business;

/**
 * 营业执照 OCR 识别响应。
 */
public class BusinessLicenseResponse extends BusinessCommonResponse {

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
    private BusinessLicenseData data;

    public BusinessLicenseResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BusinessLicenseResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BusinessLicenseResponse setData(BusinessLicenseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public BusinessLicenseData getData() {
        return this.data;
    }
}
