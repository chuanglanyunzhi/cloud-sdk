package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.core.CloudSdkModel;

/**
 * IP 应用场景响应内层业务数据。
 */
public class IpApplicationScenariosInnerData extends CloudSdkModel {

    /**
     * 应用场景识别结果。
     */
    public IpApplicationScenariosScenes scenes;

    public IpApplicationScenariosInnerData setScenes(IpApplicationScenariosScenes scenes) {
        this.scenes = scenes;
        return this;
    }
}
