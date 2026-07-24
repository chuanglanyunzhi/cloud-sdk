package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信消耗查询请求。
 */
public class IntSmsCostRequest extends CloudSdkModel {

    /**
     * 短信类型：notify（验证码）、market（营销/通知）。
     */
    private String productType;

    /**
     * 开始日期，格式：yyyy-MM-dd。
     */
    private String startDate;

    /**
     * 结束日期，格式：yyyy-MM-dd。
     */
    private String endDate;

    public IntSmsCostRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public IntSmsCostRequest setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public IntSmsCostRequest setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }
}
