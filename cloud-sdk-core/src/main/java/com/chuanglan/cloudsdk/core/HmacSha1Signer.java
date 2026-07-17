package com.chuanglan.cloudsdk.core;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 阿里云 Legacy RPC 风格 HMAC-SHA1 签名实现。
 */
public class HmacSha1Signer implements Signer {

    private static final String HMAC_SHA1 = "HmacSHA1";
    private static final String SIGNATURE_VERSION = "1.0";
    private static final String SIGNATURE_METHOD = "HMAC-SHA1";

    @Override
    public Map<String, Object> sign(Request request, Credentials credentials) throws CloudSdkException {
        Map<String, Object> params = new LinkedHashMap<>();
        params.putAll(request.getQuery());

        injectSystemParams(params, credentials);

        String canonicalQueryString = buildCanonicalQueryString(params);
        String stringToSign = request.getMethod() + "&" + percentEncode("/") + "&" + percentEncode(canonicalQueryString);

        String signature;
        try {
            Mac mac = Mac.getInstance(HMAC_SHA1);
            mac.init(new SecretKeySpec((credentials.accessKeySecret() + "&").getBytes(StandardCharsets.UTF_8), HMAC_SHA1));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            signature = Base64.getEncoder().encodeToString(signData);
        } catch (Exception e) {
            throw new CloudSdkException("SignError", "HMAC-SHA1 签名失败", null, 0, e);
        }

        params.put("Signature", signature);
        return params;
    }

    private void injectSystemParams(Map<String, Object> params, Credentials credentials) {
        params.putIfAbsent("Format", "json");
        params.putIfAbsent("SignatureMethod", SIGNATURE_METHOD);
        params.putIfAbsent("SignatureNonce", UUID.randomUUID().toString());
        params.putIfAbsent("SignatureVersion", SIGNATURE_VERSION);
        params.putIfAbsent("Timestamp", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).format(new Date()));
        params.putIfAbsent("AccessKeyId", credentials.accessKeyId());
        if (credentials.securityToken() != null) {
            params.putIfAbsent("SecurityToken", credentials.securityToken());
        }
    }

    private String buildCanonicalQueryString(Map<String, Object> params) {
        List<String> sortedKeys = new ArrayList<>(params.keySet());
        Collections.sort(sortedKeys);
        StringBuilder builder = new StringBuilder();
        for (String key : sortedKeys) {
            Object value = params.get(key);
            if (value == null) {
                continue;
            }
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(percentEncode(key)).append("=").append(percentEncode(value.toString()));
        }
        return builder.toString();
    }

    private String percentEncode(String value) {
        if (value == null) {
            return "";
        }
        try {
            return URLEncoder.encode(value, "UTF-8")
                    .replace("+", "%20")
                    .replace("*", "%2A")
                    .replace("%7E", "~");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String hash(byte[] data) throws CloudSdkException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return bytesToHex(md.digest(data));
        } catch (NoSuchAlgorithmException e) {
            throw new CloudSdkException("HashError", "SHA-256 计算失败", null, 0, e);
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    @Override
    public String signatureMethod() {
        return SIGNATURE_METHOD;
    }
}
