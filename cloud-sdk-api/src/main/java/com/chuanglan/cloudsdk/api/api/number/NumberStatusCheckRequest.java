package com.chuanglan.cloudsdk.api.api.number;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 号码状态检测请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberStatusCheckRequest extends CloudSdkModel {

    /**
     * 检测手机号，多个手机号码用英文半角逗号隔开，最多 50 个。
     */
    public String mobiles;

    /**
     * 查询类型：1=MD5（32 位小写），2=SHA256（64 位小写），0=普通手机号；默认 0。
     */
    public Integer type;

    /**
     * 1：高精度，0：高覆盖；默认 1。
     */
    public Integer sceneType;

    /**
     * 默认 0。
     */
    public Integer statusType;

    public NumberStatusCheckRequest setMobiles(String mobiles) {
        this.mobiles = mobiles;
        return this;
    }

    public NumberStatusCheckRequest setType(Integer type) {
        this.type = type;
        return this;
    }

    public NumberStatusCheckRequest setSceneType(Integer sceneType) {
        this.sceneType = sceneType;
        return this;
    }

    public NumberStatusCheckRequest setStatusType(Integer statusType) {
        this.statusType = statusType;
        return this;
    }
}
