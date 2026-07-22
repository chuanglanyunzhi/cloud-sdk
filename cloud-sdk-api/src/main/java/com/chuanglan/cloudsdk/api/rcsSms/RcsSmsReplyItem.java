package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 上行回复明细。
 */
public class RcsSmsReplyItem extends CloudSdkModel {

    /**
     * 手机号。
     */
    private String phone;

    /**
     * 端口号地址。
     */
    private String codeNoAddress;

    /**
     * 消息 ID。
     */
    private String msgId;

    /**
     * 上行回复内容。
     */
    private String upContent;

    /**
     * 创建时间（毫秒时间戳）。
     */
    private Long createTime;

    /**
     * 批次号。
     */
    private String batchId;

    /**
     * 提交号。
     */
    private String submitNo;

    public RcsSmsReplyItem setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RcsSmsReplyItem setCodeNoAddress(String codeNoAddress) {
        this.codeNoAddress = codeNoAddress;
        return this;
    }

    public RcsSmsReplyItem setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public RcsSmsReplyItem setUpContent(String upContent) {
        this.upContent = upContent;
        return this;
    }

    public RcsSmsReplyItem setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public RcsSmsReplyItem setBatchId(String batchId) {
        this.batchId = batchId;
        return this;
    }

    public RcsSmsReplyItem setSubmitNo(String submitNo) {
        this.submitNo = submitNo;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getCodeNoAddress() {
        return this.codeNoAddress;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getUpContent() {
        return this.upContent;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getBatchId() {
        return this.batchId;
    }

    public String getSubmitNo() {
        return this.submitNo;
    }
}
