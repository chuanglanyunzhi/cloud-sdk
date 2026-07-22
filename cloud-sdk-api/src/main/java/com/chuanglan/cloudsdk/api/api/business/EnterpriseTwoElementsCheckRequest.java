package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 企业二要素核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnterpriseTwoElementsCheckRequest extends CloudSdkModel {

    /**
     * 注册号/社会统一信用代码。
     */
    @JsonProperty("credit_code")
    private String creditCode;

    /**
     * 企业名称。
     */
    @JsonProperty("ent_name")
    private String entName;

    public EnterpriseTwoElementsCheckRequest setCreditCode(String creditCode) {
        this.creditCode = creditCode;
        return this;
    }

    public EnterpriseTwoElementsCheckRequest setEntName(String entName) {
        this.entName = entName;
        return this;
    }

    public String getCreditCode() {
        return this.creditCode;
    }

    public String getEntName() {
        return this.entName;
    }
}
