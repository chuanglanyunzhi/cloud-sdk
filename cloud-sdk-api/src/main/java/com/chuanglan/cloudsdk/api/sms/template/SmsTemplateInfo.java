package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 模板详情信息。
 */
public class SmsTemplateInfo extends CloudSdkModel {

    private String templateCode;
    private String webOrApi;
    private String accountId;
    private String type;
    private String contentTask;
    private String content;
    private String remark;
    private String createTime;
    private String status;
    private String auditDate;
    private String auditReason;
    private String unsubscribe;
    private String statusDesc;
    private String contentName;
    private String signName;
    private String needUnsubscribe;
    private String businessCategory;
    private String businessSubcategory;
    private Object guideUrl;
    private List<Object> guidePhone;
    private List<Object> variableParams;

    public String getTemplateCode() {
        return this.templateCode;
    }

    public String getWebOrApi() {
        return this.webOrApi;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getType() {
        return this.type;
    }

    public String getContentTask() {
        return this.contentTask;
    }

    public String getContent() {
        return this.content;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getStatus() {
        return this.status;
    }

    public String getAuditDate() {
        return this.auditDate;
    }

    public String getAuditReason() {
        return this.auditReason;
    }

    public String getUnsubscribe() {
        return this.unsubscribe;
    }

    public String getStatusDesc() {
        return this.statusDesc;
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

    public Object getGuideUrl() {
        return this.guideUrl;
    }

    public List<Object> getGuidePhone() {
        return this.guidePhone;
    }

    public List<Object> getVariableParams() {
        return this.variableParams;
    }
}
