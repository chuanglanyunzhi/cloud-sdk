package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 运营商二要素核验响应数据。
 */
public class CarriersTwoAuthResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    private String orderNo;

    /**
     * 查询时间。
     */
    private String handleTime;

    /**
     * 运营商类型：1 移动，2 联通，3 电信，4 广电。
     */
    private String type;

    /**
     * 认证结果：01 一致（收费），02 不一致（收费），03 不确定（不收费），04 失败（不收费）。
     */
    private String result;

    /**
     * 备注。
     */
    private String remark;

    public CarriersTwoAuthResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public CarriersTwoAuthResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public CarriersTwoAuthResponseData setType(String type) {
        this.type = type;
        return this;
    }

    public CarriersTwoAuthResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public CarriersTwoAuthResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getHandleTime() {
        return this.handleTime;
    }

    public String getType() {
        return this.type;
    }

    public String getResult() {
        return this.result;
    }

    public String getRemark() {
        return this.remark;
    }
}
