package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * IP 应用场景识别请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpApplicationScenariosRequest extends CloudSdkModel {

    /**
     * IP 地址，支持 IPv4。
     */
    private String ip;

    public IpApplicationScenariosRequest setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getIp() {
        return this.ip;
    }
}
