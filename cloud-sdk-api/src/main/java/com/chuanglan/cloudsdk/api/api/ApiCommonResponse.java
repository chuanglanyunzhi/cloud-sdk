package com.chuanglan.cloudsdk.api.api;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * API common response base class.
 */
public class ApiCommonResponse extends CloudSdkModel {

    /**
     * Return code, 000000 means success.
     */
    private String code;

    /**
     * Response message.
     */
    private String msg;

    /**
     * Request ID.
     */
    private String requestId;

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

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getRequestId() {
        return requestId;
    }

    /**
     * Check if request is successful.
     */
    public boolean isSuccess() {
        return "000000".equals(getCode());
    }
}
