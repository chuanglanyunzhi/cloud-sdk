package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 上行回复明细。
 */
public class RcsSmsReplyItem extends CloudSdkModel {

    /**
     * 消息 ID。
     */
    public String messageId;

    /**
     * 接收手机号。
     */
    public String phone;

    /**
     * 回复内容。
     */
    public String content;

    /**
     * 回复时间。
     */
    public String replyTime;

    public RcsSmsReplyItem setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public RcsSmsReplyItem setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RcsSmsReplyItem setContent(String content) {
        this.content = content;
        return this;
    }

    public RcsSmsReplyItem setReplyTime(String replyTime) {
        this.replyTime = replyTime;
        return this;
    }
}
