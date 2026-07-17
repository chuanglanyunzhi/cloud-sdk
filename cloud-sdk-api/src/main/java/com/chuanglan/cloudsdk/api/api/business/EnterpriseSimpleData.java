package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 企业工商信息查询（简项）数据。
 */
public class EnterpriseSimpleData extends CloudSdkModel {

    /**
     * 基本信息。
     */
    public EnterpriseSimpleBasic basic;

    /**
     * 股东信息。
     */
    public List<EnterpriseSimpleShareholder> shareholders;

    /**
     * 分支机构。
     */
    public List<EnterpriseSimpleFiliation> filiations;

    /**
     * 变更记录。
     */
    public List<EnterpriseSimpleAlter> alters;

    public EnterpriseSimpleData setBasic(EnterpriseSimpleBasic basic) {
        this.basic = basic;
        return this;
    }

    public EnterpriseSimpleData setShareholders(List<EnterpriseSimpleShareholder> shareholders) {
        this.shareholders = shareholders;
        return this;
    }

    public EnterpriseSimpleData setFiliations(List<EnterpriseSimpleFiliation> filiations) {
        this.filiations = filiations;
        return this;
    }

    public EnterpriseSimpleData setAlters(List<EnterpriseSimpleAlter> alters) {
        this.alters = alters;
        return this;
    }
}
