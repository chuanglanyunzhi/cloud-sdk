package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业司法涉诉查询返回开庭公告。
 */
public class JusticeComplainKtgg extends CloudSdkModel {

    /**
     * 立案时间。
     */
    private String sdate;

    /**
     * 案号。
     */
    private String caseno;

    /**
     * 标题。
     */
    private String title;

    /**
     * 法院名称。
     */
    private String court;

    /**
     * 当事人。
     */
    private String pname;

    /**
     * 角色（主题类型）。
     */
    private String ptype;

    /**
     * 案由。
     */
    private String causename;

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

    public String getSdate() {
        return this.sdate;
    }

    public String getCaseno() {
        return this.caseno;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCourt() {
        return this.court;
    }

    public String getPname() {
        return this.pname;
    }

    public String getPtype() {
        return this.ptype;
    }

    public String getCausename() {
        return this.causename;
    }
}
