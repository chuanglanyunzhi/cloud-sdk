package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;

/**
 * 创建签名响应。
 */
public class SmsSignatureAddResponse extends SmsCommonResponse {

    /** 响应数据。 */
    public Data data;

    public static class Data {
        /** 签名ID。 */
        public String signId;
        /** 已存在的签名ID。 */
        public String existedSignId;
    }

    public SmsSignatureAddResponse setData(Data data) {
        this.data = data;
        return this;
    }
}
