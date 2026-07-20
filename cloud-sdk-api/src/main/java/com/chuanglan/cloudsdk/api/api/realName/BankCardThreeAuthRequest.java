package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 银行卡三要素标准版核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankCardThreeAuthRequest extends CloudSdkModel {

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

    public BankCardThreeAuthRequest setName(String name) {
        this.name = name;
        return this;
    }

    public BankCardThreeAuthRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public BankCardThreeAuthRequest setCardNo(String cardNo) {
        this.cardNo = cardNo;
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
}
