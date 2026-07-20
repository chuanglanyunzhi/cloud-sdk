package com.chuanglan.cloudsdk.api.api.business;

/**
 * 发票 OCR 识别响应。
 */
public class InvoiceOcrResponse extends BusinessCommonResponse {

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
    private InvoiceOcrData data;

    public InvoiceOcrResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public InvoiceOcrResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public InvoiceOcrResponse setData(InvoiceOcrData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public InvoiceOcrData getData() {
        return this.data;
    }
}
