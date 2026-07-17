package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 风险画像响应外层 data。
 */
public class IpRiskPortraitResponseData extends CloudSdkModel {

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
    public IpRiskPortraitInnerData data;

    public IpRiskPortraitResponseData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public IpRiskPortraitResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public IpRiskPortraitResponseData setData(IpRiskPortraitInnerData data) {
        this.data = data;
        return this;
    }
}
