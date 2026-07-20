package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 国际短信发送响应业务数据。
 */
public class IntSmsSubmitResponseData extends CloudSdkModel {

    /**
     * 单发：单条消息 ID；批量：批量消息 ID。
     */
    private String messageId;

    /**
     * 仅批量发送返回，提交失败的手机号列表。
     */
    private List<String> errorPhone;

    public IntSmsSubmitResponseData setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public IntSmsSubmitResponseData setErrorPhone(List<String> errorPhone) {
        this.errorPhone = errorPhone;
        return this;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public List<String> getErrorPhone() {
        return this.errorPhone;
    }
}
