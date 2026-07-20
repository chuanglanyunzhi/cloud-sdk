package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 模板详情请求。
 */
public class SmsTemplateGetRequest extends CloudSdkModel {

    private String productType;
    private String templateCode;

    public SmsTemplateGetRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsTemplateGetRequest setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getTemplateCode() {
        return this.templateCode;
    }
}
