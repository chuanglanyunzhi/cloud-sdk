package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * IP 归属地查询 V6 请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpAddressOriginV6Request extends CloudSdkModel {

    /**
     * IP 地址，支持 IPv4 / IPv6。
     */
    public String ip;

    public IpAddressOriginV6Request setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
