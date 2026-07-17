package com.chuanglan.cloudsdk.api.api.risk;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 羊毛党检测请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RiskWoolCheckRequest extends CloudSdkModel {

    /**
     * 检测手机号，限单个，仅支持11位国内号码。
     */
    public String mobile;

    /**
     * 手机IP地址，重要参数；不传将对检测结果产生影响，不能传入10,192,172等开头的内网IP地址。
     */
    public String ip;

    /**
     * 查询类型：1 表示 MD5（32位小写），0 表示普通手机号；默认0。
     */
    public String type;

    public RiskWoolCheckRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public RiskWoolCheckRequest setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public RiskWoolCheckRequest setType(String type) {
        this.type = type;
        return this;
    }
}
