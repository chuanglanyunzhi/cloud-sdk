package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 风险画像响应外层 data。
 */
public class IpRiskPortraitResponseData extends CloudSdkModel {

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
    private IpRiskPortraitInnerData data;

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

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public IpRiskPortraitInnerData getData() {
        return this.data;
    }
}
