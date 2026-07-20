package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 银行卡三要素精准版非身份证核验响应数据。
 */
public class BankCardThreeAuthPrecisionResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    private String orderNo;

    /**
     * 查询时间。
     */
    private String handleTime;

    /**
     * 银行卡所属银行。
     */
    private String bankName;

    /**
     * 银行卡类型。
     */
    private String cardType;

    /**
     * 银行卡类别。
     */
    private String cardCategory;

    /**
     * 备注。
     */
    private String remark;

    /**
     * 认证结果：01 一致（收费），02 不一致（收费），03 不确定（不收费），
     * 04 失败（不收费），05 手机号码不匹配（收费），06 身份证号码不匹配（收费），
     * 07 姓名不匹配（收费）。
     */
    private String result;

    /**
     * result 具体解释。
     */
    private String innerresult;

    public BankCardThreeAuthPrecisionResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public BankCardThreeAuthPrecisionResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public BankCardThreeAuthPrecisionResponseData setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public BankCardThreeAuthPrecisionResponseData setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public BankCardThreeAuthPrecisionResponseData setCardCategory(String cardCategory) {
        this.cardCategory = cardCategory;
        return this;
    }

    public BankCardThreeAuthPrecisionResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public BankCardThreeAuthPrecisionResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public BankCardThreeAuthPrecisionResponseData setInnerresult(String innerresult) {
        this.innerresult = innerresult;
        return this;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getHandleTime() {
        return this.handleTime;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getCardCategory() {
        return this.cardCategory;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getResult() {
        return this.result;
    }

    public String getInnerresult() {
        return this.innerresult;
    }
}
