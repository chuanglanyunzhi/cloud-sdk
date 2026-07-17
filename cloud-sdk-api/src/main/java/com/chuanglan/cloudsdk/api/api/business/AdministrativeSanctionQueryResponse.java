package com.chuanglan.cloudsdk.api.api.business;

import java.util.List;

/**
 * 工商行政处罚查询响应。
 */
public class AdministrativeSanctionQueryResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    public Integer chargeStatus;

    /**
     * 计费条数。
     */
    public String chargeCount;

    /**
     * 行政处罚列表。
     */
    public List<AdministrativeSanctionItem> data;

    public AdministrativeSanctionQueryResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public AdministrativeSanctionQueryResponse setChargeCount(String chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public AdministrativeSanctionQueryResponse setData(List<AdministrativeSanctionItem> data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean isSuccess() {
        return "200000".equals(code) || super.isSuccess();
    }
}
