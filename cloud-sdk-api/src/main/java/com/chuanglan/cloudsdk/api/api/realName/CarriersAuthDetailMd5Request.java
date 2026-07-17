package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 运营商三要素详细版 MD5 核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarriersAuthDetailMd5Request extends CloudSdkModel {

    /**
     * 姓名，MD5 加密形式（32 位小写）。
     */
    public String name;

    /**
     * 身份证号，MD5 加密形式（32 位小写）。
     */
    public String idNum;

    /**
     * 手机号，MD5 加密形式（32 位小写）。
     */
    public String mobile;

    public CarriersAuthDetailMd5Request setName(String name) {
        this.name = name;
        return this;
    }

    public CarriersAuthDetailMd5Request setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public CarriersAuthDetailMd5Request setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
}
