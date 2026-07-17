package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 号码状态检测单条结果。
 */
public class NumberStatusCheckResponseItem extends CloudSdkModel {

    /**
     * 手机号。
     */
    public String mobile;

    /**
     * 订单号 / 检测时间戳。
     */
    public String lastTime;

    /**
     * 手机号所属区域，样例：省-市。
     */
    public String area;

    /**
     * 手机号运营商类型，样例：中国移动/联通/电信/虚拟运营商。
     */
    public String numberType;

    /**
     * 检测结果：0 空号，1 实号，3 库无，4 沉默号。
     */
    public Integer status;

    /**
     * 1：收费；0：不收费。
     */
    public String chargesStatus;

    public NumberStatusCheckResponseItem setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public NumberStatusCheckResponseItem setLastTime(String lastTime) {
        this.lastTime = lastTime;
        return this;
    }

    public NumberStatusCheckResponseItem setArea(String area) {
        this.area = area;
        return this;
    }

    public NumberStatusCheckResponseItem setNumberType(String numberType) {
        this.numberType = numberType;
        return this;
    }

    public NumberStatusCheckResponseItem setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public NumberStatusCheckResponseItem setChargesStatus(String chargesStatus) {
        this.chargesStatus = chargesStatus;
        return this;
    }
}
