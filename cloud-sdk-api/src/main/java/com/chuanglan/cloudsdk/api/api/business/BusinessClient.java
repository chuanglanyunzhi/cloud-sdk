package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.api.api.ApiClient;
import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.HttpTransport;
import com.chuanglan.cloudsdk.core.SyncResponse;

/**
 * 业务线 SDK 入口。
 * 后续新增业务接口按 realName 等业务线模式在此类中添加方法，并通过 CloudApiClient 统一对外暴露。
 */
public class BusinessClient extends ApiClient<BusinessConfig> {

    private static final String IP_ADDRESS_ORIGIN_V4_PATH = "/api/v2/sdk/ipgsdcx/addressOriginV4";

    private static final String IP_ADDRESS_ORIGIN_V6_PATH = "/api/v2/sdk/ipgsdcx/addressOriginV6";

    private static final String IP_RISK_PORTRAIT_PATH = "/api/v2/sdk/ipgsdcx/riskPortrait";

    private static final String IP_APPLICATION_SCENARIOS_PATH = "/api/v2/sdk/ipgsdcx/applicationScenarios";

    private static final String IP_PROXY_IDENTIFICATION_PATH = "/api/v2/sdk/ipgsdcx/proxyIdentification";

    private static final String IP_HOST_INFORMATION_PATH = "/api/v2/sdk/ipgsdcx/hostInformation";

    private static final String IP_FACIAL_RECOGNITION_PATH = "/api/v2/sdk/ipgsdcx/facialRecognition";

    private static final String ENTERPRISE_TWO_ELEMENTS_CHECK_PATH = "/api/v2/sdk/dynamic2/gsxx/twoElementsCheck";

    private static final String ENTERPRISE_THREE_AUTH_PATH = "/api/v2/sdk/gsxx/business-three-auth";

    private static final String ENTERPRISE_QUERY_PATH = "/api/v2/sdk/gsxx/enterpriseQuery";

    private static final String ENTERPRISE_SIMPLE_PATH = "/api/v2/sdk/gsxx/enterpriseSimple";

    private static final String ENTERPRISE_BIDDING_PATH = "/api/v2/sdk/gsxx/enterpriseBidding";

    private static final String ABNORMAL_OPERATION_PATH = "/api/v2/sdk/gsxx/abnormalOperation";

    private static final String ADMINISTRATIVE_SANCTION_QUERY_PATH = "/api/v2/sdk/gsxx/administrativeSanctionQuery";

    private static final String JUSTICE_COMPLAIN_PATH = "/api/v2/sdk/gsxx/justiceComplain";

    private static final String COMPANY_LEVEL_PATH = "/api/v2/sdk/gsxx/companyLevel";

    private static final String ENTERPRISE_OWN_TAX_PATH = "/api/v2/sdk/gsxx/enterpriseOwnTax";

    private static final String FACE_CHECK_PATH = "/api/v2/sdk/witness/face-check";

    private static final String LIFE_CHECK_PATH = "/api/v2/sdk/htjc/lifecheck";

    private static final String ID_OCR_PATH = "/api/v2/sdk/ocr/id-ocr-cl";

    private static final String ID_OCR_V2_PATH = "/api/v2/sdk/ocr/id-ocrV2";

    private static final String VEHICLE_LICENSE_PATH = "/api/v2/sdk/ocr/vehicle-license";

    private static final String DRIVING_LICENSE_PATH = "/api/v2/sdk/ocr/driving-license";

    private static final String BANKCARD_PATH = "/api/v2/sdk/ocr/bankcard";

    private static final String DRIVING_LICENSE_OCR_V2_PATH = "/api/v2/sdk/ocr/driving-licenseV2";

    private static final String VEHICLE_PLATE_OCR_PATH = "/api/v2/sdk/ocr/vehiclePlateNo";

    private static final String BUSINESS_LICENSE_PATH = "/api/v2/sdk/ocr/business-license";

    private static final String TABLE_OCR_PATH = "/api/v2/sdk/ocr/tableOcr";

    private static final String INVOICE_OCR_PATH = "/api/v2/sdk/ocr/invoiceOcr";

    private static final String VEHICLE_LICENSE_OCR_V2_PATH = "/api/v2/sdk/ocr/vehicle-licenseV2";

    public BusinessClient(BusinessConfig config) {
        super(config);
    }

