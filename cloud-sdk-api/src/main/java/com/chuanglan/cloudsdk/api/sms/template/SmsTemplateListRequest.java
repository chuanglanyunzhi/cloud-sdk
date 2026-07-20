package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 模板列表请求。
 */
public class SmsTemplateListRequest extends CloudSdkModel {

    private String productType;
    private Integer pageNo;
    private Integer pageSize;
    private String signName;
    private String contentName;

    public SmsTemplateListRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsTemplateListRequest setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public SmsTemplateListRequest setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public SmsTemplateListRequest setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    public SmsTemplateListRequest setContentName(String contentName) {
        this.contentName = contentName;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public String getSignName() {
        return this.signName;
    }

    public String getContentName() {
        return this.contentName;
    }
}
