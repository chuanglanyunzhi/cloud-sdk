package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 身份证二要素核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IdCardAuthRequest extends CloudSdkModel {

    /**
     * 姓名。
     */
    private String name;

    /**
     * 身份证号码，限单个。
     */
    private String idNum;

    public IdCardAuthRequest setName(String name) {
        this.name = name;
        return this;
    }

    public IdCardAuthRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public String getIdNum() {
        return this.idNum;
    }
}
