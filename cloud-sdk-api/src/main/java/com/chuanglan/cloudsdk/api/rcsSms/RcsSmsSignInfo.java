package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 签名信息。
 */
public class RcsSmsSignInfo extends CloudSdkModel {

    /**
     * 签名 ID。
     */
    public String signId;

    /**
     * 签名名称。
     */
    public String signName;

    /**
     * 签名状态。
     */
    public String status;

    /**
     * 创建时间。
     */
    public String createTime;

    public RcsSmsSignInfo setSignId(String signId) {
        this.signId = signId;
        return this;
    }

    public RcsSmsSignInfo setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    public RcsSmsSignInfo setStatus(String status) {
        this.status = status;
        return this;
    }

    public RcsSmsSignInfo setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }
}
