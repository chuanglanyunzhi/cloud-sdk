package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 国际短信上行回复拉取请求。
 */
public class IntSmsReplyPullRequest extends CloudSdkModel {

    /**
     * 拉取数据条数，默认 20，上限 100。
     */
    private String count;

    public IntSmsReplyPullRequest setCount(String count) {
        this.count = count;
        return this;
    }

    public String getCount() {
        return this.count;
    }
}
