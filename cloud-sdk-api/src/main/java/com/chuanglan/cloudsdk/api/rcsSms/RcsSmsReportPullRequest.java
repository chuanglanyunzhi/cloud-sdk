package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 状态报告拉取请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsReportPullRequest extends CloudSdkModel {

    /**
     * 当前页码，从 1 开始。
     */
    public Integer page;

    /**
     * 每页数量。
     */
    public Integer size;

    /**
     * 开始时间，yyyy-MM-dd HH:mm:ss。
     */
    public String startTime;

    /**
     * 结束时间，yyyy-MM-dd HH:mm:ss。
     */
    public String endTime;

    /**
     * 接收手机号。
     */
    public String phone;

    /**
     * 消息 ID。
     */
    public String messageId;

    public RcsSmsReportPullRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public RcsSmsReportPullRequest setSize(Integer size) {
        this.size = size;
        return this;
    }

    public RcsSmsReportPullRequest setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public RcsSmsReportPullRequest setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public RcsSmsReportPullRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RcsSmsReportPullRequest setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }
}
