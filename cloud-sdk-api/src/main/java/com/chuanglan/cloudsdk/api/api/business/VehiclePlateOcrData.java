package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 车牌 OCR 识别数据。
 */
public class VehiclePlateOcrData extends CloudSdkModel {

    /**
     * 认证结果。
     */
    private java.util.List<VehiclePlateResult> result;

    public VehiclePlateOcrData setResult(java.util.List<VehiclePlateResult> result) {
        this.result = result;
        return this;
    }

    /**
     * 车牌结果。
     */
    public static class VehiclePlateResult extends CloudSdkModel {

        /**
         * 车牌颜色，支持 blue、yellow、green、white、black。
         */
        private String color;

        /**
         * 车牌号。
         */
        private String number;

        public VehiclePlateResult setColor(String color) {
            this.color = color;
            return this;
        }

        public VehiclePlateResult setNumber(String number) {
            this.number = number;
            return this;
        }

        public String getColor() {
            return this.color;
        }

        public String getNumber() {
            return this.number;
        }
    }

    public java.util.List<VehiclePlateResult> getResult() {
        return this.result;
    }
}
