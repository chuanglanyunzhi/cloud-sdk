package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 运营商三要素详细版 MD5 核验不一致详情。
 */
public class CarriersAuthDetailMd5Detail extends CloudSdkModel {

    /**
     * 详细返回代码：02 手机号已实名，但身份证和姓名均不一致；03 手机号已实名，手机号和证件号一致，姓名不一致；04 手机号已实名，手机号和姓名一致，身份证不一致；05 其他不一致；06 姓名身份证不一致。
     */
    private String code;

    /**
     * 详细描述。
     */
    private String remark;

    public CarriersAuthDetailMd5Detail setCode(String code) {
        this.code = code;
        return this;
    }

    public CarriersAuthDetailMd5Detail setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public String getRemark() {
        return this.remark;
    }
}
