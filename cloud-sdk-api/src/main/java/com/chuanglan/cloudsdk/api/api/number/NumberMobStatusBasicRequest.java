package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 号码实时基础版查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberMobStatusBasicRequest extends CloudSdkModel {

    /**
     * 手机号码。
     */
    private String mobile;

    /**
     * 业务唯一流水号。
     */
    private String orderNo;

    /**
     * 加密类型：md5（32 位小写）或 sha256。
     */
    private String encrypt;

    /**
     * 加密数据字段，例如 mobile。
     */
    private String encryptFields;

    public NumberMobStatusBasicRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public NumberMobStatusBasicRequest setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public NumberMobStatusBasicRequest setEncrypt(String encrypt) {
        this.encrypt = encrypt;
        return this;
    }

    public NumberMobStatusBasicRequest setEncryptFields(String encryptFields) {
        this.encryptFields = encryptFields;
        return this;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getEncrypt() {
        return this.encrypt;
    }

    public String getEncryptFields() {
        return this.encryptFields;
    }
}
