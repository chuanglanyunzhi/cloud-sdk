package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 号码在网时长查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberOnlineDurationRequest extends CloudSdkModel {

    /**
     * 手机号。
     */
    public String mobile;

    /**
     * 加密类型：md5 小写 或 sha256。
     */
    public String encrypt;

    /**
     * 加密数据字段，例如 mobile。
     */
    public String encryptFields;

    /**
     * 交易流水号。
     */
    public String orderNo;

    public NumberOnlineDurationRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public NumberOnlineDurationRequest setEncrypt(String encrypt) {
        this.encrypt = encrypt;
        return this;
    }

    public NumberOnlineDurationRequest setEncryptFields(String encryptFields) {
        this.encryptFields = encryptFields;
        return this;
    }

    public NumberOnlineDurationRequest setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }
}
