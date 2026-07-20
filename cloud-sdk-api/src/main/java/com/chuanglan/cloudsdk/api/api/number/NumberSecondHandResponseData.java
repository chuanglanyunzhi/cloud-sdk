package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 二次号查询业务数据。
 */
public class NumberSecondHandResponseData extends CloudSdkModel {

    /**
     * 透传订单返回。
     */
    private String orderNo;

    /**
     * 查询时间，样例：2022-12-10 00:00:00。
     * 注：文档中字段名为 hanleTime，返回示例中为 handleTime，这里以示例为准。
     */
    private String handleTime;

    /**
     * 手机号。
     */
    private String mobile;

    /**
     * 归属地，例：北京-北京（加密查询时不返回）。
     */
    private String area;

    /**
     * 运营商类型：1 移动，2 联通，3 电信，4 广电。
     */
    private String numberType;

    /**
     * 1 是二次号（收费），2 不是二次号（收费），3 已销号（收费），9 服务器异常（不收费），10 查询失败（不收费），11 未知（不收费）。
     */
    private String status;

    /**
     * 是否携号转网：0 未转网，1 有过转网。
     */
    private String portability;

    /**
     * 结果备注。
     */
    private String remark;

    public NumberSecondHandResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public NumberSecondHandResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public NumberSecondHandResponseData setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public NumberSecondHandResponseData setArea(String area) {
        this.area = area;
        return this;
    }

    public NumberSecondHandResponseData setNumberType(String numberType) {
        this.numberType = numberType;
        return this;
    }

    public NumberSecondHandResponseData setStatus(String status) {
        this.status = status;
        return this;
    }

    public NumberSecondHandResponseData setPortability(String portability) {
        this.portability = portability;
        return this;
    }

    public NumberSecondHandResponseData setRemark(String remark) {
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

    public String getPortability() {
        return this.portability;
    }

    public String getRemark() {
        return this.remark;
    }
}
