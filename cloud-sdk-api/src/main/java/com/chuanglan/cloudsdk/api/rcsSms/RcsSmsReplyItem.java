package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 上行回复明细。
 */
public class RcsSmsReplyItem extends CloudSdkModel {

    /**
     * 消息 ID。
     */
    private String messageId;

    /**
     * 接收手机号。
     */
    private String phone;

    /**
     * 回复内容。
     */
    private String content;

    /**
     * 回复时间。
     */
    private String replyTime;

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

    public String getMessageId() {
        return this.messageId;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getContent() {
        return this.content;
    }

    public String getReplyTime() {
        return this.replyTime;
    }
}
