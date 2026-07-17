package com.chuanglan.cloudsdk.core;

/**
 * SDK 客户端配置。
 */
public class Config extends CloudSdkModel {

    @NameInMap("accessKeyId")
    public String accessKeyId;

    @NameInMap("accessKeySecret")
    public String accessKeySecret;

    @NameInMap("securityToken")
    public String securityToken;

    @NameInMap("endpoint")
    public String endpoint;

    @NameInMap("regionId")
    public String regionId = "cn-hangzhou";

    @NameInMap("protocol")
    public String protocol = "https";

    public String endpoint() {
        return endpoint;
    }

    public String regionId() {
        return regionId;
    }

    public String protocol() {
        return protocol;
    }
}
