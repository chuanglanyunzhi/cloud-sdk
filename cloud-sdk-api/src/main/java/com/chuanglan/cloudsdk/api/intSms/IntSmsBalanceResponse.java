package com.chuanglan.cloudsdk.api.intSms;

/**
 * 国际短信账户余额查询响应。
 */
public class IntSmsBalanceResponse extends IntSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    private IntSmsBalanceResponseData data;

    public IntSmsBalanceResponse setData(IntSmsBalanceResponseData data) {
        this.data = data;
        return this;
    }

    public IntSmsBalanceResponseData getData() {
        return this.data;
    }
}
