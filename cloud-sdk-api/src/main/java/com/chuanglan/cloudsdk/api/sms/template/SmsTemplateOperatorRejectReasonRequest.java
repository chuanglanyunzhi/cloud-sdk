package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 查询模板运营商驳回原因请求。
 */
public class SmsTemplateOperatorRejectReasonRequest extends CloudSdkModel {

    private String productType;
    private List<String> templateCodes;

    public SmsTemplateOperatorRejectReasonRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsTemplateOperatorRejectReasonRequest setTemplateCodes(List<String> templateCodes) {
        this.templateCodes = templateCodes;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public List<String> getTemplateCodes() {
        return this.templateCodes;
    }
}
