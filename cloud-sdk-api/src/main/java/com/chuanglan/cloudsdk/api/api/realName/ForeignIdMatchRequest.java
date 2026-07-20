package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 涉外身份证核验（人像）请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForeignIdMatchRequest extends CloudSdkModel {

    /**
     * 人脸照，base64 字符串，需去掉头部描述，图片大小不能大于 50K。
     */
    private String image;

    /**
     * 证件号。
     */
    private String idNum;

    /**
     * 姓名。
     */
    private String name;

    /**
     * 国家名英文缩写，除港澳以外参照 ISO3166 标准，华侨和港澳人员使用 CHN。
     */
    private String nation;

    /**
     * 证件类型。
     * 414：定居国外的中国公民护照；
     * 516：港澳居民来往内地通行证；
     * 511：台湾居民来往大陆通行证；
     * 553：外国人永久居留证。
     */
    private String type;

    public ForeignIdMatchRequest setImage(String image) {
        this.image = image;
        return this;
    }

    public ForeignIdMatchRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public ForeignIdMatchRequest setName(String name) {
        this.name = name;
        return this;
    }

    public ForeignIdMatchRequest setNation(String nation) {
        this.nation = nation;
        return this;
    }

    public ForeignIdMatchRequest setType(String type) {
        this.type = type;
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

    public String getNation() {
        return this.nation;
    }

    public String getType() {
        return this.type;
    }
}
