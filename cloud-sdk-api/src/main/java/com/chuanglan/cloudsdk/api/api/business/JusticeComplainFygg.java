package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业司法涉诉查询返回法院公告。
 */
public class JusticeComplainFygg extends CloudSdkModel {

    /**
     * 公告日期。
     */
    public String sdate;

    /**
     * 公告标题。
     */
    public String title;

    /**
     * 当事人。
     */
    public String pname;

    /**
     * 公告类型。
     */
    public String gtype;

    /**
     * 法院名称。
     */
    public String court;

    public JusticeComplainFygg setSdate(String sdate) {
        this.sdate = sdate;
        return this;
    }

    public JusticeComplainFygg setTitle(String title) {
        this.title = title;
        return this;
    }

    public JusticeComplainFygg setPname(String pname) {
        this.pname = pname;
        return this;
    }

    public JusticeComplainFygg setGtype(String gtype) {
        this.gtype = gtype;
        return this;
    }

    public JusticeComplainFygg setCourt(String court) {
        this.court = court;
        return this;
    }
}
