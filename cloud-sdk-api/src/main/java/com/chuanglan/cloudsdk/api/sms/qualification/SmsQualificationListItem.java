package com.chuanglan.cloudsdk.api.sms.qualification;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 资质列表项。
 */
public class SmsQualificationListItem extends CloudSdkModel {

    /** 终端客户ID。 */
    private String endCustomerId;
    /** 企业名称。 */
    private String enterpriseName;
    /** 统一社会信用代码。 */
    private String unifiedSocialCreditCode;
    /** 业务联系人。 */
    private String attentionLine;
    /** 经办人身份证号。 */
    private String attentionIdCard;
    /** 法人姓名。 */
    private String legalName;
    /** 联系电话。 */
    private String phoneNum;
    /** 证件类型。 */
    private String identityType;
    /** 终端类型。 */
    private String endType;
    /** 一对多标识。 */
    private String oneToManyFlag;
    /** 代理人授权书URL。 */
    private String agentAuthorizationLetterUrl;
    /** 营业执照URL。 */
    private String businessLicenseUrl;
    /** 身份证国徽面URL。 */
    private String nationalEmblemIdentityUrl;
    /** 身份证人像面URL。 */
    private String figureIdentityUrl;
    /** 法人身份证国徽面URL。 */
    private String legalNationalEmblemIdentityUrl;
    /** 法人身份证人像面URL。 */
    private String legalFigureIdentityUrl;
    /** 手持证件照/办公场景照片URL。 */
    private String identityOfficePhotoUrl;
    /** 合同首页URL。 */
    private String contractHeadPageUrl;
    /** 合同有效期页URL。 */
    private String contractValidityPageUrl;
    /** 合同尾页URL。 */
    private String contractTailPageUrl;
    /** 备注。 */
    private String remark;

    public String getEndCustomerId() {
        return this.endCustomerId;
    }

    public String getEnterpriseName() {
        return this.enterpriseName;
    }

    public String getUnifiedSocialCreditCode() {
        return this.unifiedSocialCreditCode;
    }

    public String getAttentionLine() {
        return this.attentionLine;
    }

    public String getAttentionIdCard() {
        return this.attentionIdCard;
    }

    public String getLegalName() {
        return this.legalName;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public String getIdentityType() {
        return this.identityType;
    }

    public String getEndType() {
        return this.endType;
    }

    public String getOneToManyFlag() {
        return this.oneToManyFlag;
    }

    public String getAgentAuthorizationLetterUrl() {
        return this.agentAuthorizationLetterUrl;
    }

    public String getBusinessLicenseUrl() {
        return this.businessLicenseUrl;
    }

    public String getNationalEmblemIdentityUrl() {
        return this.nationalEmblemIdentityUrl;
    }

    public String getFigureIdentityUrl() {
        return this.figureIdentityUrl;
    }

    public String getLegalNationalEmblemIdentityUrl() {
        return this.legalNationalEmblemIdentityUrl;
    }

    public String getLegalFigureIdentityUrl() {
        return this.legalFigureIdentityUrl;
    }

    public String getIdentityOfficePhotoUrl() {
        return this.identityOfficePhotoUrl;
    }

    public String getContractHeadPageUrl() {
        return this.contractHeadPageUrl;
    }

    public String getContractValidityPageUrl() {
        return this.contractValidityPageUrl;
    }

    public String getContractTailPageUrl() {
        return this.contractTailPageUrl;
    }

    public String getRemark() {
        return this.remark;
    }
}
