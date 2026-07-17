package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 企业四要素核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnterpriseFourAuthRequest extends CloudSdkModel {

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

    /**
     * 法人身份证。
     */
    public String idNum;

    public EnterpriseFourAuthRequest setEntName(String entName) {
        this.entName = entName;
        return this;
    }

    public EnterpriseFourAuthRequest setLegalPerName(String legalPerName) {
        this.legalPerName = legalPerName;
        return this;
    }

    public EnterpriseFourAuthRequest setCreditCode(String creditCode) {
        this.creditCode = creditCode;
        return this;
    }

    public EnterpriseFourAuthRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }
}
