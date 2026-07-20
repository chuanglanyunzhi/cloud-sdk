package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 运营商三要素详细版 SHA256 核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarriersAuthDetailSha256Request extends CloudSdkModel {

    /**
     * 姓名，SHA256 加密形式（64 位小写）。
     */
    private String name;

    /**
     * 身份证号，SHA256 加密形式（64 位小写）。
     */
    private String idNum;

    /**
     * 手机号，SHA256 加密形式（64 位小写）。
     */
    private String mobile;

    public CarriersAuthDetailSha256Request setName(String name) {
        this.name = name;
        return this;
    }

    public CarriersAuthDetailSha256Request setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public CarriersAuthDetailSha256Request setMobile(String mobile) {
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
