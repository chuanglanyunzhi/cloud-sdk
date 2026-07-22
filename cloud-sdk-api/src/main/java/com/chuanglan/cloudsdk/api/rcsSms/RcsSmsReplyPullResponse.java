package com.chuanglan.cloudsdk.api.rcsSms;

import java.util.List;

/**
 * 上行回复拉取响应。
 *
 * <p>data 直接为上行消息列表（非 total+list 结构）。
 */
public class RcsSmsReplyPullResponse extends RcsSmsCommonResponse {

    /**
     * 上行消息列表。
     */
    private List<RcsSmsReplyItem> data;

    public RcsSmsReplyPullResponse setData(List<RcsSmsReplyItem> data) {
        this.data = data;
        return this;
    }

    public List<RcsSmsReplyItem> getData() {
        return this.data;
    }
}
