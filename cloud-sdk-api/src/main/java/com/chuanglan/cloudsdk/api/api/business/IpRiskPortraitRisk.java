package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * IP 风险画像结果。
 */
public class IpRiskPortraitRisk extends CloudSdkModel {

    /**
     * 代理类型 / 是否代理，无代理时可能为空。
     */
    private String proxy;

    /**
     * 风险评分，根据风险证据、风险标签、代理类型发生时间及风险类型综合评分。
     */
    private Integer risk_score;

    /**
     * 风险等级，根据风险评分进行等级划分。
     */
    private String risk_level;

    /**
     * 秒拨概率，0%~100%。值越高，表明该 IP 越可能存在秒速拨号行为。
     */
    private String mb_rate;

    /**
     * 真人概率，0%~99%。值越接近 0%，越趋近机器行为。
     */
    private String real;

    /**
     * 风险标签数组，采集 IP 在使用中疑似发生的风险行为。
     */
    private List<IpRiskPortraitRiskTag> risk_tag;

    public IpRiskPortraitRisk setProxy(String proxy) {
        this.proxy = proxy;
        return this;
    }

    public IpRiskPortraitRisk setRisk_score(Integer risk_score) {
        this.risk_score = risk_score;
        return this;
    }

    public IpRiskPortraitRisk setRisk_level(String risk_level) {
        this.risk_level = risk_level;
        return this;
    }

    public IpRiskPortraitRisk setMb_rate(String mb_rate) {
        this.mb_rate = mb_rate;
        return this;
    }

    public IpRiskPortraitRisk setReal(String real) {
        this.real = real;
        return this;
    }

    public IpRiskPortraitRisk setRisk_tag(List<IpRiskPortraitRiskTag> risk_tag) {
        this.risk_tag = risk_tag;
        return this;
    }

    public String getProxy() {
        return this.proxy;
    }

    public Integer getRisk_score() {
        return this.risk_score;
    }

    public String getRisk_level() {
        return this.risk_level;
    }

    public String getMb_rate() {
        return this.mb_rate;
    }

    public String getReal() {
        return this.real;
    }

    public List<IpRiskPortraitRiskTag> getRisk_tag() {
        return this.risk_tag;
    }
}
