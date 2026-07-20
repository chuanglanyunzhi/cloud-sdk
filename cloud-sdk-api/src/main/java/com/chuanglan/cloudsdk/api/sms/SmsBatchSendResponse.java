package com.chuanglan.cloudsdk.api.sms;

/**
 * 批量发送短信响应体。
 */
public class SmsBatchSendResponse extends SmsCommonResponse {

    /**
     * 返回的数据结构。
     */
    private SmsBatchSendResponseData data;

    public SmsBatchSendResponse setData(SmsBatchSendResponseData data) {
        this.data = data;
        return this;
    }

    public SmsBatchSendResponseData getData() {
        return this.data;
    }
}
