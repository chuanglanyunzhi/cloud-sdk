package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 代理识别响应外层 data。
 */
public class IpProxyIdentificationResponseData extends CloudSdkModel {

    /**
     * 底层服务返回码，200：成功。
     */
    private Integer code;

    /**
     * 底层服务响应说明。
     */
    private String msg;

    /**
     * 业务数据对象。
     */
    private IpProxyIdentificationInnerData data;

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

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public IpProxyIdentificationInnerData getData() {
        return this.data;
    }
}
