package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 添加签名请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsSignAddRequest extends CloudSdkModel {

    /**
     * 签名名称。
     */
    public String signName;

    /**
     * 签名类型。
     */
    public String type;

    /**
     * 资质 ID。
     */
    public String qualificationId;

    /**
     * 备注。
     */
    public String remark;

    public RcsSmsSignAddRequest setSignName(String signName) {
        this.signName = signName;
        return this;
    }

    public RcsSmsSignAddRequest setType(String type) {
        this.type = type;
        return this;
    }

    public RcsSmsSignAddRequest setQualificationId(String qualificationId) {
        this.qualificationId = qualificationId;
        return this;
    }

    public RcsSmsSignAddRequest setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
