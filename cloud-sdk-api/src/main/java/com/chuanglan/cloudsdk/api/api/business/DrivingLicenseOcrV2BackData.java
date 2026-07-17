package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 驾驶证 OCR V2 副页数据。
 */
public class DrivingLicenseOcrV2BackData extends CloudSdkModel {

    /**
     * 档案编号。
     */
    public String fileNumber;

    /**
     * 姓名。
     */
    public String name;

    /**
     * 驾驶证号。
     */
    public String id;

    public DrivingLicenseOcrV2BackData setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
        return this;
    }

    public DrivingLicenseOcrV2BackData setName(String name) {
        this.name = name;
        return this;
    }

    public DrivingLicenseOcrV2BackData setId(String id) {
        this.id = id;
        return this;
    }
}
