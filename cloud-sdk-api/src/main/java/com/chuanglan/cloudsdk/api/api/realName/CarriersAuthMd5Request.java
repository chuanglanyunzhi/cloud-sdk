package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 运营商三要素 MD5 核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarriersAuthMd5Request extends CloudSdkModel {

    /**
     * 姓名，MD5 加密形式（32 位小写）。
     */
    private String name;

    /**
     * 身份证号，MD5 加密形式（32 位小写）。
     */
    private String idNum;

    /**
     * 手机号，MD5 加密形式（32 位小写）。
     */
    private String mobile;

    public CarriersAuthMd5Request setName(String name) {
        this.name = name;
        return this;
    }

    public CarriersAuthMd5Request setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public CarriersAuthMd5Request setMobile(String mobile) {
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
