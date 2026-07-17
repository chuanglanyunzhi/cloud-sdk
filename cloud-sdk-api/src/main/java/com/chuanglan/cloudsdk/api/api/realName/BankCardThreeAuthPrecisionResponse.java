package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 银行卡三要素精准版非身份证核验响应。
 */
public class BankCardThreeAuthPrecisionResponse extends RealNameCommonResponse {

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
    public BankCardThreeAuthPrecisionResponseData data;

    public BankCardThreeAuthPrecisionResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BankCardThreeAuthPrecisionResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BankCardThreeAuthPrecisionResponse setData(BankCardThreeAuthPrecisionResponseData data) {
        this.data = data;
        return this;
    }
}
