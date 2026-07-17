package com.chuanglan.cloudsdk.api.api.business;

/**
 * 车牌 OCR 识别响应。
 */
public class VehiclePlateOcrResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    public Integer chargeStatus;

    /**
     * 计费条数。
     */
    public Integer chargeCount;

    /**
     * 返回数据。
     */
    public VehiclePlateOcrData data;

    public VehiclePlateOcrResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public VehiclePlateOcrResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public VehiclePlateOcrResponse setData(VehiclePlateOcrData data) {
        this.data = data;
        return this;
    }
}
