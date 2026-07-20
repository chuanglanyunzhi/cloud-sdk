package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 行驶证 OCR V2 正页数据。
 */
public class VehicleLicenseOcrV2FrontData extends CloudSdkModel {

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
     * 号牌号码。
     */
    private String plateNo;

    public VehicleLicenseOcrV2FrontData setBrandModel(String brandModel) {
        this.brandModel = brandModel;
        return this;
    }

    public VehicleLicenseOcrV2FrontData setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
        return this;
    }

    public VehicleLicenseOcrV2FrontData setUsingProperties(String usingProperties) {
        this.usingProperties = usingProperties;
        return this;
    }

    public VehicleLicenseOcrV2FrontData setEngineNo(String engineNo) {
        this.engineNo = engineNo;
        return this;
    }

    public VehicleLicenseOcrV2FrontData setPossessor(String possessor) {
        this.possessor = possessor;
        return this;
    }

    public VehicleLicenseOcrV2FrontData setAddress(String address) {
        this.address = address;
        return this;
    }

    public VehicleLicenseOcrV2FrontData setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public VehicleLicenseOcrV2FrontData setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public VehicleLicenseOcrV2FrontData setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public VehicleLicenseOcrV2FrontData setPlateNo(String plateNo) {
        this.plateNo = plateNo;
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

    public String getPlateNo() {
        return this.plateNo;
    }
}
