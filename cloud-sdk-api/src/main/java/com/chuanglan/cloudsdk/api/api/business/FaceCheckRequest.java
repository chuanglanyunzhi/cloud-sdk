package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 静态活体检测请求。
 */
public class FaceCheckRequest extends CloudSdkModel {

    /**
     * 图片 Base64 编码，支持 JPG/PNG/BMP 格式，大小不超过 2M。
     */
    private String image;

    public FaceCheckRequest setImage(String image) {
        this.image = image;
        return this;
    }

    public String getImage() {
        return this.image;
    }
}
