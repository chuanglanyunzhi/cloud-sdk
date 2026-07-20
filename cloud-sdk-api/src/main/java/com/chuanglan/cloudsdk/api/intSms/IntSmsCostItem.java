package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信每日消耗数据。
 */
public class IntSmsCostItem extends CloudSdkModel {

    /**
     * 业务账号。
     */
    private String account;

    /**
     * 统计日期。
     */
    private String pttDay;

    /**
     * 当日短信消耗金额。
     */
    private String costTotal;

    public IntSmsCostItem setAccount(String account) {
        this.account = account;
        return this;
    }

    public IntSmsCostItem setPttDay(String pttDay) {
        this.pttDay = pttDay;
        return this;
    }

    public IntSmsCostItem setCostTotal(String costTotal) {
        this.costTotal = costTotal;
        return this;
    }

    public String getAccount() {
        return this.account;
    }

    public String getPttDay() {
        return this.pttDay;
    }

    public String getCostTotal() {
        return this.costTotal;
    }
}
