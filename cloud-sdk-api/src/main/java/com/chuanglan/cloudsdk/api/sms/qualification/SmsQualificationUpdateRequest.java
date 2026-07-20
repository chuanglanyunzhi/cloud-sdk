package com.chuanglan.cloudsdk.api.sms.qualification;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 编辑资质请求。
 */
public class SmsQualificationUpdateRequest extends CloudSdkModel {

    /** 产品类型。 */
    private String productType;
    /** 终端客户ID。 */
    private String endCustomerId;
    /** 法人姓名。 */
    private String legalName;
    /** 联系电话。 */
    private String phoneNum;
    /** 代理人授权书图片。 */
    private String agentAuthorizationLetterImg;
    /** 营业执照图片。 */
    private String businessLicenseImg;
    /** 身份证国徽面图片。 */
    private String nationalEmblemIdentityImg;
    /** 身份证人像面图片。 */
    private String figureIdentityImg;
    /** 法人身份证国徽面图片。 */
    private String legalNationalEmblemIdentityImg;
    /** 法人身份证人像面图片。 */
    private String legalFigureIdentityImg;
    /** 手持证件照/办公场景照片。 */
    private String identityOfficePhotoImg;
    /** 合同首页图片。 */
    private String contractHeadImg;
    /** 合同有效期页图片。 */
    private String contractValidityImg;
    /** 合同尾页图片。 */
    private String contractTailImg;
    /** 备注。 */
    private String remark;

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

    public String getProductType() {
        return this.productType;
    }

    public String getEndCustomerId() {
        return this.endCustomerId;
    }

    public String getLegalName() {
        return this.legalName;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public String getAgentAuthorizationLetterImg() {
        return this.agentAuthorizationLetterImg;
    }

    public String getBusinessLicenseImg() {
        return this.businessLicenseImg;
    }

    public String getNationalEmblemIdentityImg() {
        return this.nationalEmblemIdentityImg;
    }

    public String getFigureIdentityImg() {
        return this.figureIdentityImg;
    }

    public String getLegalNationalEmblemIdentityImg() {
        return this.legalNationalEmblemIdentityImg;
    }

    public String getLegalFigureIdentityImg() {
        return this.legalFigureIdentityImg;
    }

    public String getIdentityOfficePhotoImg() {
        return this.identityOfficePhotoImg;
    }

    public String getContractHeadImg() {
        return this.contractHeadImg;
    }

    public String getContractValidityImg() {
        return this.contractValidityImg;
    }

    public String getContractTailImg() {
        return this.contractTailImg;
    }

    public String getRemark() {
        return this.remark;
    }
}
