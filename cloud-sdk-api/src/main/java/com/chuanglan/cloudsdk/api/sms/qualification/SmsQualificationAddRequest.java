package com.chuanglan.cloudsdk.api.sms.qualification;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 创建资质请求。
 */
public class SmsQualificationAddRequest extends CloudSdkModel {

    /** 产品类型。 */
    public String productType;
    /** 企业名称。 */
    public String enterpriseName;
    /** 统一社会信用代码。 */
    public String unifiedSocialCreditCode;
    /** 业务联系人/经办人。 */
    public String attentionLine;
    /** 经办人身份证号。 */
    public String attentionIdCard;
    /** 法人姓名。 */
    public String legalName;
    /** 联系电话。 */
    public String phoneNum;
    /** 终端类型/客户类型。 */
    public String endType;
    /** 共享类型。 */
    public String shareType;
    /** 证件类型。 */
    public String identityType;
    /** 代理人授权书图片（Base64或URL）。 */
    public String agentAuthorizationLetterImg;
    /** 营业执照图片。 */
    public String businessLicenseImg;
    /** 身份证国徽面图片。 */
    public String nationalEmblemIdentityImg;
    /** 身份证人像面图片。 */
    public String figureIdentityImg;
    /** 法人身份证国徽面图片。 */
    public String legalNationalEmblemIdentityImg;
    /** 法人身份证人像面图片。 */
    public String legalFigureIdentityImg;
    /** 手持证件照/办公场景照片。 */
    public String identityOfficePhotoImg;
    /** 合同首页图片。 */
    public String contractHeadImg;
    /** 合同有效期页图片。 */
    public String contractValidityImg;
    /** 合同尾页图片。 */
    public String contractTailImg;
    /** 备注。 */
    public String remark;

    public SmsQualificationAddRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsQualificationAddRequest setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
        return this;
    }

    public SmsQualificationAddRequest setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode;
        return this;
    }

    public SmsQualificationAddRequest setAttentionLine(String attentionLine) {
        this.attentionLine = attentionLine;
        return this;
    }

    public SmsQualificationAddRequest setAttentionIdCard(String attentionIdCard) {
        this.attentionIdCard = attentionIdCard;
        return this;
    }

    public SmsQualificationAddRequest setLegalName(String legalName) {
        this.legalName = legalName;
        return this;
    }

    public SmsQualificationAddRequest setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public SmsQualificationAddRequest setEndType(String endType) {
        this.endType = endType;
        return this;
    }

    public SmsQualificationAddRequest setShareType(String shareType) {
        this.shareType = shareType;
        return this;
    }

    public SmsQualificationAddRequest setIdentityType(String identityType) {
        this.identityType = identityType;
        return this;
    }

    public SmsQualificationAddRequest setAgentAuthorizationLetterImg(String agentAuthorizationLetterImg) {
        this.agentAuthorizationLetterImg = agentAuthorizationLetterImg;
        return this;
    }

    public SmsQualificationAddRequest setBusinessLicenseImg(String businessLicenseImg) {
        this.businessLicenseImg = businessLicenseImg;
        return this;
    }

    public SmsQualificationAddRequest setNationalEmblemIdentityImg(String nationalEmblemIdentityImg) {
        this.nationalEmblemIdentityImg = nationalEmblemIdentityImg;
        return this;
    }

    public SmsQualificationAddRequest setFigureIdentityImg(String figureIdentityImg) {
        this.figureIdentityImg = figureIdentityImg;
        return this;
    }

    public SmsQualificationAddRequest setLegalNationalEmblemIdentityImg(String legalNationalEmblemIdentityImg) {
        this.legalNationalEmblemIdentityImg = legalNationalEmblemIdentityImg;
        return this;
    }

    public SmsQualificationAddRequest setLegalFigureIdentityImg(String legalFigureIdentityImg) {
        this.legalFigureIdentityImg = legalFigureIdentityImg;
        return this;
    }

    public SmsQualificationAddRequest setIdentityOfficePhotoImg(String identityOfficePhotoImg) {
        this.identityOfficePhotoImg = identityOfficePhotoImg;
        return this;
    }

    public SmsQualificationAddRequest setContractHeadImg(String contractHeadImg) {
        this.contractHeadImg = contractHeadImg;
        return this;
    }

    public SmsQualificationAddRequest setContractValidityImg(String contractValidityImg) {
        this.contractValidityImg = contractValidityImg;
        return this;
    }

    public SmsQualificationAddRequest setContractTailImg(String contractTailImg) {
        this.contractTailImg = contractTailImg;
        return this;
    }

    public SmsQualificationAddRequest setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
