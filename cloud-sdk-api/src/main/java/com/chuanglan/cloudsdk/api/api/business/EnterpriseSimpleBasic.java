package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业工商信息查询（简项）基本信息。
 */
public class EnterpriseSimpleBasic extends CloudSdkModel {

    /**
     * 企业名称。
     */
    private String entname;

    /**
     * 企业曾用名。
     */
    private String entnameold;

    /**
     * 统一社会信用代码。
     */
    private String creditcode;

    /**
     * 注册号。
     */
    private String regno;

    /**
     * 法定代表人。
     */
    private String frname;

    /**
     * 成立日期。
     */
    private String esdate;

    /**
     * 行业门类代码。
     */
    private String industrycocode;

    /**
     * 行业门类名称。
     */
    private String industryconame;

    /**
     * 注册资本。
     */
    private String regcap;

    /**
     * 注册资本币种。
     */
    private String regcapcur;

    /**
     * 实收资本。
     */
    private String reccap;

    /**
     * 登记机关。
     */
    private String regorg;

    /**
     * 企业状态。
     */
    private String entstatus;

    /**
     * 企业类型。
     */
    private String enttype;

    /**
     * 经营期限自。
     */
    private String opfrom;

    /**
     * 经营期限至。
     */
    private String opto;

    /**
     * 登记机关省份。
     */
    private String regorgprovince;

    /**
     * 登记机关城市。
     */
    private String regorgcity;

    /**
     * 登记机关区县。
     */
    private String regorgdistrict;

    /**
     * 邮箱。
     */
    private String email;

    /**
     * 住所。
     */
    private String dom;

    /**
     * 经营范围。
     */
    private String abuitem;

    /**
     * 年报年份。
     */
    private String ancheyear;

    /**
     * 电话。
     */
    private String tel;

    /**
     * 从业人数。
     */
    private String empnum;

    /**
     * 撤销日期。
     */
    private String revdate;

    /**
     * 吊销日期。
     */
    private String candate;

    /**
     * 核准日期。
     */
    private String apprdate;

    /**
     * 住所行政区划。
     */
    private String domdistrict;

    /**
     * 登记机关代码。
     */
    private String regorgcode;

    /**
     * 企业类型代码。
     */
    private String enttypecode;

    /**
     * 行业门类代码。
     */
    private String industryphycode;

    /**
     * 行业门类名称。
     */
    private String industryphyname;

    /**
     * 行业代码及名称。
     */
    private String industrycoall;

    /**
     * 行业门类代码及名称。
     */
    private String industryphyall;

    public EnterpriseSimpleBasic setEntname(String entname) {
        this.entname = entname;
        return this;
    }

    public EnterpriseSimpleBasic setEntnameold(String entnameold) {
        this.entnameold = entnameold;
        return this;
    }

    public EnterpriseSimpleBasic setCreditcode(String creditcode) {
        this.creditcode = creditcode;
        return this;
    }

    public EnterpriseSimpleBasic setRegno(String regno) {
        this.regno = regno;
        return this;
    }

    public EnterpriseSimpleBasic setFrname(String frname) {
        this.frname = frname;
        return this;
    }

    public EnterpriseSimpleBasic setEsdate(String esdate) {
        this.esdate = esdate;
        return this;
    }

    public EnterpriseSimpleBasic setIndustrycocode(String industrycocode) {
        this.industrycocode = industrycocode;
        return this;
    }

    public EnterpriseSimpleBasic setIndustryconame(String industryconame) {
        this.industryconame = industryconame;
        return this;
    }

    public EnterpriseSimpleBasic setRegcap(String regcap) {
        this.regcap = regcap;
        return this;
    }

    public EnterpriseSimpleBasic setRegcapcur(String regcapcur) {
        this.regcapcur = regcapcur;
        return this;
    }

    public EnterpriseSimpleBasic setReccap(String reccap) {
        this.reccap = reccap;
        return this;
    }

    public EnterpriseSimpleBasic setRegorg(String regorg) {
        this.regorg = regorg;
        return this;
    }

    public EnterpriseSimpleBasic setEntstatus(String entstatus) {
        this.entstatus = entstatus;
        return this;
    }

    public EnterpriseSimpleBasic setEnttype(String enttype) {
        this.enttype = enttype;
        return this;
    }

    public EnterpriseSimpleBasic setOpfrom(String opfrom) {
        this.opfrom = opfrom;
        return this;
    }

    public EnterpriseSimpleBasic setOpto(String opto) {
        this.opto = opto;
        return this;
    }

