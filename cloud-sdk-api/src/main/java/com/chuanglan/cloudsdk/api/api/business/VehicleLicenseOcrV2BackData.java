package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 行驶证 OCR V2 副页数据。
 */
public class VehicleLicenseOcrV2BackData extends CloudSdkModel {

    /**
     * 号牌号码。
     */
    private String plateNo;

    /**
     * 核定载人数。
     */
    private String approvedPassenger;

    /**
     * 总质量。
     */
    private String grossMass;

    /**
     * 整备质量。
     */
    private String unladenMass;

    /**
     * 核定载质量。
     */
    private String approvedLoad;

    /**
     * 外廓尺寸。
     */
    private String overallDimension;

    /**
     * 准牵引总质量。
     */
    private String tractionMass;

    /**
     * 检验记录。
     */
    private String inspectionRecord;

    /**
     * 燃油类型。
     */
    private String energyType;

    /**
     * 档案编号。
     */
    private String fileNumber;

    public VehicleLicenseOcrV2BackData setPlateNo(String plateNo) {
        this.plateNo = plateNo;
        return this;
    }

    public VehicleLicenseOcrV2BackData setApprovedPassenger(String approvedPassenger) {
        this.approvedPassenger = approvedPassenger;
        return this;
    }

    public VehicleLicenseOcrV2BackData setGrossMass(String grossMass) {
        this.grossMass = grossMass;
        return this;
    }

    public VehicleLicenseOcrV2BackData setUnladenMass(String unladenMass) {
        this.unladenMass = unladenMass;
        return this;
    }

    public VehicleLicenseOcrV2BackData setApprovedLoad(String approvedLoad) {
        this.approvedLoad = approvedLoad;
        return this;
    }

    public VehicleLicenseOcrV2BackData setOverallDimension(String overallDimension) {
        this.overallDimension = overallDimension;
        return this;
    }

    public VehicleLicenseOcrV2BackData setTractionMass(String tractionMass) {
        this.tractionMass = tractionMass;
        return this;
    }

    public VehicleLicenseOcrV2BackData setInspectionRecord(String inspectionRecord) {
        this.inspectionRecord = inspectionRecord;
        return this;
    }

    public VehicleLicenseOcrV2BackData setEnergyType(String energyType) {
        this.energyType = energyType;
        return this;
    }

    public VehicleLicenseOcrV2BackData setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
        return this;
    }

    public String getPlateNo() {
        return this.plateNo;
    }

    public String getApprovedPassenger() {
        return this.approvedPassenger;
    }

    public String getGrossMass() {
        return this.grossMass;
    }

    public String getUnladenMass() {
        return this.unladenMass;
    }

    public String getApprovedLoad() {
        return this.approvedLoad;
    }

    public String getOverallDimension() {
        return this.overallDimension;
    }

    public String getTractionMass() {
        return this.tractionMass;
    }

    public String getInspectionRecord() {
        return this.inspectionRecord;
    }

    public String getEnergyType() {
        return this.energyType;
    }

    public String getFileNumber() {
        return this.fileNumber;
    }
}
