package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 号码实时基础版查询业务数据。
 */
public class NumberMobStatusBasicResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    private String orderNo;

    /**
     * 查询时间，例：2018-04-09 15:05:01。
     */
    private String handleTime;

    /**
     * 手机号。
     */
    private String mobile;

    /**
     * 归属地，例：北京-北京。
     */
    private String area;

    /**
     * 携号转网后的运营商类型：1 移动，2 联通，3 电信，4 广电。
     */
    private String numberType;

    /**
     * 号码状态：1 正常，2 空号，4 不在网空号，5 关机，7 在网但不可用，9 服务器异常，10 未知，12 不存在的号码，13 停机。
     */
    private String status;

    /**
     * 是否携号转网：1 是，0 否。
     */
    private String mnpStatus;

    /**
     * 备注，例：中国联通 GSM/3G-正常。
     */
    private String remark;

    public NumberMobStatusBasicResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public NumberMobStatusBasicResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public NumberMobStatusBasicResponseData setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public NumberMobStatusBasicResponseData setArea(String area) {
        this.area = area;
        return this;
    }

    public NumberMobStatusBasicResponseData setNumberType(String numberType) {
        this.numberType = numberType;
        return this;
    }

    public NumberMobStatusBasicResponseData setStatus(String status) {
        this.status = status;
        return this;
    }

    public NumberMobStatusBasicResponseData setMnpStatus(String mnpStatus) {
        this.mnpStatus = mnpStatus;
        return this;
    }

    public NumberMobStatusBasicResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getHandleTime() {
        return this.handleTime;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getArea() {
        return this.area;
    }

    public String getNumberType() {
        return this.numberType;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMnpStatus() {
        return this.mnpStatus;
    }

    public String getRemark() {
        return this.remark;
    }
}
