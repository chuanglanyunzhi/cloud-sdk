package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 删除签名请求。
 */
public class SmsSignatureDeleteRequest extends CloudSdkModel {

    /** 产品类型。 */
    public String productType;
    /** 签名ID。 */
    public String signId;

    public SmsSignatureDeleteRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsSignatureDeleteRequest setSignId(String signId) {
        this.signId = signId;
        return this;
    }
}
