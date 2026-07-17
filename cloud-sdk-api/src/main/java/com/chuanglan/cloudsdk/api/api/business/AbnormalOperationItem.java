package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * 经营异常记录。
 */
public class AbnormalOperationItem extends CloudSdkModel {

    /**
     * 列入日期。
     */
    public String indate;

    /**
     * 列入机关。
     */
    public String inorg;

    /**
     * 列入原因。
     */
    public String inreason;

    /**
     * 移出日期。
     */
    public String outdate;

    /**
     * 移出机关。
     */
    public String outorg;

    /**
     * 移出原因。
     */
    public String outreason;

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
}
