package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 企业三要素核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnterpriseThreeAuthRequest extends CloudSdkModel {

    /**
     * 企业名称。
     */
    public String entName;

    /**
     * 法人姓名。
     */
    public String legalPerName;

    /**
     * 统一社会信用代码。
     */
    public String creditCode;

    public EnterpriseThreeAuthRequest setEntName(String entName) {
        this.entName = entName;
        return this;
    }

    public EnterpriseThreeAuthRequest setLegalPerName(String legalPerName) {
        this.legalPerName = legalPerName;
        return this;
    }

    public EnterpriseThreeAuthRequest setCreditCode(String creditCode) {
        this.creditCode = creditCode;
        return this;
    }
}
