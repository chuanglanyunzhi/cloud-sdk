package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 行驶证 OCR V2 返回数据。
 */
public class VehicleLicenseOcrV2Data extends CloudSdkModel {

    /**
     * 正页数据。
     */
    public VehicleLicenseOcrV2FrontData front;

    /**
     * 副页数据。
     */
    public VehicleLicenseOcrV2BackData back;

    public VehicleLicenseOcrV2Data setFront(VehicleLicenseOcrV2FrontData front) {
        this.front = front;
        return this;
    }

    public VehicleLicenseOcrV2Data setBack(VehicleLicenseOcrV2BackData back) {
        this.back = back;
        return this;
    }
}
