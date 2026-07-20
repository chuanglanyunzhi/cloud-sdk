package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 动态活体检测结果。
 */
public class LifeCheckResult extends CloudSdkModel {

    /**
     * 活体成功之后，抓取的人脸照片（链接有效期一天）。
     */
    private String face_image_url;

    /**
     * 防 hack 检测分数，阈值为 0.98，大于 0.98 是 hack 行为，小于等于 0.98 是正常活人。
     */
    private Double hack_score;

    /**
     * 用户动作序列检测结果。
     */
    private LifeCheckMotion motions;

    /**
     * 总体检测结果，true - 通过，false - 未通过。
     */
    private Boolean passed;

    /**
     * 活体检查失败的原因。
     */
    private String desc;

    public LifeCheckResult setFace_image_url(String face_image_url) {
        this.face_image_url = face_image_url;
        return this;
    }

    public LifeCheckResult setHack_score(Double hack_score) {
        this.hack_score = hack_score;
        return this;
    }

    public LifeCheckResult setMotions(LifeCheckMotion motions) {
        this.motions = motions;
        return this;
    }

    public LifeCheckResult setPassed(Boolean passed) {
        this.passed = passed;
        return this;
    }

    public LifeCheckResult setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getFace_image_url() {
        return this.face_image_url;
    }

    public Double getHack_score() {
        return this.hack_score;
    }

    public LifeCheckMotion getMotions() {
        return this.motions;
    }

    public Boolean getPassed() {
        return this.passed;
    }

    public String getDesc() {
        return this.desc;
    }
}
