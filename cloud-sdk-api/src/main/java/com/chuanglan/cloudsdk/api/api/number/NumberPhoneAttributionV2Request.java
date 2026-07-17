package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 手机号码归属地（升级版 V2）请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberPhoneAttributionV2Request extends CloudSdkModel {

    /**
     * 用户手机号（明文，或按 type 指定的加密方式）。
     */
    public String mobile;

    /**
     * 订单号。
     */
    public String orderNo;

    /**
     * 0 或空：明文手机号；1：32 位小写 MD5 手机号；2：64 位 SHA256 手机号。
     */
    public Integer type;

    public NumberPhoneAttributionV2Request setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public NumberPhoneAttributionV2Request setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public NumberPhoneAttributionV2Request setType(Integer type) {
        this.type = type;
        return this;
    }
}
