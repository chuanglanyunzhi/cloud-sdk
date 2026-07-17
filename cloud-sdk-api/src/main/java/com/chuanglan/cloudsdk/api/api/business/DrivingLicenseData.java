package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 驾驶证 OCR 识别数据。
 */
public class DrivingLicenseData extends CloudSdkModel {

    /**
     * 交易号，唯一。
     */
    public String tradeNo;

    /**
     * 证件号。
     */
    public String number;

    /**
     * 有效时间。
     */
    public String expiryTime;

    /**
     * 准驾类型。
     */
    public String carType;

    /**
     * 住址。
     */
    public String address;

    /**
     * 姓名。
     */
    public String name;

    /**
     * 国籍。
     */
    public String nationality;

    /**
     * 生日。
     */
    public String birth;

    /**
     * 性别。
     */
    public String sex;

    /**
     * 初次领证时间。
     */
    public String firstGetCard;

    /**
     * 驾驶证检测业务返回码，0 成功，其他失败。
     */
    public String code;

    /**
     * 驾驶证检测业务返回码对应说明。
     */
    public String msg;

    public DrivingLicenseData setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }

    public DrivingLicenseData setNumber(String number) {
        this.number = number;
        return this;
    }

    public DrivingLicenseData setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
        return this;
    }

    public DrivingLicenseData setCarType(String carType) {
        this.carType = carType;
        return this;
    }

    public DrivingLicenseData setAddress(String address) {
        this.address = address;
        return this;
    }

    public DrivingLicenseData setName(String name) {
        this.name = name;
        return this;
    }

    public DrivingLicenseData setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public DrivingLicenseData setBirth(String birth) {
        this.birth = birth;
        return this;
    }

    public DrivingLicenseData setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public DrivingLicenseData setFirstGetCard(String firstGetCard) {
        this.firstGetCard = firstGetCard;
        return this;
    }

    public DrivingLicenseData setCode(String code) {
        this.code = code;
        return this;
    }

    public DrivingLicenseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
