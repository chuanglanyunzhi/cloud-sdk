package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.chuanglan.cloudsdk.core.SignatureUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * 253 视频短信（RCS）签名工具：HmacSHA256 签名。
 *
 * <p>签名规则：
 * <ol>
 *     <li>将所有参与签名的参数按键名 ASCII 码从小到大排序；</li>
 *     <li>剔除 {@code body} 与 {@code signature} 两个字段；</li>
 *     <li>将键值对拼接为 {@code key1=value1&key2=value2...} 形式的明文；</li>
 *     <li>以 {@code appSecret} 为密钥，对明文计算 HmacSHA256，结果为小写 16 进制字符串。</li>
 * </ol>
 */
public final class RcsSmsSignatureUtil {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 使用 ThreadLocal&lt;SecureRandom&gt; 避免多线程竞争，同时保证密码学安全。
     * 不能用 {@link java.util.Random}，其线性同余算法可被预测，存在重放风险。
     */
    private static final ThreadLocal<SecureRandom> RNG = ThreadLocal.withInitial(SecureRandom::new);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private RcsSmsSignatureUtil() {
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
     * 计算 HmacSHA256 签名。
     *
     * @param appSecret 应用密钥
     * @param params    待签名参数，自动剔除 {@code body} 与 {@code signature}
     * @return 小写 16 进制签名值
     */
    public static String checksum(String appSecret, Map<String, Object> params) throws CloudSdkException {
        if (appSecret == null || appSecret.isEmpty()) {
            throw new CloudSdkException("ChecksumError", "appSecret 不能为空", null, 0);
        }
        try {
            TreeMap<String, Object> sorted = new TreeMap<>();
            if (params != null) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    String key = entry.getKey();
                    if ("body".equals(key) || "signature".equals(key)) {
                        continue;
                    }
                    sorted.put(key, entry.getValue());
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : sorted.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(entry.getKey()).append("=").append(formatValue(entry.getValue()));
            }

            return SignatureUtil.hmac(appSecret, sb.toString());
        } catch (Exception e) {
            throw new CloudSdkException("ChecksumError", "签名计算失败: " + e.getMessage(), null, 0, e);
        }
    }

    private static String formatValue(Object value) throws Exception {
        if (value == null) {
            return "";
        }
        if (value instanceof Collection) {
            return MAPPER.writeValueAsString(value);
        }
        return value.toString();
    }
}
