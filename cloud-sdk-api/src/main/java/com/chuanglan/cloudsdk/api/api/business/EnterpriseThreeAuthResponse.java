package com.chuanglan.cloudsdk.api.api.business;

/**
 * 企业三要素核验响应。
 */
public class EnterpriseThreeAuthResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    public Integer chargeStatus;

    /**
     * 返回数据。
     */
    public EnterpriseThreeAuthResponseData data;

    public EnterpriseThreeAuthResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public EnterpriseThreeAuthResponse setData(EnterpriseThreeAuthResponseData data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean isSuccess() {
        return "200000".equals(code) || super.isSuccess();
    }
}
