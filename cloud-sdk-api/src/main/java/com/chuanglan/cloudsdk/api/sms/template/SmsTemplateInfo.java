package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 模板详情信息。
 */
public class SmsTemplateInfo extends CloudSdkModel {

    public String templateCode;
    public String webOrApi;
    public String accountId;
    public String type;
    public String contentTask;
    public String Content;
    public String remark;
    public String createTime;
    public String status;
    public String auditDate;
    public String auditReason;
    public String unsubscribe;
    public String statusDesc;
    public String contentname;
    public String signName;
    public String needUnsubscribe;
    public String businessCategory;
    public String businessSubcategory;
    public Object guideUrl;
    public List<Object> guidePhone;
    public List<Object> variableParams;
}
