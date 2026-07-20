package com.chuanglan.cloudsdk.api.api.realName;

/**
 * IP 归属地查询响应。
 */
public class IpGsdQueryResponse extends RealNameCommonResponse {

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
    private IpGsdQueryResponseData data;

    public IpGsdQueryResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public IpGsdQueryResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public IpGsdQueryResponse setData(IpGsdQueryResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public IpGsdQueryResponseData getData() {
        return this.data;
    }
}
