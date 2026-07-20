package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 企业招投标信息查询（翻页）数据。
 */
public class EnterpriseBiddingData extends CloudSdkModel {

    @JsonProperty("DETAILS_BASIC")
    private List<EnterpriseBiddingItem> DETAILS_BASIC;

    @JsonProperty("BID_COUNT")
    private String BID_COUNT;

    public EnterpriseBiddingData setDETAILS_BASIC(List<EnterpriseBiddingItem> DETAILS_BASIC) {
        this.DETAILS_BASIC = DETAILS_BASIC;
        return this;
    }

    public EnterpriseBiddingData setBID_COUNT(String BID_COUNT) {
        this.BID_COUNT = BID_COUNT;
        return this;
    }

    public List<EnterpriseBiddingItem> getDETAILS_BASIC() {
        return this.DETAILS_BASIC;
    }

    public String getBID_COUNT() {
        return this.BID_COUNT;
    }
}
