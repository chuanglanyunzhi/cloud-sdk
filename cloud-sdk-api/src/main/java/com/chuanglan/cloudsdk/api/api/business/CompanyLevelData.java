package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 企业大中小微划型服务返回数据。
 */
public class CompanyLevelData extends CloudSdkModel {

    /**
     * 企业级别。
     */
    private String level;

    /**
     * 划分说明。
     */
    private String type;

    public CompanyLevelData setLevel(String level) {
        this.level = level;
        return this;
    }

    public CompanyLevelData setType(String type) {
        this.type = type;
        return this;
    }

    public String getLevel() {
        return this.level;
    }

    public String getType() {
        return this.type;
    }
}
