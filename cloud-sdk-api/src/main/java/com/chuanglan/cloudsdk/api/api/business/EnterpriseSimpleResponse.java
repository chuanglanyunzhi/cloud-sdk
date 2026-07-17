package com.chuanglan.cloudsdk.api.api.business;

/**
 * 企业工商信息查询（简项）响应。
 */
public class EnterpriseSimpleResponse extends BusinessCommonResponse {

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
    public EnterpriseSimpleData data;

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
        return "200000".equals(code) || super.isSuccess();
    }
}
