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
    private String signName;

    /**
     * 签名类型。
     */
    private String type;

    /**
     * 资质 ID。
     */
    private String qualificationId;

    /**
     * 备注。
     */
    private String remark;

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

    public String getSignName() {
        return this.signName;
    }

    public String getType() {
        return this.type;
    }

    public String getQualificationId() {
        return this.qualificationId;
    }

    public String getRemark() {
        return this.remark;
    }
}
