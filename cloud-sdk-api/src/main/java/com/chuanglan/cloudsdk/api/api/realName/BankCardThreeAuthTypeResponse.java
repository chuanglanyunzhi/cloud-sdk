package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 银行卡三要素多证件版核验响应。
 */
public class BankCardThreeAuthTypeResponse extends RealNameCommonResponse {

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
    private BankCardThreeAuthTypeResponseData data;

    public BankCardThreeAuthTypeResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BankCardThreeAuthTypeResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BankCardThreeAuthTypeResponse setData(BankCardThreeAuthTypeResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public BankCardThreeAuthTypeResponseData getData() {
        return this.data;
    }
}
