package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.SignatureAlgorithm;
import com.chuanglan.cloudsdk.core.SignatureUtil;

import java.util.UUID;

/**
 * 国际短信公共请求头工具：生成 Nonce、CurTime、CheckSum。
 */
public final class IntSmsSignatureUtil {

    private IntSmsSignatureUtil() {
    }

    /**
     * 生成 32 位随机字符串（UUID 去横线）。
     */
    public static String generateNonce() {
        return UUID.randomUUID().toString().replace("-", "");
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
}
