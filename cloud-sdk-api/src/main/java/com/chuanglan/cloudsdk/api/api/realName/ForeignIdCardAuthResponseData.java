package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 涉外身份证校验响应数据。
 */
public class ForeignIdCardAuthResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    public String orderNo;

    /**
     * 处理时间。
     */
    public String handleTime;

    /**
     * 返回结果码：01 一致（收费），02 不一致（收费），03 认证不确定（不收费），04 认证失败（不收费）。
     */
    public String result;

    /**
     * 返回结果说明。
     */
    public String remark;

    /**
     * 证件是否有效：0 证件无效，1 证件有效，2 无法确认。
     */
    public String isValid;

    public ForeignIdCardAuthResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public ForeignIdCardAuthResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public ForeignIdCardAuthResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public ForeignIdCardAuthResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public ForeignIdCardAuthResponseData setIsValid(String isValid) {
        this.isValid = isValid;
        return this;
    }
}
