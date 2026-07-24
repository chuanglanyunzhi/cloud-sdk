package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信账户余额查询请求。
 */
public class IntSmsBalanceRequest extends CloudSdkModel {

    /**
     * 短信类型：notify（验证码）、market（营销/通知）。
     */
    private String productType;

    public IntSmsBalanceRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }
}
