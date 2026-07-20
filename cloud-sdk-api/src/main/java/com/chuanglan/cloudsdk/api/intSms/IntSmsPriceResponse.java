package com.chuanglan.cloudsdk.api.intSms;

import java.util.List;

/**
 * 国际短信发送价格查询响应。
 */
public class IntSmsPriceResponse extends IntSmsCommonResponse {

    /**
     * 国家单价数据列表。
     */
    private List<IntSmsPriceItem> data;

    public IntSmsPriceResponse setData(List<IntSmsPriceItem> data) {
        this.data = data;
        return this;
    }

    public List<IntSmsPriceItem> getData() {
        return this.data;
    }
}
