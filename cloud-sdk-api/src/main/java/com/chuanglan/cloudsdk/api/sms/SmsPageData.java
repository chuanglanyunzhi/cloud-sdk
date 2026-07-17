package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 分页数据结构。
 */
public class SmsPageData<T> extends CloudSdkModel {

    /**
     * 列表总数。
     */
    public Integer total;

    /**
     * 数据列表。
     */
    public List<T> list;

    public SmsPageData<T> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public SmsPageData<T> setList(List<T> list) {
        this.list = list;
        return this;
    }
}
