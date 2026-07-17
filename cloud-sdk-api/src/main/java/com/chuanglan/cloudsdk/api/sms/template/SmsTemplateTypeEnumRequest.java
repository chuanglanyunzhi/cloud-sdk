package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 查询模板类型枚举请求。
 */
public class SmsTemplateTypeEnumRequest extends CloudSdkModel {

    public String productType;

    public SmsTemplateTypeEnumRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }
}
