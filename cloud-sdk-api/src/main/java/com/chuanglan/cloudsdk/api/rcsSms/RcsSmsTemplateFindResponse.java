package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 查询视频模板状态响应。
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
     * 查询视频模板状态业务数据。
     */
    public static class Data extends CloudSdkModel {

        /**
         * 模板状态说明。
         */
        private String statusName;

        /**
         * 模板状态：1 平台审核中 2 运营商审核中 3 审核成功 4 审核失败。
         */
        private Integer status;

        /**
         * 模板 ID。
         */
        private String templateId;

        /**
         * 模板可发运营商标识：1 移动 2 联通 3 电信。
         */
        private List<String> operator;

        /**
         * 审核驳回原因。
         */
        private String rejectReason;

        /**
         * 模板有效性：0 失效 1 有效。
         */
        private String expireFlag;

        /**
         * 动参或非动参标识：0 非动参 1 动参。
         */
        private String isDynamic;

        public Data setStatusName(String statusName) {
            this.statusName = statusName;
            return this;
        }

        public Data setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Data setTemplateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Data setOperator(List<String> operator) {
            this.operator = operator;
            return this;
        }

        public Data setRejectReason(String rejectReason) {
            this.rejectReason = rejectReason;
            return this;
        }

        public Data setExpireFlag(String expireFlag) {
            this.expireFlag = expireFlag;
            return this;
        }

        public Data setIsDynamic(String isDynamic) {
            this.isDynamic = isDynamic;
            return this;
        }

        public String getStatusName() {
            return this.statusName;
        }

        public Integer getStatus() {
            return this.status;
        }

        public String getTemplateId() {
            return this.templateId;
        }

        public List<String> getOperator() {
            return this.operator;
        }

        public String getRejectReason() {
            return this.rejectReason;
        }

        public String getExpireFlag() {
            return this.expireFlag;
        }

        public String getIsDynamic() {
            return this.isDynamic;
        }
    }

    public Data getData() {
        return this.data;
    }
}
