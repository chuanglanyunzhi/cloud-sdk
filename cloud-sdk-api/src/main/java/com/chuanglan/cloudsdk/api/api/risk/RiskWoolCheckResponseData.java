package com.chuanglan.cloudsdk.api.api.risk;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 羊毛党检测结果数据。
 */
public class RiskWoolCheckResponseData extends CloudSdkModel {

    /**
     * 交易号，唯一。
     */
    public String tradeNo;

    /**
     * 检测的手机号。
     */
    public String mobile;

    /**
     * 检测结果：W1 白名单；B1 黑名单；B2 可信用度低；N 库无。
     */
    public String status;

    /**
     * 检测分值，分值越高风险越高。W1:[0-60); B2:[60-90); B1:[90-100]。
     */
    public Double score;

    public RiskWoolCheckResponseData setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }

    public RiskWoolCheckResponseData setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public RiskWoolCheckResponseData setStatus(String status) {
        this.status = status;
        return this;
    }

    public RiskWoolCheckResponseData setScore(Double score) {
        this.score = score;
        return this;
    }
}
