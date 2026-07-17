package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 代理识别响应内层业务数据。
 */
public class IpProxyIdentificationInnerData extends CloudSdkModel {

    /**
     * 代理识别结果。
     */
    public IpProxyIdentificationProxy proxy;

    public IpProxyIdentificationInnerData setProxy(IpProxyIdentificationProxy proxy) {
        this.proxy = proxy;
        return this;
    }
}
