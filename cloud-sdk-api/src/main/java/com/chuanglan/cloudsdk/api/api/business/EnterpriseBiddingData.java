package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 企业招投标信息查询（翻页）数据。
 */
public class EnterpriseBiddingData extends CloudSdkModel {

    /**
     * 招投标基础信息数组。
     */
    public List<EnterpriseBiddingItem> DETAILS_BASIC;

    /**
     * 条数。
     */
    public String BID_COUNT;

    public EnterpriseBiddingData setDETAILS_BASIC(List<EnterpriseBiddingItem> DETAILS_BASIC) {
        this.DETAILS_BASIC = DETAILS_BASIC;
        return this;
    }

    public EnterpriseBiddingData setBID_COUNT(String BID_COUNT) {
        this.BID_COUNT = BID_COUNT;
        return this;
    }
}
