package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 身份证 OCR 识别数据。
 */
public class IdOcrData extends CloudSdkModel {

    /**
     * 交易号，唯一。
     */
    public String tradeNo;

    /**
     * 身份证上地址（仅 ocrType 为 0 时返回）。
     */
    public String address;

    /**
     * 身份证上出生日期（仅 ocrType 为 0 时返回）。
     */
    public String birth;

    /**
     * 身份证上姓名（仅 ocrType 为 0 时返回）。
     */
    public String name;

    /**
     * 身份证编号（仅 ocrType 为 0 时返回）。
     */
    public String cardNum;

    /**
     * 身份证上性别（仅 ocrType 为 0 时返回）。
     */
    public String sex;

    /**
     * 身份证上民族（仅 ocrType 为 0 时返回）。
     */
    public String nation;

    /**
     * 签发机关（仅 ocrType 为 1 时返回）。
     */
    public String issuingAuthority;

    /**
     * 签发日期（仅 ocrType 为 1 时返回）。
     */
    public String issuingDate;

    /**
     * 有效日期（仅 ocrType 为 1 时返回）。
     */
    public String expiryDate;

    /**
     * 图像状态：normal/reversed_side/non_idcard/blurred/not_complete/over_dark/over_exposure/unknown。
     */
    public String imageStatus;

    /**
     * 身份证风险类型：normal-正常身份证；copy-复印件。
     */
    public String riskType;

    /**
     * 图像方向：-1 未定义；0 正向；1 逆时针 90 度；2 逆时针 180 度；3 逆时针 270 度。
     */
    public String direction;

    public IdOcrData setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }

    public IdOcrData setAddress(String address) {
        this.address = address;
        return this;
    }

    public IdOcrData setBirth(String birth) {
        this.birth = birth;
        return this;
    }

    public IdOcrData setName(String name) {
        this.name = name;
        return this;
    }

    public IdOcrData setCardNum(String cardNum) {
        this.cardNum = cardNum;
        return this;
    }

    public IdOcrData setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public IdOcrData setNation(String nation) {
        this.nation = nation;
        return this;
    }

    public IdOcrData setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
        return this;
    }

    public IdOcrData setIssuingDate(String issuingDate) {
        this.issuingDate = issuingDate;
        return this;
    }

    public IdOcrData setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public IdOcrData setImageStatus(String imageStatus) {
        this.imageStatus = imageStatus;
        return this;
    }

    public IdOcrData setRiskType(String riskType) {
        this.riskType = riskType;
        return this;
    }

    public IdOcrData setDirection(String direction) {
        this.direction = direction;
        return this;
    }
}
