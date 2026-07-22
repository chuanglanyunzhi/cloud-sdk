package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.chuanglan.cloudsdk.core.NameInMap;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 发送视频短信模板请求。
 *
 * <p>支持静态模板（phoneNumbers 手机号列表）和动态模板（phoneNumberJson 带变量）两种发送方式，
 * 二者互斥：静态模板发送时 {@link #phoneNumbers} 必填；动态模板发送时 {@link #phoneNumberJson} 必填。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsTemplateSubmitRequest extends CloudSdkModel {

    /**
     * 提交号，客户端提供，作为客户端的提交标识，长度不超过 32 位。
     */
    private String submitNo;

    /**
     * 手机号列表，静态模板发送时此字段必填。
     */
    @NameInMap("phoneNumbers")
    private List<String> phoneNumbers;

    /**
     * 动态模板变量列表，动态模板发送时此字段必填。
     */
    @NameInMap("phoneNumberJson")
    private List<RcsSmsDynamicVar> phoneNumberJson;

    /**
     * 模板 ID。
     */
    private String templateId;

    public RcsSmsTemplateSubmitRequest setSubmitNo(String submitNo) {
        this.submitNo = submitNo;
        return this;
    }

    public RcsSmsTemplateSubmitRequest setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public RcsSmsTemplateSubmitRequest setPhoneNumberJson(List<RcsSmsDynamicVar> phoneNumberJson) {
        this.phoneNumberJson = phoneNumberJson;
        return this;
    }

    public RcsSmsTemplateSubmitRequest setTemplateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public String getSubmitNo() {
        return this.submitNo;
    }

    public List<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public List<RcsSmsDynamicVar> getPhoneNumberJson() {
        return this.phoneNumberJson;
    }

    public String getTemplateId() {
        return this.templateId;
    }
}
