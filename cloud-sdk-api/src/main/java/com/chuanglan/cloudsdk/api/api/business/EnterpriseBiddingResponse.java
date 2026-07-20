package com.chuanglan.cloudsdk.api.api.business;

/**
 * 企业招投标信息查询（翻页）响应。
 */
public class EnterpriseBiddingResponse extends BusinessCommonResponse {

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
    private EnterpriseBiddingData data;

    public EnterpriseBiddingResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public EnterpriseBiddingResponse setChargeCount(String chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public EnterpriseBiddingResponse setData(EnterpriseBiddingData data) {
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

    public EnterpriseBiddingData getData() {
        return this.data;
    }
}
