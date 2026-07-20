package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 更新账户地址响应。
 */
public class RcsSmsAccountAddressUpdateResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    private Data data;

    public RcsSmsAccountAddressUpdateResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 更新账户地址业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 是否更新成功。
         */
        private Boolean success;

        /**
         * 处理状态。
         */
        private String status;

        public Data setSuccess(Boolean success) {
            this.success = success;
            return this;
        }

        public Data setStatus(String status) {
            this.status = status;
            return this;
        }

        public Boolean getSuccess() {
            return this.success;
        }

        public String getStatus() {
            return this.status;
        }
    }

    public Data getData() {
        return this.data;
    }
}
