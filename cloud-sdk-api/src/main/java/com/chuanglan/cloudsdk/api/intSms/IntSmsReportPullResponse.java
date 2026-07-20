package com.chuanglan.cloudsdk.api.intSms;

import java.util.List;

/**
 * 国际短信状态报告拉取响应。
 */
public class IntSmsReportPullResponse extends IntSmsCommonResponse {

    /**
     * 短信状态报告数据集。
     */
    private List<IntSmsReportItem> data;

    public IntSmsReportPullResponse setData(List<IntSmsReportItem> data) {
        this.data = data;
        return this;
    }

    public List<IntSmsReportItem> getData() {
        return this.data;
    }
}
