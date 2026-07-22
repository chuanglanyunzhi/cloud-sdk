package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 创建签名请求。
 *
 * <p>签名内容如未带【】，系统会自动包裹。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsSignAddRequest extends CloudSdkModel {

    /**
     * 签名内容（可不带【】，系统会自动添加）。
     */
    private String sign;

    /**
     * 所属客户编码：1 党政军 2 民生 3 医疗器械/药店 4 电商 5 沿街商铺(中小) 6 教育培训 7 房地产 8 游戏。
     */
    private String customerCode;

    /**
     * 行业属性编码（见附录行业代码表）。
     */
    private String industryCode;

    /**
     * 签名类型：0 非游戏类 1 游戏类。
     */
    private String signType;

    /**
     * 企业名称。
     */
    private String businessName;

    /**
     * 统一社会信用代码。
     */
    private String creditCode;

    /**
     * 经办人姓名。
     */
    private String handledbyName;

    /**
     * 经办人身份证号。
     */
    private String relevantIdcard;

    /**
     * 签名素材体。
     */
    private RcsSmsSignAddBody body;

    public RcsSmsSignAddRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public RcsSmsSignAddRequest setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
        return this;
    }

    public RcsSmsSignAddRequest setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
        return this;
    }

    public RcsSmsSignAddRequest setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public RcsSmsSignAddRequest setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public RcsSmsSignAddRequest setCreditCode(String creditCode) {
        this.creditCode = creditCode;
        return this;
    }

    public RcsSmsSignAddRequest setHandledbyName(String handledbyName) {
        this.handledbyName = handledbyName;
        return this;
    }

    public RcsSmsSignAddRequest setRelevantIdcard(String relevantIdcard) {
        this.relevantIdcard = relevantIdcard;
        return this;
    }

    public RcsSmsSignAddRequest setBody(RcsSmsSignAddBody body) {
        this.body = body;
        return this;
    }

    public String getSign() {
        return this.sign;
    }

    public String getCustomerCode() {
        return this.customerCode;
    }

    public String getIndustryCode() {
        return this.industryCode;
    }

    public String getSignType() {
        return this.signType;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public String getCreditCode() {
        return this.creditCode;
    }

    public String getHandledbyName() {
        return this.handledbyName;
    }

    public String getRelevantIdcard() {
        return this.relevantIdcard;
    }

    public RcsSmsSignAddBody getBody() {
        return this.body;
    }
}
