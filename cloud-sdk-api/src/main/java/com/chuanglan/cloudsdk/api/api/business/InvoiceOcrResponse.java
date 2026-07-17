package com.chuanglan.cloudsdk.api.api.business;

/**
 * 发票 OCR 识别响应。
 */
public class InvoiceOcrResponse extends BusinessCommonResponse {

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
    public InvoiceOcrData data;

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
}
