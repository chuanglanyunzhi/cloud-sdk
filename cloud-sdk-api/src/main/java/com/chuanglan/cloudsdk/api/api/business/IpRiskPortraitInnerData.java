package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 风险画像响应内层业务数据。
 */
public class IpRiskPortraitInnerData extends CloudSdkModel {

    /**
     * 风险画像结果。
     */
    public IpRiskPortraitRisk risk;

    public IpRiskPortraitInnerData setRisk(IpRiskPortraitRisk risk) {
        this.risk = risk;
        return this;
    }
}
