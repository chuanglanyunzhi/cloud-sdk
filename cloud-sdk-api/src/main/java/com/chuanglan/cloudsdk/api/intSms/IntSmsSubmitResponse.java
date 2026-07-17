package com.chuanglan.cloudsdk.api.intSms;

/**
 * 国际短信发送响应。
 */
public class IntSmsSubmitResponse extends IntSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    public IntSmsSubmitResponseData data;

    public IntSmsSubmitResponse setData(IntSmsSubmitResponseData data) {
        this.data = data;
        return this;
    }
}
