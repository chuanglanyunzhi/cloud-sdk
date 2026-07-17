package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 代理识别结果。
 */
public class IpProxyIdentificationProxy extends CloudSdkModel {

    /**
     * 是否代理，"是" / "否"，无代理时可能为空。
     */
    public String is_proxy;

    /**
     * 代理类型，如 tor、vpn、proxy、relay 等。
     */
    public String proxy;

    /**
     * 最近代理发生时间，格式 yyyy-MM-dd HH:mm:ss。
     */
    public String proxy_time;

    public IpProxyIdentificationProxy setIs_proxy(String is_proxy) {
        this.is_proxy = is_proxy;
        return this;
    }

    public IpProxyIdentificationProxy setProxy(String proxy) {
        this.proxy = proxy;
        return this;
    }

    public IpProxyIdentificationProxy setProxy_time(String proxy_time) {
        this.proxy_time = proxy_time;
        return this;
    }
}
