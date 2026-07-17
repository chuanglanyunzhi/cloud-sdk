package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业欠税公告信息。
 */
public class EnterpriseOwnTaxItem extends CloudSdkModel {

    /**
     * 纳税人识别号。
     */
    public String taxIdNumber;

    /**
     * 当前新发生欠税余额。
     */
    public String newOwnTaxBalance;

    /**
     * 欠税金额。
     */
    public String ownTaxAmount;

    /**
     * 发布时间。
     */
    public String publishDate;

    /**
     * 欠税余额。
     */
    public String ownTaxBalance;

    /**
     * 税务类型。
     */
    public String type;

    /**
     * 证件号码。
     */
    public String personIdNumber;

    /**
     * 欠税税种。
     */
    public String taxCategory;

    /**
     * 纳税人类型。
     */
    public String taxpayerType;

    /**
     * 法人证件名称。
     */
    public String personIdName;

    /**
     * 纳税人名称。
     */
    public String name;

    /**
     * 经营地点。
     */
    public String location;

    /**
     * 税务机关。
     */
    public String department;

    /**
     * 注册类型。
     */
    public String regType;

    /**
     * 法人或负责人名称。
     */
    public String legalpersonName;

    public EnterpriseOwnTaxItem setTaxIdNumber(String taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
        return this;
    }

    public EnterpriseOwnTaxItem setNewOwnTaxBalance(String newOwnTaxBalance) {
        this.newOwnTaxBalance = newOwnTaxBalance;
        return this;
    }

    public EnterpriseOwnTaxItem setOwnTaxAmount(String ownTaxAmount) {
        this.ownTaxAmount = ownTaxAmount;
        return this;
    }

    public EnterpriseOwnTaxItem setPublishDate(String publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public EnterpriseOwnTaxItem setOwnTaxBalance(String ownTaxBalance) {
        this.ownTaxBalance = ownTaxBalance;
        return this;
    }

    public EnterpriseOwnTaxItem setType(String type) {
        this.type = type;
        return this;
    }

    public EnterpriseOwnTaxItem setPersonIdNumber(String personIdNumber) {
        this.personIdNumber = personIdNumber;
        return this;
    }

    public EnterpriseOwnTaxItem setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
        return this;
    }

    public EnterpriseOwnTaxItem setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
        return this;
    }

    public EnterpriseOwnTaxItem setPersonIdName(String personIdName) {
        this.personIdName = personIdName;
        return this;
    }

    public EnterpriseOwnTaxItem setName(String name) {
        this.name = name;
        return this;
    }

    public EnterpriseOwnTaxItem setLocation(String location) {
        this.location = location;
        return this;
    }

    public EnterpriseOwnTaxItem setDepartment(String department) {
        this.department = department;
        return this;
    }

    public EnterpriseOwnTaxItem setRegType(String regType) {
        this.regType = regType;
        return this;
    }

    public EnterpriseOwnTaxItem setLegalpersonName(String legalpersonName) {
        this.legalpersonName = legalpersonName;
        return this;
    }
}
