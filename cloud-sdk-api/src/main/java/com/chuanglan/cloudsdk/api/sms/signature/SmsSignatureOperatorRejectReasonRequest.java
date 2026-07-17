package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 查询签名运营商驳回原因请求。
 */
public class SmsSignatureOperatorRejectReasonRequest extends CloudSdkModel {

    /** 产品类型。 */
    public String productType;
    /** 签名ID列表。 */
    public List<String> signIds;

    public SmsSignatureOperatorRejectReasonRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsSignatureOperatorRejectReasonRequest setSignIds(List<String> signIds) {
        this.signIds = signIds;
        return this;
    }
}
