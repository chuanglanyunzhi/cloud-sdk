package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 签名详情请求。
 */
public class SmsSignatureGetRequest extends CloudSdkModel {

    /** 产品类型。 */
    public String productType;
    /** 签名ID。 */
    public String signId;

    public SmsSignatureGetRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsSignatureGetRequest setSignId(String signId) {
        this.signId = signId;
        return this;
    }
}
