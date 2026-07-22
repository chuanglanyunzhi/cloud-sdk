package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 工商行政处罚查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdministrativeSanctionQueryRequest extends CloudSdkModel {

    /**
     * 企业名称。
     */
    private String entName;

    /**
     * 统一社会信用代码。
     */
    private String uniscId;

    /**
     * 注册号。
     */
    private String regNo;

    public AdministrativeSanctionQueryRequest setEntName(String entName) {
        this.entName = entName;
        return this;
    }

    public AdministrativeSanctionQueryRequest setUniscId(String uniscId) {
        this.uniscId = uniscId;
        return this;
    }

    public AdministrativeSanctionQueryRequest setRegNo(String regNo) {
        this.regNo = regNo;
        return this;
    }

    public String getEntName() {
        return this.entName;
    }

    public String getUniscId() {
        return this.uniscId;
    }

    public String getRegNo() {
        return this.regNo;
    }
}
