package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业招投标信息查询（翻页）招投标基础信息。
 */
public class EnterpriseBiddingItem extends CloudSdkModel {

    /**
     * 招投标 id。
     */
    private String bid;

    /**
     * 标题。
     */
    private String title;

    /**
     * 项目编号。
     */
    private String pronum;

    /**
     * 招标编号。
     */
    private String bidnum;

    /**
     * 招标人。
     */
    private String tenderee;

    /**
     * 招标行业分类。
     */
    private String bidindsclass;

    /**
     * 项目所在地区。
     */
    private String region;

    /**
     * 涉及总金额（采购预算）。
     */
    private String totalamount;

    /**
     * 招标类型。
     */
    private String bidtype;

    /**
     * 招标方式。
     */
    private String bidmethod;

    /**
     * 公告日期。
     */
    private String pubdate;

    /**
     * 内容。
     */
    private String content;

    public EnterpriseBiddingItem setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public EnterpriseBiddingItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public EnterpriseBiddingItem setPronum(String pronum) {
        this.pronum = pronum;
        return this;
    }

    public EnterpriseBiddingItem setBidnum(String bidnum) {
        this.bidnum = bidnum;
        return this;
    }

    public EnterpriseBiddingItem setTenderee(String tenderee) {
        this.tenderee = tenderee;
        return this;
    }

    public EnterpriseBiddingItem setBidindsclass(String bidindsclass) {
        this.bidindsclass = bidindsclass;
        return this;
    }

    public EnterpriseBiddingItem setRegion(String region) {
        this.region = region;
        return this;
    }

    public EnterpriseBiddingItem setTotalamount(String totalamount) {
        this.totalamount = totalamount;
        return this;
    }

    public EnterpriseBiddingItem setBidtype(String bidtype) {
        this.bidtype = bidtype;
        return this;
    }

    public EnterpriseBiddingItem setBidmethod(String bidmethod) {
        this.bidmethod = bidmethod;
        return this;
    }

    public EnterpriseBiddingItem setPubdate(String pubdate) {
        this.pubdate = pubdate;
        return this;
    }

    public EnterpriseBiddingItem setContent(String content) {
        this.content = content;
        return this;
    }

    public String getBid() {
        return this.bid;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPronum() {
        return this.pronum;
    }

    public String getBidnum() {
        return this.bidnum;
    }

    public String getTenderee() {
        return this.tenderee;
    }

    public String getBidindsclass() {
        return this.bidindsclass;
    }

    public String getRegion() {
        return this.region;
    }

    public String getTotalamount() {
        return this.totalamount;
    }

    public String getBidtype() {
        return this.bidtype;
    }

    public String getBidmethod() {
        return this.bidmethod;
    }

    public String getPubdate() {
        return this.pubdate;
    }

    public String getContent() {
        return this.content;
    }
}
