package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 号码在网状态查询业务数据。
 */
public class NumberNetStatusResponseData extends CloudSdkModel {

    /**
     * 结果状态描述。
     */
    private String msg;

    /**
     * 返回状态码。
     */
    private Integer code;

    /**
     * 是否收费：0 不收费，1 收费。
     */
    private Integer fee;

    /**
     * 流水号。
     */
    private String orderNo;

    /**
     * 在网状态结果。
     */
    private NumberNetStatusResult result;

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

    public String getMsg() {
        return this.msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public Integer getFee() {
        return this.fee;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public NumberNetStatusResult getResult() {
        return this.result;
    }
}
