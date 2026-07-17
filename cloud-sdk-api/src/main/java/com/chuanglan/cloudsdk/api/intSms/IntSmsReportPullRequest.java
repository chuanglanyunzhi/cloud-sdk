package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信状态报告拉取请求。
 */
public class IntSmsReportPullRequest extends CloudSdkModel {

    /**
     * 拉取数据条数，默认 20，上限 500。
     */
    public String count;

    public IntSmsReportPullRequest setCount(String count) {
        this.count = count;
        return this;
    }
}
