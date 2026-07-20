package com.chuanglan.cloudsdk.api.api.risk;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 防骚扰黑名单查询结果项。
 */
public class RiskAntiHarassmentResponseItem extends CloudSdkModel {

    /**
     * MD5 手机号码。
     */
    private String mobile;

    /**
     * 是否拦截：0 非风险号码不拦截，1 风险号码拦截，2 超频号码拦截，3 库无。
     */
    private Integer forbid;

    /**
     * 中文描述。
     */
    private String msg;

    /**
     * 吉祥号等级。
     */
    private String luckyLevel;

    public RiskAntiHarassmentResponseItem setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public RiskAntiHarassmentResponseItem setForbid(Integer forbid) {
        this.forbid = forbid;
        return this;
    }

    public RiskAntiHarassmentResponseItem setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public RiskAntiHarassmentResponseItem setLuckyLevel(String luckyLevel) {
        this.luckyLevel = luckyLevel;
        return this;
    }

    public String getMobile() {
        return this.mobile;
    }

    public Integer getForbid() {
        return this.forbid;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getLuckyLevel() {
        return this.luckyLevel;
    }
}
