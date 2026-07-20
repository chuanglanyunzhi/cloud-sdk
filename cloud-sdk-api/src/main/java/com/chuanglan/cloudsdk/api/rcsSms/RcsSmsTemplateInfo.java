package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 视频模板信息。
 */
public class RcsSmsTemplateInfo extends CloudSdkModel {

    /**
     * 模板 ID。
     */
    private String templateId;

    /**
     * 模板名称。
     */
    private String templateName;

    /**
     * 模板签名。
     */
    private String sign;

    /**
     * 视频短信文本内容。
     */
    private String content;

    /**
     * 视频资源 URL 列表。
     */
    private List<String> videoUrls;

    /**
     * 封面 URL 列表。
     */
    private List<String> coverUrls;

    /**
     * 模板状态。
     */
    private String status;

    /**
     * 创建时间。
     */
    private String createTime;

    public RcsSmsTemplateInfo setTemplateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public RcsSmsTemplateInfo setTemplateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    public RcsSmsTemplateInfo setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public RcsSmsTemplateInfo setContent(String content) {
        this.content = content;
        return this;
    }

    public RcsSmsTemplateInfo setVideoUrls(List<String> videoUrls) {
        this.videoUrls = videoUrls;
        return this;
    }

    public RcsSmsTemplateInfo setCoverUrls(List<String> coverUrls) {
        this.coverUrls = coverUrls;
        return this;
    }

    public RcsSmsTemplateInfo setStatus(String status) {
        this.status = status;
        return this;
    }

    public RcsSmsTemplateInfo setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public String getSign() {
        return this.sign;
    }

    public String getContent() {
        return this.content;
    }

    public List<String> getVideoUrls() {
        return this.videoUrls;
    }

    public List<String> getCoverUrls() {
        return this.coverUrls;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCreateTime() {
        return this.createTime;
    }
}
