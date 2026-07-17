package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 表格 OCR 识别请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableOcrRequest extends CloudSdkModel {

    /**
     * 图片 base64 串，image、url 二选一。格式为 jpg 或 png，宽和高大于 8px、小于等于 4000px，大小不能超过 1MB。
     */
    public String image;

    /**
     * 图片 url，image、url 二选一。格式为 jpg 或 png，宽和高大于 8px、小于等于 4000px，大小不能超过 1MB。
     */
    public String url;

    public TableOcrRequest setImage(String image) {
        this.image = image;
        return this;
    }

    public TableOcrRequest setUrl(String url) {
        this.url = url;
        return this;
    }
}
