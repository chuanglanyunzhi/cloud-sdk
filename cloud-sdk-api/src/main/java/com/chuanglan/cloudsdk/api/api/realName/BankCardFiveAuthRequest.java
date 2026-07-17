package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 银行卡五要素标准版核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankCardFiveAuthRequest extends CloudSdkModel {

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
     * 银行预留手机号。
     */
    public String mobile;

    public BankCardFiveAuthRequest setName(String name) {
        this.name = name;
        return this;
    }

    public BankCardFiveAuthRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public BankCardFiveAuthRequest setCardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public BankCardFiveAuthRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
}
