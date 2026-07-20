package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 签名列表响应。
 */
public class RcsSmsSignListResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    private Data data;

    public RcsSmsSignListResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 签名列表业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 总数。
         */
        private Long total;

        /**
         * 签名列表。
         */
        private List<RcsSmsSignInfo> list;

        public Data setTotal(Long total) {
            this.total = total;
            return this;
        }

        public Data setList(List<RcsSmsSignInfo> list) {
            this.list = list;
            return this;
        }

        public Long getTotal() {
            return this.total;
        }

        public List<RcsSmsSignInfo> getList() {
            return this.list;
        }
    }

    public Data getData() {
        return this.data;
    }
}
