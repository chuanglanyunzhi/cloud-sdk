package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;
import com.chuanglan.cloudsdk.api.sms.SmsPageData;

/**
 * 签名列表响应。
 */
public class SmsSignatureListResponse extends SmsCommonResponse {

    /** 签名分页数据。 */
    private SmsPageData<SmsSignatureListItem> data;

    public SmsSignatureListResponse setData(SmsPageData<SmsSignatureListItem> data) {
        this.data = data;
        return this;
    }

    public SmsPageData<SmsSignatureListItem> getData() {
        return this.data;
    }
}
