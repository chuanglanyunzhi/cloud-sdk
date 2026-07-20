package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 企业二要素核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnterpriseTwoElementsCheckRequest extends CloudSdkModel {

    /**
     * 注册号/社会统一信用代码。
     */
    private String credit_code;

    /**
     * 企业名称。
     */
    private String ent_name;

    public EnterpriseTwoElementsCheckRequest setCredit_code(String credit_code) {
        this.credit_code = credit_code;
        return this;
    }

    public EnterpriseTwoElementsCheckRequest setEnt_name(String ent_name) {
        this.ent_name = ent_name;
        return this;
    }

    public String getCredit_code() {
        return this.credit_code;
    }

    public String getEnt_name() {
        return this.ent_name;
    }
}
