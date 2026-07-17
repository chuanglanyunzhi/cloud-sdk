package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 行驶证 OCR V2 副页数据。
 */
public class VehicleLicenseOcrV2BackData extends CloudSdkModel {

    /**
     * 号牌号码。
     */
    public String plateNo;

    /**
     * 核定载人数。
     */
    public String approvedPassenger;

    /**
     * 总质量。
     */
    public String grossMass;

    /**
     * 整备质量。
     */
    public String unladenMass;

    /**
     * 核定载质量。
     */
    public String approvedLoad;

    /**
     * 外廓尺寸。
     */
    public String overallDimension;

    /**
     * 准牵引总质量。
     */
    public String tractionMass;

    /**
     * 检验记录。
     */
    public String inspectionRecord;

    /**
     * 燃油类型。
     */
    public String energyType;

    /**
     * 档案编号。
     */
    public String fileNumber;

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
}
