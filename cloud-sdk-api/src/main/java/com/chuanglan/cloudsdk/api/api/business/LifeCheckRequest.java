package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 动态活体检测请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LifeCheckRequest extends CloudSdkModel {

    /**
     * 用户动作序列：BLINK - 眨眼；MOUTH - 张嘴；NOD - 点头；YAW - 摇头。
     */
    public String motions;

    /**
     * 视频文件，适合本地文件上传，file 和 url 二选一。
     */
    public String file;

    /**
     * 视频文件地址，下载限时 10 秒，file 和 url 二选一。
     */
    public String url;

    public LifeCheckRequest setMotions(String motions) {
        this.motions = motions;
        return this;
    }

    public LifeCheckRequest setFile(String file) {
        this.file = file;
        return this;
    }

    public LifeCheckRequest setUrl(String url) {
        this.url = url;
        return this;
    }
}
