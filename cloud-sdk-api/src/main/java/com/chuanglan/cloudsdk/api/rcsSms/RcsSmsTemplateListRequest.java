package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 视频模板列表查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsTemplateListRequest extends CloudSdkModel {

    /**
     * 当前页码，从 1 开始。
     */
    private Integer page;

    /**
     * 每页数量。
     */
    private Integer size;

    /**
     * 模板状态。
     */
    private String status;

    public RcsSmsTemplateListRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public RcsSmsTemplateListRequest setSize(Integer size) {
        this.size = size;
        return this;
    }

    public RcsSmsTemplateListRequest setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getSize() {
        return this.size;
    }

    public String getStatus() {
        return this.status;
    }
}
