package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 银行卡四要素简版加密核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankCardFourSecretRequest extends CloudSdkModel {

    /**
     * 姓名。
     */
    public String name;

    /**
     * 身份证号码。
     */
    public String idNum;

    /**
     * 银行卡号。
     */
    public String cardNo;

    /**
     * 手机号。
     */
    public String mobile;

    public BankCardFourSecretRequest setName(String name) {
        this.name = name;
        return this;
    }

    public BankCardFourSecretRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public BankCardFourSecretRequest setCardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public BankCardFourSecretRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
}
