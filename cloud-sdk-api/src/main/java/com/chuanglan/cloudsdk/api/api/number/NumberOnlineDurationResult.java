package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 号码在网时长结果。
 */
public class NumberOnlineDurationResult extends CloudSdkModel {

    /**
     * 在网时长范围起始值（含），单位为月。
     */
    private Integer rangeStart;

    /**
     * 在网时长范围结束值（不含），单位为月；-1 代表超过 24 个月。
     */
    private Integer rangeEnd;

    /**
     * 运营商：1 移动，2 电信，3 联通，4 广电；携号转网对应负数：-1 移动，-2 电信，-3 联通，-4 广电。
     */
    private Integer provider;

    public NumberOnlineDurationResult setRangeStart(Integer rangeStart) {
        this.rangeStart = rangeStart;
        return this;
    }

    public NumberOnlineDurationResult setRangeEnd(Integer rangeEnd) {
        this.rangeEnd = rangeEnd;
        return this;
    }

    public NumberOnlineDurationResult setProvider(Integer provider) {
        this.provider = provider;
        return this;
    }

    public Integer getRangeStart() {
        return this.rangeStart;
    }

    public Integer getRangeEnd() {
        return this.rangeEnd;
    }

    public Integer getProvider() {
        return this.provider;
    }
}
