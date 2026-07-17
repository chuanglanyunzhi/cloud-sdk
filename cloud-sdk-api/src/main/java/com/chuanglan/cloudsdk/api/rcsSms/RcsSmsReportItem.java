package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 状态报告明细。
 */
public class RcsSmsReportItem extends CloudSdkModel {

    /**
     * 消息 ID。
     */
    public String messageId;

    /**
     * 接收手机号。
     */
    public String phone;

    /**
     * 发送状态。
     */
    public String status;

    /**
     * 状态码。
     */
    public String statusCode;

    /**
     * 发送时间。
     */
    public String sendTime;

    /**
     * 回执时间。
     */
    public String receiveTime;

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
}
