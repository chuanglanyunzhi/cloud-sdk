package com.chuanglan.cloudsdk.core;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * 统一签名工具，支持多种签名算法。
 */
public final class SignatureUtil {

    private static final String NONCE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 使用 ThreadLocal&lt;SecureRandom&gt; 避免多线程竞争，同时保证密码学安全。
     * 不能用 {@link java.util.Random}，其线性同余算法可被预测，存在重放风险。
     */
    private static final ThreadLocal<SecureRandom> RNG = ThreadLocal.withInitial(SecureRandom::new);

    private SignatureUtil() {
    }

    /**
     * 当前 UTC 时间戳，秒级。各业务线签名均以此为基准，统一实现避免时间语义漂移。
     */
    public static String currentTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    /**
     * 生成指定长度的随机字母数字字符串，用作签名 Nonce。
     */
    public static String generateNonce(int length) {
        SecureRandom rng = RNG.get();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(NONCE_CHARACTERS.charAt(rng.nextInt(NONCE_CHARACTERS.length())));
        }
        return sb.toString();
    }

    /**
     * 计算摘要签名（无密钥，仅 AppSecret + Nonce + CurTime 拼接）。
     *
     * @param appSecret 密钥
     * @param nonce     随机字符串
     * @param curTime   时间戳
     * @param algorithm  签名算法
     * @return 十六进制签名字符串
     */
    public static String digest(String appSecret, String nonce, String curTime, SignatureAlgorithm algorithm) {
        if (appSecret == null || nonce == null || curTime == null) {
            throw new CloudSdkException("ChecksumError", "签名参数不能为空", null, 0);
        }
        String raw = appSecret + nonce + curTime;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm.getAlgorithm());
            byte[] digest = md.digest(raw.getBytes(StandardCharsets.UTF_8));
            String hex = HexUtil.bytesToHex(digest);
            return algorithm.isUppercase() ? hex.toUpperCase() : hex;
        } catch (NoSuchAlgorithmException e) {
            throw new CloudSdkException("ChecksumError", algorithm + " 算法不可用", null, 0, e);
        }
    }

    /**
     * 计算 HMAC 签名（基于密钥的签名）。
     *
     * @param appSecret 密钥
     * @param data      待签名数据
     * @return 小写十六进制签名字符串
     */
    public static String hmac(String appSecret, String data) {
        if (appSecret == null || data == null) {
            throw new CloudSdkException("ChecksumError", "签名参数不能为空", null, 0);
        }
        try {
            Mac mac = Mac.getInstance(SignatureAlgorithm.HMAC_SHA256.getAlgorithm());
            mac.init(new SecretKeySpec(appSecret.getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HMAC_SHA256.getAlgorithm()));
            byte[] digest = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return HexUtil.bytesToHex(digest);
        } catch (Exception e) {
            throw new CloudSdkException("ChecksumError", "HmacSHA256 签名计算失败: " + e.getMessage(), null, 0, e);
        }
    }
}
