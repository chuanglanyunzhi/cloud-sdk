package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信发送价格查询请求。
 */
public class IntSmsPriceRequest extends CloudSdkModel {

    /**
     * 短信类型：notify（验证码）、market（营销/通知）。
     */
    private String productType;

    /**
     * 国家码，固定携带 00 前缀，如 0086。不传默认返回全国家价格数据。
     */
    private String countryCode;

    public IntSmsPriceRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public IntSmsPriceRequest setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getCountryCode() {
        return this.countryCode;
    }
}
