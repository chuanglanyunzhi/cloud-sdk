package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 运营商三要素详细版 SHA256 核验响应数据。
 */
public class CarriersAuthDetailSha256ResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    private String orderNo;

    /**
     * 查询时间。
     */
    private String handleTime;

    /**
     * 运营商类型：1 移动，2 联通，3 电信，4 广电。
     */
    private String type;

    /**
     * 认证结果：01 一致（收费），02 不一致（收费），03 不确定（不收费），04 失败（不收费）。
     */
    private String result;

    /**
     * 备注。
     */
    private String remark;

    /**
     * 详情信息（result 为 02 时返回）。
     */
    private CarriersAuthDetailSha256Detail detail;

    public CarriersAuthDetailSha256ResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public CarriersAuthDetailSha256ResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public CarriersAuthDetailSha256ResponseData setType(String type) {
        this.type = type;
        return this;
    }

    public CarriersAuthDetailSha256ResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public CarriersAuthDetailSha256ResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public CarriersAuthDetailSha256ResponseData setDetail(CarriersAuthDetailSha256Detail detail) {
        this.detail = detail;
        return this;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getHandleTime() {
        return this.handleTime;
    }

    public String getType() {
        return this.type;
    }

    public String getResult() {
        return this.result;
    }

    public String getRemark() {
        return this.remark;
    }

    public CarriersAuthDetailSha256Detail getDetail() {
        return this.detail;
    }
}
