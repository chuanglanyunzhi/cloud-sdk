package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 宿主信息响应外层 data。
 */
public class IpHostInformationResponseData extends CloudSdkModel {

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
    public IpHostInformationInnerData data;

    public IpHostInformationResponseData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public IpHostInformationResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public IpHostInformationResponseData setData(IpHostInformationInnerData data) {
        this.data = data;
        return this;
    }
}
