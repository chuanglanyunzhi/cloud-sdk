package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 更新视频模板请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsTemplateUpdateRequest extends CloudSdkModel {

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
     * 视频资源 URL。
     */
    private String videoUrl;

    /**
     * 视频封面 URL。
     */
    private String coverUrl;

    /**
     * 视频短信文本内容。
     */
    private String content;

    /**
     * 模板状态。
     */
    private String status;

    /**
     * 备注。
     */
    private String remark;

    public RcsSmsTemplateUpdateRequest setTemplateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public RcsSmsTemplateUpdateRequest setTemplateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    public RcsSmsTemplateUpdateRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public RcsSmsTemplateUpdateRequest setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public RcsSmsTemplateUpdateRequest setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
        return this;
    }

    public RcsSmsTemplateUpdateRequest setContent(String content) {
        this.content = content;
        return this;
    }

    public RcsSmsTemplateUpdateRequest setStatus(String status) {
        this.status = status;
        return this;
    }

    public RcsSmsTemplateUpdateRequest setRemark(String remark) {
        this.remark = remark;
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

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getContent() {
        return this.content;
    }

    public String getStatus() {
        return this.status;
    }

    public String getRemark() {
        return this.remark;
    }
}
