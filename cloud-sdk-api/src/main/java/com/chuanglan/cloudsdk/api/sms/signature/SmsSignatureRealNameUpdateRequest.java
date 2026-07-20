package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 编辑签名终端资质请求。
 */
public class SmsSignatureRealNameUpdateRequest extends CloudSdkModel {

    /** 产品类型。 */
    private String productType;
    /** 签名ID。 */
    private String signId;
    /** 终端客户ID。 */
    private String endCustomerid;
    /** 变更类型。 */
    private String Type;
    /** 签名场景类型。 */
    private Integer signatureSceneType;
    /** 备注。 */
    private String remark;
    /** 应用图片。 */
    private String appImg;
    /** App打开截图。 */
    private String appOpenScreenshotImg;
    /** 主体截图。 */
    private String sbjScreenshotImg;
    /** 商标图片。 */
    private String trademarkImg;
    /** 商标授权书图片。 */
    private String trademarkAuthImg;
    /** 机构证件图片。 */
    private String institutionImg;
    /** 企业唯一标识截图。 */
    private String companyUniqueScreenshotImg;
    /** 签名授权书图片。 */
    private String signAuthImg;

    public SmsSignatureRealNameUpdateRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setSignId(String signId) {
        this.signId = signId;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setEndCustomerid(String endCustomerid) {
        this.endCustomerid = endCustomerid;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setType(String type) {
        Type = type;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setSignatureSceneType(Integer signatureSceneType) {
        this.signatureSceneType = signatureSceneType;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setAppImg(String appImg) {
        this.appImg = appImg;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setAppOpenScreenshotImg(String appOpenScreenshotImg) {
        this.appOpenScreenshotImg = appOpenScreenshotImg;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setSbjScreenshotImg(String sbjScreenshotImg) {
        this.sbjScreenshotImg = sbjScreenshotImg;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setTrademarkImg(String trademarkImg) {
        this.trademarkImg = trademarkImg;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setTrademarkAuthImg(String trademarkAuthImg) {
        this.trademarkAuthImg = trademarkAuthImg;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setInstitutionImg(String institutionImg) {
        this.institutionImg = institutionImg;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setCompanyUniqueScreenshotImg(String companyUniqueScreenshotImg) {
        this.companyUniqueScreenshotImg = companyUniqueScreenshotImg;
        return this;
    }

    public SmsSignatureRealNameUpdateRequest setSignAuthImg(String signAuthImg) {
        this.signAuthImg = signAuthImg;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getSignId() {
        return this.signId;
    }

    public String getEndCustomerid() {
        return this.endCustomerid;
    }

    public String getType() {
        return this.Type;
    }

    public Integer getSignatureSceneType() {
        return this.signatureSceneType;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getAppImg() {
        return this.appImg;
    }

    public String getAppOpenScreenshotImg() {
        return this.appOpenScreenshotImg;
    }

    public String getSbjScreenshotImg() {
        return this.sbjScreenshotImg;
    }

    public String getTrademarkImg() {
        return this.trademarkImg;
    }

    public String getTrademarkAuthImg() {
        return this.trademarkAuthImg;
    }

    public String getInstitutionImg() {
        return this.institutionImg;
    }

    public String getCompanyUniqueScreenshotImg() {
        return this.companyUniqueScreenshotImg;
    }

    public String getSignAuthImg() {
        return this.signAuthImg;
    }
}
