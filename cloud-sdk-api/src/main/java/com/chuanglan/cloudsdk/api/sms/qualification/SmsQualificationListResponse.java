package com.chuanglan.cloudsdk.api.sms.qualification;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;
import com.chuanglan.cloudsdk.api.sms.SmsPageData;

/**
 * 资质列表响应。
 */
public class SmsQualificationListResponse extends SmsCommonResponse {

    /** 资质分页数据。 */
    private SmsPageData<SmsQualificationListItem> data;

    public SmsQualificationListResponse setData(SmsPageData<SmsQualificationListItem> data) {
        this.data = data;
        return this;
    }

    public SmsPageData<SmsQualificationListItem> getData() {
        return this.data;
    }
}
