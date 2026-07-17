package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 银行卡三要素标准版核验响应。
 */
public class BankCardThreeAuthResponse extends RealNameCommonResponse {

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
    public BankCardThreeAuthResponseData data;

    public BankCardThreeAuthResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BankCardThreeAuthResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BankCardThreeAuthResponse setData(BankCardThreeAuthResponseData data) {
        this.data = data;
        return this;
    }
}
