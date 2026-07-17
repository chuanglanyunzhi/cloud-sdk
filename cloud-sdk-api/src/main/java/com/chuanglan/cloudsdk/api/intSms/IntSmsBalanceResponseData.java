package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信账户余额查询响应数据。
 */
public class IntSmsBalanceResponseData extends CloudSdkModel {

    /**
     * 账号。
     */
    public String account;

    /**
     * 账号余额。
     */
    public Double balance;

    public IntSmsBalanceResponseData setAccount(String account) {
        this.account = account;
        return this;
    }

    public IntSmsBalanceResponseData setBalance(Double balance) {
        this.balance = balance;
        return this;
    }
}
