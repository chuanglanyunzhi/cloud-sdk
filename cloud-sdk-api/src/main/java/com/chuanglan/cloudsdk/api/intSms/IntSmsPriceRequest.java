package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信发送价格查询请求。
 */
public class IntSmsPriceRequest extends CloudSdkModel {

    /**
     * 国家码，固定携带 00 前缀，如 0086。不传默认返回全国家价格数据。
     */
    public String countryCode;

    public IntSmsPriceRequest setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }
}
