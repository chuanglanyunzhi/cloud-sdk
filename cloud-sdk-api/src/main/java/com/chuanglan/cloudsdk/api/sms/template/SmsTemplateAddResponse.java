package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;

/**
 * 创建模板响应。
 */
public class SmsTemplateAddResponse extends SmsCommonResponse {

    public Data data;

    public static class Data {
        public String templateCode;
    }

    public SmsTemplateAddResponse setData(Data data) {
        this.data = data;
        return this;
    }
}
