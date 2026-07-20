package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业三要素核验响应数据。
 */
public class EnterpriseThreeAuthResponseData extends CloudSdkModel {

    /**
     * 企业名称核验结果：1 一致；2 不一致；3 无法验证。
     */
    private String entNameMatch;

    /**
     * 统一社会信用代码核验结果：1 一致；2 不一致；3 无法验证。
     */
    private String creditCodeMatch;

    /**
     * 法人姓名核验结果：1 一致；2 不一致；3 无法验证。
     */
    private String legalPerNameMatch;

    public EnterpriseThreeAuthResponseData setEntNameMatch(String entNameMatch) {
        this.entNameMatch = entNameMatch;
        return this;
    }

    public EnterpriseThreeAuthResponseData setCreditCodeMatch(String creditCodeMatch) {
        this.creditCodeMatch = creditCodeMatch;
        return this;
    }

    public EnterpriseThreeAuthResponseData setLegalPerNameMatch(String legalPerNameMatch) {
        this.legalPerNameMatch = legalPerNameMatch;
        return this;
    }

    public String getEntNameMatch() {
        return this.entNameMatch;
    }

    public String getCreditCodeMatch() {
        return this.creditCodeMatch;
    }

    public String getLegalPerNameMatch() {
        return this.legalPerNameMatch;
    }
}
