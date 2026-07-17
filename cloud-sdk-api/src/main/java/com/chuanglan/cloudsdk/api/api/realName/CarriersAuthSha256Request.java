package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 运营商三要素 SHA256 核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarriersAuthSha256Request extends CloudSdkModel {

    /**
     * 姓名，SHA256 加密形式（64 位小写）。
     */
    public String chName;

    /**
     * 身份证号，SHA256 加密形式（64 位小写）。
     */
    public String idNum;

    /**
     * 手机号，SHA256 加密形式（64 位小写）。
     */
    public String chTel;

    public CarriersAuthSha256Request setChName(String chName) {
        this.chName = chName;
        return this;
    }

    public CarriersAuthSha256Request setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public CarriersAuthSha256Request setChTel(String chTel) {
        this.chTel = chTel;
        return this;
    }
}
