package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.SignatureUtil;

/**
 * 253 短信公共请求头工具：生成 Nonce、CurTime、CheckSum。
 */
public final class SmsSignatureUtil {

    private SmsSignatureUtil() {
    }

    /**
     * 生成 32 位随机字符串。
     */
    public static String generateNonce() {
        return SignatureUtil.generateNonce(32);
    }

    /**
     * 当前 UTC 时间戳，秒级。
     */
    public static String currentTimestamp() {
        return SignatureUtil.currentTimestamp();
    }

    /**
     * 计算 CheckSum：使用业务方 PMD5Utils.encodeBySHA1(AppSecret + Nonce + CurTime)，转小写。
     */
    public static String checksum(String appSecret, String nonce, String curTime) throws CloudSdkException {
        if (appSecret == null || nonce == null || curTime == null) {
            throw new CloudSdkException("ChecksumError", "签名参数不能为空", null, 0);
        }
        String input = appSecret + nonce + curTime;
        return PMD5Utils.encodeBySHA1(input).toLowerCase();
    }
}
