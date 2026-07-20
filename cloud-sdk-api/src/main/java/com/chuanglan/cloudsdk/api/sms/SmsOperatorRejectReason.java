package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 运营商审核驳回原因项。
 */
public class SmsOperatorRejectReason extends CloudSdkModel {

    /**
     * 问题类型。
     */
    private Integer issueType;

    /**
     * 问题描述。
     */
    private String issueDesc;

    /**
     * 操作建议。
     */
    private String operationRecommend;

    /**
     * 修改模块。
     */
    private String modifyModules;

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

    public Integer getIssueType() {
        return this.issueType;
    }

    public String getIssueDesc() {
        return this.issueDesc;
    }

    public String getOperationRecommend() {
        return this.operationRecommend;
    }

    public String getModifyModules() {
        return this.modifyModules;
    }
}
