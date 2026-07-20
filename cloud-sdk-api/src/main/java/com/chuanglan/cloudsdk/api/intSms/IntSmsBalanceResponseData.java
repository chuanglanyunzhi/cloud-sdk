package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信账户余额查询响应数据。
 */
public class IntSmsBalanceResponseData extends CloudSdkModel {

    /**
     * 账号。
     */
    private String account;

    /**
     * 账号余额。
     */
    private Double balance;

    public IntSmsBalanceResponseData setAccount(String account) {
        this.account = account;
        return this;
    }

    public IntSmsBalanceResponseData setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public String getAccount() {
        return this.account;
    }

    public Double getBalance() {
        return this.balance;
    }
}
