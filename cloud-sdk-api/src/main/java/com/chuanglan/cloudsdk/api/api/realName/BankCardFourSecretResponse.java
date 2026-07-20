package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 银行卡四要素简版加密核验响应。
 */
public class BankCardFourSecretResponse extends RealNameCommonResponse {

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
    private BankCardFourSecretResponseData data;

    public BankCardFourSecretResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BankCardFourSecretResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BankCardFourSecretResponse setData(BankCardFourSecretResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public BankCardFourSecretResponseData getData() {
        return this.data;
    }
}
