package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信状态报告数据。
 */
public class IntSmsReportItem extends CloudSdkModel {

    /**
     * 短信唯一消息 ID。
     */
    public String msgid;

    /**
     * 接收手机号。
     */
    public String mobile;

    /**
     * 发送状态标识：0-成功，1-号码无效/用户关机，2-发送请求被拒绝，99-发送通用失败。
     */
    public String status;

    /**
     * 状态上报时间。
     */
    public String reportTime;

    /**
     * 短信提交发送时间。
     */
    public String requestTime;

    /**
     * 结果通知时间。
     */
    public String notifyTime;

    /**
     * 短信发送批次号。
     */
    public String batchSeq;

    /**
     * 单条短信扣费金额。
     */
    public Double fee;

    /**
     * 拆分短信条数。
     */
    public Integer smsNum;

    /**
     * 实际计费条数。
     */
    public Integer billCnt;

    public IntSmsReportItem setMsgid(String msgid) {
        this.msgid = msgid;
        return this;
    }

    public IntSmsReportItem setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public IntSmsReportItem setStatus(String status) {
        this.status = status;
        return this;
    }

    public IntSmsReportItem setReportTime(String reportTime) {
        this.reportTime = reportTime;
        return this;
    }

    public IntSmsReportItem setRequestTime(String requestTime) {
        this.requestTime = requestTime;
        return this;
    }

    public IntSmsReportItem setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
        return this;
    }

    public IntSmsReportItem setBatchSeq(String batchSeq) {
        this.batchSeq = batchSeq;
        return this;
    }

    public IntSmsReportItem setFee(Double fee) {
        this.fee = fee;
        return this;
    }

    public IntSmsReportItem setSmsNum(Integer smsNum) {
        this.smsNum = smsNum;
        return this;
    }

    public IntSmsReportItem setBillCnt(Integer billCnt) {
        this.billCnt = billCnt;
        return this;
    }
}
