package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 签名列表项。
 */
public class SmsSignatureListItem extends CloudSdkModel {

    /** 签名ID。 */
    private String signId;
    /** 签名名称。 */
    private String signName;
    /** 签名状态。 */
    private String signaturestatus;
    /** 是否系统签名。 */
    private String isSystemSignature;
    /** 运营商状态。 */
    private Integer operatorstatus;
    /** 实名状态。 */
    private String realNameStatus;
    /** 企业名称。 */
    private String companyName;
    /** 企业营业执照号。 */
    private String companyLicenseNo;
    /** 法人姓名。 */
    private String legalName;
    /** 身份证号。 */
    private String identityNo;
    /** 证件姓名。 */
    private String identityName;
    /** 联系电话。 */
    private String phoneNum;
    /** 终端客户ID。 */
    private String endCustomerId;
    /** 移动运营商状态。 */
    private String cmoperatorstatus;
    /** 电信运营商状态。 */
    private String ctoperatorstatus;
    /** 联通运营商状态。 */
    private String cuoperatorstatus;

    public String getSignId() {
        return this.signId;
    }

    public String getSignName() {
        return this.signName;
    }

    public String getSignaturestatus() {
        return this.signaturestatus;
    }

    public String getIsSystemSignature() {
        return this.isSystemSignature;
    }

    public Integer getOperatorstatus() {
        return this.operatorstatus;
    }

    public String getRealNameStatus() {
        return this.realNameStatus;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getCompanyLicenseNo() {
        return this.companyLicenseNo;
    }

    public String getLegalName() {
        return this.legalName;
    }

    public String getIdentityNo() {
        return this.identityNo;
    }

    public String getIdentityName() {
        return this.identityName;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public String getEndCustomerId() {
        return this.endCustomerId;
    }

    public String getCmoperatorstatus() {
        return this.cmoperatorstatus;
    }

    public String getCtoperatorstatus() {
        return this.ctoperatorstatus;
    }

    public String getCuoperatorstatus() {
        return this.cuoperatorstatus;
    }
}
