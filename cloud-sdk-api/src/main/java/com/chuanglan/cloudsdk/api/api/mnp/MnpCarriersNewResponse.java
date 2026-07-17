package com.chuanglan.cloudsdk.api.api.mnp;

/**
 * 携号转网 V1 查询响应。
 */
public class MnpCarriersNewResponse extends MnpCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    public Integer chargeStatus;

    /**
     * 业务数据。
     */
    public MnpCarriersNewResponseData data;

    public MnpCarriersNewResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public MnpCarriersNewResponse setData(MnpCarriersNewResponseData data) {
        this.data = data;
        return this;
    }
}
