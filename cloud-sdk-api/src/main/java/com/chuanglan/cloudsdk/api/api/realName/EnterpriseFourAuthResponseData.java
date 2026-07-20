package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业四要素核验响应数据。
 */
public class EnterpriseFourAuthResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    private String orderNo;

    /**
     * 处理时间。
     */
    private String handleTime;

    /**
     * 返回结果码：01 一致；02 不一致；03 不确定；04 通道调用异常。
     */
    private String result;

    /**
     * result 结果码描述说明。
     */
    private String remark;

    /**
     * 企业名称核验结果：1 一致；2 不一致；3 无法验证。
     */
    private String companyNameMatch;

    /**
     * 社会统一信用号核验结果：1 一致；2 不一致；3 无法验证。
     */
    private String creditCodeMatch;

    /**
     * 法人姓名核验结果：1 一致；2 不一致；3 无法验证。
     */
    private String legalPerNameMatch;

    /**
     * 法人证件号核验结果：1 一致；2 不一致；3 无法验证。
     */
    private String idNoMatch;

    public EnterpriseFourAuthResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public EnterpriseFourAuthResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public EnterpriseFourAuthResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public EnterpriseFourAuthResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public EnterpriseFourAuthResponseData setCompanyNameMatch(String companyNameMatch) {
        this.companyNameMatch = companyNameMatch;
        return this;
    }

    public EnterpriseFourAuthResponseData setCreditCodeMatch(String creditCodeMatch) {
        this.creditCodeMatch = creditCodeMatch;
        return this;
    }

    public EnterpriseFourAuthResponseData setLegalPerNameMatch(String legalPerNameMatch) {
        this.legalPerNameMatch = legalPerNameMatch;
        return this;
    }

    public EnterpriseFourAuthResponseData setIdNoMatch(String idNoMatch) {
        this.idNoMatch = idNoMatch;
        return this;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getHandleTime() {
        return this.handleTime;
    }

    public String getResult() {
        return this.result;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getCompanyNameMatch() {
        return this.companyNameMatch;
    }

    public String getCreditCodeMatch() {
        return this.creditCodeMatch;
    }

    public String getLegalPerNameMatch() {
        return this.legalPerNameMatch;
    }

    public String getIdNoMatch() {
        return this.idNoMatch;
    }
}
