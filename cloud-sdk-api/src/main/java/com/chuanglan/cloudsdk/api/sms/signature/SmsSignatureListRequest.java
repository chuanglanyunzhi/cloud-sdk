package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 签名列表请求。
 */
public class SmsSignatureListRequest extends CloudSdkModel {

    /** 产品类型。 */
    public String productType;
    /** 页码。 */
    public Integer pageNo;
    /** 每页条数。 */
    public Integer pageSize;
    /** 签名名称。 */
    public String signName;
    /** 签名状态。 */
    public String signaturestatus;

    public SmsSignatureListRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsSignatureListRequest setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public SmsSignatureListRequest setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public SmsSignatureListRequest setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    public SmsSignatureListRequest setSignaturestatus(String signaturestatus) {
        this.signaturestatus = signaturestatus;
        return this;
    }
}
