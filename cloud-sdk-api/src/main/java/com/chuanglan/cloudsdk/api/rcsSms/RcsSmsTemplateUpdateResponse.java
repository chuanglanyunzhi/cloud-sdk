package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 更新视频模板响应。
 */
public class RcsSmsTemplateUpdateResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    public Data data;

    public RcsSmsTemplateUpdateResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 更新视频模板业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 模板 ID。
         */
        public String templateId;

        /**
         * 模板状态。
         */
        public String status;

        public Data setTemplateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Data setStatus(String status) {
            this.status = status;
            return this;
        }
    }
}
