package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * 253 短信接口通用响应基类。
 */
public class SmsCommonResponse extends CloudSdkModel {

    /**
     * 请求状态码，000000 代表成功。
     */
    private String code;

    /**
     * 状态说明：success=成功，error=失败。
     */
    private String status;

    /**
     * 提示信息。
     */
    @JsonAlias("message")
    private String msg;

    /**
     * 请求 ID。
     */
    private String requestId;

    public SmsCommonResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public SmsCommonResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public SmsCommonResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public SmsCommonResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * 是否请求成功。
     */
    public boolean isSuccess() {
        return "000000".equals(getCode());
    }

    public String getCode() {
        return this.code;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRequestId() {
        return this.requestId;
    }
}
