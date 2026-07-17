package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 查询视频模板响应。
 */
public class RcsSmsTemplateFindResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    public Data data;

    public RcsSmsTemplateFindResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 查询视频模板业务数据。
     */
    public static class Data extends CloudSdkModel {

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
         * 文本内容。
         */
        public String content;

        /**
         * 视频资源 URL 列表。
         */
        public java.util.List<String> videoUrls;

        /**
         * 封面 URL 列表。
         */
        public java.util.List<String> coverUrls;

        /**
         * 模板状态。
         */
        public String status;

        /**
         * 创建时间。
         */
        public String createTime;

        public Data setTemplateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Data setTemplateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        public Data setSign(String sign) {
            this.sign = sign;
            return this;
        }

        public Data setContent(String content) {
            this.content = content;
            return this;
        }

        public Data setVideoUrls(java.util.List<String> videoUrls) {
            this.videoUrls = videoUrls;
            return this;
        }

        public Data setCoverUrls(java.util.List<String> coverUrls) {
            this.coverUrls = coverUrls;
            return this;
        }

        public Data setStatus(String status) {
            this.status = status;
            return this;
        }

        public Data setCreateTime(String createTime) {
            this.createTime = createTime;
            return this;
        }
    }
}
