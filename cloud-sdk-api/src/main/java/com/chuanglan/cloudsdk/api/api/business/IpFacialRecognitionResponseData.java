package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 真人识别响应外层 data。
 */
public class IpFacialRecognitionResponseData extends CloudSdkModel {

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
    private IpFacialRecognitionInnerData data;

    public IpFacialRecognitionResponseData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public IpFacialRecognitionResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public IpFacialRecognitionResponseData setData(IpFacialRecognitionInnerData data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public IpFacialRecognitionInnerData getData() {
        return this.data;
    }
}
