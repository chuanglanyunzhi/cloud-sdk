package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 驾驶证 OCR 识别请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DrivingLicenseRequest extends CloudSdkModel {

    /**
     * 识别图片，支持 url 或 base64，图片大小不能大于 2M，支持 jpg/png/bmp。
     */
    private String image;

    /**
     * 图片类型，枚举值：URL-图片路径；BASE64-图片 BASE64 编码。
     */
    private String imageType;

    public DrivingLicenseRequest setImage(String image) {
        this.image = image;
        return this;
    }

    public DrivingLicenseRequest setImageType(String imageType) {
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
