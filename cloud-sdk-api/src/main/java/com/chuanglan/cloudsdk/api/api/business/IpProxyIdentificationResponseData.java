package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 代理识别响应外层 data。
 */
public class IpProxyIdentificationResponseData extends CloudSdkModel {

    /**
     * 底层服务返回码，200：成功。
     */
    public Integer code;

    /**
     * 底层服务响应说明。
     */
    public String msg;

    /**
     * 业务数据对象。
     */
    public IpProxyIdentificationInnerData data;

    public IpProxyIdentificationResponseData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public IpProxyIdentificationResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public IpProxyIdentificationResponseData setData(IpProxyIdentificationInnerData data) {
        this.data = data;
        return this;
    }
}
