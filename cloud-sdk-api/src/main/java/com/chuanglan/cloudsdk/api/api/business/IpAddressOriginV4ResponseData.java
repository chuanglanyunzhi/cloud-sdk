package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 归属地查询 V4 响应外层 data。
 */
public class IpAddressOriginV4ResponseData extends CloudSdkModel {

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
    public IpAddressOriginV4InnerData data;

    public IpAddressOriginV4ResponseData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public IpAddressOriginV4ResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public IpAddressOriginV4ResponseData setData(IpAddressOriginV4InnerData data) {
        this.data = data;
        return this;
    }
}
