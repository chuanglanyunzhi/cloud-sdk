package com.chuanglan.cloudsdk.api.api;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * API 通用响应基类。
 */
public class ApiCommonResponse extends CloudSdkModel {

    /**
     * 返回状态码，000000 代表成功。
     */
    public String code;

    /**
     * 响应 code 码解释。
     */
    public String msg;

    /**
     * 流水号。
     */
    public String requestId;

    public ApiCommonResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public ApiCommonResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ApiCommonResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * 是否请求成功。
     */
    public boolean isSuccess() {
        return "000000".equals(code);
    }
}
