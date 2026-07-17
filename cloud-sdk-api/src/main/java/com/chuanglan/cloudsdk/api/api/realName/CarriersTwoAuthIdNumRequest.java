package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 运营商二要素（身份证版）核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarriersTwoAuthIdNumRequest extends CloudSdkModel {

    /**
     * 手机号，明文或 MD5 加密形式（32 位小写）。
     */
    public String mobile;

    /**
     * 身份证号，明文或 MD5 加密形式（32 位小写）。
     */
    public String idNum;

    public CarriersTwoAuthIdNumRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public CarriersTwoAuthIdNumRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }
}
