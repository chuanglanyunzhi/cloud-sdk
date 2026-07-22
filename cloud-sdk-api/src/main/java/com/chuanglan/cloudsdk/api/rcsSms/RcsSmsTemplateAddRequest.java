package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 添加视频短信模板请求。
 *
 * <p>提交模板是变量模板时，变量模板仅文本可添加变量，且最多包含 5 个变量，
 * 顺序依次为：${v1}、${v2}、${v3}、${v4}、${v5}。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsTemplateAddRequest extends CloudSdkModel {

    /**
     * 模板名称。
     */
    private String templateName;

    /**
     * 已经在平台创建的签名。
     */
    private String sign;

    /**
     * 模板内容列表。
     */
    private List<RcsSmsTemplateBodyItem> body;

    /**
     * 动态模板标记，当创建动态模板时此字段为必须。
     */
    private Integer isDynamic;

    /**
     * 模板链接，创建带链接模板时为必须。
     */
    private String templateLink;

    public RcsSmsTemplateAddRequest setTemplateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    public RcsSmsTemplateAddRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public RcsSmsTemplateAddRequest setBody(List<RcsSmsTemplateBodyItem> body) {
        this.body = body;
        return this;
    }

    public RcsSmsTemplateAddRequest setIsDynamic(Integer isDynamic) {
        this.isDynamic = isDynamic;
        return this;
    }

    public RcsSmsTemplateAddRequest setTemplateLink(String templateLink) {
        this.templateLink = templateLink;
        return this;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public String getSign() {
        return this.sign;
    }

    public List<RcsSmsTemplateBodyItem> getBody() {
        return this.body;
    }

    public Integer getIsDynamic() {
        return this.isDynamic;
    }

    public String getTemplateLink() {
        return this.templateLink;
    }
}
