package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 编辑模板请求。
 */
public class SmsTemplateUpdateRequest extends CloudSdkModel {

    public String productType;
    public String templateCode;
    public String Content;
    public String contentname;
    public String signName;
    public String needUnsubscribe;
    public String businessCategory;
    public String businessSubcategory;
    public String guideUrl;
    public String guidePhone;
    public String variableParams;
    public String remark;

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
}
