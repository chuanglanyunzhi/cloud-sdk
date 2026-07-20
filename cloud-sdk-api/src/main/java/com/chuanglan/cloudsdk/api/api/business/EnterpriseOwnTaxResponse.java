package com.chuanglan.cloudsdk.api.api.business;

/**
 * 企业欠税公告查询响应。
 */
public class EnterpriseOwnTaxResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private String chargeCount;

    /**
     * 返回数据。
     */
    private EnterpriseOwnTaxData data;

    public EnterpriseOwnTaxResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public EnterpriseOwnTaxResponse setChargeCount(String chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public EnterpriseOwnTaxResponse setData(EnterpriseOwnTaxData data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean isSuccess() {
        return "200000".equals(getCode()) || super.isSuccess();
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public String getChargeCount() {
        return this.chargeCount;
    }

    public EnterpriseOwnTaxData getData() {
        return this.data;
    }
}
