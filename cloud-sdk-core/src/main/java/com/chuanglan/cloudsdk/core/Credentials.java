package com.chuanglan.cloudsdk.core;

/**
 * 凭证接口。
 */
public interface Credentials {

    String accessKeyId();

    String accessKeySecret();

    /**
     * 临时凭证的安全令牌，非 STS 凭证返回 null。
     */
    default String securityToken() {
        return null;
    }
}
