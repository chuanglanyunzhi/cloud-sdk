package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 动态活体检测动作结果。
 */
public class LifeCheckMotion extends CloudSdkModel {

    /**
     * 单个动作分值，大于 0.2 表示通过，小于等于 0.2 表示不通过。
     */
    private Double score;

    /**
     * 用户动作序列。
     */
    private String motion;

    /**
     * 单个动作检测结果。
     */
    private Boolean passed;

    public LifeCheckMotion setScore(Double score) {
        this.score = score;
        return this;
    }

    public LifeCheckMotion setMotion(String motion) {
        this.motion = motion;
        return this;
    }

    public LifeCheckMotion setPassed(Boolean passed) {
        this.passed = passed;
        return this;
    }

    public Double getScore() {
        return this.score;
    }

    public String getMotion() {
        return this.motion;
    }

    public Boolean getPassed() {
        return this.passed;
    }
}
