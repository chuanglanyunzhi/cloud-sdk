package com.chuanglan.cloudsdk.api.intSms;

import java.util.List;

/**
 * 国际短信消耗查询响应。
 */
public class IntSmsCostResponse extends IntSmsCommonResponse {

    /**
     * 每日消耗数据集合。
     */
    private List<IntSmsCostItem> data;

    public IntSmsCostResponse setData(List<IntSmsCostItem> data) {
        this.data = data;
        return this;
    }

    public List<IntSmsCostItem> getData() {
        return this.data;
    }
}
