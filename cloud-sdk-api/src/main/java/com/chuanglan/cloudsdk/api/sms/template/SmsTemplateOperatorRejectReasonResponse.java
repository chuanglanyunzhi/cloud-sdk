package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;
import com.chuanglan.cloudsdk.api.sms.SmsOperatorRejectReason;

import java.util.List;

/**
 * 查询模板运营商驳回原因响应。
 */
public class SmsTemplateOperatorRejectReasonResponse extends SmsCommonResponse {

    private List<SmsTemplateRejectReasonInfo> data;

    public SmsTemplateOperatorRejectReasonResponse setData(List<SmsTemplateRejectReasonInfo> data) {
        this.data = data;
        return this;
    }

    public static class SmsTemplateRejectReasonInfo extends SmsCommonResponse {
        private String templateCode;
        private List<SmsOperatorRejectReason> cmOperatorRejectReason;
        private List<SmsOperatorRejectReason> ctOperatorRejectReason;
        private List<SmsOperatorRejectReason> cuOperatorRejectReason;

        public String getTemplateCode() {
            return this.templateCode;
        }

        public List<SmsOperatorRejectReason> getCmOperatorRejectReason() {
            return this.cmOperatorRejectReason;
        }

        public List<SmsOperatorRejectReason> getCtOperatorRejectReason() {
            return this.ctOperatorRejectReason;
        }

        public List<SmsOperatorRejectReason> getCuOperatorRejectReason() {
            return this.cuOperatorRejectReason;
        }
    }

    public List<SmsTemplateRejectReasonInfo> getData() {
        return this.data;
    }
}
