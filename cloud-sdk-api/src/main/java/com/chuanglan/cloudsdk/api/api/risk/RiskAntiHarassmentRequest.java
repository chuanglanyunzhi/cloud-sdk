package com.chuanglan.cloudsdk.api.api.risk;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 防骚扰黑名单查询请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RiskAntiHarassmentRequest extends CloudSdkModel {

    /**
     * 拦截等级（1：一般，2：敏感，3：高危）。
     */
    private Integer forbidLevel;

    /**
     * 手机号 MD5（32 位小写），多个 MD5 以英文半角逗号分隔，最多支持 500 个号码。
     */
    private String mobiles;

    /**
     * 加密类型：MD5 表示 MD5 加密；不填表示普通手机号（默认）。
     */
    private String encryptType;

    public RiskAntiHarassmentRequest setForbidLevel(Integer forbidLevel) {
        this.forbidLevel = forbidLevel;
        return this;
    }

    public RiskAntiHarassmentRequest setMobiles(String mobiles) {
        this.mobiles = mobiles;
        return this;
    }

    public RiskAntiHarassmentRequest setEncryptType(String encryptType) {
        this.encryptType = encryptType;
        return this;
    }

    public Integer getForbidLevel() {
        return this.forbidLevel;
    }

    public String getMobiles() {
        return this.mobiles;
    }

    public String getEncryptType() {
        return this.encryptType;
    }
}
