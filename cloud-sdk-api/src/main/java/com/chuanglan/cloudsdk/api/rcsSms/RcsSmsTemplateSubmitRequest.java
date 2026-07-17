package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 发送视频模板短信请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsTemplateSubmitRequest extends CloudSdkModel {

    /**
     * 模板 ID。
     */
    public String templateId;

    /**
     * 接收手机号列表，多个手机号使用英文逗号分隔或传入列表。
     */
    public List<String> phoneNumbers;

    /**
     * 模板变量参数，JSON 字符串。
     */
    public String params;

    /**
     * 状态回执回调地址。
     */
    public String callbackUrl;

    /**
     * 业务方自定义流水号。
     */
    public String outId;

    public RcsSmsTemplateSubmitRequest setTemplateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public RcsSmsTemplateSubmitRequest setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public RcsSmsTemplateSubmitRequest setParams(String params) {
        this.params = params;
        return this;
    }

    public RcsSmsTemplateSubmitRequest setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public RcsSmsTemplateSubmitRequest setOutId(String outId) {
        this.outId = outId;
        return this;
    }
}
