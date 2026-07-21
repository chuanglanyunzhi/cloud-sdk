package com.chuanglan.cloudsdk.api;

import com.chuanglan.cloudsdk.api.api.business.*;
import com.chuanglan.cloudsdk.api.api.mnp.*;
import com.chuanglan.cloudsdk.api.api.number.*;
import com.chuanglan.cloudsdk.api.api.risk.*;
import com.chuanglan.cloudsdk.api.api.realName.*;
import com.chuanglan.cloudsdk.api.intSms.*;
import com.chuanglan.cloudsdk.api.rcsSms.*;
import com.chuanglan.cloudsdk.api.sms.*;
import com.chuanglan.cloudsdk.api.sms.qualification.*;
import com.chuanglan.cloudsdk.api.sms.signature.*;
import com.chuanglan.cloudsdk.api.sms.template.*;
import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.HttpTransport;

/**
 * 253 云 SDK 统一入口，聚合短信、国际短信、视频短信、号码、风控、携号转网、实名认证等全部 API。
 *
 * <p>实现 {@link AutoCloseable}，业务方应在生命周期结束时通过 try-with-resources 或显式调用
 * {@link #close()} 释放底层 OkHttp 连接池与 Dispatcher 线程池，避免在容器热部署/重启场景下资源泄漏。
 */
public class CloudApiClient implements AutoCloseable {

    private final NumberClient numberClient;
    private final NumberCarrierClient numberCarrierClient;
    private final RiskClient riskClient;
    private final MnpClient mnpClient;
    private final SmsClient smsClient;
    private final IntSmsClient intSmsClient;
    private final RcsSmsClient rcsSmsClient;
    private final RealNameClient realNameClient;
    private final BusinessClient businessClient;
    private final String intSmsEndpoint;

    /** SMS 独立连接池，避免批量发送时与其他业务线竞争全局并发槽。 */
    private final HttpTransport smsHttpTransport;
    /** 其余业务线共享连接池（号码、风控、携号转网、国际短信、视频短信、实名、企业信息）。 */
    private final HttpTransport httpTransport;

    public CloudApiClient() {
        this(new CloudApiConfig());
    }

    public CloudApiClient(CloudApiConfig config) {
        if (config == null) {
            throw new IllegalArgumentException("CloudApiConfig must not be null");
        }
        this.smsHttpTransport = new HttpTransport();
        this.httpTransport = new HttpTransport();
        this.numberClient = new NumberClient(buildNumberConfig(config), httpTransport);
        this.numberCarrierClient = new NumberCarrierClient(buildNumberCarrierConfig(config), httpTransport);
        this.riskClient = new RiskClient(buildRiskConfig(config), httpTransport);
        this.mnpClient = new MnpClient(buildMnpConfig(config), httpTransport);
        this.smsClient = new SmsClient(buildSmsConfig(config), smsHttpTransport);
        this.intSmsClient = new IntSmsClient(buildIntSmsConfig(config), httpTransport);
        this.rcsSmsClient = new RcsSmsClient(buildRcsSmsConfig(config), httpTransport);
        this.realNameClient = new RealNameClient(buildRealNameConfig(config), httpTransport);
        this.businessClient = new BusinessClient(buildBusinessConfig(config), httpTransport);
        this.intSmsEndpoint = config.getIntSmsEndpoint();
    }

    private NumberConfig buildNumberConfig(CloudApiConfig config) {
        return new NumberConfig()
                .setEndpoint(config.getNumberEndpoint())
                .setConnectTimeout(config.getConnectTimeout())
                .setReadTimeout(config.getReadTimeout());
    }

    private NumberCarrierConfig buildNumberCarrierConfig(CloudApiConfig config) {
        return new NumberCarrierConfig()
                .setEndpoint(config.getNumberCarrierEndpoint())
                .setConnectTimeout(config.getConnectTimeout())
                .setReadTimeout(config.getReadTimeout());
    }

    private RiskConfig buildRiskConfig(CloudApiConfig config) {
        return new RiskConfig()
                .setEndpoint(config.getRiskEndpoint())
                .setWoolEndpoint(config.getWoolEndpoint())
                .setConnectTimeout(config.getConnectTimeout())
                .setReadTimeout(config.getReadTimeout());
    }

    private MnpConfig buildMnpConfig(CloudApiConfig config) {
        return new MnpConfig()
                .setEndpoint(config.getMnpEndpoint())
                .setConnectTimeout(config.getConnectTimeout())
                .setReadTimeout(config.getReadTimeout());
    }

    private SmsConfig buildSmsConfig(CloudApiConfig config) {
        return new SmsConfig()
                .setEndpoint(config.getSmsEndpoint())
                .setApiEndpoint(config.getSmsApiEndpoint())
                .setConnectTimeout(config.getConnectTimeout())
                .setReadTimeout(config.getReadTimeout());
    }

    private IntSmsConfig buildIntSmsConfig(CloudApiConfig config) {
        return new IntSmsConfig()
                .setConnectTimeout(config.getConnectTimeout())
                .setReadTimeout(config.getReadTimeout());
    }

    private RcsSmsConfig buildRcsSmsConfig(CloudApiConfig config) {
        return new RcsSmsConfig()
                .setEndpoint(config.getRcsSmsEndpoint())
                .setConnectTimeout(config.getConnectTimeout())
                .setReadTimeout(config.getReadTimeout());
    }

    private RealNameConfig buildRealNameConfig(CloudApiConfig config) {
        return new RealNameConfig()
                .setEndpoint(config.getRealNameEndpoint())
                .setApiEndpoint(config.getRealNameApiEndpoint())
                .setConnectTimeout(config.getConnectTimeout())
                .setReadTimeout(config.getReadTimeout());
    }

    private BusinessConfig buildBusinessConfig(CloudApiConfig config) {
        return new BusinessConfig()
                .setEndpoint(config.getBusinessEndpoint())
                .setConnectTimeout(config.getConnectTimeout())
                .setReadTimeout(config.getReadTimeout());
    }

    // ================== 号码业务 ==================

    /**
     * 号码状态检测（批量）。
     */
    public NumberStatusCheckResponse batchUcheck(String appId, String appSecret, NumberStatusCheckRequest request) throws CloudSdkException {
        return numberClient.batchUcheck(appId, appSecret, request);
    }

    /**
     * 号码状态检测（批量），支持自定义链路追踪 ID。
     */
    public NumberStatusCheckResponse batchUcheck(String appId, String appSecret, NumberStatusCheckRequest request, String traceId) throws CloudSdkException {
        return numberClient.batchUcheck(appId, appSecret, request, traceId);
    }

    /**
     * 手机号码归属地查询（升级版 V2）。
     */
    public NumberPhoneAttributionV2Response phoneAttributionV2(String appId, String appSecret, NumberPhoneAttributionV2Request request) throws CloudSdkException {
        return numberClient.phoneAttributionV2(appId, appSecret, request);
    }

    /**
     * 手机号码归属地查询（升级版 V2），支持自定义链路追踪 ID。
     */
    public NumberPhoneAttributionV2Response phoneAttributionV2(String appId, String appSecret, NumberPhoneAttributionV2Request request, String traceId) throws CloudSdkException {
        return numberClient.phoneAttributionV2(appId, appSecret, request, traceId);
    }

    // ================== 号码运营商业务 ==================

    /**
     * 二次号查询。
     */
    public NumberSecondHandResponse moresale(String appId, String appSecret, NumberSecondHandRequest request) throws CloudSdkException {
        return numberCarrierClient.moresale(appId, appSecret, request);
    }

    /**
     * 二次号查询，支持自定义链路追踪 ID。
     */
    public NumberSecondHandResponse moresale(String appId, String appSecret, NumberSecondHandRequest request, String traceId) throws CloudSdkException {
        return numberCarrierClient.moresale(appId, appSecret, request, traceId);
    }

    /**
     * 号码实时基础版查询。
     */
    public NumberMobStatusBasicResponse mobStatusBasicQuery(String appId, String appSecret, NumberMobStatusBasicRequest request) throws CloudSdkException {
        return numberCarrierClient.mobStatusBasicQuery(appId, appSecret, request);
    }

