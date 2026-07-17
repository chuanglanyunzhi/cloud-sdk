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
    public String mobile;

    /**
     * 业务唯一流水号。
     */
    public String orderNo;

    /**
     * 加密类型：md5（32 位小写）或 sha256。
     */
    public String encrypt;

    /**
     * 加密数据字段，例如 mobile。
     */
    public String encryptFields;

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
}
