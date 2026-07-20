package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 发送视频模板短信响应。
 */
public class RcsSmsTemplateSubmitResponse extends RcsSmsCommonResponse {

    /**
     * 业务返回数据。
     */
    private Data data;

    public RcsSmsTemplateSubmitResponse setData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 发送视频模板短信业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 消息 ID。
         */
        private String messageId;

        /**
         * 错误手机号列表。
         */
        private List<String> errorPhone;

        /**
         * 成功发送数量。
         */
        private Integer total;

        public Data setMessageId(String messageId) {
            this.messageId = messageId;
            return this;
        }

        public Data setErrorPhone(List<String> errorPhone) {
            this.errorPhone = errorPhone;
            return this;
        }

        public Data setTotal(Integer total) {
            this.total = total;
            return this;
        }

        public String getMessageId() {
            return this.messageId;
        }

        public List<String> getErrorPhone() {
            return this.errorPhone;
        }

        public Integer getTotal() {
            return this.total;
        }
    }

    public Data getData() {
        return this.data;
    }
}
