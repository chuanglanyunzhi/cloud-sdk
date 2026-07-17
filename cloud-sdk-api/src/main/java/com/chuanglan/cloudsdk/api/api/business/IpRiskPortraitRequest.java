package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * IP 风险画像请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpRiskPortraitRequest extends CloudSdkModel {

    /**
     * IP 地址，支持 IPv4。
     */
    public String ip;

    public IpRiskPortraitRequest setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
