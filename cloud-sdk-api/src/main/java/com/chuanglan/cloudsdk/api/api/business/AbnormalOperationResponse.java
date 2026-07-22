package com.chuanglan.cloudsdk.api.api.business;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

/**
 * 经营异常查询响应。
 */
public class AbnormalOperationResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private String chargeCount;

    /**
     * 返回数据列表。
     */
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<AbnormalOperationItem> data;

    public AbnormalOperationResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public AbnormalOperationResponse setChargeCount(String chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public AbnormalOperationResponse setData(List<AbnormalOperationItem> data) {
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

    public List<AbnormalOperationItem> getData() {
        return this.data;
    }
}
