package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 状态报告明细。
 */
public class RcsSmsReportItem extends CloudSdkModel {

    /**
     * 消息 ID。
     */
    private String messageId;

    /**
     * 接收手机号。
     */
    private String phone;

    /**
     * 发送状态。
     */
    private String status;

    /**
     * 状态码。
     */
    private String statusCode;

    /**
     * 发送时间。
     */
    private String sendTime;

    /**
     * 回执时间。
     */
    private String receiveTime;

    public RcsSmsReportItem setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public RcsSmsReportItem setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RcsSmsReportItem setStatus(String status) {
        this.status = status;
        return this;
    }

    public RcsSmsReportItem setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public RcsSmsReportItem setSendTime(String sendTime) {
        this.sendTime = sendTime;
        return this;
    }

    public RcsSmsReportItem setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
        return this;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getSendTime() {
        return this.sendTime;
    }

    public String getReceiveTime() {
        return this.receiveTime;
    }
}
