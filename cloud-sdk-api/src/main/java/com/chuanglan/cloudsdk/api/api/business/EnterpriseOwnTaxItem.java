package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业欠税公告信息。
 */
public class EnterpriseOwnTaxItem extends CloudSdkModel {

    /**
     * 纳税人识别号。
     */
    private String taxIdNumber;

    /**
     * 当前新发生欠税余额。
     */
    private String newOwnTaxBalance;

    /**
     * 欠税金额。
     */
    private String ownTaxAmount;

    /**
     * 发布时间。
     */
    private String publishDate;

    /**
     * 欠税余额。
     */
    private String ownTaxBalance;

    /**
     * 税务类型。
     */
    private String type;

    /**
     * 证件号码。
     */
    private String personIdNumber;

    /**
     * 欠税税种。
     */
    private String taxCategory;

    /**
     * 纳税人类型。
     */
    private String taxpayerType;

    /**
     * 法人证件名称。
     */
    private String personIdName;

    /**
     * 纳税人名称。
     */
    private String name;

    /**
     * 经营地点。
     */
    private String location;

    /**
     * 税务机关。
     */
    private String department;

    /**
     * 注册类型。
     */
    private String regType;

    /**
     * 法人或负责人名称。
     */
    private String legalpersonName;

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

    public String getTaxIdNumber() {
        return this.taxIdNumber;
    }

    public String getNewOwnTaxBalance() {
        return this.newOwnTaxBalance;
    }

    public String getOwnTaxAmount() {
        return this.ownTaxAmount;
    }

    public String getPublishDate() {
        return this.publishDate;
    }

    public String getOwnTaxBalance() {
        return this.ownTaxBalance;
    }

    public String getType() {
        return this.type;
    }

    public String getPersonIdNumber() {
        return this.personIdNumber;
    }

    public String getTaxCategory() {
        return this.taxCategory;
    }

    public String getTaxpayerType() {
        return this.taxpayerType;
    }

    public String getPersonIdName() {
        return this.personIdName;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getRegType() {
        return this.regType;
    }

    public String getLegalpersonName() {
        return this.legalpersonName;
    }
}
