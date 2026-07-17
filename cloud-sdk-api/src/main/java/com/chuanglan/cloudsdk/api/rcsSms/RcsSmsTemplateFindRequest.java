package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 查询视频模板请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsTemplateFindRequest extends CloudSdkModel {

    /**
     * 模板 ID。
     */
    public String templateId;

    public RcsSmsTemplateFindRequest setTemplateId(String templateId) {
        this.templateId = templateId;
        return this;
    }
}
