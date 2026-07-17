package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 营业执照 OCR 识别数据。
 */
public class BusinessLicenseData extends CloudSdkModel {

    /**
     * 交易号。
     */
    public String tradeNo;

    /**
     * 营业执照识别业务返回码，0 成功，其他失败。
     */
    public String code;

    /**
     * 营业执照识别业务返回码对应说明。
     */
    public String msg;

    /**
     * 编号。
     */
    public String number;

    /**
     * 单位地址。
     */
    public String address;

    /**
     * 社会信用代码。
     */
    public String creditCode;

    /**
     * 有效时间。
     */
    public String validDate;

    /**
     * 单位名称。
     */
    public String companyName;

    /**
     * 法人代表。
     */
    public String legalPerson;

    /**
     * 经营范围。
     */
    public String bussiness;

    /**
     * 注册资本。
     */
    public String capital;

    /**
     * 注册日期。
     */
    public String establishDate;

    /**
     * 公司类型。
     */
    public String type;

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
}
