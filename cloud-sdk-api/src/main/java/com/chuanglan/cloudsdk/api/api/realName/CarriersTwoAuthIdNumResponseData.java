package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 运营商二要素（身份证版）核验响应数据。
 */
public class CarriersTwoAuthIdNumResponseData extends CloudSdkModel {

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

    /**
     * 性别：1 男，2 女。仅明文入参时返回。
     */
    private String gender;

    /**
     * 年龄。仅明文入参时返回。
     */
    private String age;

    public CarriersTwoAuthIdNumResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public CarriersTwoAuthIdNumResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public CarriersTwoAuthIdNumResponseData setType(String type) {
        this.type = type;
        return this;
    }

    public CarriersTwoAuthIdNumResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public CarriersTwoAuthIdNumResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public CarriersTwoAuthIdNumResponseData setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public CarriersTwoAuthIdNumResponseData setAge(String age) {
        this.age = age;
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

    public String getGender() {
        return this.gender;
    }

    public String getAge() {
        return this.age;
    }
}