    /**
     * 号码实时基础版查询，支持自定义链路追踪 ID。
     */
    public NumberMobStatusBasicResponse mobStatusBasicQuery(String appId, String appSecret, NumberMobStatusBasicRequest request, String traceId) throws CloudSdkException {
        return numberCarrierClient.mobStatusBasicQuery(appId, appSecret, request, traceId);
    }

    /**
     * 号码在网时长查询。
     */
    public NumberOnlineDurationResponse onlineDurationQuery(String appId, String appSecret, NumberOnlineDurationRequest request) throws CloudSdkException {
        return numberCarrierClient.onlineDurationQuery(appId, appSecret, request);
    }

    /**
     * 号码在网时长查询，支持自定义链路追踪 ID。
     */
    public NumberOnlineDurationResponse onlineDurationQuery(String appId, String appSecret, NumberOnlineDurationRequest request, String traceId) throws CloudSdkException {
        return numberCarrierClient.onlineDurationQuery(appId, appSecret, request, traceId);
    }

    /**
     * 号码在网状态查询。
     */
    public NumberNetStatusResponse netStatus(String appId, String appSecret, NumberNetStatusRequest request) throws CloudSdkException {
        return numberCarrierClient.netStatus(appId, appSecret, request);
    }

    /**
     * 号码在网状态查询，支持自定义链路追踪 ID。
     */
    public NumberNetStatusResponse netStatus(String appId, String appSecret, NumberNetStatusRequest request, String traceId) throws CloudSdkException {
        return numberCarrierClient.netStatus(appId, appSecret, request, traceId);
    }

    // ================== 风控业务 ==================

    /**
     * 防骚扰黑名单查询。
     */
    public RiskAntiHarassmentResponse bforbid(String appId, String appSecret, RiskAntiHarassmentRequest request) throws CloudSdkException {
        return riskClient.bforbid(appId, appSecret, request);
    }

    /**
     * 防骚扰黑名单查询，支持自定义链路追踪 ID。
     */
    public RiskAntiHarassmentResponse bforbid(String appId, String appSecret, RiskAntiHarassmentRequest request, String traceId) throws CloudSdkException {
        return riskClient.bforbid(appId, appSecret, request, traceId);
    }

    /**
     * 羊毛党检测。
     */
    public RiskWoolCheckResponse woolCheck(String appId, String appSecret, RiskWoolCheckRequest request) throws CloudSdkException {
        return riskClient.woolCheck(appId, appSecret, request);
    }

    /**
     * 羊毛党检测，支持自定义链路追踪 ID。
     */
    public RiskWoolCheckResponse woolCheck(String appId, String appSecret, RiskWoolCheckRequest request, String traceId) throws CloudSdkException {
        return riskClient.woolCheck(appId, appSecret, request, traceId);
    }

    // ================== 携号转网业务 ==================

    /**
     * 携号转网 V1 查询。
     */
    public MnpCarriersSftpResponse carriersSftp(String appId, String appSecret, MnpCarriersSftpRequest request) throws CloudSdkException {
        return mnpClient.carriersSftp(appId, appSecret, request);
    }

    /**
     * 携号转网 V1 查询，支持自定义链路追踪 ID。
     */
    public MnpCarriersSftpResponse carriersSftp(String appId, String appSecret, MnpCarriersSftpRequest request, String traceId) throws CloudSdkException {
        return mnpClient.carriersSftp(appId, appSecret, request, traceId);
    }

    // ================== 短信业务 ==================

    /**
     * 短信批量发送。
     */
    public SmsBatchSendResponse batchSend(String appId, String appSecret, SmsBatchSendRequest request) throws CloudSdkException {
        return smsClient.batchSend(appId, appSecret, request);
    }

    /**
     * 短信批量发送，支持自定义链路追踪 ID。
     */
    public SmsBatchSendResponse batchSend(String appId, String appSecret, SmsBatchSendRequest request, String traceId) throws CloudSdkException {
        return smsClient.batchSend(appId, appSecret, request, traceId);
    }

    /**
     * 新增资质。
     */
    public SmsQualificationAddResponse addQualification(String appId, String appSecret, SmsQualificationAddRequest request) throws CloudSdkException {
        return smsClient.addQualification(appId, appSecret, request);
    }

    /**
     * 新增资质，支持自定义链路追踪 ID。
     */
    public SmsQualificationAddResponse addQualification(String appId, String appSecret, SmsQualificationAddRequest request, String traceId) throws CloudSdkException {
        return smsClient.addQualification(appId, appSecret, request, traceId);
    }

    /**
     * 查询资质列表。
     */
    public SmsQualificationListResponse listQualification(String appId, String appSecret, SmsQualificationListRequest request) throws CloudSdkException {
        return smsClient.listQualification(appId, appSecret, request);
    }

    /**
     * 查询资质列表，支持自定义链路追踪 ID。
     */
    public SmsQualificationListResponse listQualification(String appId, String appSecret, SmsQualificationListRequest request, String traceId) throws CloudSdkException {
        return smsClient.listQualification(appId, appSecret, request, traceId);
    }

    /**
     * 更新资质。
     */
    public SmsQualificationUpdateResponse updateQualification(String appId, String appSecret, SmsQualificationUpdateRequest request) throws CloudSdkException {
        return smsClient.updateQualification(appId, appSecret, request);
    }

    /**
     * 更新资质，支持自定义链路追踪 ID。
     */
    public SmsQualificationUpdateResponse updateQualification(String appId, String appSecret, SmsQualificationUpdateRequest request, String traceId) throws CloudSdkException {
        return smsClient.updateQualification(appId, appSecret, request, traceId);
    }

    /**
     * 删除资质。
     */
    public SmsQualificationDeleteResponse deleteQualification(String appId, String appSecret, SmsQualificationDeleteRequest request) throws CloudSdkException {
        return smsClient.deleteQualification(appId, appSecret, request);
    }

    /**
     * 删除资质，支持自定义链路追踪 ID。
     */
    public SmsQualificationDeleteResponse deleteQualification(String appId, String appSecret, SmsQualificationDeleteRequest request, String traceId) throws CloudSdkException {
        return smsClient.deleteQualification(appId, appSecret, request, traceId);
    }

    /**
     * 新增签名。
     */
    public SmsSignatureAddResponse addSignature(String appId, String appSecret, SmsSignatureAddRequest request) throws CloudSdkException {
        return smsClient.addSignature(appId, appSecret, request);
    }

    /**
     * 新增签名，支持自定义链路追踪 ID。
     */
    public SmsSignatureAddResponse addSignature(String appId, String appSecret, SmsSignatureAddRequest request, String traceId) throws CloudSdkException {
        return smsClient.addSignature(appId, appSecret, request, traceId);
    }

    /**
     * 查询签名详情。
     */
    public SmsSignatureGetResponse getSignature(String appId, String appSecret, SmsSignatureGetRequest request) throws CloudSdkException {
        return smsClient.getSignature(appId, appSecret, request);
    }

    /**
     * 查询签名详情，支持自定义链路追踪 ID。
     */
    public SmsSignatureGetResponse getSignature(String appId, String appSecret, SmsSignatureGetRequest request, String traceId) throws CloudSdkException {
        return smsClient.getSignature(appId, appSecret, request, traceId);
    }

    /**
     * 查询签名列表。
     */
    public SmsSignatureListResponse listSignature(String appId, String appSecret, SmsSignatureListRequest request) throws CloudSdkException {
        return smsClient.listSignature(appId, appSecret, request);
    }

    /**
     * 查询签名列表，支持自定义链路追踪 ID。
     */
    public SmsSignatureListResponse listSignature(String appId, String appSecret, SmsSignatureListRequest request, String traceId) throws CloudSdkException {
        return smsClient.listSignature(appId, appSecret, request, traceId);
    }

    /**
     * 查询签名运营商驳回原因。
     */
    public SmsSignatureOperatorRejectReasonResponse getSignatureOperatorRejectReason(String appId, String appSecret, SmsSignatureOperatorRejectReasonRequest request) throws CloudSdkException {
        return smsClient.getSignatureOperatorRejectReason(appId, appSecret, request);
    }

