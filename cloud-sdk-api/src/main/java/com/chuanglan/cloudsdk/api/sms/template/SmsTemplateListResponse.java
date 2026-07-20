package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;
import com.chuanglan.cloudsdk.api.sms.SmsPageData;

/**
 * 模板列表响应。
 */
public class SmsTemplateListResponse extends SmsCommonResponse {

    private SmsPageData<SmsTemplateListItem> data;

    public SmsTemplateListResponse setData(SmsPageData<SmsTemplateListItem> data) {
        this.data = data;
        return this;
    }

    public SmsPageData<SmsTemplateListItem> getData() {
        return this.data;
    }
}
