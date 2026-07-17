package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.api.sms.SmsOperatorRejectReason;
import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 签名详情信息。
 */
public class SmsSignatureInfo extends CloudSdkModel {

    /** 是否系统签名。 */
    public String isSystemSignature;
    /** 签名ID。 */
    public String signId;
    /** 签名名称。 */
    public String signName;
    /** 签名状态。 */
    public String signaturestatus;
    /** 运营商状态。 */
    public Integer operatorstatus;
    /** 实名状态。 */
    public String realNamestatus;
    /** 审核原因。 */
    public String auditReason;
    /** 移动运营商状态。 */
    public String cmOperatorstatus;
    /** 电信运营商状态。 */
    public String ctOperatorstatus;
    /** 联通运营商状态。 */
    public String cuOperatorstatus;
    /** 移动运营商驳回原因列表。 */
    public List<SmsOperatorRejectReason> cmOperatorRejectReason;
    /** 电信运营商驳回原因列表。 */
    public List<SmsOperatorRejectReason> ctOperatorRejectReason;
    /** 联通运营商驳回原因列表。 */
    public List<SmsOperatorRejectReason> cuOperatorRejectReason;
    /** 企业名称。 */
    public String companyName;
    /** 企业营业执照号。 */
    public String companyLicenseNo;
    /** 法人姓名。 */
    public String legalName;
    /** 身份证号。 */
    public String identityNo;
    /** 证件姓名。 */
    public String identityName;
    /** 联系电话。 */
    public String phoneNum;
    /** 终端客户ID。 */
    public String endCustomerid;
}
