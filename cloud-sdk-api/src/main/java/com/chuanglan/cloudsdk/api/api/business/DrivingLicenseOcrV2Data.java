package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 驾驶证 OCR V2 返回数据。
 */
public class DrivingLicenseOcrV2Data extends CloudSdkModel {

    /**
     * 正页数据。
     */
    private DrivingLicenseOcrV2FrontData front;

    /**
     * 副页数据。
     */
    private DrivingLicenseOcrV2BackData back;

    public DrivingLicenseOcrV2Data setFront(DrivingLicenseOcrV2FrontData front) {
        this.front = front;
        return this;
    }

    public DrivingLicenseOcrV2Data setBack(DrivingLicenseOcrV2BackData back) {
        this.back = back;
        return this;
    }

    public DrivingLicenseOcrV2FrontData getFront() {
        return this.front;
    }

    public DrivingLicenseOcrV2BackData getBack() {
        return this.back;
    }
}
