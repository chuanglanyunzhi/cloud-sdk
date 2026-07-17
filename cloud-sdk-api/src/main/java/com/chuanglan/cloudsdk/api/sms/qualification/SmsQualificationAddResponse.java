package com.chuanglan.cloudsdk.api.sms.qualification;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;

/**
 * 创建资质响应。
 */
public class SmsQualificationAddResponse extends SmsCommonResponse {

    /** 响应数据。 */
    public Data data;

    public static class Data {
        /** 终端客户ID。 */
        public String endCustomerId;
    }

    public SmsQualificationAddResponse setData(Data data) {
        this.data = data;
        return this;
    }
}
