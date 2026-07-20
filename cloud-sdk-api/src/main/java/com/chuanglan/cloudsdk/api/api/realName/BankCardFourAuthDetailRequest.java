package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 银行卡四要素详细版核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankCardFourAuthDetailRequest extends CloudSdkModel {

    /**
     * 姓名。
     */
    private String name;

    /**
     * 身份证号码，限单个。
     */
    private String idNum;

    /**
     * 银行卡号，限单个。
     */
    private String cardNo;

    /**
     * 银行预留手机号，仅支持国内 11 位号码。
     */
    private String mobile;

    public BankCardFourAuthDetailRequest setName(String name) {
        this.name = name;
        return this;
    }

    public BankCardFourAuthDetailRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public BankCardFourAuthDetailRequest setCardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public BankCardFourAuthDetailRequest setMobile(String mobile) {
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
