package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 添加签名响应。
 */
public class RcsSmsSignAddResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    private Data data;

    public RcsSmsSignAddResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 添加签名业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 签名 ID。
         */
        private String signId;

        /**
         * 签名状态。
         */
        private String status;

        public Data setSignId(String signId) {
            this.signId = signId;
            return this;
        }

        public Data setStatus(String status) {
            this.status = status;
            return this;
        }

        public String getSignId() {
            return this.signId;
        }

        public String getStatus() {
            return this.status;
        }
    }

    public Data getData() {
        return this.data;
    }
}
