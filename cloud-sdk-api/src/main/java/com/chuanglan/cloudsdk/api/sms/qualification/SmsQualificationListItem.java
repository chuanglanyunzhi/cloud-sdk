package com.chuanglan.cloudsdk.api.sms.qualification;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 资质列表项。
 */
public class SmsQualificationListItem extends CloudSdkModel {

    /** 终端客户ID。 */
    public String endCustomerId;
    /** 企业名称。 */
    public String enterpriseName;
    /** 统一社会信用代码。 */
    public String unifiedSocialCreditCode;
    /** 业务联系人。 */
    public String attentionLine;
    /** 经办人身份证号。 */
    public String attentionIdCard;
    /** 法人姓名。 */
    public String legalName;
    /** 联系电话。 */
    public String phoneNum;
    /** 证件类型。 */
    public String identityType;
    /** 终端类型。 */
    public String endType;
    /** 一对多标识。 */
    public String oneToManyFlag;
    /** 代理人授权书URL。 */
    public String agentAuthorizationLetterUrl;
    /** 营业执照URL。 */
    public String businessLicenseUrl;
    /** 身份证国徽面URL。 */
    public String nationalEmblemIdentityUrl;
    /** 身份证人像面URL。 */
    public String figureIdentityUrl;
    /** 法人身份证国徽面URL。 */
    public String legalNationalEmblemIdentityUrl;
    /** 法人身份证人像面URL。 */
    public String legalFigureIdentityUrl;
    /** 手持证件照/办公场景照片URL。 */
    public String identityOfficePhotoUrl;
    /** 合同首页URL。 */
    public String contractHeadPageUrl;
    /** 合同有效期页URL。 */
    public String contractValidityPageUrl;
    /** 合同尾页URL。 */
    public String contractTailPageUrl;
    /** 备注。 */
    public String remark;
}
