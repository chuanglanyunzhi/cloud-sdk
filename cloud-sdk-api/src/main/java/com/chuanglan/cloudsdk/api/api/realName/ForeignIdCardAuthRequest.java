package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 涉外身份证校验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForeignIdCardAuthRequest extends CloudSdkModel {

    /**
     * 证件号。
     */
    public String idNum;

    /**
     * 姓名。
     */
    public String name;

    /**
     * 国家名英文缩写，除港澳以外参照 ISO3166 标准，华侨和港澳人员使用 CHN。
     */
    public String nation;

    /**
     * 证件类型。
     * 414：华侨护照；
     * 516：港澳居民来往内地通行证；
     * 511：台湾居民来往大陆通行证；
     * 553：外国人永久居留身份证。
     */
    public String idType;

    public ForeignIdCardAuthRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public ForeignIdCardAuthRequest setName(String name) {
        this.name = name;
        return this;
    }

    public ForeignIdCardAuthRequest setNation(String nation) {
        this.nation = nation;
        return this;
    }

    public ForeignIdCardAuthRequest setIdType(String idType) {
        this.idType = idType;
        return this;
    }
}
