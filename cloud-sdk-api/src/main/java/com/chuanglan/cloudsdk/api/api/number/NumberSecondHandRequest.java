package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 二次号查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberSecondHandRequest extends CloudSdkModel {

    /**
     * 手机号。
     */
    public String mobile;

    /**
     * 回溯时间，格式 yyyyMMdd。
     */
    public String sinceDate;

    /**
     * 订单号（透传返回）。
     */
    public String orderNo;

    /**
     * 是否加密：默认不加密；1 表示 MD5 加密；2 表示 SHA256 加密。
     */
    public Integer type;

    public NumberSecondHandRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public NumberSecondHandRequest setSinceDate(String sinceDate) {
        this.sinceDate = sinceDate;
        return this;
    }

    public NumberSecondHandRequest setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public NumberSecondHandRequest setType(Integer type) {
        this.type = type;
        return this;
    }
}
