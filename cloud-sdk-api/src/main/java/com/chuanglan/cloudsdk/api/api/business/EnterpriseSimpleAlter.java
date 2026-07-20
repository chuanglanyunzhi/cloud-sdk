package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业工商信息查询（简项）变更记录。
 */
public class EnterpriseSimpleAlter extends CloudSdkModel {

    /**
     * 变更事项。
     */
    private String altitem;

    /**
     * 变更前内容。
     */
    private String altbe;

    /**
     * 变更后内容。
     */
    private String altaf;

    /**
     * 变更日期。
     */
    private String altdate;

    public EnterpriseSimpleAlter setAltitem(String altitem) {
        this.altitem = altitem;
        return this;
    }

    public EnterpriseSimpleAlter setAltbe(String altbe) {
        this.altbe = altbe;
        return this;
    }

    public EnterpriseSimpleAlter setAltaf(String altaf) {
        this.altaf = altaf;
        return this;
    }

    public EnterpriseSimpleAlter setAltdate(String altdate) {
        this.altdate = altdate;
        return this;
    }

    public String getAltitem() {
        return this.altitem;
    }

    public String getAltbe() {
        return this.altbe;
    }

    public String getAltaf() {
        return this.altaf;
    }

    public String getAltdate() {
        return this.altdate;
    }
}
