package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业工商信息查询（简项）分支机构。
 */
public class EnterpriseSimpleFiliation extends CloudSdkModel {

    /**
     * 分支机构名称。
     */
    private String brname;

    /**
     * 分支机构统一社会信用代码。
     */
    private String brncreditcode;

    /**
     * 分支机构注册号。
     */
    private String brregno;

    /**
     * 分支机构登记机关。
     */
    private String brnregorg;

    /**
     * 分支机构成立日期。
     */
    private String brnEsdate;

    /**
     * 分支机构企业状态。
     */
    private String brnEntStatus;

    /**
     * 分支机构企业状态代码。
     */
    private String brnEntStatusCode;

    /**
     * 分支机构省份代码。
     */
    private String brnProvinceCode;

    /**
     * 分支机构省份名称。
     */
    private String brnProvinceName;

    public EnterpriseSimpleFiliation setBrname(String brname) {
        this.brname = brname;
        return this;
    }

    public EnterpriseSimpleFiliation setBrncreditcode(String brncreditcode) {
        this.brncreditcode = brncreditcode;
        return this;
    }

    public EnterpriseSimpleFiliation setBrregno(String brregno) {
        this.brregno = brregno;
        return this;
    }

    public EnterpriseSimpleFiliation setBrnregorg(String brnregorg) {
        this.brnregorg = brnregorg;
        return this;
    }

    public EnterpriseSimpleFiliation setBrnEsdate(String brnEsdate) {
        this.brnEsdate = brnEsdate;
        return this;
    }

    public EnterpriseSimpleFiliation setBrnEntStatus(String brnEntStatus) {
        this.brnEntStatus = brnEntStatus;
        return this;
    }

    public EnterpriseSimpleFiliation setBrnEntStatusCode(String brnEntStatusCode) {
        this.brnEntStatusCode = brnEntStatusCode;
        return this;
    }

    public EnterpriseSimpleFiliation setBrnProvinceCode(String brnProvinceCode) {
        this.brnProvinceCode = brnProvinceCode;
        return this;
    }

    public EnterpriseSimpleFiliation setBrnProvinceName(String brnProvinceName) {
        this.brnProvinceName = brnProvinceName;
        return this;
    }

    public String getBrname() {
        return this.brname;
    }

    public String getBrncreditcode() {
        return this.brncreditcode;
    }

    public String getBrregno() {
        return this.brregno;
    }

    public String getBrnregorg() {
        return this.brnregorg;
    }

    public String getBrnEsdate() {
        return this.brnEsdate;
    }

    public String getBrnEntStatus() {
        return this.brnEntStatus;
    }

    public String getBrnEntStatusCode() {
        return this.brnEntStatusCode;
    }

    public String getBrnProvinceCode() {
        return this.brnProvinceCode;
    }

    public String getBrnProvinceName() {
        return this.brnProvinceName;
    }
}
