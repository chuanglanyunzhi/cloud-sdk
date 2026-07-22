package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 动态模板变量项（dynamicVars 列表元素）。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsDynamicVar extends CloudSdkModel {

    /**
     * 手机号。
     */
    private String phone;

    /**
     * 变量值，对应模板中的 ${v1}。
     */
    private String v1;

    /**
     * 变量值，对应模板中的 ${v2}。
     */
    private String v2;

    /**
     * 变量值，对应模板中的 ${v3}。
     */
    private String v3;

    /**
     * 变量值，对应模板中的 ${v4}。
     */
    private String v4;

    /**
     * 变量值，对应模板中的 ${v5}。
     */
    private String v5;

    public RcsSmsDynamicVar setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RcsSmsDynamicVar setV1(String v1) {
        this.v1 = v1;
        return this;
    }

    public RcsSmsDynamicVar setV2(String v2) {
        this.v2 = v2;
        return this;
    }

    public RcsSmsDynamicVar setV3(String v3) {
        this.v3 = v3;
        return this;
    }

    public RcsSmsDynamicVar setV4(String v4) {
        this.v4 = v4;
        return this;
    }

    public RcsSmsDynamicVar setV5(String v5) {
        this.v5 = v5;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getV1() {
        return this.v1;
    }

    public String getV2() {
        return this.v2;
    }

    public String getV3() {
        return this.v3;
    }

    public String getV4() {
        return this.v4;
    }

    public String getV5() {
        return this.v5;
    }
}
