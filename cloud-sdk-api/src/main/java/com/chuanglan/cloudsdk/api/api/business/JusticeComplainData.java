package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import java.util.List;

/**
 * 企业司法涉诉查询返回数据。
 */
public class JusticeComplainData extends CloudSdkModel {

    /**
     * 法院公告数组。
     */
    private List<JusticeComplainFygg> fyggents;

    /**
     * 法院公告总条数。
     */
    private String fyggentsCount;

    /**
     * 开庭公告数组。
     */
    private List<JusticeComplainKtgg> ktggents;

    /**
     * 开庭公告总条数。
     */
    private String ktggentsCount;

    public JusticeComplainData setFyggents(List<JusticeComplainFygg> fyggents) {
        this.fyggents = fyggents;
        return this;
    }

    public JusticeComplainData setFyggentsCount(String fyggentsCount) {
        this.fyggentsCount = fyggentsCount;
        return this;
    }

    public JusticeComplainData setKtggents(List<JusticeComplainKtgg> ktggents) {
        this.ktggents = ktggents;
        return this;
    }

    public JusticeComplainData setKtggentsCount(String ktggentsCount) {
        this.ktggentsCount = ktggentsCount;
        return this;
    }

    public List<JusticeComplainFygg> getFyggents() {
        return this.fyggents;
    }

    public String getFyggentsCount() {
        return this.fyggentsCount;
    }

    public List<JusticeComplainKtgg> getKtggents() {
        return this.ktggents;
    }

    public String getKtggentsCount() {
        return this.ktggentsCount;
    }
}
