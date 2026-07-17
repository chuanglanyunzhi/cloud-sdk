package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 运营商三要素详细版核验详情信息。
 */
public class CarriersAuthDetailResponseDetail extends CloudSdkModel {

    /**
     * 详细的返回代码。
     */
    public String code;

    /**
     * 详细描述。
     */
    public String remark;

    public CarriersAuthDetailResponseDetail setCode(String code) {
        this.code = code;
        return this;
    }

    public CarriersAuthDetailResponseDetail setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
