package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 企业工商模糊查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnterpriseQueryRequest extends CloudSdkModel {

    /**
     * 企业名称关键字。
     */
    private String entName;

    public EnterpriseQueryRequest setEntName(String entName) {
        this.entName = entName;
        return this;
    }

    public String getEntName() {
        return this.entName;
    }
}
