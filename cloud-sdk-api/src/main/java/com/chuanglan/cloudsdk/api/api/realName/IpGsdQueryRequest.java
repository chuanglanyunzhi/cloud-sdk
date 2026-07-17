package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 归属地查询请求。
 */
public class IpGsdQueryRequest extends CloudSdkModel {

    /**
     * IP 地址，支持 IPv4。
     */
    public String ip;

    public IpGsdQueryRequest setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
