package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信上行回复数据。
 */
public class IntSmsReplyItem extends CloudSdkModel {

    /**
     * 用户上行回复时间。
     */
    private String moTime;

    /**
     * 回复用户手机号。
     */
    private String mobile;

    /**
     * 用户回复短信内容。
     */
    private String msg;

    /**
     * 短信接入号 / 目的接收号码。
     */
    private String destcode;

    public IntSmsReplyItem setMoTime(String moTime) {
        this.moTime = moTime;
        return this;
    }

    public IntSmsReplyItem setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public IntSmsReplyItem setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public IntSmsReplyItem setDestcode(String destcode) {
        this.destcode = destcode;
        return this;
    }

    public String getMoTime() {
        return this.moTime;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getDestcode() {
        return this.destcode;
    }
}
