package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 运营商审核驳回原因项。
 */
public class SmsOperatorRejectReason extends CloudSdkModel {

    /**
     * 问题类型。
     */
    public Integer issueType;

    /**
     * 问题描述。
     */
    public String issueDesc;

    /**
     * 操作建议。
     */
    public String operationRecommend;

    /**
     * 修改模块。
     */
    public String modifyModules;

    public SmsOperatorRejectReason setIssueType(Integer issueType) {
        this.issueType = issueType;
        return this;
    }

    public SmsOperatorRejectReason setIssueDesc(String issueDesc) {
        this.issueDesc = issueDesc;
        return this;
    }

    public SmsOperatorRejectReason setOperationRecommend(String operationRecommend) {
        this.operationRecommend = operationRecommend;
        return this;
    }

    public SmsOperatorRejectReason setModifyModules(String modifyModules) {
        this.modifyModules = modifyModules;
        return this;
    }
}
