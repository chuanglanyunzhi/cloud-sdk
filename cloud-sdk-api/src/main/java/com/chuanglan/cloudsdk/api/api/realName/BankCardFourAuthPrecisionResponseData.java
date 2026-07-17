package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 银行卡四要素精准版非身份证核验响应数据。
 */
public class BankCardFourAuthPrecisionResponseData extends CloudSdkModel {

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
     * 认证结果：01 一致（收费），02 不一致（收费），03 认证不确定（不收费），
     * 04 认证失败（不收费），05 手机号码不匹配（收费），06 身份证号码不匹配（收费），
     * 07 姓名不匹配（收费）。
     */
    public String result;

    /**
     * result 具体解释。
     */
    public String innerresult;

    public BankCardFourAuthPrecisionResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public BankCardFourAuthPrecisionResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public BankCardFourAuthPrecisionResponseData setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public BankCardFourAuthPrecisionResponseData setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public BankCardFourAuthPrecisionResponseData setCardCategory(String cardCategory) {
        this.cardCategory = cardCategory;
        return this;
    }

    public BankCardFourAuthPrecisionResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public BankCardFourAuthPrecisionResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public BankCardFourAuthPrecisionResponseData setInnerresult(String innerresult) {
        this.innerresult = innerresult;
        return this;
    }
}
