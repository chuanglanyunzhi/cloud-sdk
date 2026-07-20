package com.chuanglan.cloudsdk.api.sms.qualification;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 删除资质请求。
 */
public class SmsQualificationDeleteRequest extends CloudSdkModel {

    /** 产品类型。 */
    private String productType;
    /** 终端客户ID。 */
    private String endCustomerId;

    public SmsQualificationDeleteRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsQualificationDeleteRequest setEndCustomerId(String endCustomerId) {
        this.endCustomerId = endCustomerId;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getEndCustomerId() {
        return this.endCustomerId;
    }
}
