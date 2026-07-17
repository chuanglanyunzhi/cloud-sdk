package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 删除模板请求。
 */
public class SmsTemplateDeleteRequest extends CloudSdkModel {

    public String productType;
    public String templateCode;

    public SmsTemplateDeleteRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsTemplateDeleteRequest setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
        return this;
    }
}
