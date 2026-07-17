package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 银行卡三要素精准版非身份证核验请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankCardThreeAuthPrecisionRequest extends CloudSdkModel {

    /**
     * 姓名。
     */
    public String name;

    /**
     * 身份证号码。
     */
    public String idNum;

    /**
     * 银行卡号。
     */
    public String cardNo;

    /**
     * 证件类型（默认不填为身份证）。
     * 02：军官证，03：护照，05：士兵证，06：内地居民来往港澳通行证，
     * 07：台湾同胞来往内地通行证，09：外国人永久居住证，10：警官证，
     * 15：港澳居民来往内地通行证（回乡证），18：台湾居民居住证，
     * 19：港澳居民居住证，20：外国护照，21：旅行证，22：出入境通行证。
     */
    public String idType;

    public BankCardThreeAuthPrecisionRequest setName(String name) {
        this.name = name;
        return this;
    }

    public BankCardThreeAuthPrecisionRequest setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public BankCardThreeAuthPrecisionRequest setCardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public BankCardThreeAuthPrecisionRequest setIdType(String idType) {
        this.idType = idType;
        return this;
    }
}
