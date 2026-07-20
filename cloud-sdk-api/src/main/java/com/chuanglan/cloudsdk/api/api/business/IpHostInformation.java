package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 宿主信息。
 */
public class IpHostInformation extends CloudSdkModel {

    /**
     * 归属运营商。
     */
    private String owner;

    /**
     * 所在地标 / 商圈 / 楼盘。
     */
    private String business;

    /**
     * 互联网服务提供商。
     */
    private String isp;

    /**
     * 行业 / 场所类型，多个用半角分号分隔。
     */
    private String industry;

    public IpHostInformation setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public IpHostInformation setBusiness(String business) {
        this.business = business;
        return this;
    }

    public IpHostInformation setIsp(String isp) {
        this.isp = isp;
        return this;
    }

    public IpHostInformation setIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getBusiness() {
        return this.business;
    }

    public String getIsp() {
        return this.isp;
    }

    public String getIndustry() {
        return this.industry;
    }
}
