package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 经营异常记录。
 */
public class AbnormalOperationItem extends CloudSdkModel {

    /**
     * 列入日期。
     */
    private String indate;

    /**
     * 列入机关。
     */
    private String inorg;

    /**
     * 列入原因。
     */
    private String inreason;

    /**
     * 移出日期。
     */
    private String outdate;

    /**
     * 移出机关。
     */
    private String outorg;

    /**
     * 移出原因。
     */
    private String outreason;

    /**
     * 无记录时的说明。
     */
    private String reason;

    public AbnormalOperationItem setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public String getReason() {
        return this.reason;
    }

    public AbnormalOperationItem setIndate(String indate) {
        this.indate = indate;
        return this;
    }

    public AbnormalOperationItem setInorg(String inorg) {
        this.inorg = inorg;
        return this;
    }

    public AbnormalOperationItem setInreason(String inreason) {
        this.inreason = inreason;
        return this;
    }

    public AbnormalOperationItem setOutdate(String outdate) {
        this.outdate = outdate;
        return this;
    }

    public AbnormalOperationItem setOutorg(String outorg) {
        this.outorg = outorg;
        return this;
    }

    public AbnormalOperationItem setOutreason(String outreason) {
        this.outreason = outreason;
        return this;
    }

    public String getIndate() {
        return this.indate;
    }

    public String getInorg() {
        return this.inorg;
    }

    public String getInreason() {
        return this.inreason;
    }

    public String getOutdate() {
        return this.outdate;
    }

    public String getOutorg() {
        return this.outorg;
    }

    public String getOutreason() {
        return this.outreason;
    }
}
