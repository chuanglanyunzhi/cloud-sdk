package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 模板列表项。
 */
public class SmsTemplateListItem extends CloudSdkModel {

    private String templateCode;
    private Integer webOrApi;
    private String accountId;
    private Integer type;
    private String contentTask;
    private String content;
    private String remark;
    private String createTime;
    private String status;
    private String auditDate;
    private String auditReason;
    private Integer remoteId;
    private String signatureName;
    private String contentName;
    private String appkey;
    private String cmOperatorStatus;
    private String ctOperatorStatus;
    private String cuOperatorStatus;

    public String getTemplateCode() {
        return this.templateCode;
    }

    public Integer getWebOrApi() {
        return this.webOrApi;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public Integer getType() {
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

    public Integer getRemoteId() {
        return this.remoteId;
    }

    public String getSignatureName() {
        return this.signatureName;
    }

    public String getContentName() {
        return this.contentName;
    }

    public String getAppkey() {
        return this.appkey;
    }

    public String getCmOperatorStatus() {
        return this.cmOperatorStatus;
    }

    public String getCtOperatorStatus() {
        return this.ctOperatorStatus;
    }

    public String getCuOperatorStatus() {
        return this.cuOperatorStatus;
    }
}
