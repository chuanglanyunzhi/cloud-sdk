package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.SignatureAlgorithm;
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
     * 计算 CheckSum：SHA256(AppSecret + Nonce + CurTime)，结果为小写 16 进制字符串。
     */
    public static String checksum(String appSecret, String nonce, String curTime) throws CloudSdkException {
        return SignatureUtil.digest(appSecret, nonce, curTime, SignatureAlgorithm.SHA256);
    }
}