    /**
     * 查询签名运营商驳回原因，支持自定义链路追踪 ID。
     */
    public SmsSignatureOperatorRejectReasonResponse getSignatureOperatorRejectReason(String appId, String appSecret, SmsSignatureOperatorRejectReasonRequest request, String traceId) throws CloudSdkException {
        return smsClient.getSignatureOperatorRejectReason(appId, appSecret, request, traceId);
    }

    /**
     * 更新签名实名信息。
     */
    public SmsSignatureRealNameUpdateResponse updateSignatureRealName(String appId, String appSecret, SmsSignatureRealNameUpdateRequest request) throws CloudSdkException {
        return smsClient.updateSignatureRealName(appId, appSecret, request);
    }

    /**
     * 更新签名实名信息，支持自定义链路追踪 ID。
     */
    public SmsSignatureRealNameUpdateResponse updateSignatureRealName(String appId, String appSecret, SmsSignatureRealNameUpdateRequest request, String traceId) throws CloudSdkException {
        return smsClient.updateSignatureRealName(appId, appSecret, request, traceId);
    }

    /**
     * 删除签名。
     */
    public SmsSignatureDeleteResponse deleteSignature(String appId, String appSecret, SmsSignatureDeleteRequest request) throws CloudSdkException {
        return smsClient.deleteSignature(appId, appSecret, request);
    }

    /**
     * 删除签名，支持自定义链路追踪 ID。
     */
    public SmsSignatureDeleteResponse deleteSignature(String appId, String appSecret, SmsSignatureDeleteRequest request, String traceId) throws CloudSdkException {
        return smsClient.deleteSignature(appId, appSecret, request, traceId);
    }

    /**
     * 新增模板。
     */
    public SmsTemplateAddResponse addTemplate(String appId, String appSecret, SmsTemplateAddRequest request) throws CloudSdkException {
        return smsClient.addTemplate(appId, appSecret, request);
    }

    /**
     * 新增模板，支持自定义链路追踪 ID。
     */
    public SmsTemplateAddResponse addTemplate(String appId, String appSecret, SmsTemplateAddRequest request, String traceId) throws CloudSdkException {
        return smsClient.addTemplate(appId, appSecret, request, traceId);
    }

    /**
     * 查询模板类型枚举。
     */
    public SmsTemplateTypeEnumResponse queryTemplateTypeEnum(String appId, String appSecret, SmsTemplateTypeEnumRequest request) throws CloudSdkException {
        return smsClient.queryTemplateTypeEnum(appId, appSecret, request);
    }

    /**
     * 查询模板类型枚举，支持自定义链路追踪 ID。
     */
    public SmsTemplateTypeEnumResponse queryTemplateTypeEnum(String appId, String appSecret, SmsTemplateTypeEnumRequest request, String traceId) throws CloudSdkException {
        return smsClient.queryTemplateTypeEnum(appId, appSecret, request, traceId);
    }

    /**
     * 查询模板列表。
     */
    public SmsTemplateListResponse listTemplate(String appId, String appSecret, SmsTemplateListRequest request) throws CloudSdkException {
        return smsClient.listTemplate(appId, appSecret, request);
    }

    /**
     * 查询模板列表，支持自定义链路追踪 ID。
     */
    public SmsTemplateListResponse listTemplate(String appId, String appSecret, SmsTemplateListRequest request, String traceId) throws CloudSdkException {
        return smsClient.listTemplate(appId, appSecret, request, traceId);
    }

    /**
     * 查询模板详情。
     */
    public SmsTemplateGetResponse getTemplate(String appId, String appSecret, SmsTemplateGetRequest request) throws CloudSdkException {
        return smsClient.getTemplate(appId, appSecret, request);
    }

    /**
     * 查询模板详情，支持自定义链路追踪 ID。
     */
    public SmsTemplateGetResponse getTemplate(String appId, String appSecret, SmsTemplateGetRequest request, String traceId) throws CloudSdkException {
        return smsClient.getTemplate(appId, appSecret, request, traceId);
    }

    /**
     * 查询模板运营商驳回原因。
     */
    public SmsTemplateOperatorRejectReasonResponse getTemplateOperatorRejectReason(String appId, String appSecret, SmsTemplateOperatorRejectReasonRequest request) throws CloudSdkException {
        return smsClient.getTemplateOperatorRejectReason(appId, appSecret, request);
    }

    /**
     * 查询模板运营商驳回原因，支持自定义链路追踪 ID。
     */
    public SmsTemplateOperatorRejectReasonResponse getTemplateOperatorRejectReason(String appId, String appSecret, SmsTemplateOperatorRejectReasonRequest request, String traceId) throws CloudSdkException {
        return smsClient.getTemplateOperatorRejectReason(appId, appSecret, request, traceId);
    }

    /**
     * 更新模板。
     */
    public SmsTemplateUpdateResponse updateTemplate(String appId, String appSecret, SmsTemplateUpdateRequest request) throws CloudSdkException {
        return smsClient.updateTemplate(appId, appSecret, request);
    }

    /**
     * 更新模板，支持自定义链路追踪 ID。
     */
    public SmsTemplateUpdateResponse updateTemplate(String appId, String appSecret, SmsTemplateUpdateRequest request, String traceId) throws CloudSdkException {
        return smsClient.updateTemplate(appId, appSecret, request, traceId);
    }

    /**
     * 删除模板。
     */
    public SmsTemplateDeleteResponse deleteTemplate(String appId, String appSecret, SmsTemplateDeleteRequest request) throws CloudSdkException {
        return smsClient.deleteTemplate(appId, appSecret, request);
    }

    /**
     * 删除模板，支持自定义链路追踪 ID。
     */
    public SmsTemplateDeleteResponse deleteTemplate(String appId, String appSecret, SmsTemplateDeleteRequest request, String traceId) throws CloudSdkException {
        return smsClient.deleteTemplate(appId, appSecret, request, traceId);
    }

    // ================== 国际短信业务 ==================

    /**
     * 国际短信发送，使用默认配置节点。
     */
    public IntSmsSubmitResponse submitIntSms(String appId, String appSecret, IntSmsSubmitRequest request) throws CloudSdkException {
        return submitIntSms(appId, appSecret, intSmsEndpoint, request);
    }

    /**
     * 国际短信发送，使用默认配置节点，支持自定义链路追踪 ID。
     */
    public IntSmsSubmitResponse submitIntSms(String appId, String appSecret, IntSmsSubmitRequest request, String traceId) throws CloudSdkException {
        return submitIntSms(appId, appSecret, intSmsEndpoint, request, traceId);
    }

    /**
     * 国际短信发送，由调用方指定节点。
     */
    public IntSmsSubmitResponse submitIntSms(String appId, String appSecret, String endpoint, IntSmsSubmitRequest request) throws CloudSdkException {
        if (endpoint == null || endpoint.isEmpty()) {
            endpoint = intSmsEndpoint;
        }
        return intSmsClient.submit(appId, appSecret, endpoint, request);
    }

    /**
     * 国际短信发送，由调用方指定节点，支持自定义链路追踪 ID。
     */
    public IntSmsSubmitResponse submitIntSms(String appId, String appSecret, String endpoint, IntSmsSubmitRequest request, String traceId) throws CloudSdkException {
        if (endpoint == null || endpoint.isEmpty()) {
            endpoint = intSmsEndpoint;
        }
        return intSmsClient.submit(appId, appSecret, endpoint, request, traceId);
    }

    /**
     * 国际短信账户余额查询，使用默认配置节点。
     */
    public IntSmsBalanceResponse queryIntSmsBalance(String appId, String appSecret) throws CloudSdkException {
        return queryIntSmsBalance(appId, appSecret, intSmsEndpoint);
    }

    /**
     * 国际短信账户余额查询，使用默认配置节点，支持自定义链路追踪 ID。
     */
    public IntSmsBalanceResponse queryIntSmsBalance(String appId, String appSecret, String traceId) throws CloudSdkException {
        return queryIntSmsBalance(appId, appSecret, intSmsEndpoint, traceId);
    }

    /**
     * 国际短信账户余额查询，由调用方指定节点。
     */
    public IntSmsBalanceResponse queryIntSmsBalance(String appId, String appSecret, String endpoint, String traceId) throws CloudSdkException {
        if (endpoint == null || endpoint.isEmpty()) {
            endpoint = intSmsEndpoint;
        }
        return intSmsClient.balanceQuery(appId, appSecret, endpoint, traceId);
    }

