package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 运营商三要素核验响应数据。
 */
public class CarriersAuthResponseData extends CloudSdkModel {

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
     * 性别。
     */
    private String gender;

    /**
     * 年龄。
     */
    private String age;

    /**
     * 认证结果：01 一致（收费），02 不一致（收费），03 不确定（不收费），04 失败（不收费）。
     */
    private String result;

    /**
     * 备注。
     */
    private String remark;

    public CarriersAuthResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public CarriersAuthResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public CarriersAuthResponseData setType(String type) {
        this.type = type;
        return this;
    }

    public CarriersAuthResponseData setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public CarriersAuthResponseData setAge(String age) {
        this.age = age;
        return this;
    }

    public CarriersAuthResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public CarriersAuthResponseData setRemark(String remark) {
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

    public String getGender() {
        return this.gender;
    }

    public String getAge() {
        return this.age;
    }

    public String getResult() {
        return this.result;
    }

    public String getRemark() {
        return this.remark;
    }
}
