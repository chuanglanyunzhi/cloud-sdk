package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信细分运营商价格明细。
 */
public class IntSmsPriceCarrierItem extends CloudSdkModel {

    /**
     * 国家码。
     */
    private String countryCode;

    /**
     * 运营商名称。
     */
    private String carrier;

    /**
     * 对应运营商单价。
     */
    private Double settleUnitPrice;

    /**
     * 计价币种。
     */
    private String settleCurrency;

    public IntSmsPriceCarrierItem setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public IntSmsPriceCarrierItem setCarrier(String carrier) {
        this.carrier = carrier;
        return this;
    }

    public IntSmsPriceCarrierItem setSettleUnitPrice(Double settleUnitPrice) {
        this.settleUnitPrice = settleUnitPrice;
        return this;
    }

    public IntSmsPriceCarrierItem setSettleCurrency(String settleCurrency) {
        this.settleCurrency = settleCurrency;
        return this;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public Double getSettleUnitPrice() {
        return this.settleUnitPrice;
    }

    public String getSettleCurrency() {
        return this.settleCurrency;
    }
}
