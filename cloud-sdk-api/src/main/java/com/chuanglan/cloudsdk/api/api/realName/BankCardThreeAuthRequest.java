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
    public String name;

    /**
     * 身份证号码，限单个。
     */
    public String idNum;

    /**
     * 银行卡号，限单个。
     */
    public String cardNo;

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
}
