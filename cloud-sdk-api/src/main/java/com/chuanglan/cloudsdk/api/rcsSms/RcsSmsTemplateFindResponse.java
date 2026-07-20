package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 查询视频模板响应。
 */
public class RcsSmsTemplateFindResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    private Data data;

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
         * 文本内容。
         */
        private String content;

        /**
         * 视频资源 URL 列表。
         */
        private java.util.List<String> videoUrls;

        /**
         * 封面 URL 列表。
         */
        private java.util.List<String> coverUrls;

        /**
         * 模板状态。
         */
        private String status;

        /**
         * 创建时间。
         */
        private String createTime;

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

        public java.util.List<String> getVideoUrls() {
            return this.videoUrls;
        }

        public java.util.List<String> getCoverUrls() {
            return this.coverUrls;
        }

        public String getStatus() {
            return this.status;
        }

        public String getCreateTime() {
            return this.createTime;
        }
    }

    public Data getData() {
        return this.data;
    }
}
