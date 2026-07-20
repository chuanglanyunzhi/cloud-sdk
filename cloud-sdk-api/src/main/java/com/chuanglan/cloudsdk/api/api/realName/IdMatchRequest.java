package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 身份证人像比对 V2.0 请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IdMatchRequest extends CloudSdkModel {

    /**
     * 人脸照，base64 字符串，需去掉头部描述（如 data:image/png;base64,），图片大小不能大于 100K。
     */
    private String image;

    /**
     * 身份证号。
     */
    private String idNum;

    /**
     * 姓名。
     */
    private String name;

    /**
     * 是否使用千分制。true：千分制分数；false：百分制分数。默认 false。
     */
    private Boolean useThousandScale;

    public IdMatchRequest setImage(String image) {
        this.image = image;
        return this;
    }

    public IdMatchRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public IdMatchRequest setName(String name) {
        this.name = name;
        return this;
    }

    public IdMatchRequest setUseThousandScale(Boolean useThousandScale) {
        this.useThousandScale = useThousandScale;
        return this;
    }

    public String getImage() {
        return this.image;
    }

    public String getIdNum() {
        return this.idNum;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getUseThousandScale() {
        return this.useThousandScale;
    }
}
