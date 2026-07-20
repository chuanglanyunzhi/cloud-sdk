package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 号码状态检测单条结果。
 */
public class NumberStatusCheckResponseItem extends CloudSdkModel {

    /**
     * 手机号。
     */
    private String mobile;

    /**
     * 订单号 / 检测时间戳。
     */
    private String lastTime;

    /**
     * 手机号所属区域，样例：省-市。
     */
    private String area;

    /**
     * 手机号运营商类型，样例：中国移动/联通/电信/虚拟运营商。
     */
    private String numberType;

    /**
     * 检测结果：0 空号，1 实号，3 库无，4 沉默号。
     */
    private Integer status;

    /**
     * 1：收费；0：不收费。
     */
    private String chargesStatus;

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

    public String getMobile() {
        return this.mobile;
    }

    public String getLastTime() {
        return this.lastTime;
    }

    public String getArea() {
        return this.area;
    }

    public String getNumberType() {
        return this.numberType;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getChargesStatus() {
        return this.chargesStatus;
    }
}
