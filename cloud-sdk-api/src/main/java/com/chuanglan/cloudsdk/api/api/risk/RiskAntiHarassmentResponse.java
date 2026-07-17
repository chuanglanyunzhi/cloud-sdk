package com.chuanglan.cloudsdk.api.api.risk;

import java.util.List;

/**
 * 防骚扰黑名单查询响应。
 */
public class RiskAntiHarassmentResponse extends RiskCommonResponse {

    /**
     * 1：收费；0：不收费。
     */
    public Integer chargeStatus;

    /**
     * 计费条数。
     */
    public Integer chargeCount;

    /**
     * 返回结果列表。
     */
    public List<RiskAntiHarassmentResponseItem> data;

    public RiskAntiHarassmentResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public RiskAntiHarassmentResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public RiskAntiHarassmentResponse setData(List<RiskAntiHarassmentResponseItem> data) {
        this.data = data;
        return this;
    }
}
