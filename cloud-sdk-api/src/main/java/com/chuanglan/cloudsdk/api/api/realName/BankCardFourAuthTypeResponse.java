package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 银行卡四要素多证件版核验响应。
 */
public class BankCardFourAuthTypeResponse extends RealNameCommonResponse {

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
    private BankCardFourAuthTypeResponseData data;

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

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public BankCardFourAuthTypeResponseData getData() {
        return this.data;
    }
}
