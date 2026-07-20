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
    private String entname;

    /**
     * 统一社会信用代码。
     */
    private String creditcode;

    /**
     * 企业注册号。
     */
    private String regno;

    /**
     * 组织机构代码。
     */
    private String orgcode;

    public AbnormalOperationRequest setEntname(String entname) {
        this.entname = entname;
        return this;
    }

    public AbnormalOperationRequest setCreditcode(String creditcode) {
        this.creditcode = creditcode;
        return this;
    }

    public AbnormalOperationRequest setRegno(String regno) {
        this.regno = regno;
        return this;
    }

    public AbnormalOperationRequest setOrgcode(String orgcode) {
        this.orgcode = orgcode;
        return this;
    }

    public String getEntname() {
        return this.entname;
    }

    public String getCreditcode() {
        return this.creditcode;
    }

    public String getRegno() {
        return this.regno;
    }

    public String getOrgcode() {
        return this.orgcode;
    }
}
