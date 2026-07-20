package com.chuanglan.cloudsdk.api.api.mnp;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 携号转网 V1 查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MnpCarriersSftpRequest extends CloudSdkModel {

    /**
     * 手机号。
     */
    private String mobile;

    /**
     * 加密类型：1-MD5，2-SHA256，3-SM3。
     */
    private String type;

    public MnpCarriersSftpRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public MnpCarriersSftpRequest setType(String type) {
        this.type = type;
        return this;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getType() {
        return this.type;
    }
}
