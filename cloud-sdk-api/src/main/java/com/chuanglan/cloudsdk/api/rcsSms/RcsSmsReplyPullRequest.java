package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 上行回复拉取请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsReplyPullRequest extends CloudSdkModel {

    /**
     * 当前页码，从 1 开始。
     */
    private Integer page;

    /**
     * 每页数量。
     */
    private Integer size;

    /**
     * 开始时间，yyyy-MM-dd HH:mm:ss。
     */
    private String startTime;

    /**
     * 结束时间，yyyy-MM-dd HH:mm:ss。
     */
    private String endTime;

    /**
     * 接收手机号。
     */
    private String phone;

    public RcsSmsReplyPullRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public RcsSmsReplyPullRequest setSize(Integer size) {
        this.size = size;
        return this;
    }

    public RcsSmsReplyPullRequest setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public RcsSmsReplyPullRequest setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public RcsSmsReplyPullRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getSize() {
        return this.size;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getPhone() {
        return this.phone;
    }
}
