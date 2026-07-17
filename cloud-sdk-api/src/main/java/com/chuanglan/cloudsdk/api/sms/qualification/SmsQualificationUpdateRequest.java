package com.chuanglan.cloudsdk.api.sms.qualification;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 编辑资质请求。
 */
public class SmsQualificationUpdateRequest extends CloudSdkModel {

    /** 产品类型。 */
    public String productType;
    /** 终端客户ID。 */
    public String endCustomerId;
    /** 法人姓名。 */
    public String legalName;
    /** 联系电话。 */
    public String phoneNum;
    /** 代理人授权书图片。 */
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

    public SmsQualificationUpdateRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsQualificationUpdateRequest setEndCustomerId(String endCustomerId) {
        this.endCustomerId = endCustomerId;
        return this;
    }

    public SmsQualificationUpdateRequest setLegalName(String legalName) {
        this.legalName = legalName;
        return this;
    }

    public SmsQualificationUpdateRequest setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public SmsQualificationUpdateRequest setAgentAuthorizationLetterImg(String agentAuthorizationLetterImg) {
        this.agentAuthorizationLetterImg = agentAuthorizationLetterImg;
        return this;
    }

    public SmsQualificationUpdateRequest setBusinessLicenseImg(String businessLicenseImg) {
        this.businessLicenseImg = businessLicenseImg;
        return this;
    }

    public SmsQualificationUpdateRequest setNationalEmblemIdentityImg(String nationalEmblemIdentityImg) {
        this.nationalEmblemIdentityImg = nationalEmblemIdentityImg;
        return this;
    }

    public SmsQualificationUpdateRequest setFigureIdentityImg(String figureIdentityImg) {
        this.figureIdentityImg = figureIdentityImg;
        return this;
    }

    public SmsQualificationUpdateRequest setLegalNationalEmblemIdentityImg(String legalNationalEmblemIdentityImg) {
        this.legalNationalEmblemIdentityImg = legalNationalEmblemIdentityImg;
        return this;
    }

    public SmsQualificationUpdateRequest setLegalFigureIdentityImg(String legalFigureIdentityImg) {
        this.legalFigureIdentityImg = legalFigureIdentityImg;
        return this;
    }

    public SmsQualificationUpdateRequest setIdentityOfficePhotoImg(String identityOfficePhotoImg) {
        this.identityOfficePhotoImg = identityOfficePhotoImg;
        return this;
    }

    public SmsQualificationUpdateRequest setContractHeadImg(String contractHeadImg) {
        this.contractHeadImg = contractHeadImg;
        return this;
    }

    public SmsQualificationUpdateRequest setContractValidityImg(String contractValidityImg) {
        this.contractValidityImg = contractValidityImg;
        return this;
    }

    public SmsQualificationUpdateRequest setContractTailImg(String contractTailImg) {
        this.contractTailImg = contractTailImg;
        return this;
    }

    public SmsQualificationUpdateRequest setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
