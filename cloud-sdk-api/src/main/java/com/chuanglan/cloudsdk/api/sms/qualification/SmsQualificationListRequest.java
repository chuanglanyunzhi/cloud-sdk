package com.chuanglan.cloudsdk.api.sms.qualification;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 资质列表请求。
 */
public class SmsQualificationListRequest extends CloudSdkModel {

    /** 产品类型。 */
    public String productType;
    /** 企业名称。 */
    public String companyName;
    /** 终端类型。 */
    public String endType;
    /** 页码。 */
    public Integer pageNo;
    /** 每页条数。 */
    public Integer pageSize;

    public SmsQualificationListRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsQualificationListRequest setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public SmsQualificationListRequest setEndType(String endType) {
        this.endType = endType;
        return this;
    }

    public SmsQualificationListRequest setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public SmsQualificationListRequest setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
