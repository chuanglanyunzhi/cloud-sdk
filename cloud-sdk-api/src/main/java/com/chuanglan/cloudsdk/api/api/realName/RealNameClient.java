package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.api.api.ApiClient;
import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.HttpTransport;
import com.chuanglan.cloudsdk.core.SyncResponse;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 253 实名认证服务 SDK 入口。
 */
public class RealNameClient extends ApiClient<RealNameConfig> {

    private static final String ID_CARD_AUTH_PATH = "/api/v2/auth/idcard/id-card-auth";
    private static final String ID_CARD_AUTH_V2_PATH = "/api/v2/auth/idcard/id-card-auth/vs";
    private static final String FOREIGN_ID_CARD_AUTH_PATH = "/api/v2/auth/idcard/id-card-auth-foreign-sign";
    private static final String ID_MATCH_PATH = "/api/v2/auth/idmatch/idmatch-new";
    private static final String FOREIGN_ID_MATCH_PATH = "/api/v2/auth/idmatch/idmatch-abroad";
    private static final String CARRIERS_TWO_AUTH_PATH = "/api/v2/auth/carriers/carriers-two-auth";
    private static final String CARRIERS_TWO_AUTH_ID_NUM_PATH = "/api/v2/auth/carriers/carriers-two-auth-idnum";
    private static final String CARRIERS_TWO_AUTH_MD5_PATH = "/api/v2/auth/carriers/carriers-two-auth-md5";
    private static final String CARRIERS_AUTH_PATH = "/api/v2/auth/carriers/carriers-auth";
    private static final String CARRIERS_AUTH_MD5_PATH = "/api/v2/auth/carriers/carriers-auth-md5";
    private static final String CARRIERS_AUTH_DETAIL_PATH = "/api/v2/auth/carriers/carriers-auth-detail";
    private static final String CARRIERS_AUTH_DETAIL_MD5_PATH = "/api/v2/auth/carriers/carriers-auth-detail-md5";
    private static final String CARRIERS_AUTH_DETAIL_SHA256_PATH = "/api/v2/auth/carriers/carriers-auth-detail-sha256";
    private static final String CARRIERS_AUTH_SHA256_PATH = "/api/v2/auth/carriers/carriersAuthSha256";
    private static final String BANK_CARD_TWO_AUTH_PATH = "/api/v2/auth/bankcard/card-two-auth";
    private static final String BANK_CARD_THREE_AUTH_PATH = "/api/v2/auth/bankcard/card-three-auth";
    private static final String BANK_CARD_THREE_AUTH_TYPE_PATH = "/api/v2/auth/bankcard/card-three-auth-type";
    private static final String BANK_CARD_THREE_AUTH_DETAIL_PATH = "/api/v2/auth/bankcard/card-three-auth-detail";
    private static final String BANK_CARD_THREE_AUTH_PRECISION_PATH = "/api/v2/auth/bankcard/card-three-auth-precision";
    private static final String BANK_CARD_FOUR_AUTH_PATH = "/api/v2/auth/bankcard/card-auth";
    private static final String BANK_CARD_FOUR_SECRET_PATH = "/api/v2/auth/bankcard/card-auth-secret";
    private static final String BANK_CARD_FOUR_AUTH_DETAIL_PATH = "/api/v2/auth/bankcard/card-auth-detail";
    private static final String BANK_CARD_FOUR_AUTH_TYPE_PATH = "/api/v2/auth/bankcard/card-auth-type";
    private static final String BANK_CARD_FOUR_AUTH_PRECISION_PATH = "/api/v2/auth/bankcard/card-auth-precision";
    private static final String BANK_CARD_FIVE_AUTH_PATH = "/api/v2/auth/bankcard/card-five-auth";
    private static final String IP_GSD_QUERY_PATH = "/api/v2/auth/ipgsdcx/ipgsd";
    private static final String BUSINESS_FOUR_AUTH_PATH = "/api/v2/auth/gsxx/business-four-auth";

    public RealNameClient(RealNameConfig config) {
        super(config);
    }

    public RealNameClient(RealNameConfig config, HttpTransport httpTransport) {
        super(config, httpTransport);
    }

