package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 运营商二要素（身份证版）核验响应数据。
 */
public class CarriersTwoAuthIdNumResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    public String orderNo;

    /**
     * 查询时间。
     */
    public String handleTime;

    /**
     * 运营商类型：1 移动，2 联通，3 电信，4 广电。
     */
    public String type;

    /**
     * 认证结果：01 一致（收费），02 不一致（收费），03 不确定（不收费），04 失败（不收费）。
     */
    public String result;

    /**
     * 备注。
     */
    public String remark;

    /**
     * 性别：1 男，2 女。仅明文入参时返回。
     */
    public String gender;

    /**
     * 年龄。仅明文入参时返回。
     */
    public String age;

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
}
