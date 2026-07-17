package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 查询余额请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsBalanceRequest extends CloudSdkModel {

    /**
     * 产品类型，视频短信固定填写相应产品类型。
     */
    public String productType;

    public RcsSmsBalanceRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }
}
