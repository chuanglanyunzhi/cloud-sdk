package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * 批量发送短信请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmsBatchSendRequest extends CloudSdkModel {

    /**
     * 产品类型：notify/market/verify/2ec/finance/game/acquisition。
     */
    private String productType;

    /**
     * 短信接收手机号，多个使用英文逗号间隔，一次不要超过 1000 个。
     */
    private String phoneNumbers;

    /**
     * 模板 ID。
     */
    private String templateCode;

    /**
     * 变量参数值，JSON 数组字符串格式。
     */
    private String templateParam;

    /**
     * 短信签名，模板未关联签名时必填。
     */
    private String signName;

    /**
     * 状态回执开关，传 "true" 开启。
     */
    private String report;

    /**
     * 状态回执回调地址，需带 http 协议头。
     */
    private String callbackUrl;

    /**
     * 下发短信号码扩展码，用于匹配上行回复。
     */
    private String smsUpExtendCode;

    /**
     * 自定义参数，如订单号或流水号，状态回执会回传。
     */
    private String outId;

    public static SmsBatchSendRequest build(Map<String, ?> map) throws Exception {
        return build(map, SmsBatchSendRequest.class);
    }

    public SmsBatchSendRequest setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public SmsBatchSendRequest setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public SmsBatchSendRequest setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
        return this;
    }

    public SmsBatchSendRequest setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
        return this;
    }

    public SmsBatchSendRequest setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    public SmsBatchSendRequest setReport(String report) {
        this.report = report;
        return this;
    }

    public SmsBatchSendRequest setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public SmsBatchSendRequest setSmsUpExtendCode(String smsUpExtendCode) {
        this.smsUpExtendCode = smsUpExtendCode;
        return this;
    }

    public SmsBatchSendRequest setOutId(String outId) {
        this.outId = outId;
        return this;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public String getTemplateCode() {
        return this.templateCode;
    }

    public String getTemplateParam() {
        return this.templateParam;
    }

    public String getSignName() {
        return this.signName;
    }

    public String getReport() {
        return this.report;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public String getSmsUpExtendCode() {
        return this.smsUpExtendCode;
    }

    public String getOutId() {
        return this.outId;
    }
}
