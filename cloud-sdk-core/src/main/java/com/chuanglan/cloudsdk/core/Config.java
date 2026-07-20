package com.chuanglan.cloudsdk.core;

/**
 * SDK 客户端配置。
 */
public class Config extends CloudSdkModel {

    @NameInMap("accessKeyId")
    private String accessKeyId;

    @NameInMap("accessKeySecret")
    private String accessKeySecret;

    @NameInMap("securityToken")
    private String securityToken;

    @NameInMap("endpoint")
    private String endpoint;

    @NameInMap("regionId")
    private String regionId = "cn-hangzhou";

    @NameInMap("protocol")
    private String protocol = "https";

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getRegionId() {
        return regionId;
    }

    public String getProtocol() {
        return protocol;
    }

    public Config setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public Config setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
        return this;
    }

    public Config setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
        return this;
    }

    public Config setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public Config setRegionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    public Config setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }
}
