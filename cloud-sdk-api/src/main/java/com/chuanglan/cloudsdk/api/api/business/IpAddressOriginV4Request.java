package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * IP 归属地查询 V4 请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpAddressOriginV4Request extends CloudSdkModel {

    /**
     * IP 地址，支持 IPv4。
     */
    public String ip;

    public IpAddressOriginV4Request setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
