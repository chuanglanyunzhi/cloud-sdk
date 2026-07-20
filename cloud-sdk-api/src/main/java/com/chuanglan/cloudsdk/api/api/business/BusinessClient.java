package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.api.api.ApiClient;
import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.HttpTransport;

/**
 * 业务线 SDK 入口。
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

    // ==================== IP 类接口 ====================

    public IpAddressOriginV4Response ipAddressOriginV4(String appId, String appSecret, IpAddressOriginV4Request request) throws CloudSdkException {
        return ipAddressOriginV4(appId, appSecret, request, null);
    }

    public IpAddressOriginV4Response ipAddressOriginV4(String appId, String appSecret, IpAddressOriginV4Request request, String traceId) throws CloudSdkException {
        requireNonNull(request, "IpAddressOriginV4Request");
        requireNonEmpty(request.getIp(), "ip");
        return call(appId, appSecret, url(IP_ADDRESS_ORIGIN_V4_PATH), request, IpAddressOriginV4Response.class, traceId);
    }

    public IpAddressOriginV6Response ipAddressOriginV6(String appId, String appSecret, IpAddressOriginV6Request request) throws CloudSdkException {
        return ipAddressOriginV6(appId, appSecret, request, null);
    }

    public IpAddressOriginV6Response ipAddressOriginV6(String appId, String appSecret, IpAddressOriginV6Request request, String traceId) throws CloudSdkException {
        requireNonNull(request, "IpAddressOriginV6Request");
        requireNonEmpty(request.getIp(), "ip");
        return call(appId, appSecret, url(IP_ADDRESS_ORIGIN_V6_PATH), request, IpAddressOriginV6Response.class, traceId);
    }

    public IpRiskPortraitResponse ipRiskPortrait(String appId, String appSecret, IpRiskPortraitRequest request) throws CloudSdkException {
        return ipRiskPortrait(appId, appSecret, request, null);
    }

    public IpRiskPortraitResponse ipRiskPortrait(String appId, String appSecret, IpRiskPortraitRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "IpRiskPortraitRequest");
        requireNonEmpty(request.getIp(), "ip");
        return call(appId, appSecret, url(IP_RISK_PORTRAIT_PATH), request, IpRiskPortraitResponse.class, traceId);
    }

    public IpFacialRecognitionResponse ipFacialRecognition(String appId, String appSecret, IpFacialRecognitionRequest request) throws CloudSdkException {
        return ipFacialRecognition(appId, appSecret, request, null);
    }

    public IpFacialRecognitionResponse ipFacialRecognition(String appId, String appSecret, IpFacialRecognitionRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "IpFacialRecognitionRequest");
        requireNonEmpty(request.getIp(), "ip");
        return call(appId, appSecret, url(IP_FACIAL_RECOGNITION_PATH), request, IpFacialRecognitionResponse.class, traceId);
    }

    public IpApplicationScenariosResponse ipApplicationScenarios(String appId, String appSecret, IpApplicationScenariosRequest request) throws CloudSdkException {
        return ipApplicationScenarios(appId, appSecret, request, null);
    }

    public IpApplicationScenariosResponse ipApplicationScenarios(String appId, String appSecret, IpApplicationScenariosRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "IpApplicationScenariosRequest");
        requireNonEmpty(request.getIp(), "ip");
        return call(appId, appSecret, url(IP_APPLICATION_SCENARIOS_PATH), request, IpApplicationScenariosResponse.class, traceId);
    }

    public IpProxyIdentificationResponse ipProxyIdentification(String appId, String appSecret, IpProxyIdentificationRequest request) throws CloudSdkException {
        return ipProxyIdentification(appId, appSecret, request, null);
    }

    public IpProxyIdentificationResponse ipProxyIdentification(String appId, String appSecret, IpProxyIdentificationRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "IpProxyIdentificationRequest");
        requireNonEmpty(request.getIp(), "ip");
        return call(appId, appSecret, url(IP_PROXY_IDENTIFICATION_PATH), request, IpProxyIdentificationResponse.class, traceId);
    }

    public IpHostInformationResponse ipHostInformation(String appId, String appSecret, IpHostInformationRequest request) throws CloudSdkException {
        return ipHostInformation(appId, appSecret, request, null);
    }

    public IpHostInformationResponse ipHostInformation(String appId, String appSecret, IpHostInformationRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "IpHostInformationRequest");
        requireNonEmpty(request.getIp(), "ip");
        return call(appId, appSecret, url(IP_HOST_INFORMATION_PATH), request, IpHostInformationResponse.class, traceId);
    }

    // ==================== 企业信息类接口 ====================

    public EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(String appId, String appSecret, EnterpriseTwoElementsCheckRequest request) throws CloudSdkException {
        return enterpriseTwoElementsCheck(appId, appSecret, request, null);
    }

    public EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(String appId, String appSecret, EnterpriseTwoElementsCheckRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "EnterpriseTwoElementsCheckRequest");
        requireNonEmpty(request.getCredit_code(), "credit_code");
        requireNonEmpty(request.getEnt_name(), "ent_name");
        return call(appId, appSecret, url(ENTERPRISE_TWO_ELEMENTS_CHECK_PATH), request, EnterpriseTwoElementsCheckResponse.class, traceId);
    }

    public EnterpriseThreeAuthResponse enterpriseThreeAuth(String appId, String appSecret, EnterpriseThreeAuthRequest request) throws CloudSdkException {
        return enterpriseThreeAuth(appId, appSecret, request, null);
    }

    public EnterpriseThreeAuthResponse enterpriseThreeAuth(String appId, String appSecret, EnterpriseThreeAuthRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "EnterpriseThreeAuthRequest");
        requireNonEmpty(request.getEntName(), "entName");
        requireNonEmpty(request.getLegalPerName(), "legalPerName");
        requireNonEmpty(request.getCreditCode(), "creditCode");
        return call(appId, appSecret, url(ENTERPRISE_THREE_AUTH_PATH), request, EnterpriseThreeAuthResponse.class, traceId);
    }

    public EnterpriseQueryResponse enterpriseQuery(String appId, String appSecret, EnterpriseQueryRequest request) throws CloudSdkException {
        return enterpriseQuery(appId, appSecret, request, null);
    }

    public EnterpriseQueryResponse enterpriseQuery(String appId, String appSecret, EnterpriseQueryRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "EnterpriseQueryRequest");
        requireNonEmpty(request.getEntName(), "entName");
        return call(appId, appSecret, url(ENTERPRISE_QUERY_PATH), request, EnterpriseQueryResponse.class, traceId);
    }

    public EnterpriseSimpleResponse enterpriseSimple(String appId, String appSecret, EnterpriseSimpleRequest request) throws CloudSdkException {
        return enterpriseSimple(appId, appSecret, request, null);
    }

    public EnterpriseSimpleResponse enterpriseSimple(String appId, String appSecret, EnterpriseSimpleRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "EnterpriseSimpleRequest");
        if (isEmpty(request.getEntName()) && isEmpty(request.getRegNo())
                && isEmpty(request.getCreditCode()) && isEmpty(request.getOrgCode())) {
            throw new CloudSdkException("ParameterMissing", "entName、regNo、creditCode、orgCode 至少填写一个", null, 0);
        }
        return call(appId, appSecret, url(ENTERPRISE_SIMPLE_PATH), request, EnterpriseSimpleResponse.class, traceId);
    }

    public AbnormalOperationResponse abnormalOperation(String appId, String appSecret, AbnormalOperationRequest request) throws CloudSdkException {
        return abnormalOperation(appId, appSecret, request, null);
    }

    public AbnormalOperationResponse abnormalOperation(String appId, String appSecret, AbnormalOperationRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "AbnormalOperationRequest");
        return call(appId, appSecret, url(ABNORMAL_OPERATION_PATH), request, AbnormalOperationResponse.class, traceId);
    }

    public AdministrativeSanctionQueryResponse administrativeSanctionQuery(String appId, String appSecret, AdministrativeSanctionQueryRequest request) throws CloudSdkException {
        return administrativeSanctionQuery(appId, appSecret, request, null);
    }

    public AdministrativeSanctionQueryResponse administrativeSanctionQuery(String appId, String appSecret, AdministrativeSanctionQueryRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "AdministrativeSanctionQueryRequest");
        if (isEmpty(request.getEntname()) && isEmpty(request.getUniscid()) && isEmpty(request.getRegno())) {
            throw new CloudSdkException("ParameterMissing", "entname、uniscid、regno 至少填写一个", null, 0);
        }
        return call(appId, appSecret, url(ADMINISTRATIVE_SANCTION_QUERY_PATH), request, AdministrativeSanctionQueryResponse.class, traceId);
    }

    public JusticeComplainResponse justiceComplain(String appId, String appSecret, JusticeComplainRequest request) throws CloudSdkException {
        return justiceComplain(appId, appSecret, request, null);
    }

    public JusticeComplainResponse justiceComplain(String appId, String appSecret, JusticeComplainRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "JusticeComplainRequest");
        requireNonEmpty(request.getEntName(), "entName");
        return call(appId, appSecret, url(JUSTICE_COMPLAIN_PATH), request, JusticeComplainResponse.class, traceId);
    }

    public CompanyLevelResponse companyLevel(String appId, String appSecret, CompanyLevelRequest request) throws CloudSdkException {
        return companyLevel(appId, appSecret, request, null);
    }

    public CompanyLevelResponse companyLevel(String appId, String appSecret, CompanyLevelRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "CompanyLevelRequest");
        requireNonEmpty(request.getKey(), "key");
        return call(appId, appSecret, url(COMPANY_LEVEL_PATH), request, CompanyLevelResponse.class, traceId);
    }

    public EnterpriseBiddingResponse enterpriseBidding(String appId, String appSecret, EnterpriseBiddingRequest request) throws CloudSdkException {
        return enterpriseBidding(appId, appSecret, request, null);
    }

    public EnterpriseBiddingResponse enterpriseBidding(String appId, String appSecret, EnterpriseBiddingRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "EnterpriseBiddingRequest");
        if (isEmpty(request.getEntname()) && isEmpty(request.getRegno())) {
            throw new CloudSdkException("ParameterMissing", "entname、regno 至少填写一个", null, 0);
        }
        return call(appId, appSecret, url(ENTERPRISE_BIDDING_PATH), request, EnterpriseBiddingResponse.class, traceId);
    }

    public EnterpriseOwnTaxResponse enterpriseOwnTax(String appId, String appSecret, EnterpriseOwnTaxRequest request) throws CloudSdkException {
        return enterpriseOwnTax(appId, appSecret, request, null);
    }

    public EnterpriseOwnTaxResponse enterpriseOwnTax(String appId, String appSecret, EnterpriseOwnTaxRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "EnterpriseOwnTaxRequest");
        requireNonEmpty(request.getKeyword(), "keyword");
        return call(appId, appSecret, url(ENTERPRISE_OWN_TAX_PATH), request, EnterpriseOwnTaxResponse.class, traceId);
    }

    // ==================== 人脸/活体检测 ====================

    public FaceCheckResponse faceCheck(String appId, String appSecret, FaceCheckRequest request) throws CloudSdkException {
        return faceCheck(appId, appSecret, request, null);
    }

    public FaceCheckResponse faceCheck(String appId, String appSecret, FaceCheckRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "FaceCheckRequest");
        requireNonEmpty(request.getImage(), "image");
        return call(appId, appSecret, url(FACE_CHECK_PATH), request, FaceCheckResponse.class, traceId);
    }

    public LifeCheckResponse lifeCheck(String appId, String appSecret, LifeCheckRequest request) throws CloudSdkException {
        return lifeCheck(appId, appSecret, request, null);
    }

    public LifeCheckResponse lifeCheck(String appId, String appSecret, LifeCheckRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "LifeCheckRequest");
        requireNonEmpty(request.getMotions(), "motions");
        if (isEmpty(request.getFile()) && isEmpty(request.getUrl())) {
            throw new CloudSdkException("ParameterMissing", "file 和 url 至少填写一个", null, 0);
        }
        return call(appId, appSecret, url(LIFE_CHECK_PATH), request, LifeCheckResponse.class, traceId);
    }

    // ==================== OCR 类接口 ====================

    public IdOcrResponse idOcr(String appId, String appSecret, IdOcrRequest request) throws CloudSdkException {
        return idOcr(appId, appSecret, request, null);
    }

    public IdOcrResponse idOcr(String appId, String appSecret, IdOcrRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "IdOcrRequest");
        requireNonEmpty(request.getImage(), "image");
        requireNonEmpty(request.getImageType(), "imageType");
        requireNonEmpty(request.getOcrType(), "ocrType");
        return call(appId, appSecret, url(ID_OCR_PATH), request, IdOcrResponse.class, traceId);
    }

    public IdOcrV2Response idOcrV2(String appId, String appSecret, IdOcrV2Request request) throws CloudSdkException {
        return idOcrV2(appId, appSecret, request, null);
    }

    public IdOcrV2Response idOcrV2(String appId, String appSecret, IdOcrV2Request request, String traceId) throws CloudSdkException {
        requireNonNull(request, "IdOcrV2Request");
        requireNonEmpty(request.getImage(), "image");
        requireNonEmpty(request.getImageType(), "imageType");
        return call(appId, appSecret, url(ID_OCR_V2_PATH), request, IdOcrV2Response.class, traceId);
    }

    public VehicleLicenseResponse vehicleLicense(String appId, String appSecret, VehicleLicenseRequest request) throws CloudSdkException {
        return vehicleLicense(appId, appSecret, request, null);
    }

    public VehicleLicenseResponse vehicleLicense(String appId, String appSecret, VehicleLicenseRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "VehicleLicenseRequest");
        requireNonEmpty(request.getImage(), "image");
        requireNonEmpty(request.getImageType(), "imageType");
        return call(appId, appSecret, url(VEHICLE_LICENSE_PATH), request, VehicleLicenseResponse.class, traceId);
    }

    public BankcardResponse bankcard(String appId, String appSecret, BankcardRequest request) throws CloudSdkException {
        return bankcard(appId, appSecret, request, null);
    }

    public BankcardResponse bankcard(String appId, String appSecret, BankcardRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "BankcardRequest");
        requireNonEmpty(request.getImage(), "image");
        requireNonEmpty(request.getImageType(), "imageType");
        return call(appId, appSecret, url(BANKCARD_PATH), request, BankcardResponse.class, traceId);
    }

    public DrivingLicenseResponse drivingLicense(String appId, String appSecret, DrivingLicenseRequest request) throws CloudSdkException {
        return drivingLicense(appId, appSecret, request, null);
    }

    public DrivingLicenseResponse drivingLicense(String appId, String appSecret, DrivingLicenseRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "DrivingLicenseRequest");
        requireNonEmpty(request.getImage(), "image");
        requireNonEmpty(request.getImageType(), "imageType");
        return call(appId, appSecret, url(DRIVING_LICENSE_PATH), request, DrivingLicenseResponse.class, traceId);
    }

    public DrivingLicenseOcrV2Response drivingLicenseOcrV2(String appId, String appSecret, DrivingLicenseOcrV2Request request) throws CloudSdkException {
        return drivingLicenseOcrV2(appId, appSecret, request, null);
    }

    public DrivingLicenseOcrV2Response drivingLicenseOcrV2(String appId, String appSecret, DrivingLicenseOcrV2Request request, String traceId) throws CloudSdkException {
        requireNonNull(request, "DrivingLicenseOcrV2Request");
        requireNonEmpty(request.getImage(), "image");
        requireNonEmpty(request.getImageType(), "imageType");
        return call(appId, appSecret, url(DRIVING_LICENSE_OCR_V2_PATH), request, DrivingLicenseOcrV2Response.class, traceId);
    }

    public VehiclePlateOcrResponse vehiclePlateOcr(String appId, String appSecret, VehiclePlateOcrRequest request) throws CloudSdkException {
        return vehiclePlateOcr(appId, appSecret, request, null);
    }

    public VehiclePlateOcrResponse vehiclePlateOcr(String appId, String appSecret, VehiclePlateOcrRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "VehiclePlateOcrRequest");
        requireNonEmpty(request.getImage(), "image");
        requireNonEmpty(request.getImageType(), "imageType");
        return call(appId, appSecret, url(VEHICLE_PLATE_OCR_PATH), request, VehiclePlateOcrResponse.class, traceId);
    }

    public BusinessLicenseResponse businessLicense(String appId, String appSecret, BusinessLicenseRequest request) throws CloudSdkException {
        return businessLicense(appId, appSecret, request, null);
    }

    public BusinessLicenseResponse businessLicense(String appId, String appSecret, BusinessLicenseRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "BusinessLicenseRequest");
        requireNonEmpty(request.getImage(), "image");
        requireNonEmpty(request.getImageType(), "imageType");
        return call(appId, appSecret, url(BUSINESS_LICENSE_PATH), request, BusinessLicenseResponse.class, traceId);
    }

    public TableOcrResponse tableOcr(String appId, String appSecret, TableOcrRequest request) throws CloudSdkException {
        return tableOcr(appId, appSecret, request, null);
    }

    public TableOcrResponse tableOcr(String appId, String appSecret, TableOcrRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "TableOcrRequest");
        if (isEmpty(request.getImage()) && isEmpty(request.getUrl())) {
            throw new CloudSdkException("ParameterMissing", "image 和 url 至少填写一个", null, 0);
        }
        return call(appId, appSecret, url(TABLE_OCR_PATH), request, TableOcrResponse.class, traceId);
    }

    public InvoiceOcrResponse invoiceOcr(String appId, String appSecret, InvoiceOcrRequest request) throws CloudSdkException {
        return invoiceOcr(appId, appSecret, request, null);
    }

    public InvoiceOcrResponse invoiceOcr(String appId, String appSecret, InvoiceOcrRequest request, String traceId) throws CloudSdkException {
        requireNonNull(request, "InvoiceOcrRequest");
        requireNonEmpty(request.getImage(), "image");
        requireNonEmpty(request.getImageType(), "imageType");
        return call(appId, appSecret, url(INVOICE_OCR_PATH), request, InvoiceOcrResponse.class, traceId);
    }

    public VehicleLicenseOcrV2Response vehicleLicenseOcrV2(String appId, String appSecret, VehicleLicenseOcrV2Request request) throws CloudSdkException {
        return vehicleLicenseOcrV2(appId, appSecret, request, null);
    }

    public VehicleLicenseOcrV2Response vehicleLicenseOcrV2(String appId, String appSecret, VehicleLicenseOcrV2Request request, String traceId) throws CloudSdkException {
        requireNonNull(request, "VehicleLicenseOcrV2Request");
        requireNonEmpty(request.getImage(), "image");
        requireNonEmpty(request.getImageType(), "imageType");
        return call(appId, appSecret, url(VEHICLE_LICENSE_OCR_V2_PATH), request, VehicleLicenseOcrV2Response.class, traceId);
    }

    // ==================== 凭证已绑定的便捷方法 ====================

    public IpAddressOriginV4Response ipAddressOriginV4(IpAddressOriginV4Request request) throws CloudSdkException {
        return ipAddressOriginV4(configAppId(), configAppSecret(), request, null);
    }

    public IpAddressOriginV6Response ipAddressOriginV6(IpAddressOriginV6Request request) throws CloudSdkException {
        return ipAddressOriginV6(configAppId(), configAppSecret(), request, null);
    }

    public IpRiskPortraitResponse ipRiskPortrait(IpRiskPortraitRequest request) throws CloudSdkException {
        return ipRiskPortrait(configAppId(), configAppSecret(), request, null);
    }

    public IpFacialRecognitionResponse ipFacialRecognition(IpFacialRecognitionRequest request) throws CloudSdkException {
        return ipFacialRecognition(configAppId(), configAppSecret(), request, null);
    }

    public IpApplicationScenariosResponse ipApplicationScenarios(IpApplicationScenariosRequest request) throws CloudSdkException {
        return ipApplicationScenarios(configAppId(), configAppSecret(), request, null);
    }

    public IpProxyIdentificationResponse ipProxyIdentification(IpProxyIdentificationRequest request) throws CloudSdkException {
        return ipProxyIdentification(configAppId(), configAppSecret(), request, null);
    }

    public IpHostInformationResponse ipHostInformation(IpHostInformationRequest request) throws CloudSdkException {
        return ipHostInformation(configAppId(), configAppSecret(), request, null);
    }

    public EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(EnterpriseTwoElementsCheckRequest request) throws CloudSdkException {
        return enterpriseTwoElementsCheck(configAppId(), configAppSecret(), request, null);
    }

    public EnterpriseThreeAuthResponse enterpriseThreeAuth(EnterpriseThreeAuthRequest request) throws CloudSdkException {
        return enterpriseThreeAuth(configAppId(), configAppSecret(), request, null);
    }

    public EnterpriseQueryResponse enterpriseQuery(EnterpriseQueryRequest request) throws CloudSdkException {
        return enterpriseQuery(configAppId(), configAppSecret(), request, null);
    }

    public EnterpriseSimpleResponse enterpriseSimple(EnterpriseSimpleRequest request) throws CloudSdkException {
        return enterpriseSimple(configAppId(), configAppSecret(), request, null);
    }

    public AbnormalOperationResponse abnormalOperation(AbnormalOperationRequest request) throws CloudSdkException {
        return abnormalOperation(configAppId(), configAppSecret(), request, null);
    }

    public AdministrativeSanctionQueryResponse administrativeSanctionQuery(AdministrativeSanctionQueryRequest request) throws CloudSdkException {
        return administrativeSanctionQuery(configAppId(), configAppSecret(), request, null);
    }

    public JusticeComplainResponse justiceComplain(JusticeComplainRequest request) throws CloudSdkException {
        return justiceComplain(configAppId(), configAppSecret(), request, null);
    }

    public CompanyLevelResponse companyLevel(CompanyLevelRequest request) throws CloudSdkException {
        return companyLevel(configAppId(), configAppSecret(), request, null);
    }

    public EnterpriseBiddingResponse enterpriseBidding(EnterpriseBiddingRequest request) throws CloudSdkException {
        return enterpriseBidding(configAppId(), configAppSecret(), request, null);
    }

    public EnterpriseOwnTaxResponse enterpriseOwnTax(EnterpriseOwnTaxRequest request) throws CloudSdkException {
        return enterpriseOwnTax(configAppId(), configAppSecret(), request, null);
    }

    public FaceCheckResponse faceCheck(FaceCheckRequest request) throws CloudSdkException {
        return faceCheck(configAppId(), configAppSecret(), request, null);
    }

    public LifeCheckResponse lifeCheck(LifeCheckRequest request) throws CloudSdkException {
        return lifeCheck(configAppId(), configAppSecret(), request, null);
    }

    public IdOcrResponse idOcr(IdOcrRequest request) throws CloudSdkException {
        return idOcr(configAppId(), configAppSecret(), request, null);
    }

    public IdOcrV2Response idOcrV2(IdOcrV2Request request) throws CloudSdkException {
        return idOcrV2(configAppId(), configAppSecret(), request, null);
    }

    public VehicleLicenseResponse vehicleLicense(VehicleLicenseRequest request) throws CloudSdkException {
        return vehicleLicense(configAppId(), configAppSecret(), request, null);
    }

    public BankcardResponse bankcard(BankcardRequest request) throws CloudSdkException {
        return bankcard(configAppId(), configAppSecret(), request, null);
    }

    public DrivingLicenseResponse drivingLicense(DrivingLicenseRequest request) throws CloudSdkException {
        return drivingLicense(configAppId(), configAppSecret(), request, null);
    }

    public DrivingLicenseOcrV2Response drivingLicenseOcrV2(DrivingLicenseOcrV2Request request) throws CloudSdkException {
        return drivingLicenseOcrV2(configAppId(), configAppSecret(), request, null);
    }

    public VehiclePlateOcrResponse vehiclePlateOcr(VehiclePlateOcrRequest request) throws CloudSdkException {
        return vehiclePlateOcr(configAppId(), configAppSecret(), request, null);
    }

    public BusinessLicenseResponse businessLicense(BusinessLicenseRequest request) throws CloudSdkException {
        return businessLicense(configAppId(), configAppSecret(), request, null);
    }

    public TableOcrResponse tableOcr(TableOcrRequest request) throws CloudSdkException {
        return tableOcr(configAppId(), configAppSecret(), request, null);
    }

    public InvoiceOcrResponse invoiceOcr(InvoiceOcrRequest request) throws CloudSdkException {
        return invoiceOcr(configAppId(), configAppSecret(), request, null);
    }

    public VehicleLicenseOcrV2Response vehicleLicenseOcrV2(VehicleLicenseOcrV2Request request) throws CloudSdkException {
        return vehicleLicenseOcrV2(configAppId(), configAppSecret(), request, null);
    }

    // ==================== 内部工具方法 ====================

    private String url(String path) {
        return config.getEndpoint() + path;
    }

    private String configAppId() {
        String appId = config.getAppId();
        if (appId == null || appId.isEmpty()) {
            throw new IllegalStateException("appId not configured, use BusinessConfig.builder().appId(...) or pass appId explicitly");
        }
        return appId;
    }

    private String configAppSecret() {
        String appSecret = config.getAppSecret();
        if (appSecret == null || appSecret.isEmpty()) {
            throw new IllegalStateException("appSecret not configured, use BusinessConfig.builder().appSecret(...) or pass appSecret explicitly");
        }
        return appSecret;
    }

    private static void requireNonNull(Object obj, String name) {
        if (obj == null) {
            throw new CloudSdkException("ParameterMissing", name + " 不能为空", null, 0);
        }
    }

    private static void requireNonEmpty(String value, String name) {
        if (value == null || value.isEmpty()) {
            throw new CloudSdkException("ParameterMissing", name + " 不能为空", null, 0);
        }
    }

    private static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
