package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 归属地查询 V6 响应归属地详细信息。
 */
public class IpAddressOriginV6Location extends CloudSdkModel {

    /**
     * 查询的 IP。
     */
    public String ip;

    /**
     * 所属七大洲。
     */
    public String continent;

    /**
     * 国家。
     */
    public String country;

    /**
     * 国家英文简写。
     */
    public String country_code;

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
    public String district;

    /**
     * 街道。
     */
    public String street;

    /**
     * 行政区码。
     */
    public String area_code;

    /**
     * 城市代码（区号）。
     */
    public String city_code;

    /**
     * 邮编。
     */
    public String zip_code;

    /**
     * 经度。
     */
    public String longitude;

    /**
     * 纬度。
     */
    public String latitude;

    /**
     * 海拔。
     */
    public String elevation;

    /**
     * 时区。
     */
    public String time_zone;

    /**
     * 气象站。
     */
    public String weather_station;

    /**
     * 运营商。
     */
    public String isp;

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
}
