package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 企业欠税公告查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnterpriseOwnTaxRequest extends CloudSdkModel {

    /**
     * 搜索关键字（公司名称、注册号或社会统一信用代码）。
     */
    public String keyword;

    /**
     * 每页条数（默认 20 条，最大 20 条）。
     */
    public String pageSize;

    /**
     * 当前页数（默认第 1 页）。
     */
    public String pageNum;

    public EnterpriseOwnTaxRequest setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public EnterpriseOwnTaxRequest setPageSize(String pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public EnterpriseOwnTaxRequest setPageNum(String pageNum) {
        this.pageNum = pageNum;
        return this;
    }
}
