package com.chuanglan.cloudsdk.api.api.business;

import java.util.List;

/**
 * 企业工商模糊查询响应。
 */
public class EnterpriseQueryResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private String chargeCount;

    /**
     * 企业信息数组。
     */
    private List<EnterpriseQueryData> data;

    public EnterpriseQueryResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public EnterpriseQueryResponse setChargeCount(String chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public EnterpriseQueryResponse setData(List<EnterpriseQueryData> data) {
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

    public List<EnterpriseQueryData> getData() {
        return this.data;
    }
}
