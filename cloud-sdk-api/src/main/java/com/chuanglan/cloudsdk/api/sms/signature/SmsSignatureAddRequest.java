package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 创建签名请求。
 */
public class SmsSignatureAddRequest extends CloudSdkModel {

    /** 产品类型。 */
    private String productType;
    /** 签名类型。 */
    private String signType;
    /** 签名名称。 */
    private String signatureName;
    /** 签名场景类型。 */
    private Integer signatureSceneType;
    /** 终端客户ID/资质ID。 */
    private String endCustomerid;
    /** 应用/网站URL。 */
    private String appUrl;
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
    /** 其他补充材料图片列表。 */
    private List<String> additionalAttachmentsImg;

    public SmsSignatureAddRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsSignatureAddRequest setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public SmsSignatureAddRequest setSignatureName(String signatureName) {
        this.signatureName = signatureName;
        return this;
    }

    public SmsSignatureAddRequest setSignatureSceneType(Integer signatureSceneType) {
        this.signatureSceneType = signatureSceneType;
        return this;
    }

    public SmsSignatureAddRequest setEndCustomerid(String endCustomerid) {
        this.endCustomerid = endCustomerid;
        return this;
    }

    public SmsSignatureAddRequest setAppUrl(String appUrl) {
        this.appUrl = appUrl;
        return this;
    }

    public SmsSignatureAddRequest setAppImg(String appImg) {
        this.appImg = appImg;
        return this;
    }

    public SmsSignatureAddRequest setAppOpenScreenshotImg(String appOpenScreenshotImg) {
        this.appOpenScreenshotImg = appOpenScreenshotImg;
        return this;
    }

    public SmsSignatureAddRequest setSbjScreenshotImg(String sbjScreenshotImg) {
        this.sbjScreenshotImg = sbjScreenshotImg;
        return this;
    }

    public SmsSignatureAddRequest setTrademarkImg(String trademarkImg) {
        this.trademarkImg = trademarkImg;
        return this;
    }

    public SmsSignatureAddRequest setTrademarkAuthImg(String trademarkAuthImg) {
        this.trademarkAuthImg = trademarkAuthImg;
        return this;
    }

    public SmsSignatureAddRequest setInstitutionImg(String institutionImg) {
        this.institutionImg = institutionImg;
        return this;
    }

    public SmsSignatureAddRequest setCompanyUniqueScreenshotImg(String companyUniqueScreenshotImg) {
        this.companyUniqueScreenshotImg = companyUniqueScreenshotImg;
        return this;
    }

    public SmsSignatureAddRequest setSignAuthImg(String signAuthImg) {
        this.signAuthImg = signAuthImg;
        return this;
    }

    public SmsSignatureAddRequest setAdditionalAttachmentsImg(List<String> additionalAttachmentsImg) {
        this.additionalAttachmentsImg = additionalAttachmentsImg;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getSignType() {
        return this.signType;
    }

    public String getSignatureName() {
        return this.signatureName;
    }

    public Integer getSignatureSceneType() {
        return this.signatureSceneType;
    }

    public String getEndCustomerid() {
        return this.endCustomerid;
    }

    public String getAppUrl() {
        return this.appUrl;
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

    public List<String> getAdditionalAttachmentsImg() {
        return this.additionalAttachmentsImg;
    }
}
