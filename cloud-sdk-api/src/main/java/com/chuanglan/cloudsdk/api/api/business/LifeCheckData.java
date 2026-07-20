package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 动态活体检测数据。
 */
public class LifeCheckData extends CloudSdkModel {

    /**
     * 检测结果。
     */
    private LifeCheckResult result;

    /**
     * 流水号。
     */
    private String request_id;

    public LifeCheckData setResult(LifeCheckResult result) {
        this.result = result;
        return this;
    }

    public LifeCheckData setRequest_id(String request_id) {
        this.request_id = request_id;
        return this;
    }

    public LifeCheckResult getResult() {
        return this.result;
    }

    public String getRequest_id() {
        return this.request_id;
    }
}
