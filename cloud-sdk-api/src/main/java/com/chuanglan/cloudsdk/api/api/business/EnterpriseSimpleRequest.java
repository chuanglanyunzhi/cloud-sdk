package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 企业工商信息查询（简项）请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnterpriseSimpleRequest extends CloudSdkModel {

    /**
     * 企业名称。
     */
    public String entName;

    /**
     * 企业注册号。
     */
    public String regNo;

    /**
     * 统一信用代码。
     */
    public String creditCode;

    /**
     * 组织机构代码。
     */
    public String orgCode;

    public EnterpriseSimpleRequest setEntName(String entName) {
        this.entName = entName;
        return this;
    }

    public EnterpriseSimpleRequest setRegNo(String regNo) {
        this.regNo = regNo;
        return this;
    }

    public EnterpriseSimpleRequest setCreditCode(String creditCode) {
        this.creditCode = creditCode;
        return this;
    }

    public EnterpriseSimpleRequest setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }
}
