package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;
import com.chuanglan.cloudsdk.api.sms.SmsPageData;

/**
 * 模板列表响应。
 */
public class SmsTemplateListResponse extends SmsCommonResponse {

    public SmsPageData<SmsTemplateListItem> data;

    public SmsTemplateListResponse setData(SmsPageData<SmsTemplateListItem> data) {
        this.data = data;
        return this;
    }
}
