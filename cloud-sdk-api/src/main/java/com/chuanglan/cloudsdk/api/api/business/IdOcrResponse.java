package com.chuanglan.cloudsdk.api.api.business;

/**
 * 身份证 OCR 识别响应。
 */
public class IdOcrResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    public Integer chargeStatus;

    /**
     * 返回数据。
     */
    public IdOcrData data;

    public IdOcrResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public IdOcrResponse setData(IdOcrData data) {
        this.data = data;
        return this;
    }
}
