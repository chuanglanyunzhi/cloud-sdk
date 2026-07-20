package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;
import com.chuanglan.cloudsdk.api.sms.SmsOperatorRejectReason;

import java.util.List;

/**
 * 签名详情响应。
 */
public class SmsSignatureGetResponse extends SmsCommonResponse {

    /** 签名详情数据。 */
    private SmsSignatureInfo data;

    public SmsSignatureGetResponse setData(SmsSignatureInfo data) {
        this.data = data;
        return this;
    }

    public SmsSignatureInfo getData() {
        return this.data;
    }
}