    public BusinessClient(BusinessConfig config, HttpTransport httpTransport) {
        super(config, httpTransport);
    }

    /**
     * IP 归属地查询 V4。
     */
    public IpAddressOriginV4Response ipAddressOriginV4(String appId, String appSecret, IpAddressOriginV4Request request) throws CloudSdkException {
        return ipAddressOriginV4(appId, appSecret, request, null);
    }

    /**
     * IP 归属地查询 V4，支持自定义链路追踪 ID。
     */
    public IpAddressOriginV4Response ipAddressOriginV4(String appId, String appSecret, IpAddressOriginV4Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IpAddressOriginV4Request 不能为空", null, 0);
        }
        if (request.ip == null || request.ip.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "ip 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + IP_ADDRESS_ORIGIN_V4_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IpAddressOriginV4Response.class);
    }

    /**
     * IP 归属地查询 V6。
     */
    public IpAddressOriginV6Response ipAddressOriginV6(String appId, String appSecret, IpAddressOriginV6Request request) throws CloudSdkException {
        return ipAddressOriginV6(appId, appSecret, request, null);
    }

    /**
     * IP 归属地查询 V6，支持自定义链路追踪 ID。
     */
    public IpAddressOriginV6Response ipAddressOriginV6(String appId, String appSecret, IpAddressOriginV6Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IpAddressOriginV6Request 不能为空", null, 0);
        }
        if (request.ip == null || request.ip.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "ip 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + IP_ADDRESS_ORIGIN_V6_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IpAddressOriginV6Response.class);
    }

    /**
     * IP 风险画像。
     */
    public IpRiskPortraitResponse ipRiskPortrait(String appId, String appSecret, IpRiskPortraitRequest request) throws CloudSdkException {
        return ipRiskPortrait(appId, appSecret, request, null);
    }

    /**
     * IP 风险画像，支持自定义链路追踪 ID。
     */
    public IpRiskPortraitResponse ipRiskPortrait(String appId, String appSecret, IpRiskPortraitRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IpRiskPortraitRequest 不能为空", null, 0);
        }
        if (request.ip == null || request.ip.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "ip 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + IP_RISK_PORTRAIT_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IpRiskPortraitResponse.class);
    }

    /**
     * IP 真人识别。
     */
    public IpFacialRecognitionResponse ipFacialRecognition(String appId, String appSecret, IpFacialRecognitionRequest request) throws CloudSdkException {
        return ipFacialRecognition(appId, appSecret, request, null);
    }

    /**
     * IP 真人识别，支持自定义链路追踪 ID。
     */
    public IpFacialRecognitionResponse ipFacialRecognition(String appId, String appSecret, IpFacialRecognitionRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IpFacialRecognitionRequest 不能为空", null, 0);
        }
        if (request.ip == null || request.ip.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "ip 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + IP_FACIAL_RECOGNITION_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IpFacialRecognitionResponse.class);
    }

    /**
     * IP 应用场景识别。
     */
    public IpApplicationScenariosResponse ipApplicationScenarios(String appId, String appSecret, IpApplicationScenariosRequest request) throws CloudSdkException {
        return ipApplicationScenarios(appId, appSecret, request, null);
    }

    /**
     * IP 应用场景识别，支持自定义链路追踪 ID。
     */
    public IpApplicationScenariosResponse ipApplicationScenarios(String appId, String appSecret, IpApplicationScenariosRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IpApplicationScenariosRequest 不能为空", null, 0);
        }
        if (request.ip == null || request.ip.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "ip 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + IP_APPLICATION_SCENARIOS_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IpApplicationScenariosResponse.class);
    }

    /**
     * IP 代理识别。
     */
    public IpProxyIdentificationResponse ipProxyIdentification(String appId, String appSecret, IpProxyIdentificationRequest request) throws CloudSdkException {
        return ipProxyIdentification(appId, appSecret, request, null);
    }

    /**
     * IP 代理识别，支持自定义链路追踪 ID。
     */
    public IpProxyIdentificationResponse ipProxyIdentification(String appId, String appSecret, IpProxyIdentificationRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IpProxyIdentificationRequest 不能为空", null, 0);
        }
        if (request.ip == null || request.ip.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "ip 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + IP_PROXY_IDENTIFICATION_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IpProxyIdentificationResponse.class);
    }

