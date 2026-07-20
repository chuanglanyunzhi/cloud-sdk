package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 银行卡四要素精准版非身份证核验响应。
 */
public class BankCardFourAuthPrecisionResponse extends RealNameCommonResponse {

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
    private BankCardFourAuthPrecisionResponseData data;

    public BankCardFourAuthPrecisionResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BankCardFourAuthPrecisionResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BankCardFourAuthPrecisionResponse setData(BankCardFourAuthPrecisionResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public BankCardFourAuthPrecisionResponseData getData() {
        return this.data;
    }
}
