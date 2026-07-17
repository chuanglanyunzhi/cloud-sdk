package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 手机号码归属地（升级版 V2）业务数据。
 */
public class NumberPhoneAttributionV2ResponseData extends CloudSdkModel {

    /**
     * 业务唯一订单号。
     */
    public String orderNo;

    /**
     * 查询时间，样例：2018-04-09 15:05:01。
     */
    public String handleTime;

    /**
     * 省份。
     */
    public String province;

    /**
     * 城市。
     */
    public String city;

    /**
     * 省份编码。
     */
    public String provinceCode;

    /**
     * 市区编码。
     */
    public String cityCode;

    /**
     * 手机号。
     */
    public String mobile;

    /**
     * 邮编。
     */
    public String postCode;

    /**
     * 原来运营商。
     */
    public String originalIsp;

    /**
     * 现在运营商。
     */
    public String latestIsp;

    public NumberPhoneAttributionV2ResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public NumberPhoneAttributionV2ResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public NumberPhoneAttributionV2ResponseData setProvince(String province) {
        this.province = province;
        return this;
    }

    public NumberPhoneAttributionV2ResponseData setCity(String city) {
        this.city = city;
        return this;
    }

    public NumberPhoneAttributionV2ResponseData setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
        return this;
    }

    public NumberPhoneAttributionV2ResponseData setCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public NumberPhoneAttributionV2ResponseData setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public NumberPhoneAttributionV2ResponseData setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public NumberPhoneAttributionV2ResponseData setOriginalIsp(String originalIsp) {
        this.originalIsp = originalIsp;
        return this;
    }

    public NumberPhoneAttributionV2ResponseData setLatestIsp(String latestIsp) {
        this.latestIsp = latestIsp;
        return this;
    }
}
