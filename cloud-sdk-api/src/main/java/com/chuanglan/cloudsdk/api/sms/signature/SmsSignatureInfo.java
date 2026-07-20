package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.api.sms.SmsOperatorRejectReason;
import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 签名详情信息。
 */
public class SmsSignatureInfo extends CloudSdkModel {

    /** 是否系统签名。 */
    private String isSystemSignature;
    /** 签名ID。 */
    private String signId;
    /** 签名名称。 */
    private String signName;
    /** 签名状态。 */
    private String signaturestatus;
    /** 运营商状态。 */
    private Integer operatorstatus;
    /** 实名状态。 */
    private String realNamestatus;
    /** 审核原因。 */
    private String auditReason;
    /** 移动运营商状态。 */
    private String cmOperatorstatus;
    /** 电信运营商状态。 */
    private String ctOperatorstatus;
    /** 联通运营商状态。 */
    private String cuOperatorstatus;
    /** 移动运营商驳回原因列表。 */
    private List<SmsOperatorRejectReason> cmOperatorRejectReason;
    /** 电信运营商驳回原因列表。 */
    private List<SmsOperatorRejectReason> ctOperatorRejectReason;
    /** 联通运营商驳回原因列表。 */
    private List<SmsOperatorRejectReason> cuOperatorRejectReason;
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
    private String endCustomerid;

    public String getIsSystemSignature() {
        return this.isSystemSignature;
    }

    public String getSignId() {
        return this.signId;
    }

    public String getSignName() {
        return this.signName;
    }

    public String getSignaturestatus() {
        return this.signaturestatus;
    }

    public Integer getOperatorstatus() {
        return this.operatorstatus;
    }

    public String getRealNamestatus() {
        return this.realNamestatus;
    }

    public String getAuditReason() {
        return this.auditReason;
    }

    public String getCmOperatorstatus() {
        return this.cmOperatorstatus;
    }

    public String getCtOperatorstatus() {
        return this.ctOperatorstatus;
    }

    public String getCuOperatorstatus() {
        return this.cuOperatorstatus;
    }

    public List<SmsOperatorRejectReason> getCmOperatorRejectReason() {
        return this.cmOperatorRejectReason;
    }

    public List<SmsOperatorRejectReason> getCtOperatorRejectReason() {
        return this.ctOperatorRejectReason;
    }

    public List<SmsOperatorRejectReason> getCuOperatorRejectReason() {
        return this.cuOperatorRejectReason;
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

    public String getEndCustomerid() {
        return this.endCustomerid;
    }
}
