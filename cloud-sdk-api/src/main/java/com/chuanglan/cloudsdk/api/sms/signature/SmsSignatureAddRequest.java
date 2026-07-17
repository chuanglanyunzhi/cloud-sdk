package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 创建签名请求。
 */
public class SmsSignatureAddRequest extends CloudSdkModel {

    /** 产品类型。 */
    public String productType;
    /** 签名类型。 */
    public String signType;
    /** 签名名称。 */
    public String signatureName;
    /** 签名场景类型。 */
    public Integer signatureSceneType;
    /** 终端客户ID/资质ID。 */
    public String endCustomerid;
    /** 应用/网站URL。 */
    public String appUrl;
    /** 应用图片。 */
    public String appImg;
    /** App打开截图。 */
    public String appOpenScreenshotImg;
    /** 主体截图。 */
    public String sbjScreenshotImg;
    /** 商标图片。 */
    public String trademarkImg;
    /** 商标授权书图片。 */
    public String trademarkAuthImg;
    /** 机构证件图片。 */
    public String institutionImg;
    /** 企业唯一标识截图。 */
    public String companyUniqueScreenshotImg;
    /** 签名授权书图片。 */
    public String signAuthImg;
    /** 其他补充材料图片列表。 */
    public List<String> additionalAttachmentsImg;

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
}
