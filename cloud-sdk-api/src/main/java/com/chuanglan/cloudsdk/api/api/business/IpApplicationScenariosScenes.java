package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 应用场景识别结果。
 */
public class IpApplicationScenariosScenes extends CloudSdkModel {

    /**
     * 运营商。
     */
    private String isp;

    /**
     * 应用场景类型。
     */
    private String usage_type;

    /**
     * ASN 号。
     */
    private String asn;

    public IpApplicationScenariosScenes setIsp(String isp) {
        this.isp = isp;
        return this;
    }

    public IpApplicationScenariosScenes setUsage_type(String usage_type) {
        this.usage_type = usage_type;
        return this;
    }

    public IpApplicationScenariosScenes setAsn(String asn) {
        this.asn = asn;
        return this;
    }

    public String getIsp() {
        return this.isp;
    }

    public String getUsage_type() {
        return this.usage_type;
    }

    public String getAsn() {
        return this.asn;
    }
}