    /**
     * 国际短信账户消耗查询，使用默认配置节点。
     */
    public IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, IntSmsCostRequest request) throws CloudSdkException {
        return queryIntSmsCost(appId, appSecret, intSmsEndpoint, request);
    }

    /**
     * 国际短信账户消耗查询，使用默认配置节点，支持自定义链路追踪 ID。
     */
    public IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, IntSmsCostRequest request, String traceId) throws CloudSdkException {
        return queryIntSmsCost(appId, appSecret, intSmsEndpoint, request, traceId);
    }

    /**
     * 国际短信账户消耗查询，由调用方指定节点。
     */
    public IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, String endpoint, IntSmsCostRequest request) throws CloudSdkException {
        if (endpoint == null || endpoint.isEmpty()) {
            endpoint = intSmsEndpoint;
        }
        return intSmsClient.costQuery(appId, appSecret, endpoint, request);
    }

    /**
     * 国际短信账户消耗查询，由调用方指定节点，支持自定义链路追踪 ID。
     */
    public IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, String endpoint, IntSmsCostRequest request, String traceId) throws CloudSdkException {
        if (endpoint == null || endpoint.isEmpty()) {
            endpoint = intSmsEndpoint;
        }
        return intSmsClient.costQuery(appId, appSecret, endpoint, request, traceId);
    }

    /**
     * 国际短信发送价格查询（查询全部国家），使用默认配置节点。
     */
    public IntSmsPriceResponse queryIntSmsPrice(String appId, String appSecret) throws CloudSdkException {
        return queryIntSmsPrice(appId, appSecret, intSmsEndpoint, null, null);
    }

    /**
     * 国际短信发送价格查询（可指定国家），使用默认配置节点。
     */
    public IntSmsPriceResponse queryIntSmsPrice(String appId, String appSecret, IntSmsPriceRequest request) throws CloudSdkException {
        return queryIntSmsPrice(appId, appSecret, intSmsEndpoint, request, null);
    }

    /**
     * 国际短信发送价格查询（可指定国家），使用默认配置节点，支持自定义链路追踪 ID。
     */
    public IntSmsPriceResponse queryIntSmsPrice(String appId, String appSecret, IntSmsPriceRequest request, String traceId) throws CloudSdkException {
        return queryIntSmsPrice(appId, appSecret, intSmsEndpoint, request, traceId);
    }

    /**
     * 国际短信发送价格查询，由调用方指定节点，支持自定义链路追踪 ID。
     */
    public IntSmsPriceResponse queryIntSmsPrice(String appId, String appSecret, String endpoint, IntSmsPriceRequest request, String traceId) throws CloudSdkException {
        if (endpoint == null || endpoint.isEmpty()) {
            endpoint = intSmsEndpoint;
        }
        return intSmsClient.priceQuery(appId, appSecret, endpoint, request, traceId);
    }

    /**
     * 国际短信状态报告拉取，使用默认配置节点。
     */
    public IntSmsReportPullResponse pullIntSmsReport(String appId, String appSecret) throws CloudSdkException {
        return pullIntSmsReport(appId, appSecret, intSmsEndpoint, null, null);
    }

    /**
     * 国际短信状态报告拉取（可指定条数），使用默认配置节点。
     */
    public IntSmsReportPullResponse pullIntSmsReport(String appId, String appSecret, IntSmsReportPullRequest request) throws CloudSdkException {
        return pullIntSmsReport(appId, appSecret, intSmsEndpoint, request, null);
    }

    /**
     * 国际短信状态报告拉取（可指定条数），使用默认配置节点，支持自定义链路追踪 ID。
     */
    public IntSmsReportPullResponse pullIntSmsReport(String appId, String appSecret, IntSmsReportPullRequest request, String traceId) throws CloudSdkException {
        return pullIntSmsReport(appId, appSecret, intSmsEndpoint, request, traceId);
    }

    /**
     * 国际短信状态报告拉取，由调用方指定节点，支持自定义链路追踪 ID。
     */
    public IntSmsReportPullResponse pullIntSmsReport(String appId, String appSecret, String endpoint, IntSmsReportPullRequest request, String traceId) throws CloudSdkException {
        if (endpoint == null || endpoint.isEmpty()) {
            endpoint = intSmsEndpoint;
        }
        return intSmsClient.reportPull(appId, appSecret, endpoint, request, traceId);
    }

    /**
     * 国际短信上行回复拉取，使用默认配置节点。
     */
    public IntSmsReplyPullResponse pullIntSmsReply(String appId, String appSecret) throws CloudSdkException {
        return pullIntSmsReply(appId, appSecret, intSmsEndpoint, null, null);
    }

    /**
     * 国际短信上行回复拉取（可指定条数），使用默认配置节点。
     */
    public IntSmsReplyPullResponse pullIntSmsReply(String appId, String appSecret, IntSmsReplyPullRequest request) throws CloudSdkException {
        return pullIntSmsReply(appId, appSecret, intSmsEndpoint, request, null);
    }

    /**
     * 国际短信上行回复拉取（可指定条数），使用默认配置节点，支持自定义链路追踪 ID。
     */
    public IntSmsReplyPullResponse pullIntSmsReply(String appId, String appSecret, IntSmsReplyPullRequest request, String traceId) throws CloudSdkException {
        return pullIntSmsReply(appId, appSecret, intSmsEndpoint, request, traceId);
    }

    /**
     * 国际短信上行回复拉取，由调用方指定节点，支持自定义链路追踪 ID。
     */
    public IntSmsReplyPullResponse pullIntSmsReply(String appId, String appSecret, String endpoint, IntSmsReplyPullRequest request, String traceId) throws CloudSdkException {
        if (endpoint == null || endpoint.isEmpty()) {
            endpoint = intSmsEndpoint;
        }
        return intSmsClient.replyPull(appId, appSecret, endpoint, request, traceId);
    }

    // ================== 视频短信（RCS）业务 ==================

    /**
     * 新增视频模板。
     */
    public RcsSmsTemplateAddResponse addVideoTemplate(String appId, String appSecret, RcsSmsTemplateAddRequest request) throws CloudSdkException {
        return rcsSmsClient.addVideoTemplate(appId, appSecret, request);
    }

    /**
     * 新增视频模板，支持自定义链路追踪 ID。
     */
    public RcsSmsTemplateAddResponse addVideoTemplate(String appId, String appSecret, RcsSmsTemplateAddRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.addVideoTemplate(appId, appSecret, request, traceId);
    }

    /**
     * 查询视频模板。
     */
    public RcsSmsTemplateFindResponse findVideoTemplate(String appId, String appSecret, RcsSmsTemplateFindRequest request) throws CloudSdkException {
        return rcsSmsClient.findVideoTemplate(appId, appSecret, request);
    }

    /**
     * 查询视频模板，支持自定义链路追踪 ID。
     */
    public RcsSmsTemplateFindResponse findVideoTemplate(String appId, String appSecret, RcsSmsTemplateFindRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.findVideoTemplate(appId, appSecret, request, traceId);
    }

    /**
     * 查询视频模板列表。
     */
    public RcsSmsTemplateListResponse listVideoTemplate(String appId, String appSecret, RcsSmsTemplateListRequest request) throws CloudSdkException {
        return rcsSmsClient.listVideoTemplate(appId, appSecret, request);
    }

    /**
     * 查询视频模板列表，支持自定义链路追踪 ID。
     */
    public RcsSmsTemplateListResponse listVideoTemplate(String appId, String appSecret, RcsSmsTemplateListRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.listVideoTemplate(appId, appSecret, request, traceId);
    }

    /**
     * 查询签名列表。
     */
    public RcsSmsSignListResponse listSign(String appId, String appSecret, RcsSmsSignListRequest request) throws CloudSdkException {
        return rcsSmsClient.listSign(appId, appSecret, request);
    }

    /**
     * 查询签名列表，支持自定义链路追踪 ID。
     */
    public RcsSmsSignListResponse listSign(String appId, String appSecret, RcsSmsSignListRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.listSign(appId, appSecret, request, traceId);
    }

    /**
     * 更新视频模板。
     */
    public RcsSmsTemplateUpdateResponse updateVideoTemplate(String appId, String appSecret, RcsSmsTemplateUpdateRequest request) throws CloudSdkException {
        return rcsSmsClient.updateVideoTemplate(appId, appSecret, request);
    }

    /**
     * 更新视频模板，支持自定义链路追踪 ID。
     */
    public RcsSmsTemplateUpdateResponse updateVideoTemplate(String appId, String appSecret, RcsSmsTemplateUpdateRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.updateVideoTemplate(appId, appSecret, request, traceId);
    }

    /**
     * 发送视频短信。
     */
    public RcsSmsTemplateSubmitResponse submitVideoTemplate(String appId, String appSecret, RcsSmsTemplateSubmitRequest request) throws CloudSdkException {
        return rcsSmsClient.submitVideoTemplate(appId, appSecret, request);
    }

    /**
     * 发送视频短信，支持自定义链路追踪 ID。
     */
    public RcsSmsTemplateSubmitResponse submitVideoTemplate(String appId, String appSecret, RcsSmsTemplateSubmitRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.submitVideoTemplate(appId, appSecret, request, traceId);
    }

    /**
     * 拉取状态报告。
     */
    public RcsSmsReportPullResponse pullReport(String appId, String appSecret, RcsSmsReportPullRequest request) throws CloudSdkException {
        return rcsSmsClient.pullReport(appId, appSecret, request);
    }

    /**
     * 拉取状态报告，支持自定义链路追踪 ID。
     */
    public RcsSmsReportPullResponse pullReport(String appId, String appSecret, RcsSmsReportPullRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.pullReport(appId, appSecret, request, traceId);
    }

    /**
     * 拉取上行回复。
     */
    public RcsSmsReplyPullResponse pullReply(String appId, String appSecret, RcsSmsReplyPullRequest request) throws CloudSdkException {
        return rcsSmsClient.pullReply(appId, appSecret, request);
    }

    /**
     * 拉取上行回复，支持自定义链路追踪 ID。
     */
    public RcsSmsReplyPullResponse pullReply(String appId, String appSecret, RcsSmsReplyPullRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.pullReply(appId, appSecret, request, traceId);
    }

    /**
     * 查询余额。
     */
    public RcsSmsBalanceResponse getBalance(String appId, String appSecret, RcsSmsBalanceRequest request) throws CloudSdkException {
        return rcsSmsClient.getBalance(appId, appSecret, request);
    }

    /**
     * 查询余额，支持自定义链路追踪 ID。
     */
    public RcsSmsBalanceResponse getBalance(String appId, String appSecret, RcsSmsBalanceRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.getBalance(appId, appSecret, request, traceId);
    }

    /**
     * 新增签名。
     */
    public RcsSmsSignAddResponse addSign(String appId, String appSecret, RcsSmsSignAddRequest request) throws CloudSdkException {
        return rcsSmsClient.addSign(appId, appSecret, request);
    }

    /**
     * 新增签名，支持自定义链路追踪 ID。
     */
    public RcsSmsSignAddResponse addSign(String appId, String appSecret, RcsSmsSignAddRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.addSign(appId, appSecret, request, traceId);
    }

    /**
     * 更新账户地址。
     */
    public RcsSmsAccountAddressUpdateResponse updateAccountAddress(String appId, String appSecret, RcsSmsAccountAddressUpdateRequest request) throws CloudSdkException {
        return rcsSmsClient.updateAccountAddress(appId, appSecret, request);
    }

    /**
     * 更新账户地址，支持自定义链路追踪 ID。
     */
    public RcsSmsAccountAddressUpdateResponse updateAccountAddress(String appId, String appSecret, RcsSmsAccountAddressUpdateRequest request, String traceId) throws CloudSdkException {
        return rcsSmsClient.updateAccountAddress(appId, appSecret, request, traceId);
    }

    // ================== 实名认证业务 ==================

    /**
     * 身份证二要素核验。
     */
    public IdCardAuthResponse idCardAuth(String appId, String appSecret, IdCardAuthRequest request) throws CloudSdkException {
        return realNameClient.idCardAuth(appId, appSecret, request);
    }

    /**
     * 身份证二要素核验，支持自定义链路追踪 ID。
     */
    public IdCardAuthResponse idCardAuth(String appId, String appSecret, IdCardAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.idCardAuth(appId, appSecret, request, traceId);
    }

    /**
     * 身份证二要素核验 V2（签名版）。
     */
    public IdCardAuthResponse idCardAuthV2(String appId, String appSecret, IdCardAuthV2Request request) throws CloudSdkException {
        return realNameClient.idCardAuthV2(appId, appSecret, request);
    }

    /**
     * 身份证二要素核验 V2（签名版），支持自定义链路追踪 ID。
     */
    public IdCardAuthResponse idCardAuthV2(String appId, String appSecret, IdCardAuthV2Request request, String traceId) throws CloudSdkException {
        return realNameClient.idCardAuthV2(appId, appSecret, request, traceId);
    }

    /**
     * 涉外身份证校验。
     */
    public ForeignIdCardAuthResponse foreignIdCardAuth(String appId, String appSecret, ForeignIdCardAuthRequest request) throws CloudSdkException {
        return realNameClient.foreignIdCardAuth(appId, appSecret, request);
    }

    /**
     * 涉外身份证校验，支持自定义链路追踪 ID。
     */
    public ForeignIdCardAuthResponse foreignIdCardAuth(String appId, String appSecret, ForeignIdCardAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.foreignIdCardAuth(appId, appSecret, request, traceId);
    }

    /**
     * 身份证人像比对 V2.0。
     */
    public IdMatchResponse idMatch(String appId, String appSecret, IdMatchRequest request) throws CloudSdkException {
        return realNameClient.idMatch(appId, appSecret, request);
    }

    /**
     * 身份证人像比对 V2.0，支持自定义链路追踪 ID。
     */
    public IdMatchResponse idMatch(String appId, String appSecret, IdMatchRequest request, String traceId) throws CloudSdkException {
        return realNameClient.idMatch(appId, appSecret, request, traceId);
    }

    /**
     * 涉外身份证核验（人像）。
     */
    public ForeignIdMatchResponse foreignIdMatch(String appId, String appSecret, ForeignIdMatchRequest request) throws CloudSdkException {
        return realNameClient.foreignIdMatch(appId, appSecret, request);
    }

    /**
     * 涉外身份证核验（人像），支持自定义链路追踪 ID。
     */
    public ForeignIdMatchResponse foreignIdMatch(String appId, String appSecret, ForeignIdMatchRequest request, String traceId) throws CloudSdkException {
        return realNameClient.foreignIdMatch(appId, appSecret, request, traceId);
    }

    /**
     * 运营商二要素核验。
     */
    public CarriersTwoAuthResponse carriersTwoAuth(String appId, String appSecret, CarriersTwoAuthRequest request) throws CloudSdkException {
        return realNameClient.carriersTwoAuth(appId, appSecret, request);
    }

    /**
     * 运营商二要素核验，支持自定义链路追踪 ID。
     */
    public CarriersTwoAuthResponse carriersTwoAuth(String appId, String appSecret, CarriersTwoAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.carriersTwoAuth(appId, appSecret, request, traceId);
    }

    /**
     * 运营商二要素（身份证版）核验。
     */
    public CarriersTwoAuthIdNumResponse carriersTwoAuthIdNum(String appId, String appSecret, CarriersTwoAuthIdNumRequest request) throws CloudSdkException {
        return realNameClient.carriersTwoAuthIdNum(appId, appSecret, request);
    }

    /**
     * 运营商二要素（身份证版）核验，支持自定义链路追踪 ID。
     */
    public CarriersTwoAuthIdNumResponse carriersTwoAuthIdNum(String appId, String appSecret, CarriersTwoAuthIdNumRequest request, String traceId) throws CloudSdkException {
        return realNameClient.carriersTwoAuthIdNum(appId, appSecret, request, traceId);
    }

    /**
     * 运营商二要素 MD5 核验。
     */
    public CarriersTwoAuthResponse carriersTwoAuthMd5(String appId, String appSecret, CarriersTwoAuthMd5Request request) throws CloudSdkException {
        return realNameClient.carriersTwoAuthMd5(appId, appSecret, request);
    }

    /**
     * 运营商三要素核验。
     */
    public CarriersAuthResponse carriersAuth(String appId, String appSecret, CarriersAuthRequest request) throws CloudSdkException {
        return realNameClient.carriersAuth(appId, appSecret, request);
    }

    /**
     * 运营商三要素核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthResponse carriersAuth(String appId, String appSecret, CarriersAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.carriersAuth(appId, appSecret, request, traceId);
    }

    /**
     * 运营商三要素 MD5 核验。
     */
    public CarriersAuthMd5Response carriersAuthMd5(String appId, String appSecret, CarriersAuthMd5Request request) throws CloudSdkException {
        return realNameClient.carriersAuthMd5(appId, appSecret, request);
    }

    /**
     * 运营商三要素 MD5 核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthMd5Response carriersAuthMd5(String appId, String appSecret, CarriersAuthMd5Request request, String traceId) throws CloudSdkException {
        return realNameClient.carriersAuthMd5(appId, appSecret, request, traceId);
    }

    /**
     * 运营商三要素详细版核验。
     */
    public CarriersAuthDetailResponse carriersAuthDetail(String appId, String appSecret, CarriersAuthRequest request) throws CloudSdkException {
        return realNameClient.carriersAuthDetail(appId, appSecret, request);
    }

    /**
     * 运营商三要素详细版核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthDetailResponse carriersAuthDetail(String appId, String appSecret, CarriersAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.carriersAuthDetail(appId, appSecret, request, traceId);
    }

    /**
     * 运营商三要素详细版 MD5 核验。
     */
    public CarriersAuthDetailMd5Response carriersAuthDetailMd5(String appId, String appSecret, CarriersAuthDetailMd5Request request) throws CloudSdkException {
        return realNameClient.carriersAuthDetailMd5(appId, appSecret, request);
    }

    /**
     * 运营商三要素详细版 MD5 核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthDetailMd5Response carriersAuthDetailMd5(String appId, String appSecret, CarriersAuthDetailMd5Request request, String traceId) throws CloudSdkException {
        return realNameClient.carriersAuthDetailMd5(appId, appSecret, request, traceId);
    }

    /**
     * 运营商三要素详细版 SHA256 核验。
     */
    public CarriersAuthDetailSha256Response carriersAuthDetailSha256(String appId, String appSecret, CarriersAuthDetailSha256Request request) throws CloudSdkException {
        return realNameClient.carriersAuthDetailSha256(appId, appSecret, request);
    }

    /**
     * 运营商三要素详细版 SHA256 核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthDetailSha256Response carriersAuthDetailSha256(String appId, String appSecret, CarriersAuthDetailSha256Request request, String traceId) throws CloudSdkException {
        return realNameClient.carriersAuthDetailSha256(appId, appSecret, request, traceId);
    }

    /**
     * 运营商三要素 SHA256 核验。
     */
    public CarriersAuthSha256Response carriersAuthSha256(String appId, String appSecret, CarriersAuthSha256Request request) throws CloudSdkException {
        return realNameClient.carriersAuthSha256(appId, appSecret, request);
    }

    /**
     * 运营商三要素 SHA256 核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthSha256Response carriersAuthSha256(String appId, String appSecret, CarriersAuthSha256Request request, String traceId) throws CloudSdkException {
        return realNameClient.carriersAuthSha256(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡二要素标准版核验。
     */
    public BankCardTwoAuthResponse bankCardTwoAuth(String appId, String appSecret, BankCardTwoAuthRequest request) throws CloudSdkException {
        return realNameClient.bankCardTwoAuth(appId, appSecret, request);
    }

    /**
     * 银行卡二要素标准版核验，支持自定义链路追踪 ID。
     */
    public BankCardTwoAuthResponse bankCardTwoAuth(String appId, String appSecret, BankCardTwoAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardTwoAuth(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡三要素标准版核验。
     */
    public BankCardThreeAuthResponse bankCardThreeAuth(String appId, String appSecret, BankCardThreeAuthRequest request) throws CloudSdkException {
        return realNameClient.bankCardThreeAuth(appId, appSecret, request);
    }

    /**
     * 银行卡三要素标准版核验，支持自定义链路追踪 ID。
     */
    public BankCardThreeAuthResponse bankCardThreeAuth(String appId, String appSecret, BankCardThreeAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardThreeAuth(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡三要素多证件版核验。
     */
    public BankCardThreeAuthTypeResponse bankCardThreeAuthType(String appId, String appSecret, BankCardThreeAuthTypeRequest request) throws CloudSdkException {
        return realNameClient.bankCardThreeAuthType(appId, appSecret, request);
    }

    /**
     * 银行卡三要素多证件版核验，支持自定义链路追踪 ID。
     */
    public BankCardThreeAuthTypeResponse bankCardThreeAuthType(String appId, String appSecret, BankCardThreeAuthTypeRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardThreeAuthType(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡三要素详细版核验。
     */
    public BankCardThreeAuthDetailResponse bankCardThreeAuthDetail(String appId, String appSecret, BankCardThreeAuthRequest request) throws CloudSdkException {
        return realNameClient.bankCardThreeAuthDetail(appId, appSecret, request);
    }

    /**
     * 银行卡三要素详细版核验，支持自定义链路追踪 ID。
     */
    public BankCardThreeAuthDetailResponse bankCardThreeAuthDetail(String appId, String appSecret, BankCardThreeAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardThreeAuthDetail(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡三要素精准版非身份证核验。
     */
    public BankCardThreeAuthPrecisionResponse bankCardThreeAuthPrecision(String appId, String appSecret, BankCardThreeAuthPrecisionRequest request) throws CloudSdkException {
        return realNameClient.bankCardThreeAuthPrecision(appId, appSecret, request);
    }

    /**
     * 银行卡三要素精准版非身份证核验，支持自定义链路追踪 ID。
     */
    public BankCardThreeAuthPrecisionResponse bankCardThreeAuthPrecision(String appId, String appSecret, BankCardThreeAuthPrecisionRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardThreeAuthPrecision(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡四要素标准版核验。
     */
    public BankCardFourAuthResponse bankCardFourAuth(String appId, String appSecret, BankCardFourAuthRequest request) throws CloudSdkException {
        return realNameClient.bankCardFourAuth(appId, appSecret, request);
    }

    /**
     * 银行卡四要素标准版核验，支持自定义链路追踪 ID。
     */
    public BankCardFourAuthResponse bankCardFourAuth(String appId, String appSecret, BankCardFourAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardFourAuth(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡四要素简版加密核验。
     */
    public BankCardFourSecretResponse bankCardFourSecret(String appId, String appSecret, BankCardFourSecretRequest request) throws CloudSdkException {
        return realNameClient.bankCardFourSecret(appId, appSecret, request);
    }

    /**
     * 银行卡四要素简版加密核验，支持自定义链路追踪 ID。
     */
    public BankCardFourSecretResponse bankCardFourSecret(String appId, String appSecret, BankCardFourSecretRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardFourSecret(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡四要素详细版核验。
     */
    public BankCardFourAuthDetailResponse bankCardFourAuthDetail(String appId, String appSecret, BankCardFourAuthDetailRequest request) throws CloudSdkException {
        return realNameClient.bankCardFourAuthDetail(appId, appSecret, request);
    }

    /**
     * 银行卡四要素详细版核验，支持自定义链路追踪 ID。
     */
    public BankCardFourAuthDetailResponse bankCardFourAuthDetail(String appId, String appSecret, BankCardFourAuthDetailRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardFourAuthDetail(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡四要素多证件版核验。
     */
    public BankCardFourAuthTypeResponse bankCardFourAuthType(String appId, String appSecret, BankCardFourAuthTypeRequest request) throws CloudSdkException {
        return realNameClient.bankCardFourAuthType(appId, appSecret, request);
    }

    /**
     * 银行卡四要素多证件版核验，支持自定义链路追踪 ID。
     */
    public BankCardFourAuthTypeResponse bankCardFourAuthType(String appId, String appSecret, BankCardFourAuthTypeRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardFourAuthType(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡四要素精准版非身份证核验。
     */
    public BankCardFourAuthPrecisionResponse bankCardFourAuthPrecision(String appId, String appSecret, BankCardFourAuthPrecisionRequest request) throws CloudSdkException {
        return realNameClient.bankCardFourAuthPrecision(appId, appSecret, request);
    }

    /**
     * 银行卡四要素精准版非身份证核验，支持自定义链路追踪 ID。
     */
    public BankCardFourAuthPrecisionResponse bankCardFourAuthPrecision(String appId, String appSecret, BankCardFourAuthPrecisionRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardFourAuthPrecision(appId, appSecret, request, traceId);
    }

    /**
     * 银行卡五要素标准版核验。
     */
    public BankCardFiveAuthResponse bankCardFiveAuth(String appId, String appSecret, BankCardFiveAuthRequest request) throws CloudSdkException {
        return realNameClient.bankCardFiveAuth(appId, appSecret, request);
    }

    /**
     * 银行卡五要素标准版核验，支持自定义链路追踪 ID。
     */
    public BankCardFiveAuthResponse bankCardFiveAuth(String appId, String appSecret, BankCardFiveAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.bankCardFiveAuth(appId, appSecret, request, traceId);
    }

    /**
     * IP 归属地查询。
     */
    public IpGsdQueryResponse ipGsdQuery(String appId, String appSecret, IpGsdQueryRequest request) throws CloudSdkException {
        return realNameClient.ipGsdQuery(appId, appSecret, request);
    }

    /**
     * IP 归属地查询，支持自定义链路追踪 ID。
     */
    public IpGsdQueryResponse ipGsdQuery(String appId, String appSecret, IpGsdQueryRequest request, String traceId) throws CloudSdkException {
        return realNameClient.ipGsdQuery(appId, appSecret, request, traceId);
    }

    /**
     * 企业四要素核验。
     */
    public EnterpriseFourAuthResponse enterpriseFourAuth(String appId, String appSecret, EnterpriseFourAuthRequest request) throws CloudSdkException {
        return realNameClient.enterpriseFourAuth(appId, appSecret, request);
    }

    /**
     * 企业四要素核验，支持自定义链路追踪 ID。
     */
    public EnterpriseFourAuthResponse enterpriseFourAuth(String appId, String appSecret, EnterpriseFourAuthRequest request, String traceId) throws CloudSdkException {
        return realNameClient.enterpriseFourAuth(appId, appSecret, request, traceId);
    }

    // ================== 业务线（business） ==================

    /**
     * IP 归属地查询 V4。
     */
    public IpAddressOriginV4Response ipAddressOriginV4(String appId, String appSecret, IpAddressOriginV4Request request) throws CloudSdkException {
        return businessClient.ipAddressOriginV4(appId, appSecret, request);
    }

    /**
     * IP 归属地查询 V4，支持自定义链路追踪 ID。
     */
    public IpAddressOriginV4Response ipAddressOriginV4(String appId, String appSecret, IpAddressOriginV4Request request, String traceId) throws CloudSdkException {
        return businessClient.ipAddressOriginV4(appId, appSecret, request, traceId);
    }

    /**
     * IP 归属地查询 V6。
     */
    public IpAddressOriginV6Response ipAddressOriginV6(String appId, String appSecret, IpAddressOriginV6Request request) throws CloudSdkException {
        return businessClient.ipAddressOriginV6(appId, appSecret, request);
    }

    /**
     * IP 归属地查询 V6，支持自定义链路追踪 ID。
     */
    public IpAddressOriginV6Response ipAddressOriginV6(String appId, String appSecret, IpAddressOriginV6Request request, String traceId) throws CloudSdkException {
        return businessClient.ipAddressOriginV6(appId, appSecret, request, traceId);
    }

    /**
     * IP 风险画像。
     */
    public IpRiskPortraitResponse ipRiskPortrait(String appId, String appSecret, IpRiskPortraitRequest request) throws CloudSdkException {
        return businessClient.ipRiskPortrait(appId, appSecret, request);
    }

    /**
     * IP 风险画像，支持自定义链路追踪 ID。
     */
    public IpRiskPortraitResponse ipRiskPortrait(String appId, String appSecret, IpRiskPortraitRequest request, String traceId) throws CloudSdkException {
        return businessClient.ipRiskPortrait(appId, appSecret, request, traceId);
    }

    /**
     * IP 真人识别。
     */
    public IpFacialRecognitionResponse ipFacialRecognition(String appId, String appSecret, IpFacialRecognitionRequest request) throws CloudSdkException {
        return businessClient.ipFacialRecognition(appId, appSecret, request);
    }

    /**
     * IP 真人识别，支持自定义链路追踪 ID。
     */
    public IpFacialRecognitionResponse ipFacialRecognition(String appId, String appSecret, IpFacialRecognitionRequest request, String traceId) throws CloudSdkException {
        return businessClient.ipFacialRecognition(appId, appSecret, request, traceId);
    }

    /**
     * IP 应用场景识别。
     */
    public IpApplicationScenariosResponse ipApplicationScenarios(String appId, String appSecret, IpApplicationScenariosRequest request) throws CloudSdkException {
        return businessClient.ipApplicationScenarios(appId, appSecret, request);
    }

    /**
     * IP 应用场景识别，支持自定义链路追踪 ID。
     */
    public IpApplicationScenariosResponse ipApplicationScenarios(String appId, String appSecret, IpApplicationScenariosRequest request, String traceId) throws CloudSdkException {
        return businessClient.ipApplicationScenarios(appId, appSecret, request, traceId);
    }

    /**
     * IP 代理识别。
     */
    public IpProxyIdentificationResponse ipProxyIdentification(String appId, String appSecret, IpProxyIdentificationRequest request) throws CloudSdkException {
        return businessClient.ipProxyIdentification(appId, appSecret, request);
    }

    /**
     * IP 代理识别，支持自定义链路追踪 ID。
     */
    public IpProxyIdentificationResponse ipProxyIdentification(String appId, String appSecret, IpProxyIdentificationRequest request, String traceId) throws CloudSdkException {
        return businessClient.ipProxyIdentification(appId, appSecret, request, traceId);
    }

    /**
     * IP 宿主信息。
     */
    public IpHostInformationResponse ipHostInformation(String appId, String appSecret, IpHostInformationRequest request) throws CloudSdkException {
        return businessClient.ipHostInformation(appId, appSecret, request);
    }

    /**
     * IP 宿主信息，支持自定义链路追踪 ID。
     */
    public IpHostInformationResponse ipHostInformation(String appId, String appSecret, IpHostInformationRequest request, String traceId) throws CloudSdkException {
        return businessClient.ipHostInformation(appId, appSecret, request, traceId);
    }

    /**
     * 企业二要素核验。
     */
    public EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(String appId, String appSecret, EnterpriseTwoElementsCheckRequest request) throws CloudSdkException {
        return businessClient.enterpriseTwoElementsCheck(appId, appSecret, request);
    }

    /**
     * 企业二要素核验，支持自定义链路追踪 ID。
     */
    public EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(String appId, String appSecret, EnterpriseTwoElementsCheckRequest request, String traceId) throws CloudSdkException {
        return businessClient.enterpriseTwoElementsCheck(appId, appSecret, request, traceId);
    }

    /**
     * 企业三要素核验。
     */
    public EnterpriseThreeAuthResponse enterpriseThreeAuth(String appId, String appSecret, EnterpriseThreeAuthRequest request) throws CloudSdkException {
        return businessClient.enterpriseThreeAuth(appId, appSecret, request);
    }

    /**
     * 企业三要素核验，支持自定义链路追踪 ID。
     */
    public EnterpriseThreeAuthResponse enterpriseThreeAuth(String appId, String appSecret, EnterpriseThreeAuthRequest request, String traceId) throws CloudSdkException {
        return businessClient.enterpriseThreeAuth(appId, appSecret, request, traceId);
    }

    /**
     * 企业工商模糊查询。
     */
    public EnterpriseQueryResponse enterpriseQuery(String appId, String appSecret, EnterpriseQueryRequest request) throws CloudSdkException {
        return businessClient.enterpriseQuery(appId, appSecret, request);
    }

    /**
     * 企业工商模糊查询，支持自定义链路追踪 ID。
     */
    public EnterpriseQueryResponse enterpriseQuery(String appId, String appSecret, EnterpriseQueryRequest request, String traceId) throws CloudSdkException {
        return businessClient.enterpriseQuery(appId, appSecret, request, traceId);
    }

    /**
     * 企业工商信息查询（简项）。
     */
    public EnterpriseSimpleResponse enterpriseSimple(String appId, String appSecret, EnterpriseSimpleRequest request) throws CloudSdkException {
        return businessClient.enterpriseSimple(appId, appSecret, request);
    }

    /**
     * 企业工商信息查询（简项），支持自定义链路追踪 ID。
     */
    public EnterpriseSimpleResponse enterpriseSimple(String appId, String appSecret, EnterpriseSimpleRequest request, String traceId) throws CloudSdkException {
        return businessClient.enterpriseSimple(appId, appSecret, request, traceId);
    }

    /**
     * 经营异常查询。
     */
    public AbnormalOperationResponse abnormalOperation(String appId, String appSecret, AbnormalOperationRequest request) throws CloudSdkException {
        return businessClient.abnormalOperation(appId, appSecret, request);
    }

    /**
     * 经营异常查询，支持自定义链路追踪 ID。
     */
    public AbnormalOperationResponse abnormalOperation(String appId, String appSecret, AbnormalOperationRequest request, String traceId) throws CloudSdkException {
        return businessClient.abnormalOperation(appId, appSecret, request, traceId);
    }

    /**
     * 工商行政处罚查询。
     */
    public AdministrativeSanctionQueryResponse administrativeSanctionQuery(String appId, String appSecret, AdministrativeSanctionQueryRequest request) throws CloudSdkException {
        return businessClient.administrativeSanctionQuery(appId, appSecret, request);
    }

    /**
     * 工商行政处罚查询，支持自定义链路追踪 ID。
     */
    public AdministrativeSanctionQueryResponse administrativeSanctionQuery(String appId, String appSecret, AdministrativeSanctionQueryRequest request, String traceId) throws CloudSdkException {
        return businessClient.administrativeSanctionQuery(appId, appSecret, request, traceId);
    }

    /**
     * 企业司法涉诉查询。
     */
    public JusticeComplainResponse justiceComplain(String appId, String appSecret, JusticeComplainRequest request) throws CloudSdkException {
        return businessClient.justiceComplain(appId, appSecret, request);
    }

    /**
     * 企业司法涉诉查询，支持自定义链路追踪 ID。
     */
    public JusticeComplainResponse justiceComplain(String appId, String appSecret, JusticeComplainRequest request, String traceId) throws CloudSdkException {
        return businessClient.justiceComplain(appId, appSecret, request, traceId);
    }

    /**
     * 企业大中小微划型服务。
     */
    public CompanyLevelResponse companyLevel(String appId, String appSecret, CompanyLevelRequest request) throws CloudSdkException {
        return businessClient.companyLevel(appId, appSecret, request);
    }

    /**
     * 企业大中小微划型服务，支持自定义链路追踪 ID。
     */
    public CompanyLevelResponse companyLevel(String appId, String appSecret, CompanyLevelRequest request, String traceId) throws CloudSdkException {
        return businessClient.companyLevel(appId, appSecret, request, traceId);
    }

    /**
     * 企业招投标查询（翻页）。
     */
    public EnterpriseBiddingResponse enterpriseBidding(String appId, String appSecret, EnterpriseBiddingRequest request) throws CloudSdkException {
        return businessClient.enterpriseBidding(appId, appSecret, request);
    }

    /**
     * 企业招投标查询（翻页），支持自定义链路追踪 ID。
     */
    public EnterpriseBiddingResponse enterpriseBidding(String appId, String appSecret, EnterpriseBiddingRequest request, String traceId) throws CloudSdkException {
        return businessClient.enterpriseBidding(appId, appSecret, request, traceId);
    }

    /**
     * 企业欠税公告查询。
     */
    public EnterpriseOwnTaxResponse enterpriseOwnTax(String appId, String appSecret, EnterpriseOwnTaxRequest request) throws CloudSdkException {
        return businessClient.enterpriseOwnTax(appId, appSecret, request);
    }

    /**
     * 企业欠税公告查询，支持自定义链路追踪 ID。
     */
    public EnterpriseOwnTaxResponse enterpriseOwnTax(String appId, String appSecret, EnterpriseOwnTaxRequest request, String traceId) throws CloudSdkException {
        return businessClient.enterpriseOwnTax(appId, appSecret, request, traceId);
    }

    /**
     * 静态活体检测。
     */
    public FaceCheckResponse faceCheck(String appId, String appSecret, FaceCheckRequest request) throws CloudSdkException {
        return businessClient.faceCheck(appId, appSecret, request);
    }

    /**
     * 静态活体检测，支持自定义链路追踪 ID。
     */
    public FaceCheckResponse faceCheck(String appId, String appSecret, FaceCheckRequest request, String traceId) throws CloudSdkException {
        return businessClient.faceCheck(appId, appSecret, request, traceId);
    }

    /**
     * 动态活体检测。
     */
    public LifeCheckResponse lifeCheck(String appId, String appSecret, LifeCheckRequest request) throws CloudSdkException {
        return businessClient.lifeCheck(appId, appSecret, request);
    }

    /**
     * 动态活体检测，支持自定义链路追踪 ID。
     */
    public LifeCheckResponse lifeCheck(String appId, String appSecret, LifeCheckRequest request, String traceId) throws CloudSdkException {
        return businessClient.lifeCheck(appId, appSecret, request, traceId);
    }

    /**
     * 身份证 OCR 识别。
     */
    public IdOcrResponse idOcr(String appId, String appSecret, IdOcrRequest request) throws CloudSdkException {
        return businessClient.idOcr(appId, appSecret, request);
    }

    /**
     * 身份证 OCR 识别，支持自定义链路追踪 ID。
     */
    public IdOcrResponse idOcr(String appId, String appSecret, IdOcrRequest request, String traceId) throws CloudSdkException {
        return businessClient.idOcr(appId, appSecret, request, traceId);
    }

    /**
     * 身份证 OCR V2 识别（自动识别正反面）。
     */
    public IdOcrV2Response idOcrV2(String appId, String appSecret, IdOcrV2Request request) throws CloudSdkException {
        return businessClient.idOcrV2(appId, appSecret, request);
    }

    /**
     * 身份证 OCR V2 识别（自动识别正反面），支持自定义链路追踪 ID。
     */
    public IdOcrV2Response idOcrV2(String appId, String appSecret, IdOcrV2Request request, String traceId) throws CloudSdkException {
        return businessClient.idOcrV2(appId, appSecret, request, traceId);
    }

    /**
     * 行驶证 OCR 识别。
     */
    public VehicleLicenseResponse vehicleLicense(String appId, String appSecret, VehicleLicenseRequest request) throws CloudSdkException {
        return businessClient.vehicleLicense(appId, appSecret, request);
    }

    /**
     * 行驶证 OCR 识别，支持自定义链路追踪 ID。
     */
    public VehicleLicenseResponse vehicleLicense(String appId, String appSecret, VehicleLicenseRequest request, String traceId) throws CloudSdkException {
        return businessClient.vehicleLicense(appId, appSecret, request, traceId);
    }

    /**
     * 获取业务线 Client 实例，后续业务接口通过此实例调用。
     */
    public BusinessClient businessClient() {
        return businessClient;
    }

    /**
     * 释放底层所有 HttpTransport 资源（OkHttp 连接池 + Dispatcher 线程池）。
     *
     * <p>建议在 Spring Bean 销毁、应用关闭、热部署等场景调用，或直接使用 try-with-resources：
     * <pre>{@code
     * try (CloudApiClient client = new CloudApiClient(config)) {
     *     client.smsBatchSend(...);
     * }
     * }</pre>
     */
    @Override
    public void close() {
        closeQuietly(smsHttpTransport);
        closeQuietly(httpTransport);
    }

    private static void closeQuietly(HttpTransport transport) {
        if (transport == null) {
            return;
        }
        try {
            transport.close();
        } catch (Exception ignored) {
            // 释放资源时忽略异常，避免单个 transport 失败影响其他 transport
        }
    }
}
