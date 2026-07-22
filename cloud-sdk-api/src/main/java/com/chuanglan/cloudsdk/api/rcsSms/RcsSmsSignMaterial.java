package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 签名素材参数（SignMaterialParam）。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsSignMaterial extends CloudSdkModel {

    /**
     * 素材来源：1 base64（默认）2 url。
     */
    private String source;

    /**
     * 素材格式，如 jpg、png、pdf 等。
     */
    private String type;

    /**
     * 素材具体内容：base64 字符串或 url 地址。
     */
    private String content;

    public RcsSmsSignMaterial setSource(String source) {
        this.source = source;
        return this;
    }

    public RcsSmsSignMaterial setType(String type) {
        this.type = type;
        return this;
    }

    public RcsSmsSignMaterial setContent(String content) {
        this.content = content;
        return this;
    }

    public String getSource() {
        return this.source;
    }

    public String getType() {
        return this.type;
    }

    public String getContent() {
        return this.content;
    }
}
