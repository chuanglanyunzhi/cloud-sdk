package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 身份证二要素核验 V2（签名版）请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IdCardAuthV2Request extends CloudSdkModel {

    /**
     * 姓名。
     */
    public String name;

    /**
     * 身份证号码，限单个。
     */
    public String idNum;

    public IdCardAuthV2Request setName(String name) {
        this.name = name;
        return this;
    }

    public IdCardAuthV2Request setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }
}
