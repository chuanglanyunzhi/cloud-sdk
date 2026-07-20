package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 驾驶证 OCR V2 正页数据。
 */
public class DrivingLicenseOcrV2FrontData extends CloudSdkModel {

    /**
     * 驾驶证号。
     */
    private String id;

    /**
     * 有效期限。
     */
    private String expiryTime;

    /**
     * 准驾类型。
     */
    private String carType;

    /**
     * 住址。
     */
    private String address;

    /**
     * 姓名。
     */
    private String name;

    /**
     * 国籍。
     */
    private String nationality;

    /**
     * 出生日期，格式：yyyy-mm-dd。
     */
    private String birth;

    /**
     * 性别。
     */
    private String sex;

    /**
     * 初次领证时间。
     */
    private String firstGetCard;

    /**
     * 发证单位。
     */
    private String issueBy;

    public DrivingLicenseOcrV2FrontData setId(String id) {
        this.id = id;
        return this;
    }

    public DrivingLicenseOcrV2FrontData setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
        return this;
    }

    public DrivingLicenseOcrV2FrontData setCarType(String carType) {
        this.carType = carType;
        return this;
    }

    public DrivingLicenseOcrV2FrontData setAddress(String address) {
        this.address = address;
        return this;
    }

    public DrivingLicenseOcrV2FrontData setName(String name) {
        this.name = name;
        return this;
    }

    public DrivingLicenseOcrV2FrontData setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public DrivingLicenseOcrV2FrontData setBirth(String birth) {
        this.birth = birth;
        return this;
    }

    public DrivingLicenseOcrV2FrontData setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public DrivingLicenseOcrV2FrontData setFirstGetCard(String firstGetCard) {
        this.firstGetCard = firstGetCard;
        return this;
    }

    public DrivingLicenseOcrV2FrontData setIssueBy(String issueBy) {
        this.issueBy = issueBy;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public String getExpiryTime() {
        return this.expiryTime;
    }

    public String getCarType() {
        return this.carType;
    }

    public String getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getBirth() {
        return this.birth;
    }

    public String getSex() {
        return this.sex;
    }

    public String getFirstGetCard() {
        return this.firstGetCard;
    }

    public String getIssueBy() {
        return this.issueBy;
    }
}
