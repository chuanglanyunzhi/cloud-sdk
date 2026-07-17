package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 涉外身份证核验（人像）响应数据。
 */
public class ForeignIdMatchResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    public String orderNo;

    /**
     * 处理时间。
     */
    public String handleTime;

    /**
     * 最终返回结果：01 一致（收费），02 不一致（收费），03 库无（不收费），04 认证失败（不收费）。
     */
    public String result;

    /**
     * 身份证核验结果。
     */
    public String idcardResult;

    /**
     * 身份证核验结果说明。
     */
    public String idcardMessage;

    /**
     * 图像结果。
     */
    public String photoResult;

    /**
     * 图像结果说明。
     */
    public String photoMessage;

    /**
     * 证件是否有效：0 证件无效，1 证件有效，2 无法确认。
     */
    public String isValid;

    /**
     * 结果说明。
     */
    public String remark;

    public ForeignIdMatchResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public ForeignIdMatchResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public ForeignIdMatchResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public ForeignIdMatchResponseData setIdcardResult(String idcardResult) {
        this.idcardResult = idcardResult;
        return this;
    }

    public ForeignIdMatchResponseData setIdcardMessage(String idcardMessage) {
        this.idcardMessage = idcardMessage;
        return this;
    }

    public ForeignIdMatchResponseData setPhotoResult(String photoResult) {
        this.photoResult = photoResult;
        return this;
    }

    public ForeignIdMatchResponseData setPhotoMessage(String photoMessage) {
        this.photoMessage = photoMessage;
        return this;
    }

    public ForeignIdMatchResponseData setIsValid(String isValid) {
        this.isValid = isValid;
        return this;
    }

    public ForeignIdMatchResponseData setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