    /**
     * 身份证二要素核验。
     */
    public IdCardAuthResponse idCardAuth(String appId, String appSecret, IdCardAuthRequest request) throws CloudSdkException {
        return idCardAuth(appId, appSecret, request, null);
    }

    /**
     * 身份证二要素核验，支持自定义链路追踪 ID。
     */
    public IdCardAuthResponse idCardAuth(String appId, String appSecret, IdCardAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IdCardAuthRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + ID_CARD_AUTH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IdCardAuthResponse.class);
    }

    /**
     * 身份证二要素核验 V2（签名版）。
     */
    public IdCardAuthResponse idCardAuthV2(String appId, String appSecret, IdCardAuthV2Request request) throws CloudSdkException {
        return idCardAuthV2(appId, appSecret, request, null);
    }

    /**
     * 身份证二要素核验 V2（签名版），支持自定义链路追踪 ID。
     */
    public IdCardAuthResponse idCardAuthV2(String appId, String appSecret, IdCardAuthV2Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IdCardAuthV2Request 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (appSecret == null || appSecret.isEmpty()) {
            throw new IllegalArgumentException("appSecret must not be empty");
        }

        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", request.getName());
        bodyMap.put("idNum", request.getIdNum());
        bodyMap.put("sign", buildV2Sign(appId, appSecret, request.getIdNum(), request.getName()));
        String body = serializeRequest(bodyMap);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + ID_CARD_AUTH_V2_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IdCardAuthResponse.class);
    }

    /**
     * 涉外身份证校验。
     */
    public ForeignIdCardAuthResponse foreignIdCardAuth(String appId, String appSecret, ForeignIdCardAuthRequest request) throws CloudSdkException {
        return foreignIdCardAuth(appId, appSecret, request, null);
    }

    /**
     * 涉外身份证校验，支持自定义链路追踪 ID。
     */
    public ForeignIdCardAuthResponse foreignIdCardAuth(String appId, String appSecret, ForeignIdCardAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "ForeignIdCardAuthRequest 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getNation() == null || request.getNation().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "nation 不能为空", null, 0);
        }
        if (request.getIdType() == null || request.getIdType().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idType 不能为空", null, 0);
        }
        if (appSecret == null || appSecret.isEmpty()) {
            throw new IllegalArgumentException("appSecret must not be empty");
        }

        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("idNum", request.getIdNum());
        bodyMap.put("name", request.getName());
        bodyMap.put("nation", request.getNation());
        bodyMap.put("idType", request.getIdType());
        bodyMap.put("sign", buildForeignSign(appId, appSecret, request));
        String body = serializeRequest(bodyMap);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + FOREIGN_ID_CARD_AUTH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), ForeignIdCardAuthResponse.class);
    }

    /**
     * 身份证人像比对 V2.0。
     */
    public IdMatchResponse idMatch(String appId, String appSecret, IdMatchRequest request) throws CloudSdkException {
        return idMatch(appId, appSecret, request, null);
    }

    /**
     * 身份证人像比对 V2.0，支持自定义链路追踪 ID。
     */
    public IdMatchResponse idMatch(String appId, String appSecret, IdMatchRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IdMatchRequest 不能为空", null, 0);
        }
        if (request.getImage() == null || request.getImage().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + ID_MATCH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IdMatchResponse.class);
    }

    /**
     * 涉外身份证核验（人像）。
     */
    public ForeignIdMatchResponse foreignIdMatch(String appId, String appSecret, ForeignIdMatchRequest request) throws CloudSdkException {
        return foreignIdMatch(appId, appSecret, request, null);
    }

    /**
     * 涉外身份证核验（人像），支持自定义链路追踪 ID。
     */
    public ForeignIdMatchResponse foreignIdMatch(String appId, String appSecret, ForeignIdMatchRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "ForeignIdMatchRequest 不能为空", null, 0);
        }
        if (request.getImage() == null || request.getImage().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "image 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getNation() == null || request.getNation().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "nation 不能为空", null, 0);
        }
        if (request.getType() == null || request.getType().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "type 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + FOREIGN_ID_MATCH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), ForeignIdMatchResponse.class);
    }

    /**
     * 运营商二要素核验。
     */
    public CarriersTwoAuthResponse carriersTwoAuth(String appId, String appSecret, CarriersTwoAuthRequest request) throws CloudSdkException {
        return carriersTwoAuth(appId, appSecret, request, null);
    }

    /**
     * 运营商二要素核验，支持自定义链路追踪 ID。
     */
    public CarriersTwoAuthResponse carriersTwoAuth(String appId, String appSecret, CarriersTwoAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "CarriersTwoAuthRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + CARRIERS_TWO_AUTH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), CarriersTwoAuthResponse.class);
    }

    /**
     * 运营商二要素（身份证版）核验。
     */
    public CarriersTwoAuthIdNumResponse carriersTwoAuthIdNum(String appId, String appSecret, CarriersTwoAuthIdNumRequest request) throws CloudSdkException {
        return carriersTwoAuthIdNum(appId, appSecret, request, null);
    }

    /**
     * 运营商二要素（身份证版）核验，支持自定义链路追踪 ID。
     */
    public CarriersTwoAuthIdNumResponse carriersTwoAuthIdNum(String appId, String appSecret, CarriersTwoAuthIdNumRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "CarriersTwoAuthIdNumRequest 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + CARRIERS_TWO_AUTH_ID_NUM_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), CarriersTwoAuthIdNumResponse.class);
    }

    /**
     * 运营商二要素 MD5 核验。
     */
    public CarriersTwoAuthResponse carriersTwoAuthMd5(String appId, String appSecret, CarriersTwoAuthMd5Request request) throws CloudSdkException {
        return carriersTwoAuthMd5(appId, appSecret, request, null);
    }

    /**
     * 运营商二要素 MD5 核验，支持自定义链路追踪 ID。
     */
    public CarriersTwoAuthResponse carriersTwoAuthMd5(String appId, String appSecret, CarriersTwoAuthMd5Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "CarriersTwoAuthMd5Request 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + CARRIERS_TWO_AUTH_MD5_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), CarriersTwoAuthResponse.class);
    }

    /**
     * 运营商三要素核验。
     */
    public CarriersAuthResponse carriersAuth(String appId, String appSecret, CarriersAuthRequest request) throws CloudSdkException {
        return carriersAuth(appId, appSecret, request, null);
    }

    /**
     * 运营商三要素核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthResponse carriersAuth(String appId, String appSecret, CarriersAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "CarriersAuthRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + CARRIERS_AUTH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), CarriersAuthResponse.class);
    }

    /**
     * 运营商三要素 MD5 核验。
     */
    public CarriersAuthMd5Response carriersAuthMd5(String appId, String appSecret, CarriersAuthMd5Request request) throws CloudSdkException {
        return carriersAuthMd5(appId, appSecret, request, null);
    }

    /**
     * 运营商三要素 MD5 核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthMd5Response carriersAuthMd5(String appId, String appSecret, CarriersAuthMd5Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "CarriersAuthMd5Request 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + CARRIERS_AUTH_MD5_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), CarriersAuthMd5Response.class);
    }

    /**
     * 运营商三要素详细版核验。
     */
    public CarriersAuthDetailResponse carriersAuthDetail(String appId, String appSecret, CarriersAuthRequest request) throws CloudSdkException {
        return carriersAuthDetail(appId, appSecret, request, null);
    }

    /**
     * 运营商三要素详细版核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthDetailResponse carriersAuthDetail(String appId, String appSecret, CarriersAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "CarriersAuthRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getApiEndpoint() + CARRIERS_AUTH_DETAIL_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), CarriersAuthDetailResponse.class);
    }

    /**
     * 运营商三要素详细版 MD5 核验。
     */
    public CarriersAuthDetailMd5Response carriersAuthDetailMd5(String appId, String appSecret, CarriersAuthDetailMd5Request request) throws CloudSdkException {
        return carriersAuthDetailMd5(appId, appSecret, request, null);
    }

    /**
     * 运营商三要素详细版 MD5 核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthDetailMd5Response carriersAuthDetailMd5(String appId, String appSecret, CarriersAuthDetailMd5Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "CarriersAuthDetailMd5Request 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getApiEndpoint() + CARRIERS_AUTH_DETAIL_MD5_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), CarriersAuthDetailMd5Response.class);
    }

    /**
     * 运营商三要素详细版 SHA256 核验。
     */
    public CarriersAuthDetailSha256Response carriersAuthDetailSha256(String appId, String appSecret, CarriersAuthDetailSha256Request request) throws CloudSdkException {
        return carriersAuthDetailSha256(appId, appSecret, request, null);
    }

    /**
     * 运营商三要素详细版 SHA256 核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthDetailSha256Response carriersAuthDetailSha256(String appId, String appSecret, CarriersAuthDetailSha256Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "CarriersAuthDetailSha256Request 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + CARRIERS_AUTH_DETAIL_SHA256_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), CarriersAuthDetailSha256Response.class);
    }

    /**
     * 运营商三要素 SHA256 核验。
     */
    public CarriersAuthSha256Response carriersAuthSha256(String appId, String appSecret, CarriersAuthSha256Request request) throws CloudSdkException {
        return carriersAuthSha256(appId, appSecret, request, null);
    }

    /**
     * 运营商三要素 SHA256 核验，支持自定义链路追踪 ID。
     */
    public CarriersAuthSha256Response carriersAuthSha256(String appId, String appSecret, CarriersAuthSha256Request request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "CarriersAuthSha256Request 不能为空", null, 0);
        }
        if (request.getChName() == null || request.getChName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "chName 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getChTel() == null || request.getChTel().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "chTel 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + CARRIERS_AUTH_SHA256_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), CarriersAuthSha256Response.class);
    }

    /**
     * 银行卡二要素标准版核验。
     */
    public BankCardTwoAuthResponse bankCardTwoAuth(String appId, String appSecret, BankCardTwoAuthRequest request) throws CloudSdkException {
        return bankCardTwoAuth(appId, appSecret, request, null);
    }

    /**
     * 银行卡二要素标准版核验，支持自定义链路追踪 ID。
     */
    public BankCardTwoAuthResponse bankCardTwoAuth(String appId, String appSecret, BankCardTwoAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardTwoAuthRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_TWO_AUTH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardTwoAuthResponse.class);
    }

    /**
     * 银行卡三要素标准版核验。
     */
    public BankCardThreeAuthResponse bankCardThreeAuth(String appId, String appSecret, BankCardThreeAuthRequest request) throws CloudSdkException {
        return bankCardThreeAuth(appId, appSecret, request, null);
    }

    /**
     * 银行卡三要素标准版核验，支持自定义链路追踪 ID。
     */
    public BankCardThreeAuthResponse bankCardThreeAuth(String appId, String appSecret, BankCardThreeAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardThreeAuthRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_THREE_AUTH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardThreeAuthResponse.class);
    }

    /**
     * 银行卡三要素多证件版核验。
     */
    public BankCardThreeAuthTypeResponse bankCardThreeAuthType(String appId, String appSecret, BankCardThreeAuthTypeRequest request) throws CloudSdkException {
        return bankCardThreeAuthType(appId, appSecret, request, null);
    }

    /**
     * 银行卡三要素多证件版核验，支持自定义链路追踪 ID。
     */
    public BankCardThreeAuthTypeResponse bankCardThreeAuthType(String appId, String appSecret, BankCardThreeAuthTypeRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardThreeAuthTypeRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_THREE_AUTH_TYPE_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardThreeAuthTypeResponse.class);
    }

    /**
     * 银行卡三要素详细版核验。
     */
    public BankCardThreeAuthDetailResponse bankCardThreeAuthDetail(String appId, String appSecret, BankCardThreeAuthRequest request) throws CloudSdkException {
        return bankCardThreeAuthDetail(appId, appSecret, request, null);
    }

    /**
     * 银行卡三要素详细版核验，支持自定义链路追踪 ID。
     */
    public BankCardThreeAuthDetailResponse bankCardThreeAuthDetail(String appId, String appSecret, BankCardThreeAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardThreeAuthRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_THREE_AUTH_DETAIL_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardThreeAuthDetailResponse.class);
    }

    /**
     * 银行卡三要素精准版非身份证核验。
     */
    public BankCardThreeAuthPrecisionResponse bankCardThreeAuthPrecision(String appId, String appSecret, BankCardThreeAuthPrecisionRequest request) throws CloudSdkException {
        return bankCardThreeAuthPrecision(appId, appSecret, request, null);
    }

    /**
     * 银行卡三要素精准版非身份证核验，支持自定义链路追踪 ID。
     */
    public BankCardThreeAuthPrecisionResponse bankCardThreeAuthPrecision(String appId, String appSecret, BankCardThreeAuthPrecisionRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardThreeAuthPrecisionRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_THREE_AUTH_PRECISION_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardThreeAuthPrecisionResponse.class);
    }

    /**
     * 银行卡四要素标准版核验。
     */
    public BankCardFourAuthResponse bankCardFourAuth(String appId, String appSecret, BankCardFourAuthRequest request) throws CloudSdkException {
        return bankCardFourAuth(appId, appSecret, request, null);
    }

    /**
     * 银行卡四要素标准版核验，支持自定义链路追踪 ID。
     */
    public BankCardFourAuthResponse bankCardFourAuth(String appId, String appSecret, BankCardFourAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardFourAuthRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_FOUR_AUTH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardFourAuthResponse.class);
    }

    /**
     * 银行卡四要素简版加密核验。
     */
    public BankCardFourSecretResponse bankCardFourSecret(String appId, String appSecret, BankCardFourSecretRequest request) throws CloudSdkException {
        return bankCardFourSecret(appId, appSecret, request, null);
    }

    /**
     * 银行卡四要素简版加密核验，支持自定义链路追踪 ID。
     */
    public BankCardFourSecretResponse bankCardFourSecret(String appId, String appSecret, BankCardFourSecretRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardFourSecretRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }
        if (appSecret == null || appSecret.isEmpty()) {
            throw new IllegalArgumentException("appSecret must not be empty");
        }

        String param = encryptBankCardFourSecretParam(appSecret, request);
        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("param", param);
        String body = serializeRequest(bodyMap);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_FOUR_SECRET_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardFourSecretResponse.class);
    }

    /**
     * 银行卡四要素详细版核验。
     */
    public BankCardFourAuthDetailResponse bankCardFourAuthDetail(String appId, String appSecret, BankCardFourAuthDetailRequest request) throws CloudSdkException {
        return bankCardFourAuthDetail(appId, appSecret, request, null);
    }

    /**
     * 银行卡四要素详细版核验，支持自定义链路追踪 ID。
     */
    public BankCardFourAuthDetailResponse bankCardFourAuthDetail(String appId, String appSecret, BankCardFourAuthDetailRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardFourAuthDetailRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_FOUR_AUTH_DETAIL_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardFourAuthDetailResponse.class);
    }

    /**
     * 银行卡四要素多证件版核验。
     */
    public BankCardFourAuthTypeResponse bankCardFourAuthType(String appId, String appSecret, BankCardFourAuthTypeRequest request) throws CloudSdkException {
        return bankCardFourAuthType(appId, appSecret, request, null);
    }

    /**
     * 银行卡四要素多证件版核验，支持自定义链路追踪 ID。
     */
    public BankCardFourAuthTypeResponse bankCardFourAuthType(String appId, String appSecret, BankCardFourAuthTypeRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardFourAuthTypeRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_FOUR_AUTH_TYPE_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardFourAuthTypeResponse.class);
    }

    /**
     * 银行卡四要素精准版非身份证核验。
     */
    public BankCardFourAuthPrecisionResponse bankCardFourAuthPrecision(String appId, String appSecret, BankCardFourAuthPrecisionRequest request) throws CloudSdkException {
        return bankCardFourAuthPrecision(appId, appSecret, request, null);
    }

    /**
     * 银行卡四要素精准版非身份证核验，支持自定义链路追踪 ID。
     */
    public BankCardFourAuthPrecisionResponse bankCardFourAuthPrecision(String appId, String appSecret, BankCardFourAuthPrecisionRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardFourAuthPrecisionRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_FOUR_AUTH_PRECISION_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardFourAuthPrecisionResponse.class);
    }

    /**
     * 银行卡五要素标准版核验。
     */
    public BankCardFiveAuthResponse bankCardFiveAuth(String appId, String appSecret, BankCardFiveAuthRequest request) throws CloudSdkException {
        return bankCardFiveAuth(appId, appSecret, request, null);
    }

    /**
     * 银行卡五要素标准版核验，支持自定义链路追踪 ID。
     */
    public BankCardFiveAuthResponse bankCardFiveAuth(String appId, String appSecret, BankCardFiveAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "BankCardFiveAuthRequest 不能为空", null, 0);
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "name 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }
        if (request.getCardNo() == null || request.getCardNo().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "cardNo 不能为空", null, 0);
        }
        if (request.getMobile() == null || request.getMobile().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "mobile 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BANK_CARD_FIVE_AUTH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), BankCardFiveAuthResponse.class);
    }

    /**
     * IP 归属地查询。
     */
    public IpGsdQueryResponse ipGsdQuery(String appId, String appSecret, IpGsdQueryRequest request) throws CloudSdkException {
        return ipGsdQuery(appId, appSecret, request, null);
    }

    /**
     * IP 归属地查询，支持自定义链路追踪 ID。
     */
    public IpGsdQueryResponse ipGsdQuery(String appId, String appSecret, IpGsdQueryRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "IpGsdQueryRequest 不能为空", null, 0);
        }
        if (request.getIp() == null || request.getIp().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "ip 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + IP_GSD_QUERY_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), IpGsdQueryResponse.class);
    }

    /**
     * 企业四要素核验。
     */
    public EnterpriseFourAuthResponse enterpriseFourAuth(String appId, String appSecret, EnterpriseFourAuthRequest request) throws CloudSdkException {
        return enterpriseFourAuth(appId, appSecret, request, null);
    }

    /**
     * 企业四要素核验，支持自定义链路追踪 ID。
     */
    public EnterpriseFourAuthResponse enterpriseFourAuth(String appId, String appSecret, EnterpriseFourAuthRequest request, String traceId) throws CloudSdkException {
        if (request == null) {
            throw new CloudSdkException("ParameterMissing", "EnterpriseFourAuthRequest 不能为空", null, 0);
        }
        if (request.getEntName() == null || request.getEntName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "entName 不能为空", null, 0);
        }
        if (request.getLegalPerName() == null || request.getLegalPerName().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "legalPerName 不能为空", null, 0);
        }
        if (request.getCreditCode() == null || request.getCreditCode().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "creditCode 不能为空", null, 0);
        }
        if (request.getIdNum() == null || request.getIdNum().isEmpty()) {
            throw new CloudSdkException("ParameterMissing", "idNum 不能为空", null, 0);
        }

        String body = serializeRequest(request);
        SyncResponse syncResponse = execute(appId, appSecret, config.getEndpoint() + BUSINESS_FOUR_AUTH_PATH, body, traceId);
        return parseResponse(syncResponse.getBody(), EnterpriseFourAuthResponse.class);
    }

    private String encryptBankCardFourSecretParam(String appSecret, BankCardFourSecretRequest request) throws CloudSdkException {
        try {
            String raw = "name=" + request.getName() + "&idnum=" + request.getIdNum() + "&cardnum=" + request.getCardNo() + "&mobilenum=" + request.getMobile();
            String md5Hex = md5Hex(appSecret);
            String key = md5Hex.substring(0, 16);
            String iv = md5Hex.substring(16, 32);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,
                    new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES"),
                    new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));
            byte[] encrypted = cipher.doFinal(raw.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new CloudSdkException("EncryptError", "银行卡四要素加密失败: " + e.getMessage(), null, 0, e);
        }
    }

    private String md5Hex(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private String buildV2Sign(String appId, String appSecret, String idNum, String name) throws CloudSdkException {
        String raw = "appId" + appId + "idNum" + idNum + "name" + name;
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(appSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA1"));
            byte[] signData = mac.doFinal(raw.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(signData);
        } catch (Exception e) {
            throw new CloudSdkException("SignError", "实名认证 V2 签名失败: " + e.getMessage(), null, 0, e);
        }
    }

    private String buildForeignSign(String appId, String appSecret, ForeignIdCardAuthRequest request) throws CloudSdkException {
        String raw = "appId" + appId + "appKey" + appSecret + "idNum" + request.getIdNum()
                + "idType" + request.getIdType() + "name" + request.getName() + "nation" + request.getNation();
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(appSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA1"));
            byte[] signData = mac.doFinal(raw.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(signData);
        } catch (Exception e) {
            throw new CloudSdkException("SignError", "涉外身份证校验签名失败: " + e.getMessage(), null, 0, e);
        }
    }
}
