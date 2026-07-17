package com.chuanglan.cloudsdk.api.api.business;

/**
 * 企业二要素核验响应。
 */
public class EnterpriseTwoElementsCheckResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    public Integer chargeStatus;

    /**
     * 计费条数。
     */
    public String chargeCount;

    /**
     * 返回数据。
     */
    public EnterpriseTwoElementsCheckData data;

    public EnterpriseTwoElementsCheckResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public EnterpriseTwoElementsCheckResponse setChargeCount(String chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public EnterpriseTwoElementsCheckResponse setData(EnterpriseTwoElementsCheckData data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean isSuccess() {
        return "200000".equals(code) || super.isSuccess();
    }
}
