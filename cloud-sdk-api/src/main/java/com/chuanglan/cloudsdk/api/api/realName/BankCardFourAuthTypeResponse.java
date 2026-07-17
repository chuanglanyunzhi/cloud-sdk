package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 银行卡四要素多证件版核验响应。
 */
public class BankCardFourAuthTypeResponse extends RealNameCommonResponse {

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
    public BankCardFourAuthTypeResponseData data;

    public BankCardFourAuthTypeResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BankCardFourAuthTypeResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BankCardFourAuthTypeResponse setData(BankCardFourAuthTypeResponseData data) {
        this.data = data;
        return this;
    }
}
