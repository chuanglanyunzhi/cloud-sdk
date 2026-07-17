package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 银行卡五要素标准版核验响应数据。
 */
public class BankCardFiveAuthResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    public String orderNo;

    /**
     * 查询时间。
     */
    public String handleTime;

    /**
     * 银行卡所属银行。
     */
    public String bankName;

    /**
     * 银行卡类型。
     */
    public String cardType;

    /**
     * 银行卡类别。
     */
    public String cardCategory;

    /**
     * 备注。
     */
    public String remark;

    /**
     * 认证结果：01 认证信息匹配（收费），02 不匹配（收费），03 无法验证（收费），04 认证失败（不收费）。
     */
    public String result;

    /**
     * 银行账户类型：0 暂不支持，1 疑似 I 类，2 II 类，3 III 类，4 II 或 III 类，5 贷记卡，7 未知。
     */
    public String bankAccountType;

    public BankCardFiveAuthResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public BankCardFiveAuthResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public BankCardFiveAuthResponseData setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public BankCardFiveAuthResponseData setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public BankCardFiveAuthResponseData setCardCategory(String cardCategory) {
        this.cardCategory = cardCategory;
        return this;
    }

    public BankCardFiveAuthResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public BankCardFiveAuthResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public BankCardFiveAuthResponseData setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
        return this;
    }
}
