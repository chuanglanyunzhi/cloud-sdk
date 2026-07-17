package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 归属地查询 V6 响应外层 data。
 */
public class IpAddressOriginV6ResponseData extends CloudSdkModel {

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
    public IpAddressOriginV6InnerData data;

    public IpAddressOriginV6ResponseData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public IpAddressOriginV6ResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public IpAddressOriginV6ResponseData setData(IpAddressOriginV6InnerData data) {
        this.data = data;
        return this;
    }
}
