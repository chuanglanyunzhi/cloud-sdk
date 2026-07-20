package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 企业大中小微划型服务请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyLevelRequest extends CloudSdkModel {

    /**
     * 信用代码/注册号/组织机构代码/企业名称。
     */
    private String key;

    public CompanyLevelRequest setKey(String key) {
        this.key = key;
        return this;
    }

    public String getKey() {
        return this.key;
    }
}
