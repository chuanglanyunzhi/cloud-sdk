package com.chuanglan.cloudsdk.core;

/**
 * 签名算法枚举。
 */
public enum SignatureAlgorithm {

    /**
     * SHA1 摘要算法，结果大写。
     */
    SHA1("SHA1", true),

    /**
     * SHA-256 摘要算法，结果小写。
     */
    SHA256("SHA-256", false),

    /**
     * HmacSHA256 算法，结果小写。
     */
    HMAC_SHA256("HmacSHA256", false);

    private final String algorithm;
    private final boolean uppercase;

    SignatureAlgorithm(String algorithm, boolean uppercase) {
        this.algorithm = algorithm;
        this.uppercase = uppercase;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public boolean isUppercase() {
        return uppercase;
    }
}
