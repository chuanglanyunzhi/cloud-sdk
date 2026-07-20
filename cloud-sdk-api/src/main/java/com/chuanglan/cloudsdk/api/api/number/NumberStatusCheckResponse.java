package com.chuanglan.cloudsdk.api.api.number;

import java.util.List;

/**
 * 号码状态检测响应。
 */
public class NumberStatusCheckResponse extends NumberCommonResponse {

    /**
     * 1：收费；0：不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private Integer chargeCount;

    /**
     * 检测结果列表。
     */
    private List<NumberStatusCheckResponseItem> data;

    public NumberStatusCheckResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public NumberStatusCheckResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public NumberStatusCheckResponse setData(List<NumberStatusCheckResponseItem> data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public List<NumberStatusCheckResponseItem> getData() {
        return this.data;
    }
}
