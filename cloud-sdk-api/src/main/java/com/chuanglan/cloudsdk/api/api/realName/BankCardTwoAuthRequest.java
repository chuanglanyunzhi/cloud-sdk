package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 银行卡二要素标准版核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankCardTwoAuthRequest extends CloudSdkModel {

    /**
     * 姓名。
     */
    private String name;

    /**
     * 银行卡号，限单个。
     */
    private String cardNo;

    public BankCardTwoAuthRequest setName(String name) {
        this.name = name;
        return this;
    }

    public BankCardTwoAuthRequest setCardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public String getCardNo() {
        return this.cardNo;
    }
}
