package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 身份证人像比对 V2.0 响应数据。
 */
public class IdMatchResponseData extends CloudSdkModel {

    /**
     * 业务唯一流水号。
     */
    private String orderNo;

    /**
     * 处理时间。
     */
    private String handleTime;

    /**
     * 最终返回结果：01 一致（收费），02 不一致（收费），03 库无（不收费），04 认证失败（不收费）。
     */
    private String result;

    /**
     * 身份证核验结果：01 一致，02 不一致，03 库无，04 认证失败。
     */
    private String idcardResult;

    /**
     * 身份证核验结果说明。
     */
    private String idcardMessage;

    /**
     * 图像结果：01 判断为同一人，02 判断不是同一人，03 不能确定是否为同一人，04 认证失败，
     * 05 身份校验未通过，06 库中无照片，07 图片质量不合格，08 库中无此号，09 无法验证。
     */
    private String photoResult;

    /**
     * 图像结果说明。
     */
    private String photoMessage;

    /**
     * 照片相似分数（0-100 或 0-1000，取决于 useThousandScale）。
     */
    private String photoScore;

    public IdMatchResponseData setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public IdMatchResponseData setHandleTime(String handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    public IdMatchResponseData setResult(String result) {
        this.result = result;
        return this;
    }

    public IdMatchResponseData setIdcardResult(String idcardResult) {
        this.idcardResult = idcardResult;
        return this;
    }

    public IdMatchResponseData setIdcardMessage(String idcardMessage) {
        this.idcardMessage = idcardMessage;
        return this;
    }

    public IdMatchResponseData setPhotoResult(String photoResult) {
        this.photoResult = photoResult;
        return this;
    }

    public IdMatchResponseData setPhotoMessage(String photoMessage) {
        this.photoMessage = photoMessage;
        return this;
    }

    public IdMatchResponseData setPhotoScore(String photoScore) {
        this.photoScore = photoScore;
        return this;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getHandleTime() {
        return this.handleTime;
    }

    public String getResult() {
        return this.result;
    }

    public String getIdcardResult() {
        return this.idcardResult;
    }

    public String getIdcardMessage() {
        return this.idcardMessage;
    }

    public String getPhotoResult() {
        return this.photoResult;
    }

    public String getPhotoMessage() {
        return this.photoMessage;
    }

    public String getPhotoScore() {
        return this.photoScore;
    }
}
