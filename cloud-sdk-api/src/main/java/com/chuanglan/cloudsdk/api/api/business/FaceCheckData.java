package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 静态活体检测返回数据。
 */
public class FaceCheckData extends CloudSdkModel {

    /**
     * 人脸 ID。
     */
    public String faceId;

    /**
     * 是否活体：0 非活体，1 活体。
     */
    public String isLived;

    /**
     * 活体分数，范围 0-100。
     */
    public Float score;

    /**
     * 结果描述。
     */
    public String msg;

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
}
