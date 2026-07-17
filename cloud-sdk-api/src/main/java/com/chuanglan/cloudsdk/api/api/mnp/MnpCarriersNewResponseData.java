package com.chuanglan.cloudsdk.api.api.mnp;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 携号转网 V1 查询业务数据。
 */
public class MnpCarriersNewResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    public String batchNo;

    /**
     * 查询结果列表。
     */
    public List<MnpCarriersNewResult> queryResult;

    public MnpCarriersNewResponseData setBatchNo(String batchNo) {
        this.batchNo = batchNo;
        return this;
    }

    public MnpCarriersNewResponseData setQueryResult(List<MnpCarriersNewResult> queryResult) {
        this.queryResult = queryResult;
        return this;
    }
}
