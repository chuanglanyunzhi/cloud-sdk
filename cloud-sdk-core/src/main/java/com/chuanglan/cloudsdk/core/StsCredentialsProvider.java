package com.chuanglan.cloudsdk.core;

/**
 * STS 临时凭证提供者。
 */
public class StsCredentialsProvider implements CredentialsProvider {

    private final String accessKeyId;
    private final String accessKeySecret;
    private final String securityToken;

    public StsCredentialsProvider(String accessKeyId, String accessKeySecret, String securityToken) {
        if (accessKeyId == null || accessKeyId.isEmpty()) {
            throw new IllegalArgumentException("accessKeyId must not be empty");
        }
        if (accessKeySecret == null || accessKeySecret.isEmpty()) {
            throw new IllegalArgumentException("accessKeySecret must not be empty");
        }
        if (securityToken == null || securityToken.isEmpty()) {
            throw new IllegalArgumentException("securityToken must not be empty");
        }
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.securityToken = securityToken;
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

            @Override
            public String securityToken() {
                return securityToken;
            }
        };
    }
}
