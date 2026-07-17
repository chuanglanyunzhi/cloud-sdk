package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 身份证 OCR V2 识别数据。
 */
public class IdOcrV2Data extends CloudSdkModel {

    /**
     * front 正面，back 背面。
     */
    public String side;

    /**
     * 返回结果。
     */
    public IdOcrV2Result result;

    public IdOcrV2Data setSide(String side) {
        this.side = side;
        return this;
    }

    public IdOcrV2Data setResult(IdOcrV2Result result) {
        this.result = result;
        return this;
    }
}
