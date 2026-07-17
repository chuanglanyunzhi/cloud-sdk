package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;
import com.chuanglan.cloudsdk.api.sms.SmsOperatorRejectReason;

import java.util.List;

/**
 * 查询签名运营商驳回原因响应。
 */
public class SmsSignatureOperatorRejectReasonResponse extends SmsCommonResponse {

    /** 签名运营商驳回原因列表。 */
    public List<SmsSignatureRejectReasonInfo> data;

    public SmsSignatureOperatorRejectReasonResponse setData(List<SmsSignatureRejectReasonInfo> data) {
        this.data = data;
        return this;
    }

    public static class SmsSignatureRejectReasonInfo extends SmsCommonResponse {
        /** 签名ID。 */
        public String signId;
        /** 移动运营商驳回原因列表。 */
        public List<SmsOperatorRejectReason> cmOperatorRejectReason;
        /** 电信运营商驳回原因列表。 */
        public List<SmsOperatorRejectReason> ctOperatorRejectReason;
        /** 联通运营商驳回原因列表。 */
        public List<SmsOperatorRejectReason> cuOperatorRejectReason;
    }
}
