package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 运营商二要素核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarriersTwoAuthRequest extends CloudSdkModel {

    /**
     * 姓名。
     */
    public String name;

    /**
     * 手机号。
     */
    public String mobile;

    public CarriersTwoAuthRequest setName(String name) {
        this.name = name;
        return this;
    }

    public CarriersTwoAuthRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
}
