package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 经营异常查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbnormalOperationRequest extends CloudSdkModel {

    /**
     * 企业名称。
     */
    private String entName;

    /**
     * 统一社会信用代码。
     */
    private String creditCode;

    /**
     * 企业注册号。
     */
    private String regNo;

    /**
     * 组织机构代码。
     */
    private String orgCode;

    public AbnormalOperationRequest setEntName(String entName) {
        this.entName = entName;
        return this;
    }

    public AbnormalOperationRequest setCreditCode(String creditCode) {
        this.creditCode = creditCode;
        return this;
    }

    public AbnormalOperationRequest setRegNo(String regNo) {
        this.regNo = regNo;
        return this;
    }

    public AbnormalOperationRequest setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }

    public String getEntName() {
        return this.entName;
    }

    public String getCreditCode() {
        return this.creditCode;
    }

    public String getRegNo() {
        return this.regNo;
    }

    public String getOrgCode() {
        return this.orgCode;
    }
}
