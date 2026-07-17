package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;
import com.chuanglan.cloudsdk.api.sms.SmsOperatorRejectReason;

import java.util.List;

/**
 * 查询模板运营商驳回原因响应。
 */
public class SmsTemplateOperatorRejectReasonResponse extends SmsCommonResponse {

    public List<SmsTemplateRejectReasonInfo> data;

    public SmsTemplateOperatorRejectReasonResponse setData(List<SmsTemplateRejectReasonInfo> data) {
        this.data = data;
        return this;
    }

    public static class SmsTemplateRejectReasonInfo extends SmsCommonResponse {
        public String templateCode;
        public List<SmsOperatorRejectReason> cmOperatorRejectReason;
        public List<SmsOperatorRejectReason> ctOperatorRejectReason;
        public List<SmsOperatorRejectReason> cuOperatorRejectReason;
    }
}
