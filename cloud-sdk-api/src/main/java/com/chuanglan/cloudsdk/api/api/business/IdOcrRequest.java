package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 身份证 OCR 识别请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IdOcrRequest extends CloudSdkModel {

    /**
     * 身份证照片，支持 url 或 base64，图片大小不能大于 2M。
     */
    public String image;

    /**
     * 图片类型，枚举值：URL-图片路径；BASE64-图片 BASE64 编码。
     */
    public String imageType;

    /**
     * ocr 类型，0 表示身份证正面，1 表示身份证反面。
     */
    public String ocrType;

    /**
     * 是否开启身份证风险类型（身份证复印件）功能，默认不开启。可选值：true/false。
     */
    public String detectRisk;

    public IdOcrRequest setImage(String image) {
        this.image = image;
        return this;
    }

    public IdOcrRequest setImageType(String imageType) {
        this.imageType = imageType;
        return this;
    }

    public IdOcrRequest setOcrType(String ocrType) {
        this.ocrType = ocrType;
        return this;
    }

    public IdOcrRequest setDetectRisk(String detectRisk) {
        this.detectRisk = detectRisk;
        return this;
    }
}
