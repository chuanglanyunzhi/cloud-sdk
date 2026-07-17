package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;
import com.chuanglan.cloudsdk.api.sms.SmsPageData;

/**
 * 签名列表响应。
 */
public class SmsSignatureListResponse extends SmsCommonResponse {

    /** 签名分页数据。 */
    public SmsPageData<SmsSignatureListItem> data;

    public SmsSignatureListResponse setData(SmsPageData<SmsSignatureListItem> data) {
        this.data = data;
        return this;
    }
}
