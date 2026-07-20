package com.chuanglan.cloudsdk.api.sms.signature;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 签名列表请求。
 */
public class SmsSignatureListRequest extends CloudSdkModel {

    /** 产品类型。 */
    private String productType;
    /** 页码。 */
    private Integer pageNo;
    /** 每页条数。 */
    private Integer pageSize;
    /** 签名名称。 */
    private String signName;
    /** 签名状态。 */
    private String signaturestatus;

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

    public String getProductType() {
        return this.productType;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public String getSignName() {
        return this.signName;
    }

    public String getSignaturestatus() {
        return this.signaturestatus;
    }
}
