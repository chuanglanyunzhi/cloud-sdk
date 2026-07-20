package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 添加视频模板响应。
 */
public class RcsSmsTemplateAddResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    private Data data;

    public RcsSmsTemplateAddResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 添加视频模板业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 模板 ID。
         */
        private String templateId;

        /**
         * 模板状态。
         */
        private String status;

        public Data setTemplateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Data setStatus(String status) {
            this.status = status;
            return this;
        }

        public String getTemplateId() {
            return this.templateId;
        }

        public String getStatus() {
            return this.status;
        }
    }

    public Data getData() {
        return this.data;
    }
}
