package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 身份证二要素核验响应数据。
 */
public class IdCardAuthResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    private String orderNo;

    /**
     * 查询时间。
     */
    private String handleTime;

    /**
     * 省份。
     */
    private String province;

    /**
     * 市区。
     */
    private String city;

    /**
     * 县区。
     */
    private String country;

    /**
     * 生日，格式 yyyyMMdd。
     */
    private String birthday;

    /**
     * 年龄。
     */
    private String age;

    /**
     * 性别：1 男，2 女。
     */
    private String gender;

    /**
     * 备注。
     */
    private String remark;

    /**
     * 返回结果：01 一致（收费），02 不一致（收费），03 认证不确定（不收费），04 认证失败（不收费）。
     */
    private String result;

    public IdCardAuthResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public IdCardAuthResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public IdCardAuthResponseData setProvince(String province) {
        this.province = province;
        return this;
    }

    public IdCardAuthResponseData setCity(String city) {
        this.city = city;
        return this;
    }

    public IdCardAuthResponseData setCountry(String country) {
        this.country = country;
        return this;
    }

    public IdCardAuthResponseData setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public IdCardAuthResponseData setAge(String age) {
        this.age = age;
        return this;
    }

    public IdCardAuthResponseData setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public IdCardAuthResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public IdCardAuthResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getHandleTime() {
        return this.handleTime;
    }

    public String getProvince() {
        return this.province;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getResult() {
        return this.result;
    }
}
