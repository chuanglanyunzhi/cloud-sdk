package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.SignatureAlgorithm;
import com.chuanglan.cloudsdk.core.SignatureUtil;

import java.security.SecureRandom;

/**
 * 253 短信公共请求头工具：生成 Nonce、CurTime、CheckSum。
 */
public final class SmsSignatureUtil {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 使用 ThreadLocal&lt;SecureRandom&gt; 避免多线程竞争，同时保证密码学安全。
     * 不能用 {@link java.util.Random}，其线性同余算法可被预测，存在重放风险。
     */
    private static final ThreadLocal<SecureRandom> RNG = ThreadLocal.withInitial(SecureRandom::new);

    private SmsSignatureUtil() {
    }

    /**
     * 生成 32 位随机字符串。
     */
    public static String generateNonce() {
        SecureRandom rng = RNG.get();
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0; i < 32; i++) {
            sb.append(CHARACTERS.charAt(rng.nextInt(CHARACTERS.length())));
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
        return SignatureUtil.digest(appSecret, nonce, curTime, SignatureAlgorithm.SHA256);
    }
}
