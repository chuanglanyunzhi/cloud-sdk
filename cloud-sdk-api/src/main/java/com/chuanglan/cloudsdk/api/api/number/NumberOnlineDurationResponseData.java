package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 号码在网时长查询业务数据。
 */
public class NumberOnlineDurationResponseData extends CloudSdkModel {

    /**
     * 结果状态描述。
     */
    private String msg;

    /**
     * 返回状态码：0 成功，503 查无，500 其他失败。
     */
    private String code;

    /**
     * 是否收费：0 不收费，1 收费。
     */
    private Integer fee;

    /**
     * 交易流水号。
     */
    private String orderNo;

    /**
     * 在网时长结果。
     */
    private NumberOnlineDurationResult result;

    public NumberOnlineDurationResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public NumberOnlineDurationResponseData setCode(String code) {
        this.code = code;
        return this;
    }

    public NumberOnlineDurationResponseData setFee(Integer fee) {
        this.fee = fee;
        return this;
    }

    public NumberOnlineDurationResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public NumberOnlineDurationResponseData setResult(NumberOnlineDurationResult result) {
        this.result = result;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }

    public Integer getFee() {
        return this.fee;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public NumberOnlineDurationResult getResult() {
        return this.result;
    }
}
