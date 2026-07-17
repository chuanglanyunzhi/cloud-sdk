package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 工商行政处罚记录。
 */
public class AdministrativeSanctionItem extends CloudSdkModel {

    /**
     * 行政处罚决定书文号。
     */
    public String pendecno;

    /**
     * 违法行为类型。
     */
    public String casetype;

    /**
     * 处罚种类。
     */
    public String pentype;

    /**
     * 主要违法事实。
     */
    public String illegfact;

    /**
     * 行政处罚内容。
     */
    public String content;

    /**
     * 处罚金额。
     */
    public String penam;

    /**
     * 没收金额。
     */
    public String confiscate;

    /**
     * 作出行政处罚机关名称。
     */
    public String penauth;

    /**
     * 作出行政处罚决定日期。
     */
    public String pendecissdate;

    /**
     * 公示日期。
     */
    public String pubdate;

    /**
     * 处罚依据。
     */
    public String penbasis;

    /**
     * 处罚结果。
     */
    public String penresult;

    /**
     * 处罚执行情况。
     */
    public String penexest;

    /**
     * 处罚有效期。
     */
    public String peneffdate;

    /**
     * 公示截止期。
     */
    public String pubenddate;

    /**
     * 是否公示(0:公示；1:源已不公示；2：已过公示期)。
     */
    public String isUsed;

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
}
