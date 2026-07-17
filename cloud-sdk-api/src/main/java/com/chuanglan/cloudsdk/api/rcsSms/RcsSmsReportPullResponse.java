package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 状态报告拉取响应。
 */
public class RcsSmsReportPullResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    public Data data;

    public RcsSmsReportPullResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 状态报告拉取业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 总数。
         */
        public Long total;

        /**
         * 状态报告列表。
         */
        public List<RcsSmsReportItem> list;

        public Data setTotal(Long total) {
            this.total = total;
            return this;
        }

        public Data setList(List<RcsSmsReportItem> list) {
            this.list = list;
            return this;
        }
    }
}
