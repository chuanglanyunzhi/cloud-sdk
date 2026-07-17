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
    public String entname;

    /**
     * 注册号。
     */
    public String regno;

    /**
     * 角色（作为招标方 0；作为中标方 1，全部不用填）。
     */
    public String btype;

    /**
     * 公告开始日期，格式：2023-01-01。
     */
    public String publishStartTime;

    /**
     * 公告结束日期，格式：2023-01-01。
     */
    public String publishEndTime;

    /**
     * 当前页数（默认第 1 页）。
     */
    public String page;

    /**
     * 每页条数（默认 20 条，最大 20 条）。
     */
    public String size;

    public EnterpriseBiddingRequest setEntname(String entname) {
        this.entname = entname;
        return this;
    }

    public EnterpriseBiddingRequest setRegno(String regno) {
        this.regno = regno;
        return this;
    }

    public EnterpriseBiddingRequest setBtype(String btype) {
        this.btype = btype;
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
}
