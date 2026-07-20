package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 编辑模板请求。
 */
public class SmsTemplateUpdateRequest extends CloudSdkModel {

    private String productType;
    private String templateCode;
    private String Content;
    private String contentname;
    private String signName;
    private String needUnsubscribe;
    private String businessCategory;
    private String businessSubcategory;
    private String guideUrl;
    private String guidePhone;
    private String variableParams;
    private String remark;

    public SmsTemplateUpdateRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsTemplateUpdateRequest setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
        return this;
    }

    public SmsTemplateUpdateRequest setContent(String content) {
        Content = content;
        return this;
    }

    public SmsTemplateUpdateRequest setContentname(String contentname) {
        this.contentname = contentname;
        return this;
    }

    public SmsTemplateUpdateRequest setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    public SmsTemplateUpdateRequest setNeedUnsubscribe(String needUnsubscribe) {
        this.needUnsubscribe = needUnsubscribe;
        return this;
    }

    public SmsTemplateUpdateRequest setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
        return this;
    }

    public SmsTemplateUpdateRequest setBusinessSubcategory(String businessSubcategory) {
        this.businessSubcategory = businessSubcategory;
        return this;
    }

    public SmsTemplateUpdateRequest setGuideUrl(String guideUrl) {
        this.guideUrl = guideUrl;
        return this;
    }

    public SmsTemplateUpdateRequest setGuidePhone(String guidePhone) {
        this.guidePhone = guidePhone;
        return this;
    }

    public SmsTemplateUpdateRequest setVariableParams(String variableParams) {
        this.variableParams = variableParams;
        return this;
    }

    public SmsTemplateUpdateRequest setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getTemplateCode() {
        return this.templateCode;
    }

    public String getContent() {
        return this.Content;
    }

    public String getContentname() {
        return this.contentname;
    }

    public String getSignName() {
        return this.signName;
    }

    public String getNeedUnsubscribe() {
        return this.needUnsubscribe;
    }

    public String getBusinessCategory() {
        return this.businessCategory;
    }

    public String getBusinessSubcategory() {
        return this.businessSubcategory;
    }

    public String getGuideUrl() {
        return this.guideUrl;
    }

    public String getGuidePhone() {
        return this.guidePhone;
    }

    public String getVariableParams() {
        return this.variableParams;
    }

    public String getRemark() {
        return this.remark;
    }
}
