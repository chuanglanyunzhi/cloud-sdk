package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 查询余额响应。
 */
public class RcsSmsBalanceResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    private Data data;

    public RcsSmsBalanceResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 查询余额业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 余额。
         */
        private String balance;

        /**
         * 余额单位。
         */
        private String unit;

        public Data setBalance(String balance) {
            this.balance = balance;
            return this;
        }

        public Data setUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public String getBalance() {
            return this.balance;
        }

        public String getUnit() {
            return this.unit;
        }
    }

    public Data getData() {
        return this.data;
    }
}
