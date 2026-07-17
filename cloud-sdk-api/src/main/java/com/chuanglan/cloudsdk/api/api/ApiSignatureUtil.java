package com.chuanglan.cloudsdk.api.api;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.SignatureAlgorithm;
import com.chuanglan.cloudsdk.core.SignatureUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 通用 API 请求头签名工具。
 *
 * <p>根据通用请求头规范生成：
 * <ul>
 *     <li>Content-Type: application/json; charset=utf-8</li>
 *     <li>AppID: 调用方传入</li>
 *     <li>Nonce: UUID（含横线，最大长度不超过 128）</li>
 *     <li>CurTime: 当前 UTC 秒级时间戳</li>
 *     <li>CheckSum: SHA1(AppSecret + Nonce + CurTime)，大写 16 进制字符串</li>
 *     <li>X-Custom-TraceId: 可选，自定义链路追踪 ID</li>
 * </ul>
 */
public final class ApiSignatureUtil {

    private ApiSignatureUtil() {
    }

    /**
     * 生成随机 Nonce，使用 UUID（含横线）。
     */
    public static String generateNonce() {
        return UUID.randomUUID().toString();
    }

    /**
     * 当前 UTC 时间戳，秒级。
     */
    public static String currentTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    /**
     * 计算 CheckSum：SHA1(AppSecret + Nonce + CurTime)，结果为大写 16 进制字符串。
     */
    public static String checksum(String appSecret, String nonce, String curTime) throws CloudSdkException {
        return SignatureUtil.digest(appSecret, nonce, curTime, SignatureAlgorithm.SHA1);
    }

    /**
     * 生成通用请求头。
     */
    public static Map<String, String> generateHeaders(String appId, String appSecret) throws CloudSdkException {
        return generateHeaders(appId, appSecret, null);
    }

    /**
     * 生成通用请求头，支持自定义链路追踪 ID。
     */
    public static Map<String, String> generateHeaders(String appId, String appSecret, String traceId) throws CloudSdkException {
        if (appId == null || appId.isEmpty()) {
            throw new CloudSdkException("ChecksumError", "appId 不能为空", null, 0);
        }
        String nonce = generateNonce();
        String curTime = currentTimestamp();
        String checksum = checksum(appSecret, nonce, curTime);

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("AppID", appId);
        headers.put("Nonce", nonce);
        headers.put("CurTime", curTime);
        headers.put("CheckSum", checksum);
        if (traceId != null && !traceId.isEmpty()) {
            headers.put("X-Custom-TraceId", traceId);
        }
        return headers;
    }
}
