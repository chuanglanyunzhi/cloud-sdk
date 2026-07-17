package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业工商信息查询（简项）股东信息。
 */
public class EnterpriseSimpleShareholder extends CloudSdkModel {

    /**
     * 股东名称。
     */
    public String shareholder_name;

    /**
     * 认缴出资额。
     */
    public String subscrib_amt;

    /**
     * 认缴出资方式。
     */
    public String subscrib_form;

    /**
     * 认缴出资日期。
     */
    public String subscrib_date;

    /**
     * 实缴出资额。
     */
    public String actual_amt;

    /**
     * 实缴出资方式。
     */
    public String actual_form;

    /**
     * 实缴出资日期。
     */
    public String actual_date;

    public EnterpriseSimpleShareholder setShareholder_name(String shareholder_name) {
        this.shareholder_name = shareholder_name;
        return this;
    }

    public EnterpriseSimpleShareholder setSubscrib_amt(String subscrib_amt) {
        this.subscrib_amt = subscrib_amt;
        return this;
    }

    public EnterpriseSimpleShareholder setSubscrib_form(String subscrib_form) {
        this.subscrib_form = subscrib_form;
        return this;
    }

    public EnterpriseSimpleShareholder setSubscrib_date(String subscrib_date) {
        this.subscrib_date = subscrib_date;
        return this;
    }

    public EnterpriseSimpleShareholder setActual_amt(String actual_amt) {
        this.actual_amt = actual_amt;
        return this;
    }

    public EnterpriseSimpleShareholder setActual_form(String actual_form) {
        this.actual_form = actual_form;
        return this;
    }

    public EnterpriseSimpleShareholder setActual_date(String actual_date) {
        this.actual_date = actual_date;
        return this;
    }
}
