package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 归属地查询 V6 响应归属地详细信息。
 */
public class IpAddressOriginV6Location extends CloudSdkModel {

    /**
     * 查询的 IP。
     */
    private String ip;

    /**
     * 所属七大洲。
     */
    private String continent;

    /**
     * 国家。
     */
    private String country;

    /**
     * 国家英文简写。
     */
    private String country_code;

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
    private String district;

    /**
     * 街道。
     */
    private String street;

    /**
     * 行政区码。
     */
    private String area_code;

    /**
     * 城市代码（区号）。
     */
    private String city_code;

    /**
     * 邮编。
     */
    private String zip_code;

    /**
     * 经度。
     */
    private String longitude;

    /**
     * 纬度。
     */
    private String latitude;

    /**
     * 海拔。
     */
    private String elevation;

    /**
     * 时区。
     */
    private String time_zone;

    /**
     * 气象站。
     */
    private String weather_station;

    /**
     * 运营商。
     */
    private String isp;

    public IpAddressOriginV6Location setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public IpAddressOriginV6Location setContinent(String continent) {
        this.continent = continent;
        return this;
    }

    public IpAddressOriginV6Location setCountry(String country) {
        this.country = country;
        return this;
    }

    public IpAddressOriginV6Location setCountry_code(String country_code) {
        this.country_code = country_code;
        return this;
    }

    public IpAddressOriginV6Location setProvince(String province) {
        this.province = province;
        return this;
    }

    public IpAddressOriginV6Location setCity(String city) {
        this.city = city;
        return this;
    }

    public IpAddressOriginV6Location setDistrict(String district) {
        this.district = district;
        return this;
    }

    public IpAddressOriginV6Location setStreet(String street) {
        this.street = street;
        return this;
    }

    public IpAddressOriginV6Location setArea_code(String area_code) {
        this.area_code = area_code;
        return this;
    }

    public IpAddressOriginV6Location setCity_code(String city_code) {
        this.city_code = city_code;
        return this;
    }

    public IpAddressOriginV6Location setZip_code(String zip_code) {
        this.zip_code = zip_code;
        return this;
    }

    public IpAddressOriginV6Location setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public IpAddressOriginV6Location setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public IpAddressOriginV6Location setElevation(String elevation) {
        this.elevation = elevation;
        return this;
    }

    public IpAddressOriginV6Location setTime_zone(String time_zone) {
        this.time_zone = time_zone;
        return this;
    }

    public IpAddressOriginV6Location setWeather_station(String weather_station) {
        this.weather_station = weather_station;
        return this;
    }

    public IpAddressOriginV6Location setIsp(String isp) {
        this.isp = isp;
        return this;
    }

    public String getIp() {
        return this.ip;
    }

    public String getContinent() {
        return this.continent;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountry_code() {
        return this.country_code;
    }

    public String getProvince() {
        return this.province;
    }

    public String getCity() {
        return this.city;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getStreet() {
        return this.street;
    }

    public String getArea_code() {
        return this.area_code;
    }

    public String getCity_code() {
        return this.city_code;
    }

    public String getZip_code() {
        return this.zip_code;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getElevation() {
        return this.elevation;
    }

    public String getTime_zone() {
        return this.time_zone;
    }

    public String getWeather_station() {
        return this.weather_station;
    }

    public String getIsp() {
        return this.isp;
    }
}
