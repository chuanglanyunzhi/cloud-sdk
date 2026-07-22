package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 企业招投标信息查询（翻页）请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnterpriseBiddingRequest extends CloudSdkModel {

    /**
     * 企业名称。
     */
    private String entName;

    /**
     * 注册号。
     */
    private String regNo;

    /**
     * 角色（作为招标方 0；作为中标方 1，全部不用填）。
     */
    private String bType;

    /**
     * 公告开始日期，格式：2023-01-01。
     */
    private String publishStartTime;

    /**
     * 公告结束日期，格式：2023-01-01。
     */
    private String publishEndTime;

    /**
     * 当前页数（默认第 1 页）。
     */
    private String page;

    /**
     * 每页条数（默认 20 条，最大 20 条）。
     */
    private String size;

    public EnterpriseBiddingRequest setEntName(String entName) {
        this.entName = entName;
        return this;
    }

    public EnterpriseBiddingRequest setRegNo(String regNo) {
        this.regNo = regNo;
        return this;
    }

    public EnterpriseBiddingRequest setBType(String bType) {
        this.bType = bType;
        return this;
    }

    public EnterpriseBiddingRequest setPublishStartTime(String publishStartTime) {
        this.publishStartTime = publishStartTime;
        return this;
    }

    public EnterpriseBiddingRequest setPublishEndTime(String publishEndTime) {
        this.publishEndTime = publishEndTime;
        return this;
    }

    public EnterpriseBiddingRequest setPage(String page) {
        this.page = page;
        return this;
    }

    public EnterpriseBiddingRequest setSize(String size) {
        this.size = size;
        return this;
    }

    public String getEntName() {
        return this.entName;
    }

    public String getRegNo() {
        return this.regNo;
    }

    public String getBType() {
        return this.bType;
    }

    public String getPublishStartTime() {
        return this.publishStartTime;
    }

    public String getPublishEndTime() {
        return this.publishEndTime;
    }

    public String getPage() {
        return this.page;
    }

    public String getSize() {
        return this.size;
    }
}
