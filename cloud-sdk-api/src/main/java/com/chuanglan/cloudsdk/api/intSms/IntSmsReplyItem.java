package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信上行回复数据。
 */
public class IntSmsReplyItem extends CloudSdkModel {

    /**
     * 用户上行回复时间。
     */
    public String moTime;

    /**
     * 回复用户手机号。
     */
    public String mobile;

    /**
     * 用户回复短信内容。
     */
    public String msg;

    /**
     * 短信接入号 / 目的接收号码。
     */
    public String destcode;

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
}
