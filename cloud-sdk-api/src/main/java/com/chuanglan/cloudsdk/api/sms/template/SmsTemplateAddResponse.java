package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;

/**
 * 创建模板响应。
 */
public class SmsTemplateAddResponse extends SmsCommonResponse {

    private Data data;

    public static class Data {
        private String templateCode;

        public String getTemplateCode() {
            return this.templateCode;
        }
    }

    public SmsTemplateAddResponse setData(Data data) {
        this.data = data;
        return this;
    }

    public Data getData() {
        return this.data;
    }
}
