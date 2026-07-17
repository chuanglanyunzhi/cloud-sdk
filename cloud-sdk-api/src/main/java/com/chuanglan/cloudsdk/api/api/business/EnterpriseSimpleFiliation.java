package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业工商信息查询（简项）分支机构。
 */
public class EnterpriseSimpleFiliation extends CloudSdkModel {

    /**
     * 分支机构名称。
     */
    public String brname;

    /**
     * 分支机构统一社会信用代码。
     */
    public String brncreditcode;

    /**
     * 分支机构注册号。
     */
    public String brregno;

    /**
     * 分支机构登记机关。
     */
    public String brnregorg;

    /**
     * 分支机构成立日期。
     */
    public String brnEsdate;

    /**
     * 分支机构企业状态。
     */
    public String brnEntStatus;

    /**
     * 分支机构企业状态代码。
     */
    public String brnEntStatusCode;

    /**
     * 分支机构省份代码。
     */
    public String brnProvinceCode;

    /**
     * 分支机构省份名称。
     */
    public String brnProvinceName;

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
}
