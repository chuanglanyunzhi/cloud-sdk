package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 发送视频短信模板响应。
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
     * 发送视频短信模板业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 提交失败的号码。
         */
        private List<String> errPhone;

        /**
         * 提交号。
         */
        private String submitNo;

        /**
         * 批次号，一次提交算一个。
         */
        private String batchId;

        public Data setErrPhone(List<String> errPhone) {
            this.errPhone = errPhone;
            return this;
        }

        public Data setSubmitNo(String submitNo) {
            this.submitNo = submitNo;
            return this;
        }

        public Data setBatchId(String batchId) {
            this.batchId = batchId;
            return this;
        }

        public List<String> getErrPhone() {
            return this.errPhone;
        }

        public String getSubmitNo() {
            return this.submitNo;
        }

        public String getBatchId() {
            return this.batchId;
        }
    }

    public Data getData() {
        return this.data;
    }
}
