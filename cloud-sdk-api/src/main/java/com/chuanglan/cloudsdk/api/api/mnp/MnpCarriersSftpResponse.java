package com.chuanglan.cloudsdk.api.api.mnp;

/**
 * 携号转网 V1 查询响应。
 */
public class MnpCarriersSftpResponse extends MnpCommonResponse {

    /**
     * 1：收费；0：不收费。
     */
    private Integer chargeStatus;

    /**
     * 计费条数。
     */
    private Integer chargeCount;

    /**
     * 业务数据。
     */
    private MnpCarriersSftpResponseData data;

    public MnpCarriersSftpResponse setChargeStatus(Integer chargeStatus) {
        this.chargeStatus = chargeStatus;
        return this;
    }

    public MnpCarriersSftpResponse setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
        return this;
    }

    public MnpCarriersSftpResponse setData(MnpCarriersSftpResponseData data) {
        this.data = data;
        return this;
    }

    public Integer getChargeStatus() {
        return this.chargeStatus;
    }

    public Integer getChargeCount() {
        return this.chargeCount;
    }

    public MnpCarriersSftpResponseData getData() {
        return this.data;
    }
}
