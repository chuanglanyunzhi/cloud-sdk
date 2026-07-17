package com.chuanglan.cloudsdk.api.api.business;

/**
 * 企业大中小微划型服务响应。
 */
public class CompanyLevelResponse extends BusinessCommonResponse {

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
    public CompanyLevelData data;

    public CompanyLevelResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public CompanyLevelResponse setChargeCount(String chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public CompanyLevelResponse setData(CompanyLevelData data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean isSuccess() {
        return "200000".equals(code) || super.isSuccess();
    }
}
