package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 签名信息。
 */
public class RcsSmsSignInfo extends CloudSdkModel {

    /**
     * 签名 ID。
     */
    private String signId;

    /**
     * 签名名称。
     */
    private String signName;

    /**
     * 签名状态。
     */
    private String status;

    /**
     * 创建时间。
     */
    private String createTime;

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

    public String getSignId() {
        return this.signId;
    }

    public String getSignName() {
        return this.signName;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCreateTime() {
        return this.createTime;
    }
}
