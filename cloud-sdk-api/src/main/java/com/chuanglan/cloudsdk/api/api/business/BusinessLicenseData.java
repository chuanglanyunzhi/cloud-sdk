package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 营业执照 OCR 识别数据。
 */
public class BusinessLicenseData extends CloudSdkModel {

    /**
     * 交易号。
     */
    private String tradeNo;

    /**
     * 营业执照识别业务返回码，0 成功，其他失败。
     */
    private String code;

    /**
     * 营业执照识别业务返回码对应说明。
     */
    private String msg;

    /**
     * 编号。
     */
    private String number;

    /**
     * 单位地址。
     */
    private String address;

    /**
     * 社会信用代码。
     */
    private String creditCode;

    /**
     * 有效时间。
     */
    private String validDate;

    /**
     * 单位名称。
     */
    private String companyName;

    /**
     * 法人代表。
     */
    private String legalPerson;

    /**
     * 经营范围。
     */
    private String bussiness;

    /**
     * 注册资本。
     */
    private String capital;

    /**
     * 注册日期。
     */
    private String establishDate;

    /**
     * 公司类型。
     */
    private String type;

    public BusinessLicenseData setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }

    public BusinessLicenseData setCode(String code) {
        this.code = code;
        return this;
    }

    public BusinessLicenseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public BusinessLicenseData setNumber(String number) {
        this.number = number;
        return this;
    }

    public BusinessLicenseData setAddress(String address) {
        this.address = address;
        return this;
    }

    public BusinessLicenseData setCreditCode(String creditCode) {
        this.creditCode = creditCode;
        return this;
    }

    public BusinessLicenseData setValidDate(String validDate) {
        this.validDate = validDate;
        return this;
    }

    public BusinessLicenseData setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public BusinessLicenseData setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
        return this;
    }

    public BusinessLicenseData setBussiness(String bussiness) {
        this.bussiness = bussiness;
        return this;
    }

    public BusinessLicenseData setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public BusinessLicenseData setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
        return this;
    }

    public BusinessLicenseData setType(String type) {
        this.type = type;
        return this;
    }

    public String getTradeNo() {
        return this.tradeNo;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getNumber() {
        return this.number;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCreditCode() {
        return this.creditCode;
    }

    public String getValidDate() {
        return this.validDate;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getLegalPerson() {
        return this.legalPerson;
    }

    public String getBussiness() {
        return this.bussiness;
    }

    public String getCapital() {
        return this.capital;
    }

    public String getEstablishDate() {
        return this.establishDate;
    }

    public String getType() {
        return this.type;
    }
}
