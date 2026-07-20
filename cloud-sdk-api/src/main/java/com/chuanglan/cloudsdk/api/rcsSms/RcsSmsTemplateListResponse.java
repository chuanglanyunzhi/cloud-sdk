package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 视频模板列表响应。
 */
public class RcsSmsTemplateListResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    private Data data;

    public RcsSmsTemplateListResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 视频模板列表业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 总数。
         */
        private Long total;

        /**
         * 模板列表。
         */
        private List<RcsSmsTemplateInfo> list;

        public Data setTotal(Long total) {
            this.total = total;
            return this;
        }

        public Data setList(List<RcsSmsTemplateInfo> list) {
            this.list = list;
            return this;
        }

        public Long getTotal() {
            return this.total;
        }

        public List<RcsSmsTemplateInfo> getList() {
            return this.list;
        }
    }

    public Data getData() {
        return this.data;
    }
}
