package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 涉外身份证校验响应。
 */
public class ForeignIdCardAuthResponse extends RealNameCommonResponse {

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
    private ForeignIdCardAuthResponseData data;

    public ForeignIdCardAuthResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public ForeignIdCardAuthResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public ForeignIdCardAuthResponse setData(ForeignIdCardAuthResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public ForeignIdCardAuthResponseData getData() {
        return this.data;
    }
}
