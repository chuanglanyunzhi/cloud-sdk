package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业二要素核验返回 data。
 */
public class EnterpriseTwoElementsCheckData extends CloudSdkModel {

    /**
     * 企业名称认证结果（-1：无法验证；0：不一致；1：一致）。
     */
    private String ent_name_match;

    /**
     * 社会统一信用代码认证结果（-1：无法验证；0：不一致；1：一致）。
     */
    private String credit_code_match;

    public EnterpriseTwoElementsCheckData setEnt_name_match(String ent_name_match) {
        this.ent_name_match = ent_name_match;
        return this;
    }

    public EnterpriseTwoElementsCheckData setCredit_code_match(String credit_code_match) {
        this.credit_code_match = credit_code_match;
        return this;
    }

    public String getEnt_name_match() {
        return this.ent_name_match;
    }

    public String getCredit_code_match() {
        return this.credit_code_match;
    }
}
