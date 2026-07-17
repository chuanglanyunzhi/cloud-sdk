package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 银行卡二要素标准版核验响应。
 */
public class BankCardTwoAuthResponse extends RealNameCommonResponse {

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
    public BankCardTwoAuthResponseData data;

    public BankCardTwoAuthResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BankCardTwoAuthResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BankCardTwoAuthResponse setData(BankCardTwoAuthResponseData data) {
        this.data = data;
        return this;
    }
}
