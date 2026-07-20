package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 行驶证 OCR 识别数据。
 */
public class VehicleLicenseData extends CloudSdkModel {

    /**
     * 品牌型号。
     */
    private String brandModel;

    /**
     * 发证日期。
     */
    private String openingDate;

    /**
     * 使用性质。
     */
    private String usingProperties;

    /**
     * 发动机号码。
     */
    private String engineNo;

    /**
     * 车牌号。
     */
    private String plateNo;

    /**
     * 所有人。
     */
    private String possessor;

    /**
     * 住址。
     */
    private String address;

    /**
     * 注册日期。
     */
    private String registrationDate;

    /**
     * 车辆识别代号。
     */
    private String vin;

    /**
     * 车辆类型。
     */
    private String vehicleType;

    /**
     * 行驶证检测业务返回码，0 成功，其他失败。
     */
    private String code;

    /**
     * 行驶证检测业务返回码对应说明。
     */
    private String msg;

    /**
     * 交易号，唯一。
     */
    private String tradeNo;

    public VehicleLicenseData setBrandModel(String brandModel) {
        this.brandModel = brandModel;
        return this;
    }

    public VehicleLicenseData setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
        return this;
    }

    public VehicleLicenseData setUsingProperties(String usingProperties) {
        this.usingProperties = usingProperties;
        return this;
    }

    public VehicleLicenseData setEngineNo(String engineNo) {
        this.engineNo = engineNo;
        return this;
    }

    public VehicleLicenseData setPlateNo(String plateNo) {
        this.plateNo = plateNo;
        return this;
    }

    public VehicleLicenseData setPossessor(String possessor) {
        this.possessor = possessor;
        return this;
    }

    public VehicleLicenseData setAddress(String address) {
        this.address = address;
        return this;
    }

    public VehicleLicenseData setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public VehicleLicenseData setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public VehicleLicenseData setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public VehicleLicenseData setCode(String code) {
        this.code = code;
        return this;
    }

    public VehicleLicenseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public VehicleLicenseData setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }

    public String getBrandModel() {
        return this.brandModel;
    }

    public String getOpeningDate() {
        return this.openingDate;
    }

    public String getUsingProperties() {
        return this.usingProperties;
    }

    public String getEngineNo() {
        return this.engineNo;
    }

    public String getPlateNo() {
        return this.plateNo;
    }

    public String getPossessor() {
        return this.possessor;
    }

    public String getAddress() {
        return this.address;
    }

    public String getRegistrationDate() {
        return this.registrationDate;
    }

    public String getVin() {
        return this.vin;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getTradeNo() {
        return this.tradeNo;
    }
}
