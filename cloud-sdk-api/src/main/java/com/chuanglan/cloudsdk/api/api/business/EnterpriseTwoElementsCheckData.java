package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 企业二要素核验返回 data。
 */
public class EnterpriseTwoElementsCheckData extends CloudSdkModel {

    /**
     * 企业名称认证结果（-1：无法验证；0：不一致；1：一致）。
     */
    @JsonProperty("ent_name_match")
    private String entNameMatch;

    /**
     * 社会统一信用代码认证结果（-1：无法验证；0：不一致；1：一致）。
     */
    @JsonProperty("credit_code_match")
    private String creditCodeMatch;

    public EnterpriseTwoElementsCheckData setEntNameMatch(String entNameMatch) {
        this.entNameMatch = entNameMatch;
        return this;
    }

    public EnterpriseTwoElementsCheckData setCreditCodeMatch(String creditCodeMatch) {
        this.creditCodeMatch = creditCodeMatch;
        return this;
    }

    public String getEntNameMatch() {
        return this.entNameMatch;
    }

    public String getCreditCodeMatch() {
        return this.creditCodeMatch;
    }
}
