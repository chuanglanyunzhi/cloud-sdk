package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 身份证 OCR V2 识别结果。
 */
public class IdOcrV2Result extends CloudSdkModel {

    /**
     * 证件号（仅正面返回）。
     */
    private String number;

    /**
     * 地址（仅正面返回）。
     */
    private String address;

    /**
     * 出生月份（仅正面返回）。
     */
    private String month;

    /**
     * 民族（仅正面返回）。
     */
    private String nation;

    /**
     * 出生年（仅正面返回）。
     */
    private String year;

    /**
     * 性别（仅正面返回）。
     */
    private String sex;

    /**
     * 姓名（仅正面返回）。
     */
    private String name;

    /**
     * 出生日（仅正面返回）。
     */
    private String day;

    /**
     * 签发机关（仅背面返回）。
     */
    private String authority;

    /**
     * 身份证有效期（仅背面返回）。
     */
    private String timelimit;

    public IdOcrV2Result setNumber(String number) {
        this.number = number;
        return this;
    }

    public IdOcrV2Result setAddress(String address) {
        this.address = address;
        return this;
    }

    public IdOcrV2Result setMonth(String month) {
        this.month = month;
        return this;
    }

    public IdOcrV2Result setNation(String nation) {
        this.nation = nation;
        return this;
    }

    public IdOcrV2Result setYear(String year) {
        this.year = year;
        return this;
    }

    public IdOcrV2Result setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public IdOcrV2Result setName(String name) {
        this.name = name;
        return this;
    }

    public IdOcrV2Result setDay(String day) {
        this.day = day;
        return this;
    }

    public IdOcrV2Result setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    public IdOcrV2Result setTimelimit(String timelimit) {
        this.timelimit = timelimit;
        return this;
    }

    public String getNumber() {
        return this.number;
    }

    public String getAddress() {
        return this.address;
    }

    public String getMonth() {
        return this.month;
    }

    public String getNation() {
        return this.nation;
    }

    public String getYear() {
        return this.year;
    }

    public String getSex() {
        return this.sex;
    }

    public String getName() {
        return this.name;
    }

    public String getDay() {
        return this.day;
    }

    public String getAuthority() {
        return this.authority;
    }

    public String getTimelimit() {
        return this.timelimit;
    }
}
