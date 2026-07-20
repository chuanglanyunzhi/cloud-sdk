package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 企业欠税公告查询数据。
 */
public class EnterpriseOwnTaxData extends CloudSdkModel {

    /**
     * 欠税公告列表。
     */
    private List<EnterpriseOwnTaxItem> items;

    /**
     * 总数。
     */
    private Integer total;

    public EnterpriseOwnTaxData setItems(List<EnterpriseOwnTaxItem> items) {
        this.items = items;
        return this;
    }

    public EnterpriseOwnTaxData setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public List<EnterpriseOwnTaxItem> getItems() {
        return this.items;
    }

    public Integer getTotal() {
        return this.total;
    }
}
