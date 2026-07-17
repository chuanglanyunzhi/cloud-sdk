package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 模板列表项。
 */
public class SmsTemplateListItem extends CloudSdkModel {

    public String templateCode;
    public Integer webOrApi;
    public String accountId;
    public Integer type;
    public String contentTask;
    public String content;
    public String remark;
    public String createTime;
    public String status;
    public String auditDate;
    public String auditReason;
    public Integer remoteId;
    public String signatureName;
    public String contentName;
    public String cmOperatorstatus;
    public String ctOperatorstatus;
    public String cuOperatorstatus;
}
