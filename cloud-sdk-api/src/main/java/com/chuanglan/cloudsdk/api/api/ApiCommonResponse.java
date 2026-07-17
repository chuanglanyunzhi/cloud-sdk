package com.chuanglan.cloudsdk.api.api;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * API common response base class.
 */
public class ApiCommonResponse extends CloudSdkModel {

    /**
     * Return code, 000000 means success.
     */
    public String code;

    /**
     * Response message.
     */
    public String msg;

    /**
     * Request ID.
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

    protected String getCode() {
        return code;
    }

    protected String getMsg() {
        return msg;
    }

    protected String getRequestId() {
        return requestId;
    }

    /**
     * Check if request is successful.
     */
    public boolean isSuccess() {
        return "000000".equals(code);
    }
}
