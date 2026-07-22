package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 静态活体检测请求。
 */
public class FaceCheckRequest extends CloudSdkModel {

    /**
     * 活体检测自拍照，支持 URL 或 Base64，图片大小不超过 2M，支持 JPG/PNG/BMP 格式。
     */
    private String image;

    /**
     * 图片类型，枚举值：URL-图片路径；BASE64-图片 Base64 编码。
     */
    private String imageType = "URL";

    public FaceCheckRequest setImage(String image) {
        this.image = image;
        return this;
    }

    public FaceCheckRequest setImageType(String imageType) {
        this.imageType = imageType;
        return this;
    }

    public String getImage() {
        return this.image;
    }

    public String getImageType() {
        return this.imageType;
    }
}
