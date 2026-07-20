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
    private String mobile;

    /**
     * 加密类型：md5 小写 或 sha256。
     */
    private String encrypt;

    /**
     * 加密数据字段，例如 mobile。
     */
    private String encryptFields;

    /**
     * 交易流水号。
     */
    private String orderNo;

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

    public String getMobile() {
        return this.mobile;
    }

    public String getEncrypt() {
        return this.encrypt;
    }

    public String getEncryptFields() {
        return this.encryptFields;
    }

    public String getOrderNo() {
        return this.orderNo;
    }
}
