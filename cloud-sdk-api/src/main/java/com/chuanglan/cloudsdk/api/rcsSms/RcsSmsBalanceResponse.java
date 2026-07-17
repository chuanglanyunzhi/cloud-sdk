package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 查询余额响应。
 */
public class RcsSmsBalanceResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    public Data data;

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
        public String balance;

        /**
         * 余额单位。
         */
        public String unit;

        public Data setBalance(String balance) {
            this.balance = balance;
            return this;
        }

        public Data setUnit(String unit) {
            this.unit = unit;
            return this;
        }
    }
}
