package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;

/**
 * 创建签名响应。
 */
public class SmsSignatureAddResponse extends SmsCommonResponse {

    /** 响应数据。 */
    private Data data;

    public static class Data {
        /** 签名ID。 */
        private String signId;
        /** 已存在的签名ID。 */
        private String existedSignId;

        public String getSignId() {
            return this.signId;
        }

        public String getExistedSignId() {
            return this.existedSignId;
        }
    }

    public SmsSignatureAddResponse setData(Data data) {
        this.data = data;
        return this;
    }

    public Data getData() {
        return this.data;
    }
}
