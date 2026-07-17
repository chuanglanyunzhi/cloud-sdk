package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业司法涉诉查询返回开庭公告。
 */
public class JusticeComplainKtgg extends CloudSdkModel {

    /**
     * 立案时间。
     */
    public String sdate;

    /**
     * 案号。
     */
    public String caseno;

    /**
     * 标题。
     */
    public String title;

    /**
     * 法院名称。
     */
    public String court;

    /**
     * 当事人。
     */
    public String pname;

    /**
     * 角色（主题类型）。
     */
    public String ptype;

    /**
     * 案由。
     */
    public String causename;

    public JusticeComplainKtgg setSdate(String sdate) {
        this.sdate = sdate;
        return this;
    }

    public JusticeComplainKtgg setCaseno(String caseno) {
        this.caseno = caseno;
        return this;
    }

    public JusticeComplainKtgg setTitle(String title) {
        this.title = title;
        return this;
    }

    public JusticeComplainKtgg setCourt(String court) {
        this.court = court;
        return this;
    }

    public JusticeComplainKtgg setPname(String pname) {
        this.pname = pname;
        return this;
    }

    public JusticeComplainKtgg setPtype(String ptype) {
        this.ptype = ptype;
        return this;
    }

    public JusticeComplainKtgg setCausename(String causename) {
        this.causename = causename;
        return this;
    }
}
