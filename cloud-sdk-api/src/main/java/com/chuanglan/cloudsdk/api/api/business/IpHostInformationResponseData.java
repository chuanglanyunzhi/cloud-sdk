package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 宿主信息响应外层 data。
 */
public class IpHostInformationResponseData extends CloudSdkModel {

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
    private IpHostInformationInnerData data;

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

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public IpHostInformationInnerData getData() {
        return this.data;
    }
}