    /**
     * IP 宿主信息。
     */
    public IpHostInformationResponse ipHostInformation(String appId, String appSecret, IpHostInformationRequest request) throws CloudSdkException {
        return ipHostInformation(appId, appSecret, request, null);
    }

    /**
     * IP 宿主信息，支持自定义链路追踪 ID。
     */
    public IpHostInformationResponse ipHostInformation(String appId, String appSecret, IpHostInformationRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IpHostInformationRequest 不能为空", null, 0);
        }
        if (request.ip == null || request.ip.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "ip 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + IP_HOST_INFORMATION_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IpHostInformationResponse.class);
    }

    /**
     * 企业二要素核验。
     */
    public EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(String appId, String appSecret, EnterpriseTwoElementsCheckRequest request) throws CloudSdkException {
        return enterpriseTwoElementsCheck(appId, appSecret, request, null);
    }

    /**
     * 企业二要素核验，支持自定义链路追踪 ID。
     */
    public EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(String appId, String appSecret, EnterpriseTwoElementsCheckRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "EnterpriseTwoElementsCheckRequest 不能为空", null, 0);
        }
        if (request.credit_code == null || request.credit_code.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "credit_code 不能为空", null, 0);
        }
        if (request.ent_name == null || request.ent_name.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "ent_name 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + ENTERPRISE_TWO_ELEMENTS_CHECK_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), EnterpriseTwoElementsCheckResponse.class);
    }

    /**
     * 企业三要素核验。
     */
    public EnterpriseThreeAuthResponse enterpriseThreeAuth(String appId, String appSecret, EnterpriseThreeAuthRequest request) throws CloudSdkException {
        return enterpriseThreeAuth(appId, appSecret, request, null);
    }

    /**
     * 企业三要素核验，支持自定义链路追踪 ID。
     */
    public EnterpriseThreeAuthResponse enterpriseThreeAuth(String appId, String appSecret, EnterpriseThreeAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "EnterpriseThreeAuthRequest 不能为空", null, 0);
        }
        if (request.entName == null || request.entName.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "entName 不能为空", null, 0);
        }
        if (request.legalPerName == null || request.legalPerName.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "legalPerName 不能为空", null, 0);
        }
        if (request.creditCode == null || request.creditCode.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "creditCode 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + ENTERPRISE_THREE_AUTH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), EnterpriseThreeAuthResponse.class);
    }

    /**
     * 企业工商模糊查询。
     */
    public EnterpriseQueryResponse enterpriseQuery(String appId, String appSecret, EnterpriseQueryRequest request) throws CloudSdkException {
        return enterpriseQuery(appId, appSecret, request, null);
    }

    /**
     * 企业工商模糊查询，支持自定义链路追踪 ID。
     */
    public EnterpriseQueryResponse enterpriseQuery(String appId, String appSecret, EnterpriseQueryRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "EnterpriseQueryRequest 不能为空", null, 0);
        }
        if (request.entName == null || request.entName.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "entName 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + ENTERPRISE_QUERY_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), EnterpriseQueryResponse.class);
    }

    /**
     * 企业工商信息查询（简项）。
     */
    public EnterpriseSimpleResponse enterpriseSimple(String appId, String appSecret, EnterpriseSimpleRequest request) throws CloudSdkException {
        return enterpriseSimple(appId, appSecret, request, null);
    }

    /**
     * 企业工商信息查询（简项），支持自定义链路追踪 ID。
     */
    public EnterpriseSimpleResponse enterpriseSimple(String appId, String appSecret, EnterpriseSimpleRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "EnterpriseSimpleRequest 不能为空", null, 0);
        }
        if ((request.entName == null || request.entName.isEmpty())
                && (request.regNo == null || request.regNo.isEmpty())
                && (request.creditCode == null || request.creditCode.isEmpty())
                && (request.orgCode == null || request.orgCode.isEmpty())) {
            throw new CloudSdkException("ParameterMissing", "entName、regNo、creditCode、orgCode 至少填写一个", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + ENTERPRISE_SIMPLE_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), EnterpriseSimpleResponse.class);
    }

    /**
     * 经营异常查询。
     */
    public AbnormalOperationResponse abnormalOperation(String appId, String appSecret, AbnormalOperationRequest request) throws CloudSdkException {
        return abnormalOperation(appId, appSecret, request, null);
    }

    /**
     * 经营异常查询，支持自定义链路追踪 ID。
     */
    public AbnormalOperationResponse abnormalOperation(String appId, String appSecret, AbnormalOperationRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "AbnormalOperationRequest 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + ABNORMAL_OPERATION_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), AbnormalOperationResponse.class);
    }

    /**
     * 工商行政处罚查询。
     */
    public AdministrativeSanctionQueryResponse administrativeSanctionQuery(String appId, String appSecret, AdministrativeSanctionQueryRequest request) throws CloudSdkException {
        return administrativeSanctionQuery(appId, appSecret, request, null);
    }

    /**
     * 工商行政处罚查询，支持自定义链路追踪 ID。
     */
    public AdministrativeSanctionQueryResponse administrativeSanctionQuery(String appId, String appSecret, AdministrativeSanctionQueryRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "AdministrativeSanctionQueryRequest 不能为空", null, 0);
        }
        if ((request.entname == null || request.entname.isEmpty())
                && (request.uniscid == null || request.uniscid.isEmpty())
                && (request.regno == null || request.regno.isEmpty())) {
            throw new CloudSdkException("ParameterMissing", "entname、uniscid、regno 至少填写一个", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + ADMINISTRATIVE_SANCTION_QUERY_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), AdministrativeSanctionQueryResponse.class);
    }

    /**
     * 企业司法涉诉查询。
     */
    public JusticeComplainResponse justiceComplain(String appId, String appSecret, JusticeComplainRequest request) throws CloudSdkException {
        return justiceComplain(appId, appSecret, request, null);
    }

    /**
     * 企业司法涉诉查询，支持自定义链路追踪 ID。
     */
    public JusticeComplainResponse justiceComplain(String appId, String appSecret, JusticeComplainRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "JusticeComplainRequest 不能为空", null, 0);
        }
        if (request.entName == null || request.entName.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "entName 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + JUSTICE_COMPLAIN_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), JusticeComplainResponse.class);
    }

    /**
     * 企业大中小微划型服务。
     */
    public CompanyLevelResponse companyLevel(String appId, String appSecret, CompanyLevelRequest request) throws CloudSdkException {
        return companyLevel(appId, appSecret, request, null);
    }

    /**
     * 企业大中小微划型服务，支持自定义链路追踪 ID。
     */
    public CompanyLevelResponse companyLevel(String appId, String appSecret, CompanyLevelRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "CompanyLevelRequest 不能为空", null, 0);
        }
        if (request.key == null || request.key.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "key 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + COMPANY_LEVEL_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), CompanyLevelResponse.class);
    }

    /**
     * 企业招投标查询（翻页）。
     */
    public EnterpriseBiddingResponse enterpriseBidding(String appId, String appSecret, EnterpriseBiddingRequest request) throws CloudSdkException {
        return enterpriseBidding(appId, appSecret, request, null);
    }

    /**
     * 企业招投标查询（翻页），支持自定义链路追踪 ID。
     */
    public EnterpriseBiddingResponse enterpriseBidding(String appId, String appSecret, EnterpriseBiddingRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "EnterpriseBiddingRequest 不能为空", null, 0);
        }
        if ((request.entname == null || request.entname.isEmpty())
                && (request.regno == null || request.regno.isEmpty())) {
            throw new CloudSdkException("ParameterMissing", "entname、regno 至少填写一个", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + ENTERPRISE_BIDDING_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), EnterpriseBiddingResponse.class);
    }

    /**
     * 企业欠税公告查询。
     */
    public EnterpriseOwnTaxResponse enterpriseOwnTax(String appId, String appSecret, EnterpriseOwnTaxRequest request) throws CloudSdkException {
        return enterpriseOwnTax(appId, appSecret, request, null);
    }

    /**
     * 企业欠税公告查询，支持自定义链路追踪 ID。
     */
    public EnterpriseOwnTaxResponse enterpriseOwnTax(String appId, String appSecret, EnterpriseOwnTaxRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "EnterpriseOwnTaxRequest 不能为空", null, 0);
        }
        if (request.keyword == null || request.keyword.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "keyword 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + ENTERPRISE_OWN_TAX_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), EnterpriseOwnTaxResponse.class);
    }

    /**
     * 静态活体检测。
     */
    public FaceCheckResponse faceCheck(String appId, String appSecret, FaceCheckRequest request) throws CloudSdkException {
        return faceCheck(appId, appSecret, request, null);
    }

    /**
     * 静态活体检测，支持自定义链路追踪 ID。
     */
    public FaceCheckResponse faceCheck(String appId, String appSecret, FaceCheckRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "FaceCheckRequest 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + FACE_CHECK_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), FaceCheckResponse.class);
    }

    /**
     * 动态活体检测。
     */
    public LifeCheckResponse lifeCheck(String appId, String appSecret, LifeCheckRequest request) throws CloudSdkException {
        return lifeCheck(appId, appSecret, request, null);
    }

    /**
     * 动态活体检测，支持自定义链路追踪 ID。
     */
    public LifeCheckResponse lifeCheck(String appId, String appSecret, LifeCheckRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "LifeCheckRequest 不能为空", null, 0);
        }
        if (request.motions == null || request.motions.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "motions 不能为空", null, 0);
        }
        if ((request.file == null || request.file.isEmpty())
                && (request.url == null || request.url.isEmpty())) {
            throw new CloudSdkException("ParameterMissing", "file 和 url 至少填写一个", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + LIFE_CHECK_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), LifeCheckResponse.class);
    }

    /**
     * 身份证 OCR 识别。
     */
    public IdOcrResponse idOcr(String appId, String appSecret, IdOcrRequest request) throws CloudSdkException {
        return idOcr(appId, appSecret, request, null);
    }

    /**
     * 身份证 OCR 识别，支持自定义链路追踪 ID。
     */
    public IdOcrResponse idOcr(String appId, String appSecret, IdOcrRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IdOcrRequest 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.imageType == null || request.imageType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "imageType 不能为空", null, 0);
        }
        if (request.ocrType == null || request.ocrType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "ocrType 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + ID_OCR_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IdOcrResponse.class);
    }

    /**
     * 身份证 OCR V2 识别（自动识别正反面）。
     */
    public IdOcrV2Response idOcrV2(String appId, String appSecret, IdOcrV2Request request) throws CloudSdkException {
        return idOcrV2(appId, appSecret, request, null);
    }

    /**
     * 身份证 OCR V2 识别（自动识别正反面），支持自定义链路追踪 ID。
     */
    public IdOcrV2Response idOcrV2(String appId, String appSecret, IdOcrV2Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IdOcrV2Request 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.imageType == null || request.imageType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "imageType 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + ID_OCR_V2_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IdOcrV2Response.class);
    }

    /**
     * 行驶证 OCR 识别。
     */
    public VehicleLicenseResponse vehicleLicense(String appId, String appSecret, VehicleLicenseRequest request) throws CloudSdkException {
        return vehicleLicense(appId, appSecret, request, null);
    }

    /**
     * 行驶证 OCR 识别，支持自定义链路追踪 ID。
     */
    public VehicleLicenseResponse vehicleLicense(String appId, String appSecret, VehicleLicenseRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "VehicleLicenseRequest 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.imageType == null || request.imageType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "imageType 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + VEHICLE_LICENSE_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), VehicleLicenseResponse.class);
    }

    /**
     * 银行卡 OCR 识别。
     */
    public BankcardResponse bankcard(String appId, String appSecret, BankcardRequest request) throws CloudSdkException {
        return bankcard(appId, appSecret, request, null);
    }

    /**
     * 银行卡 OCR 识别，支持自定义链路追踪 ID。
     */
    public BankcardResponse bankcard(String appId, String appSecret, BankcardRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankcardRequest 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.imageType == null || request.imageType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "imageType 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + BANKCARD_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankcardResponse.class);
    }

    /**
     * 驾驶证 OCR 识别。
     */
    public DrivingLicenseResponse drivingLicense(String appId, String appSecret, DrivingLicenseRequest request) throws CloudSdkException {
        return drivingLicense(appId, appSecret, request, null);
    }

    /**
     * 驾驶证 OCR 识别，支持自定义链路追踪 ID。
     */
    public DrivingLicenseResponse drivingLicense(String appId, String appSecret, DrivingLicenseRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "DrivingLicenseRequest 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.imageType == null || request.imageType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "imageType 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + DRIVING_LICENSE_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), DrivingLicenseResponse.class);
    }

    /**
     * 驾驶证 OCR V2 识别（支持正副页同时识别）。
     */
    public DrivingLicenseOcrV2Response drivingLicenseOcrV2(String appId, String appSecret, DrivingLicenseOcrV2Request request) throws CloudSdkException {
        return drivingLicenseOcrV2(appId, appSecret, request, null);
    }

    /**
     * 驾驶证 OCR V2 识别（支持正副页同时识别），支持自定义链路追踪 ID。
     */
    public DrivingLicenseOcrV2Response drivingLicenseOcrV2(String appId, String appSecret, DrivingLicenseOcrV2Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "DrivingLicenseOcrV2Request 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.imageType == null || request.imageType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "imageType 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + DRIVING_LICENSE_OCR_V2_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), DrivingLicenseOcrV2Response.class);
    }

    /**
     * 车牌 OCR 识别。
     */
    public VehiclePlateOcrResponse vehiclePlateOcr(String appId, String appSecret, VehiclePlateOcrRequest request) throws CloudSdkException {
        return vehiclePlateOcr(appId, appSecret, request, null);
    }

    /**
     * 车牌 OCR 识别，支持自定义链路追踪 ID。
     */
    public VehiclePlateOcrResponse vehiclePlateOcr(String appId, String appSecret, VehiclePlateOcrRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "VehiclePlateOcrRequest 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.imageType == null || request.imageType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "imageType 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + VEHICLE_PLATE_OCR_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), VehiclePlateOcrResponse.class);
    }

    /**
     * 营业执照 OCR 识别。
     */
    public BusinessLicenseResponse businessLicense(String appId, String appSecret, BusinessLicenseRequest request) throws CloudSdkException {
        return businessLicense(appId, appSecret, request, null);
    }

    /**
     * 营业执照 OCR 识别，支持自定义链路追踪 ID。
     */
    public BusinessLicenseResponse businessLicense(String appId, String appSecret, BusinessLicenseRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BusinessLicenseRequest 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.imageType == null || request.imageType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "imageType 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + BUSINESS_LICENSE_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BusinessLicenseResponse.class);
    }

    /**
     * 表格 OCR 识别。
     */
    public TableOcrResponse tableOcr(String appId, String appSecret, TableOcrRequest request) throws CloudSdkException {
        return tableOcr(appId, appSecret, request, null);
    }

    /**
     * 表格 OCR 识别，支持自定义链路追踪 ID。
     */
    public TableOcrResponse tableOcr(String appId, String appSecret, TableOcrRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "TableOcrRequest 不能为空", null, 0);
        }
        if ((request.image == null || request.image.isEmpty())
                && (request.url == null || request.url.isEmpty())) {
            throw new CloudSdkException("ParameterMissing", "image 和 url 至少填写一个", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + TABLE_OCR_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), TableOcrResponse.class);
    }

    /**
     * 发票 OCR 识别。
     */
    public InvoiceOcrResponse invoiceOcr(String appId, String appSecret, InvoiceOcrRequest request) throws CloudSdkException {
        return invoiceOcr(appId, appSecret, request, null);
    }

    /**
     * 发票 OCR 识别，支持自定义链路追踪 ID。
     */
    public InvoiceOcrResponse invoiceOcr(String appId, String appSecret, InvoiceOcrRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "InvoiceOcrRequest 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.imageType == null || request.imageType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "imageType 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + INVOICE_OCR_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), InvoiceOcrResponse.class);
    }

    /**
     * 行驶证 OCR V2 识别（支持正副页同时识别）。
     */
    public VehicleLicenseOcrV2Response vehicleLicenseOcrV2(String appId, String appSecret, VehicleLicenseOcrV2Request request) throws CloudSdkException {
        return vehicleLicenseOcrV2(appId, appSecret, request, null);
    }

    /**
     * 行驶证 OCR V2 识别（支持正副页同时识别），支持自定义链路追踪 ID。
     */
    public VehicleLicenseOcrV2Response vehicleLicenseOcrV2(String appId, String appSecret, VehicleLicenseOcrV2Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "VehicleLicenseOcrV2Request 不能为空", null, 0);
        }
        if (request.image == null || request.image.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.imageType == null || request.imageType.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "imageType 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.endpoint + VEHICLE_LICENSE_OCR_V2_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), VehicleLicenseOcrV2Response.class);
    }
}
