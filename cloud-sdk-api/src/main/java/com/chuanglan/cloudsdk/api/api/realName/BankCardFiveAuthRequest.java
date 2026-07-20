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
    private String name;

    /**
     * 身份证号码。
     */
    private String idNum;

    /**
     * 银行卡号。
     */
    private String cardNo;

    /**
     * 银行预留手机号。
     */
    private String mobile;

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

    public String getName() {
        return this.name;
    }

    public String getIdNum() {
        return this.idNum;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public String getMobile() {
        return this.mobile;
    }
}
