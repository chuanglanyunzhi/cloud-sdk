package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 国际短信发送价格查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntSmsPriceRequest extends CloudSdkModel {

    /**
     * 短信产品类型，必填，例如 notify。
     */
    private String productType;

    /**
     * 国家码，可选；不传时查询当前产品类型下的全部国家价格。
     * 传入时需携带 00 前缀，如印度尼西亚为 0062。
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