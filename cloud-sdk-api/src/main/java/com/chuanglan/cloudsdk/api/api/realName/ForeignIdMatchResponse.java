package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 涉外身份证核验（人像）响应。
 */
public class ForeignIdMatchResponse extends RealNameCommonResponse {

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
    private ForeignIdMatchResponseData data;

    public ForeignIdMatchResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public ForeignIdMatchResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public ForeignIdMatchResponse setData(ForeignIdMatchResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public ForeignIdMatchResponseData getData() {
        return this.data;
    }
}
