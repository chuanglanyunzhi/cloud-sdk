package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 添加视频模板请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsTemplateAddRequest extends CloudSdkModel {

    /**
     * 模板名称。
     */
    public String templateName;

    /**
     * 模板签名。
     */
    public String sign;

    /**
     * 视频资源 URL。
     */
    public String videoUrl;

    /**
     * 视频封面 URL。
     */
    public String coverUrl;

    /**
     * 视频短信文本内容。
     */
    public String content;

    /**
     * 备注。
     */
    public String remark;

    public RcsSmsTemplateAddRequest setTemplateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    public RcsSmsTemplateAddRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public RcsSmsTemplateAddRequest setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public RcsSmsTemplateAddRequest setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
        return this;
    }

    public RcsSmsTemplateAddRequest setContent(String content) {
        this.content = content;
        return this;
    }

    public RcsSmsTemplateAddRequest setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
