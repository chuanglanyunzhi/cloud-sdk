package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 状态报告明细。
 */
public class RcsSmsReportItem extends CloudSdkModel {

    /**
     * 手机号。
     */
    private String phone;

    /**
     * 批次号。
     */
    private String batchId;

    /**
     * 提交号。
     */
    private String submitNo;

    /**
     * 投递状态：1 成功 2 失败。
     */
    private String deliveryStatus;

    /**
     * 创建时间（毫秒时间戳）。
     */
    private Long createTime;

    /**
     * 创蓝错误码。
     */
    private String clErrorCode;

    public RcsSmsReportItem setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RcsSmsReportItem setBatchId(String batchId) {
        this.batchId = batchId;
        return this;
    }

    public RcsSmsReportItem setSubmitNo(String submitNo) {
        this.submitNo = submitNo;
        return this;
    }

    public RcsSmsReportItem setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        return this;
    }

    public RcsSmsReportItem setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public RcsSmsReportItem setClErrorCode(String clErrorCode) {
        this.clErrorCode = clErrorCode;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getBatchId() {
        return this.batchId;
    }

    public String getSubmitNo() {
        return this.submitNo;
    }

    public String getDeliveryStatus() {
        return this.deliveryStatus;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getClErrorCode() {
        return this.clErrorCode;
    }
}
