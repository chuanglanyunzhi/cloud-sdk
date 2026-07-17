package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 应用场景响应外层 data。
 */
public class IpApplicationScenariosResponseData extends CloudSdkModel {

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
    public IpApplicationScenariosInnerData data;

    public IpApplicationScenariosResponseData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public IpApplicationScenariosResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public IpApplicationScenariosResponseData setData(IpApplicationScenariosInnerData data) {
        this.data = data;
        return this;
    }
}
