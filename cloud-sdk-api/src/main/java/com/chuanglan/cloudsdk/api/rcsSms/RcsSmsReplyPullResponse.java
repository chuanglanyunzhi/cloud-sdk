package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 上行回复拉取响应。
 */
public class RcsSmsReplyPullResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    private Data data;

    public RcsSmsReplyPullResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 上行回复拉取业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 总数。
         */
        private Long total;

        /**
         * 上行回复列表。
         */
        private List<RcsSmsReplyItem> list;

        public Data setTotal(Long total) {
            this.total = total;
            return this;
        }

        public Data setList(List<RcsSmsReplyItem> list) {
            this.list = list;
            return this;
        }

        public Long getTotal() {
            return this.total;
        }

        public List<RcsSmsReplyItem> getList() {
            return this.list;
        }
    }

    public Data getData() {
        return this.data;
    }
}
