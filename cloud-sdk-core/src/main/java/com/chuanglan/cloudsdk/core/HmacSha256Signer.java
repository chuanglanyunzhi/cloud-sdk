package com.chuanglan.cloudsdk.core;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

/**
 * HMAC-SHA256 签名实现（简化版，可用于非 RPC 风格 API）。
 */
public class HmacSha256Signer implements Signer {

    private static final String HMAC_SHA256 = "HmacSHA256";
    private static final String SIGNATURE_METHOD = "HMAC-SHA256";

    @Override
    public Map<String, Object> sign(Request request, Credentials credentials) throws CloudSdkException {
        Map<String, Object> params = new java.util.LinkedHashMap<>();
        params.putAll(request.getQuery());
        params.put("AccessKeyId", credentials.accessKeyId());

        String stringToSign = request.getMethod() + "\n" + request.getUrl() + "\n" + params.toString();
        String signature;
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256);
            mac.init(new SecretKeySpec(credentials.accessKeySecret().getBytes(StandardCharsets.UTF_8), HMAC_SHA256));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            signature = Base64.getEncoder().encodeToString(signData);
        } catch (Exception e) {
            throw new CloudSdkException("SignError", "HMAC-SHA256 签名失败", null, 0, e);
        }
        params.put("Signature", signature);
        return params;
    }

    @Override
    public String signatureMethod() {
        return SIGNATURE_METHOD;
    }
}
