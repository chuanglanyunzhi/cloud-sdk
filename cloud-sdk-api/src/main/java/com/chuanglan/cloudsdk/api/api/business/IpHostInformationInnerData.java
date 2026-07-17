package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 宿主信息响应内层业务数据。
 */
public class IpHostInformationInnerData extends CloudSdkModel {

    /**
     * IP 宿主信息。
     */
    public IpHostInformation host_information;

    public IpHostInformationInnerData setHost_information(IpHostInformation host_information) {
        this.host_information = host_information;
        return this;
    }
}
