package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 签名素材体（RcsSmsSignAddRequest.body）。
 *
 * <p>以下文件均支持 source=1 base64 或 source=2 url。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsSignAddBody extends CloudSdkModel {

    /**
     * 授权文件列表（最多 3 个）。
     */
    private List<RcsSmsSignMaterial> authorizeFile;

    /**
     * 委托书文件（最多 1 个）。
     */
    private RcsSmsSignMaterial entrustFile;

    /**
     * 营业执照文件（最多 1 个）。
     */
    private RcsSmsSignMaterial jobPermitFile;

    /**
     * 网络游戏出版物号（最多 10 个，signType=1 游戏类时必传）。
     */
    private List<RcsSmsSignMaterial> editionFile;

    /**
     * 软件著作权登记证书（最多 10 个，signType=1 游戏类时必传）。
     */
    private List<RcsSmsSignMaterial> softnessFile;

    public RcsSmsSignAddBody setAuthorizeFile(List<RcsSmsSignMaterial> authorizeFile) {
        this.authorizeFile = authorizeFile;
        return this;
    }

    public RcsSmsSignAddBody setEntrustFile(RcsSmsSignMaterial entrustFile) {
        this.entrustFile = entrustFile;
        return this;
    }

    public RcsSmsSignAddBody setJobPermitFile(RcsSmsSignMaterial jobPermitFile) {
        this.jobPermitFile = jobPermitFile;
        return this;
    }

    public RcsSmsSignAddBody setEditionFile(List<RcsSmsSignMaterial> editionFile) {
        this.editionFile = editionFile;
        return this;
    }

    public RcsSmsSignAddBody setSoftnessFile(List<RcsSmsSignMaterial> softnessFile) {
        this.softnessFile = softnessFile;
        return this;
    }

    public List<RcsSmsSignMaterial> getAuthorizeFile() {
        return this.authorizeFile;
    }

    public RcsSmsSignMaterial getEntrustFile() {
        return this.entrustFile;
    }

    public RcsSmsSignMaterial getJobPermitFile() {
        return this.jobPermitFile;
    }

    public List<RcsSmsSignMaterial> getEditionFile() {
        return this.editionFile;
    }

    public List<RcsSmsSignMaterial> getSoftnessFile() {
        return this.softnessFile;
    }
}
