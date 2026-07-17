package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 签名列表查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsSignListRequest extends CloudSdkModel {

    /**
     * 当前页码，从 1 开始。
     */
    public Integer page;

    /**
     * 每页数量。
     */
    public Integer size;

    /**
     * 签名状态。
     */
    public String status;

    public RcsSmsSignListRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public RcsSmsSignListRequest setSize(Integer size) {
        this.size = size;
        return this;
    }

    public RcsSmsSignListRequest setStatus(String status) {
        this.status = status;
        return this;
    }
}
