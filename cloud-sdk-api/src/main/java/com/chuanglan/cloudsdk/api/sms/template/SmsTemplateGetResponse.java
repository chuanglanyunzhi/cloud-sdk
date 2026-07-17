package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;

/**
 * 模板详情响应。
 */
public class SmsTemplateGetResponse extends SmsCommonResponse {

    public SmsTemplateInfo data;

    public SmsTemplateGetResponse setData(SmsTemplateInfo data) {
        this.data = data;
        return this;
    }
}
