package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 银行卡 OCR 识别数据。
 */
public class BankcardData extends CloudSdkModel {

    /**
     * 交易号，唯一。
     */
    private String tradeNo;

    /**
     * 银行卡账号。
     */
    private String cardNum;

    /**
     * 卡类型：0-未知银行；1-借记卡；2-信用卡；3-预付费卡。
     */
    private String cardType;

    /**
     * 银行卡名称（建设银行、招商银行等）。
     */
    private String cardName;

    /**
     * 有效期（格式：月/年）。
     */
    private String validDate;

    /**
     * 银行卡检测业务返回码，0 成功，其他失败。
     */
    private String code;

    /**
     * 银行卡检测业务返回码对应说明。
     */
    private String msg;

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

    public String getTradeNo() {
        return this.tradeNo;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getCardName() {
        return this.cardName;
    }

    public String getValidDate() {
        return this.validDate;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
