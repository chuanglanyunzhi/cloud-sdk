package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 归属地查询响应数据。
 */
public class IpGsdQueryResponseData extends CloudSdkModel {

    /**
     * 结果，01 表示成功。
     */
    private String result;

    /**
     * 业务流水号。
     */
    private String orderNo;

    /**
     * 处理时间。
     */
    private String handleTime;

    /**
     * 查询的 IP 地址。
     */
    private String ipAddr;

    /**
     * 国家。
     */
    private String country;

    /**
     * 省份。
     */
    private String province;

    /**
     * 城市。
     */
    private String city;

    /**
     * 区县。
     */
    private String area;

    /**
     * 运营商线路。
     */
    private String line;

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

    public String getResult() {
        return this.result;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getHandleTime() {
        return this.handleTime;
    }

    public String getIpAddr() {
        return this.ipAddr;
    }

    public String getCountry() {
        return this.country;
    }

    public String getProvince() {
        return this.province;
    }

    public String getCity() {
        return this.city;
    }

    public String getArea() {
        return this.area;
    }

    public String getLine() {
        return this.line;
    }
}
