package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 归属地查询 V6 响应内层业务数据。
 */
public class IpAddressOriginV6InnerData extends CloudSdkModel {

    /**
     * 归属地详细信息。
     */
    private IpAddressOriginV6Location location;

    public IpAddressOriginV6InnerData setLocation(IpAddressOriginV6Location location) {
        this.location = location;
        return this;
    }

    public IpAddressOriginV6Location getLocation() {
        return this.location;
    }
}