    public EnterpriseSimpleBasic setRegorgprovince(String regorgprovince) {
        this.regorgprovince = regorgprovince;
        return this;
    }

    public EnterpriseSimpleBasic setRegorgcity(String regorgcity) {
        this.regorgcity = regorgcity;
        return this;
    }

    public EnterpriseSimpleBasic setRegorgdistrict(String regorgdistrict) {
        this.regorgdistrict = regorgdistrict;
        return this;
    }

    public EnterpriseSimpleBasic setEmail(String email) {
        this.email = email;
        return this;
    }

    public EnterpriseSimpleBasic setDom(String dom) {
        this.dom = dom;
        return this;
    }

    public EnterpriseSimpleBasic setAbuitem(String abuitem) {
        this.abuitem = abuitem;
        return this;
    }

    public EnterpriseSimpleBasic setAncheyear(String ancheyear) {
        this.ancheyear = ancheyear;
        return this;
    }

    public EnterpriseSimpleBasic setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public EnterpriseSimpleBasic setEmpnum(String empnum) {
        this.empnum = empnum;
        return this;
    }

    public EnterpriseSimpleBasic setRevdate(String revdate) {
        this.revdate = revdate;
        return this;
    }

    public EnterpriseSimpleBasic setCandate(String candate) {
        this.candate = candate;
        return this;
    }

    public EnterpriseSimpleBasic setApprdate(String apprdate) {
        this.apprdate = apprdate;
        return this;
    }

    public EnterpriseSimpleBasic setDomdistrict(String domdistrict) {
        this.domdistrict = domdistrict;
        return this;
    }

    public EnterpriseSimpleBasic setRegorgcode(String regorgcode) {
        this.regorgcode = regorgcode;
        return this;
    }

    public EnterpriseSimpleBasic setEnttypecode(String enttypecode) {
        this.enttypecode = enttypecode;
        return this;
    }

    public EnterpriseSimpleBasic setIndustryphycode(String industryphycode) {
        this.industryphycode = industryphycode;
        return this;
    }

    public EnterpriseSimpleBasic setIndustryphyname(String industryphyname) {
        this.industryphyname = industryphyname;
        return this;
    }

    public EnterpriseSimpleBasic setIndustrycoall(String industrycoall) {
        this.industrycoall = industrycoall;
        return this;
    }

    public EnterpriseSimpleBasic setIndustryphyall(String industryphyall) {
        this.industryphyall = industryphyall;
        return this;
    }

    public String getEntname() {
        return this.entname;
    }

    public String getEntnameold() {
        return this.entnameold;
    }

    public String getCreditcode() {
        return this.creditcode;
    }

    public String getRegno() {
        return this.regno;
    }

    public String getFrname() {
        return this.frname;
    }

    public String getEsdate() {
        return this.esdate;
    }

    public String getIndustrycocode() {
        return this.industrycocode;
    }

    public String getIndustryconame() {
        return this.industryconame;
    }

    public String getRegcap() {
        return this.regcap;
    }

    public String getRegcapcur() {
        return this.regcapcur;
    }

    public String getReccap() {
        return this.reccap;
    }

    public String getRegorg() {
        return this.regorg;
    }

    public String getEntstatus() {
        return this.entstatus;
    }

    public String getEnttype() {
        return this.enttype;
    }

    public String getOpfrom() {
        return this.opfrom;
    }

    public String getOpto() {
        return this.opto;
    }

    public String getRegorgprovince() {
        return this.regorgprovince;
    }

    public String getRegorgcity() {
        return this.regorgcity;
    }

    public String getRegorgdistrict() {
        return this.regorgdistrict;
    }

    public String getEmail() {
        return this.email;
    }

    public String getDom() {
        return this.dom;
    }

    public String getAbuitem() {
        return this.abuitem;
    }

    public String getAncheyear() {
        return this.ancheyear;
    }

    public String getTel() {
        return this.tel;
    }

    public String getEmpnum() {
        return this.empnum;
    }

    public String getRevdate() {
        return this.revdate;
    }

    public String getCandate() {
        return this.candate;
    }

    public String getApprdate() {
        return this.apprdate;
    }

    public String getDomdistrict() {
        return this.domdistrict;
    }

    public String getRegorgcode() {
        return this.regorgcode;
    }

    public String getEnttypecode() {
        return this.enttypecode;
    }

    public String getIndustryphycode() {
        return this.industryphycode;
    }

    public String getIndustryphyname() {
        return this.industryphyname;
    }

    public String getIndustrycoall() {
        return this.industrycoall;
    }

    public String getIndustryphyall() {
        return this.industryphyall;
    }
}
