package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.Map;

/**
 * 批量发送短信响应 data 字段。
 */
public class SmsBatchSendResponseData extends CloudSdkModel {

    /**
     * 提交成功条数。
     */
    public String successNum;

    /**
     * 提交失败条数。
     */
    public String failNum;

    /**
     * 消息 id（32 位纯数字）。
     */
    public String msgId;

    public static SmsBatchSendResponseData build(Map<String, ?> map) throws Exception {
        return build(map, SmsBatchSendResponseData.class);
    }

    public SmsBatchSendResponseData setSuccessNum(String successNum) {
        this.successNum = successNum;
        return this;
    }

    public SmsBatchSendResponseData setFailNum(String failNum) {
        this.failNum = failNum;
        return this;
    }

    public SmsBatchSendResponseData setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }
}
