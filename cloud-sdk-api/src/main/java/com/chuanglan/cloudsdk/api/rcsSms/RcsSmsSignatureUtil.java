package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.SignatureAlgorithm;
import com.chuanglan.cloudsdk.core.SignatureUtil;

/**
 * 253 视频短信（RCS）签名工具：SHA1 签名。
 *
 * <p>签名规则：
 * <ol>
 *     <li>拼接字符串 {@code appSecret + nonce + curTime}；</li>
 *     <li>对拼接结果计算 SHA1，结果为大写 16 进制字符串。</li>
 * </ol>
 */
public final class RcsSmsSignatureUtil {

    private RcsSmsSignatureUtil() {
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
     * 计算 CheckSum：SHA1(AppSecret + Nonce + CurTime)，结果为大写 16 进制字符串。
     *
     * @param appSecret 应用密钥
     * @param nonce     随机字符串
     * @param curTime   当前时间戳（秒级）
     * @return 大写 16 进制签名值
     */
    public static String checksum(String appSecret, String nonce, String curTime) throws CloudSdkException {
        if (appSecret == null || nonce == null || curTime == null) {
            throw new CloudSdkException("ChecksumError", "签名参数不能为空", null, 0);
        }
        return SignatureUtil.digest(appSecret, nonce, curTime, SignatureAlgorithm.SHA1);
    }
}
