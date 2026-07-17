package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 创建模板请求。
 */
public class SmsTemplateAddRequest extends CloudSdkModel {

    public String productType;
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

    public SmsTemplateAddRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsTemplateAddRequest setContent(String content) {
        Content = content;
        return this;
    }

    public SmsTemplateAddRequest setContentname(String contentname) {
        this.contentname = contentname;
        return this;
    }

    public SmsTemplateAddRequest setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    public SmsTemplateAddRequest setNeedUnsubscribe(String needUnsubscribe) {
        this.needUnsubscribe = needUnsubscribe;
        return this;
    }

    public SmsTemplateAddRequest setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
        return this;
    }

    public SmsTemplateAddRequest setBusinessSubcategory(String businessSubcategory) {
        this.businessSubcategory = businessSubcategory;
        return this;
    }

    public SmsTemplateAddRequest setGuideUrl(String guideUrl) {
        this.guideUrl = guideUrl;
        return this;
    }

    public SmsTemplateAddRequest setGuidePhone(String guidePhone) {
        this.guidePhone = guidePhone;
        return this;
    }

    public SmsTemplateAddRequest setVariableParams(String variableParams) {
        this.variableParams = variableParams;
        return this;
    }

    public SmsTemplateAddRequest setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
