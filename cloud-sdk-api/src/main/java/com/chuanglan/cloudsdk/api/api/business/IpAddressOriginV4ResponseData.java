package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 归属地查询 V4 响应外层 data。
 */
public class IpAddressOriginV4ResponseData extends CloudSdkModel {

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
    private IpAddressOriginV4InnerData data;

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

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public IpAddressOriginV4InnerData getData() {
        return this.data;
    }
}
