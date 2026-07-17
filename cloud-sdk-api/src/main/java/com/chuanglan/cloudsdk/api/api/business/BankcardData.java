package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 银行卡 OCR 识别数据。
 */
public class BankcardData extends CloudSdkModel {

    /**
     * 交易号，唯一。
     */
    public String tradeNo;

    /**
     * 银行卡账号。
     */
    public String cardNum;

    /**
     * 卡类型：0-未知银行；1-借记卡；2-信用卡；3-预付费卡。
     */
    public String cardType;

    /**
     * 银行卡名称（建设银行、招商银行等）。
     */
    public String cardName;

    /**
     * 有效期（格式：月/年）。
     */
    public String validDate;

    /**
     * 银行卡检测业务返回码，0 成功，其他失败。
     */
    public String code;

    /**
     * 银行卡检测业务返回码对应说明。
     */
    public String msg;

    public BankcardData setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }

    public BankcardData setCardNum(String cardNum) {
        this.cardNum = cardNum;
        return this;
    }

    public BankcardData setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public BankcardData setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public BankcardData setValidDate(String validDate) {
        this.validDate = validDate;
        return this;
    }

    public BankcardData setCode(String code) {
        this.code = code;
        return this;
    }

    public BankcardData setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
