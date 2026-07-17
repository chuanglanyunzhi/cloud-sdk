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
    public String templateId;

    /**
     * 模板名称。
     */
    public String templateName;

    /**
     * 模板签名。
     */
    public String sign;

    /**
     * 视频短信文本内容。
     */
    public String content;

    /**
     * 视频资源 URL 列表。
     */
    public List<String> videoUrls;

    /**
     * 封面 URL 列表。
     */
    public List<String> coverUrls;

    /**
     * 模板状态。
     */
    public String status;

    /**
     * 创建时间。
     */
    public String createTime;

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
}
