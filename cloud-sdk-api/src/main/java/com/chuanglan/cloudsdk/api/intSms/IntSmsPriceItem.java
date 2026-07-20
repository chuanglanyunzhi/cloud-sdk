package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import java.util.List;

/**
 * 国际短信国家单价数据。
 */
public class IntSmsPriceItem extends CloudSdkModel {

    /**
     * 国家中文名称。
     */
    private String countryName;

    /**
     * 标准国家码。
     */
    private String countryCode;

    /**
     * 结算币种。
     */
    private String settleCurrency;

    /**
     * 统一结算单价。
     */
    private Double settleUnitPrice;

    /**
     * 细分运营商价格明细。
     */
    private List<IntSmsPriceCarrierItem> accountSendPricelist;

    public IntSmsPriceItem setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public IntSmsPriceItem setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public IntSmsPriceItem setSettleCurrency(String settleCurrency) {
        this.settleCurrency = settleCurrency;
        return this;
    }

    public IntSmsPriceItem setSettleUnitPrice(Double settleUnitPrice) {
        this.settleUnitPrice = settleUnitPrice;
        return this;
    }

    public IntSmsPriceItem setAccountSendPricelist(List<IntSmsPriceCarrierItem> accountSendPricelist) {
        this.accountSendPricelist = accountSendPricelist;
        return this;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getSettleCurrency() {
        return this.settleCurrency;
    }

    public Double getSettleUnitPrice() {
        return this.settleUnitPrice;
    }

    public List<IntSmsPriceCarrierItem> getAccountSendPricelist() {
        return this.accountSendPricelist;
    }
}
