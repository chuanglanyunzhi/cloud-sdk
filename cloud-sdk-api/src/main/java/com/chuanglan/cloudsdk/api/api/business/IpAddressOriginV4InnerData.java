package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 归属地查询 V4 响应内层业务数据。
 */
public class IpAddressOriginV4InnerData extends CloudSdkModel {

    /**
     * 归属地详细信息。
     */
    public IpAddressOriginV4Location location;

    public IpAddressOriginV4InnerData setLocation(IpAddressOriginV4Location location) {
        this.location = location;
        return this;
    }
}
