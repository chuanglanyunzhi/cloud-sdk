package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 银行卡三要素详细版核验响应。
 */
public class BankCardThreeAuthDetailResponse extends RealNameCommonResponse {

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
    private BankCardThreeAuthResponseData data;

    public BankCardThreeAuthDetailResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public BankCardThreeAuthDetailResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public BankCardThreeAuthDetailResponse setData(BankCardThreeAuthResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public BankCardThreeAuthResponseData getData() {
        return this.data;
    }
}
