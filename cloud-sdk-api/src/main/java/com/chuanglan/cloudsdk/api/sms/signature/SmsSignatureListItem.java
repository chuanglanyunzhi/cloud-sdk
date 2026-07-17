package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 签名列表项。
 */
public class SmsSignatureListItem extends CloudSdkModel {

    /** 签名ID。 */
    public String signId;
    /** 签名名称。 */
    public String signName;
    /** 签名状态。 */
    public String signaturestatus;
    /** 是否系统签名。 */
    public String isSystemSignature;
    /** 运营商状态。 */
    public Integer operatorstatus;
    /** 实名状态。 */
    public String realNameStatus;
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
    public String endCustomerId;
    /** 移动运营商状态。 */
    public String cmoperatorstatus;
    /** 电信运营商状态。 */
    public String ctoperatorstatus;
    /** 联通运营商状态。 */
    public String cuoperatorstatus;
}
