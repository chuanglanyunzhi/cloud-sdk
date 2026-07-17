package com.chuanglan.cloudsdk.api.api.mnp;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 携号转网 V1 查询结果项。
 */
public class MnpCarriersSftpResult extends CloudSdkModel {

    /**
     * 是否携号转网：0 未转网，1 已转网。
     */
    public String result;

    /**
     * 原始运营商类型：-1 未知，1 移动，2 联通，3 电信，4 广电。
     */
    public String before;

    /**
     * 手机号。
     */
    public String mobile;

    /**
     * 转网后运营商类型：-1 未知，1 移动，2 联通，3 电信，4 广电。
     */
    public String after;

    public MnpCarriersSftpResult setResult(String result) {
        this.result = result;
        return this;
    }

    public MnpCarriersSftpResult setBefore(String before) {
        this.before = before;
        return this;
    }

    public MnpCarriersSftpResult setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public MnpCarriersSftpResult setAfter(String after) {
        this.after = after;
        return this;
    }
}
