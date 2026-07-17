package com.chuanglan.cloudsdk.api.api.business;

import java.util.List;

/**
 * 经营异常查询响应。
 */
public class AbnormalOperationResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    public Integer chargeStatus;

    /**
     * 计费条数。
     */
    public String chargeCount;

    /**
     * 返回数据列表。
     */
    public List<AbnormalOperationItem> data;

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
        return "200000".equals(code) || super.isSuccess();
    }
}
