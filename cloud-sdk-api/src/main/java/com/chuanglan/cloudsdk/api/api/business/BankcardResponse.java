package com.chuanglan.cloudsdk.api.api.business;

/**
 * 银行卡 OCR 识别响应。
 */
public class BankcardResponse extends BusinessCommonResponse {

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
    public BankcardData data;

    public BankcardResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BankcardResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BankcardResponse setData(BankcardData data) {
        this.data = data;
        return this;
    }
}
