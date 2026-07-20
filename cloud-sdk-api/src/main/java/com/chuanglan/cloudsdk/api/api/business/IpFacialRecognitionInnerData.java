package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 真人识别响应内层业务数据。
 */
public class IpFacialRecognitionInnerData extends CloudSdkModel {

    /**
     * 互联网服务提供商。
     */
    private String isp;

    /**
     * ASN 号。
     */
    private String asn;

    /**
     * 秒拨概率，0%~100%。值越高，表明该 IP 越可能存在秒速拨号行为。
     */
    private String mb_rate;

    /**
     * 真人概率，0%~99%。值越接近 0%，越趋近机器行为。
     */
    private String real;

    public IpFacialRecognitionInnerData setIsp(String isp) {
        this.isp = isp;
        return this;
    }

    public IpFacialRecognitionInnerData setAsn(String asn) {
        this.asn = asn;
        return this;
    }

    public IpFacialRecognitionInnerData setMb_rate(String mb_rate) {
        this.mb_rate = mb_rate;
        return this;
    }

    public IpFacialRecognitionInnerData setReal(String real) {
        this.real = real;
        return this;
    }

    public String getIsp() {
        return this.isp;
    }

    public String getAsn() {
        return this.asn;
    }

    public String getMb_rate() {
        return this.mb_rate;
    }

    public String getReal() {
        return this.real;
    }
}
