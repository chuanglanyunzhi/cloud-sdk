package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 视频短信（RCS）接口通用响应基类。
 */
public class RcsSmsCommonResponse extends CloudSdkModel {

    /**
     * 请求状态码，000000 代表成功。
     */
    public String code;

    /**
     * 提示信息。
     */
    public String msg;

    /**
     * 请求 ID。
     */
    public String requestId;

    public RcsSmsCommonResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public RcsSmsCommonResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public RcsSmsCommonResponse setRequestId(String requestId) {
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
