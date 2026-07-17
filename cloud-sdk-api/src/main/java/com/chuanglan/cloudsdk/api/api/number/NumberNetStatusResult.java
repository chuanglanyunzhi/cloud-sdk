package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 号码在网状态结果。
 */
public class NumberNetStatusResult extends CloudSdkModel {

    /**
     * 当前归属运营商：1 移动，2 电信，3 联通，4 广电；负数为携号转网。
     */
    public Integer provider;

    /**
     * 状态：1 正常，2 停机，3 在网但不可用，4 销号/空号。
     */
    public Integer status;

    public NumberNetStatusResult setProvider(Integer provider) {
        this.provider = provider;
        return this;
    }

    public NumberNetStatusResult setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
