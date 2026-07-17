package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 企业司法涉诉查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JusticeComplainRequest extends CloudSdkModel {

    /**
     * 企业名称。
     */
    public String entName;

    /**
     * 页码，默认 1。
     */
    public String pageNum;

    /**
     * 每页数量，默认 20，最大 50。
     */
    public String pageSize;

    /**
     * 数据类型。
     */
    public String dataType;

    /**
     * 数据时间，yyyy-mm-dd。
     */
    public String sortTime;

    public JusticeComplainRequest setEntName(String entName) {
        this.entName = entName;
        return this;
    }

    public JusticeComplainRequest setPageNum(String pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public JusticeComplainRequest setPageSize(String pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public JusticeComplainRequest setDataType(String dataType) {
        this.dataType = dataType;
        return this;
    }

    public JusticeComplainRequest setSortTime(String sortTime) {
        this.sortTime = sortTime;
        return this;
    }
}
