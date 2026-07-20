package com.chuanglan.cloudsdk.api.api.mnp;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

import java.util.List;

/**
 * 携号转网 V1 查询业务数据。
 */
public class MnpCarriersSftpResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    private String batchNo;

    /**
     * 查询结果列表。
     */
    private List<MnpCarriersSftpResult> queryResult;

    public MnpCarriersSftpResponseData setBatchNo(String batchNo) {
        this.batchNo = batchNo;
        return this;
    }

    public MnpCarriersSftpResponseData setQueryResult(List<MnpCarriersSftpResult> queryResult) {
        this.queryResult = queryResult;
        return this;
    }

    public String getBatchNo() {
        return this.batchNo;
    }

    public List<MnpCarriersSftpResult> getQueryResult() {
        return this.queryResult;
    }
}
