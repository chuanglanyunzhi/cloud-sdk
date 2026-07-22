package com.chuanglan.cloudsdk.api.rcsSms;

import java.util.List;

/**
 * 状态报告拉取响应。
 *
 * <p>data 直接为状态报告列表（非 total+list 结构）。
 */
public class RcsSmsReportPullResponse extends RcsSmsCommonResponse {

    /**
     * 状态报告列表。
     */
    private List<RcsSmsReportItem> data;

    public RcsSmsReportPullResponse setData(List<RcsSmsReportItem> data) {
        this.data = data;
        return this;
    }

    public List<RcsSmsReportItem> getData() {
        return this.data;
    }
}
