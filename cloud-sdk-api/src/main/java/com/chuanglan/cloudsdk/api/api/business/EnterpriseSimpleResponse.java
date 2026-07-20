package com.chuanglan.cloudsdk.api.api.business;

/**
 * 企业工商信息查询（简项）响应。
 */
public class EnterpriseSimpleResponse extends BusinessCommonResponse {

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
    private EnterpriseSimpleData data;

    public EnterpriseSimpleResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public EnterpriseSimpleResponse setChargeCount(String chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public EnterpriseSimpleResponse setData(EnterpriseSimpleData data) {
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

    public EnterpriseSimpleData getData() {
        return this.data;
    }
}
