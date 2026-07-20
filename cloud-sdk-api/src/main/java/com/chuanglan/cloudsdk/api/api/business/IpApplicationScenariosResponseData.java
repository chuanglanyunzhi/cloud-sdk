package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 应用场景响应外层 data。
 */
public class IpApplicationScenariosResponseData extends CloudSdkModel {

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
    private IpApplicationScenariosInnerData data;

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

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public IpApplicationScenariosInnerData getData() {
        return this.data;
    }
}
