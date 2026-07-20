package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 静态活体检测返回数据。
 */
public class FaceCheckData extends CloudSdkModel {

    /**
     * 人脸 ID。
     */
    private String faceId;

    /**
     * 是否活体：0 非活体，1 活体。
     */
    private String isLived;

    /**
     * 活体分数，范围 0-100。
     */
    private Float score;

    /**
     * 结果描述。
     */
    private String msg;

    public FaceCheckData setFaceId(String faceId) {
        this.faceId = faceId;
        return this;
    }

    public FaceCheckData setIsLived(String isLived) {
        this.isLived = isLived;
        return this;
    }

    public FaceCheckData setScore(Float score) {
        this.score = score;
        return this;
    }

    public FaceCheckData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getFaceId() {
        return this.faceId;
    }

    public String getIsLived() {
        return this.isLived;
    }

    public Float getScore() {
        return this.score;
    }

    public String getMsg() {
        return this.msg;
    }
}
