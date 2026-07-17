package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.HexUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 253 短信公共请求头工具：生成 Nonce、CurTime、CheckSum。
 */
public final class SmsSignatureUtil {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    private SmsSignatureUtil() {
    }

    /**
     * 生成 32 位随机字符串。
     */
    public static String generateNonce() {
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0; i < 32; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    /**
     * 当前 UTC 时间戳，秒级。
     */
    public static String currentTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    /**
     * 计算 CheckSum：SHA256(AppSecret + Nonce + CurTime)，结果为小写 16 进制字符串。
     */
    public static String checksum(String appSecret, String nonce, String curTime) throws CloudSdkException {
        String raw = appSecret + nonce + curTime;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(raw.getBytes(StandardCharsets.UTF_8));
            return HexUtil.bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new CloudSdkException("ChecksumError", "SHA-256 算法不可用", null, 0, e);
        }
    }
}
