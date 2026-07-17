package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 银行卡三要素多证件版核验响应数据。
 */
public class BankCardThreeAuthTypeResponseData extends CloudSdkModel {

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
     * 认证结果：01 一致（收费），02 不一致（收费），03 认证不确定（不收费），04 认证失败（不收费）。
     */
    public String result;

    /**
     * result 具体解释：0101-认证一致，0201-不一致认证未通过，0202-不一致此卡已过期/卡号无效/卡状态异常，
     * 0205-不一致持卡人信息有误或卡状态异常，0301-认证不确定，0401-认证失败，
     * 0403-认证失败当前提交数量过多请降低提交频率，0404-认证失败详情请咨询您的发卡行。
     */
    public String innerresult;

    public BankCardThreeAuthTypeResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public BankCardThreeAuthTypeResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public BankCardThreeAuthTypeResponseData setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public BankCardThreeAuthTypeResponseData setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public BankCardThreeAuthTypeResponseData setCardCategory(String cardCategory) {
        this.cardCategory = cardCategory;
        return this;
    }

    public BankCardThreeAuthTypeResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public BankCardThreeAuthTypeResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public BankCardThreeAuthTypeResponseData setInnerresult(String innerresult) {
        this.innerresult = innerresult;
        return this;
    }
}
