package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 号码在网状态查询业务数据。
 */
public class NumberNetStatusResponseData extends CloudSdkModel {

    /**
     * 结果状态描述。
     */
    public String msg;

    /**
     * 返回状态码。
     */
    public Integer code;

    /**
     * 是否收费：0 不收费，1 收费。
     */
    public Integer fee;

    /**
     * 流水号。
     */
    public String orderNo;

    /**
     * 在网状态结果。
     */
    public NumberNetStatusResult result;

    public NumberNetStatusResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public NumberNetStatusResponseData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public NumberNetStatusResponseData setFee(Integer fee) {
        this.fee = fee;
        return this;
    }

    public NumberNetStatusResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public NumberNetStatusResponseData setResult(NumberNetStatusResult result) {
        this.result = result;
        return this;
    }
}
