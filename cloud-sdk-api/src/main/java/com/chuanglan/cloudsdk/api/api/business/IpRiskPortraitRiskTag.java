package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 风险画像风险标签。
 */
public class IpRiskPortraitRiskTag extends CloudSdkModel {

    /**
     * 风险标签。
     */
    public String label;

    /**
     * 风险标签名称。
     */
    public String label_name;

    /**
     * 最近一次发生时间，格式 yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss。
     */
    public String last_time;

    public IpRiskPortraitRiskTag setLabel(String label) {
        this.label = label;
        return this;
    }

    public IpRiskPortraitRiskTag setLabel_name(String label_name) {
        this.label_name = label_name;
        return this;
    }

    public IpRiskPortraitRiskTag setLast_time(String last_time) {
        this.last_time = last_time;
        return this;
    }
}
