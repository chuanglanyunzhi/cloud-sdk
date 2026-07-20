package com.chuanglan.cloudsdk.api.api.business;

/**
 * 车牌 OCR 识别响应。
 */
public class VehiclePlateOcrResponse extends BusinessCommonResponse {

    /**
     * 是否收费：1 收费，0 不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private Integer chargeCount;

    /**
     * 返回数据。
     */
    private VehiclePlateOcrData data;

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

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public VehiclePlateOcrData getData() {
        return this.data;
    }
}
