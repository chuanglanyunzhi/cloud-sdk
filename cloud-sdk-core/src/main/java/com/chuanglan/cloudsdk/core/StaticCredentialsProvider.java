package com.chuanglan.cloudsdk.core;

/**
 * 静态凭证提供者。
 */
public class StaticCredentialsProvider implements CredentialsProvider {

    private final String accessKeyId;
    private final String accessKeySecret;

    public StaticCredentialsProvider(String accessKeyId, String accessKeySecret) {
        if (accessKeyId == null || accessKeyId.isEmpty()) {
            throw new IllegalArgumentException("accessKeyId must not be empty");
        }
        if (accessKeySecret == null || accessKeySecret.isEmpty()) {
            throw new IllegalArgumentException("accessKeySecret must not be empty");
        }
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }

    @Override
    public Credentials getCredentials() {
        return new Credentials() {
            @Override
            public String accessKeyId() {
                return accessKeyId;
            }

            @Override
            public String accessKeySecret() {
                return accessKeySecret;
            }
        };
    }
}
