package com.chuanglan.cloudsdk.api.intSms;

import java.util.List;

/**
 * 国际短信上行回复拉取响应。
 */
public class IntSmsReplyPullResponse extends IntSmsCommonResponse {

    /**
     * 上行回复短信数据集。
     */
    private List<IntSmsReplyItem> data;

    public IntSmsReplyPullResponse setData(List<IntSmsReplyItem> data) {
        this.data = data;
        return this;
    }

    public List<IntSmsReplyItem> getData() {
        return this.data;
    }
}
