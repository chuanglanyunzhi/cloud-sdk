package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业工商模糊查询返回企业信息。
 */
public class EnterpriseQueryData extends CloudSdkModel {

    /**
     * 企业名称。
     */
    public String entname;

    /**
     * 统一社会信用代码。
     */
    public String creditCode;

    public EnterpriseQueryData setEntname(String entname) {
        this.entname = entname;
        return this;
    }

    public EnterpriseQueryData setCreditCode(String creditCode) {
        this.creditCode = creditCode;
        return this;
    }
}
