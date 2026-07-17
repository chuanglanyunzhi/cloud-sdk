package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 号码在网状态查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberNetStatusRequest extends CloudSdkModel {

    /**
     * 预验证 11 位手机号码（与 encryptFields 二选一）。
     */
    public String mobile;

    /**
     * 加密类型：md5（32 位小写）或 sha256。
     */
    public String encrypt;

    /**
     * 加密数据字段，例如 mobile。
     */
    public String encryptFields;

    /**
     * 订单号。
     */
    public String orderNo;

    public NumberNetStatusRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public NumberNetStatusRequest setEncrypt(String encrypt) {
        this.encrypt = encrypt;
        return this;
    }

    public NumberNetStatusRequest setEncryptFields(String encryptFields) {
        this.encryptFields = encryptFields;
        return this;
    }

    public NumberNetStatusRequest setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }
}
