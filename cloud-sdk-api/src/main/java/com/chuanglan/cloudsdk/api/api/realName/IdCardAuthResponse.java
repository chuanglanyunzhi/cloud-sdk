package com.chuanglan.cloudsdk.api.api.realName;

/**
 * 身份证二要素核验响应。
 */
public class IdCardAuthResponse extends RealNameCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    public Integer chargeStatus;

    /**
     * 计费条数。
     */
    public Integer chargeCount;

    /**
     * 返回数据。
     */
    public IdCardAuthResponseData data;

    public IdCardAuthResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public IdCardAuthResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public IdCardAuthResponse setData(IdCardAuthResponseData data) {
        this.data = data;
        return this;
    }
}
