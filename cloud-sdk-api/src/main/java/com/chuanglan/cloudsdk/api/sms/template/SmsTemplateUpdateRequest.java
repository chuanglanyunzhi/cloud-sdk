package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 编辑模板请求。
 */
public class SmsTemplateUpdateRequest extends CloudSdkModel {

    /**
     * 产品类型，必填。可选值：notify（通知短信）、market（营销短信）、verify（验证码短信）、
     * 2ec（CS短信/二类电商）、finance（DK短信/金融）、game（BK短信/游戏）、acquisition（HK短信/拉新）
     */
    private String productType;

    /** 模板ID，必填 */
    private String templateCode;

    /**
     * 模板内容，必填。不包含短信签名和退订语，长度不超过500字；包含链接时需在链接前后各加一个空格；变量用 {s} 标识。
     * 示例：您的验证码是123456，请在5分钟内使用
     */
    private String content;

    /** 模板名称，必填。长度限2-20个字符 */
    private String contentName;

    /** 关联签名名称，必填 */
    private String signName;

    /** 退订语，可选。0不需要，1需要（营销必填） */
    private String needUnsubscribe;

    /** 业务大类，必填。从类型枚举接口获取 */
    private String businessCategory;

    /** 业务细类，必填。从类型枚举接口获取 */
    private String businessSubcategory;

    /**
     * 引流链接，可选。JSON 数组字符串格式，包含 guideType、content、domainExample、icpImg、
     * originLinkAuthImg、redirectLinkAuthImg 等字段。
     * 示例：[{"guideType":"2","content":"https://api.253.com","domainExample":"https://api.253.com/ZKPDCasdasdfT","icpImg":"...","originLinkAuthImg":"...","redirectLinkAuthImg":"..."}]
     */
    private String guideUrl;

    /**
     * 联系方式，可选。JSON 数组字符串格式，包含 guideType、content、phoneMaterialImg 等字段。
     * 示例：[{"guideType":"1","content":"130XXXXXXXX","phoneMaterialImg":"..."}]
     */
    private String guidePhone;

    /**
     * 变量属性，可选。JSON 数组字符串格式，包含 name、type、length、position 等字段。运营商建议3个变量，最大不超过20个。
     * 示例：[{"name":"变量1","type":"3","length":"30","position":0}]
     */
    private String variableParams;

    /** 备注内容，可选。描述对审核者的建议，有利于加速模板审核 */
    private String remark;

    public SmsTemplateUpdateRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsTemplateUpdateRequest setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
        return this;
    }

    public SmsTemplateUpdateRequest setContent(String content) {
        this.content = content;
        return this;
    }

    public SmsTemplateUpdateRequest setContentName(String contentName) {
        this.contentName = contentName;
        return this;
    }

    public SmsTemplateUpdateRequest setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    public SmsTemplateUpdateRequest setNeedUnsubscribe(String needUnsubscribe) {
        this.needUnsubscribe = needUnsubscribe;
        return this;
    }

    public SmsTemplateUpdateRequest setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
        return this;
    }

    public SmsTemplateUpdateRequest setBusinessSubcategory(String businessSubcategory) {
        this.businessSubcategory = businessSubcategory;
        return this;
    }

    public SmsTemplateUpdateRequest setGuideUrl(String guideUrl) {
        this.guideUrl = guideUrl;
        return this;
    }

    public SmsTemplateUpdateRequest setGuidePhone(String guidePhone) {
        this.guidePhone = guidePhone;
        return this;
    }

    public SmsTemplateUpdateRequest setVariableParams(String variableParams) {
        this.variableParams = variableParams;
        return this;
    }

    public SmsTemplateUpdateRequest setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getTemplateCode() {
        return this.templateCode;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentName() {
        return this.contentName;
    }

    public String getSignName() {
        return this.signName;
    }

    public String getNeedUnsubscribe() {
        return this.needUnsubscribe;
    }

    public String getBusinessCategory() {
        return this.businessCategory;
    }

    public String getBusinessSubcategory() {
        return this.businessSubcategory;
    }

    public String getGuideUrl() {
        return this.guideUrl;
    }

    public String getGuidePhone() {
        return this.guidePhone;
    }

    public String getVariableParams() {
        return this.variableParams;
    }

    public String getRemark() {
        return this.remark;
    }
}
