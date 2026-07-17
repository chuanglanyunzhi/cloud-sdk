package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 银行卡五要素标准版核验响应。
 */
public class BankCardFiveAuthResponse extends RealNameCommonResponse {

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
    public BankCardFiveAuthResponseData data;

    public BankCardFiveAuthResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BankCardFiveAuthResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BankCardFiveAuthResponse setData(BankCardFiveAuthResponseData data) {
        this.data = data;
        return this;
    }
}
