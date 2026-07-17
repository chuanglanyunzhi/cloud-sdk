package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 驾驶证 OCR V2 识别请求，支持正副页同时识别。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DrivingLicenseOcrV2Request extends CloudSdkModel {

    /**
     * 识别图片，请确保内容信息清晰可见。支持 url 或 base64，图片大小不能大于 2M，支持图片类型：jpg/png/bmp。
     */
    public String image;

    /**
     * 图片类型，枚举值：URL-图片路径，BASE64-图片 BASE64 编码。
     */
    public String imageType;

    public DrivingLicenseOcrV2Request setImage(String image) {
        this.image = image;
        return this;
    }

    public DrivingLicenseOcrV2Request setImageType(String imageType) {
        this.imageType = imageType;
        return this;
    }
}
