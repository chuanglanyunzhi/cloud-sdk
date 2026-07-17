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
    public String entname;

    /**
     * 统一社会信用代码。
     */
    public String uniscid;

    /**
     * 注册号。
     */
    public String regno;

    public AdministrativeSanctionQueryRequest setEntname(String entname) {
        this.entname = entname;
        return this;
    }

    public AdministrativeSanctionQueryRequest setUniscid(String uniscid) {
        this.uniscid = uniscid;
        return this;
    }

    public AdministrativeSanctionQueryRequest setRegno(String regno) {
        this.regno = regno;
        return this;
    }
}
