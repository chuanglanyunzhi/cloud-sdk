package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 运营商三要素核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarriersAuthRequest extends CloudSdkModel {

    /**
     * 姓名。
     */
    private String name;

    /**
     * 身份证号。
     */
    private String idNum;

    /**
     * 手机号。
     */
    private String mobile;

    public CarriersAuthRequest setName(String name) {
        this.name = name;
        return this;
    }

    public CarriersAuthRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public CarriersAuthRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public String getIdNum() {
        return this.idNum;
    }

    public String getMobile() {
        return this.mobile;
    }
}
