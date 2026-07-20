package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 工商行政处罚记录。
 */
public class AdministrativeSanctionItem extends CloudSdkModel {

    /**
     * 行政处罚决定书文号。
     */
    private String pendecno;

    /**
     * 违法行为类型。
     */
    private String casetype;

    /**
     * 处罚种类。
     */
    private String pentype;

    /**
     * 主要违法事实。
     */
    private String illegfact;

    /**
     * 行政处罚内容。
     */
    private String content;

    /**
     * 处罚金额。
     */
    private String penam;

    /**
     * 没收金额。
     */
    private String confiscate;

    /**
     * 作出行政处罚机关名称。
     */
    private String penauth;

    /**
     * 作出行政处罚决定日期。
     */
    private String pendecissdate;

    /**
     * 公示日期。
     */
    private String pubdate;

    /**
     * 处罚依据。
     */
    private String penbasis;

    /**
     * 处罚结果。
     */
    private String penresult;

    /**
     * 处罚执行情况。
     */
    private String penexest;

    /**
     * 处罚有效期。
     */
    private String peneffdate;

    /**
     * 公示截止期。
     */
    private String pubenddate;

    /**
     * 是否公示(0:公示；1:源已不公示；2：已过公示期)。
     */
    private String isUsed;

    public AdministrativeSanctionItem setPendecno(String pendecno) {
        this.pendecno = pendecno;
        return this;
    }

    public AdministrativeSanctionItem setCasetype(String casetype) {
        this.casetype = casetype;
        return this;
    }

    public AdministrativeSanctionItem setPentype(String pentype) {
        this.pentype = pentype;
        return this;
    }

    public AdministrativeSanctionItem setIllegfact(String illegfact) {
        this.illegfact = illegfact;
        return this;
    }

    public AdministrativeSanctionItem setContent(String content) {
        this.content = content;
        return this;
    }

    public AdministrativeSanctionItem setPenam(String penam) {
        this.penam = penam;
        return this;
    }

    public AdministrativeSanctionItem setConfiscate(String confiscate) {
        this.confiscate = confiscate;
        return this;
    }

    public AdministrativeSanctionItem setPenauth(String penauth) {
        this.penauth = penauth;
        return this;
    }

    public AdministrativeSanctionItem setPendecissdate(String pendecissdate) {
        this.pendecissdate = pendecissdate;
        return this;
    }

    public AdministrativeSanctionItem setPubdate(String pubdate) {
        this.pubdate = pubdate;
        return this;
    }

    public AdministrativeSanctionItem setPenbasis(String penbasis) {
        this.penbasis = penbasis;
        return this;
    }

    public AdministrativeSanctionItem setPenresult(String penresult) {
        this.penresult = penresult;
        return this;
    }

    public AdministrativeSanctionItem setPenexest(String penexest) {
        this.penexest = penexest;
        return this;
    }

    public AdministrativeSanctionItem setPeneffdate(String peneffdate) {
        this.peneffdate = peneffdate;
        return this;
    }

    public AdministrativeSanctionItem setPubenddate(String pubenddate) {
        this.pubenddate = pubenddate;
        return this;
    }

    public AdministrativeSanctionItem setIsUsed(String isUsed) {
        this.isUsed = isUsed;
        return this;
    }

    public String getPendecno() {
        return this.pendecno;
    }

    public String getCasetype() {
        return this.casetype;
    }

    public String getPentype() {
        return this.pentype;
    }

    public String getIllegfact() {
        return this.illegfact;
    }

    public String getContent() {
        return this.content;
    }

    public String getPenam() {
        return this.penam;
    }

    public String getConfiscate() {
        return this.confiscate;
    }

    public String getPenauth() {
        return this.penauth;
    }

    public String getPendecissdate() {
        return this.pendecissdate;
    }

    public String getPubdate() {
        return this.pubdate;
    }

    public String getPenbasis() {
        return this.penbasis;
    }

    public String getPenresult() {
        return this.penresult;
    }

    public String getPenexest() {
        return this.penexest;
    }

    public String getPeneffdate() {
        return this.peneffdate;
    }

    public String getPubenddate() {
        return this.pubenddate;
    }

    public String getIsUsed() {
        return this.isUsed;
    }
}
