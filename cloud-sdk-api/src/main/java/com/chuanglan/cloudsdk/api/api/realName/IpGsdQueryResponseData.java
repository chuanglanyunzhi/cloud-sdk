package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 归属地查询响应数据。
 */
public class IpGsdQueryResponseData extends CloudSdkModel {

    /**
     * 结果，01 表示成功。
     */
    public String result;

    /**
     * 业务流水号。
     */
    public String orderNo;

    /**
     * 处理时间。
     */
    public String handleTime;

    /**
     * 查询的 IP 地址。
     */
    public String ipAddr;

    /**
     * 国家。
     */
    public String country;

    /**
     * 省份。
     */
    public String province;

    /**
     * 城市。
     */
    public String city;

    /**
     * 区县。
     */
    public String area;

    /**
     * 运营商线路。
     */
    public String line;

    public IpGsdQueryResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public IpGsdQueryResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public IpGsdQueryResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public IpGsdQueryResponseData setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
        return this;
    }

    public IpGsdQueryResponseData setCountry(String country) {
        this.country = country;
        return this;
    }

    public IpGsdQueryResponseData setProvince(String province) {
        this.province = province;
        return this;
    }

    public IpGsdQueryResponseData setCity(String city) {
        this.city = city;
        return this;
    }

    public IpGsdQueryResponseData setArea(String area) {
        this.area = area;
        return this;
    }

    public IpGsdQueryResponseData setLine(String line) {
        this.line = line;
        return this;
    }
}
