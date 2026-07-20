package com.chuanglan.cloudsdk.spring;

import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.CloudApiConfig;

import java.util.logging.Logger;

/**
 * SDK 加载日志统一入口，供三种接入路径（Spring Boot 自动装配、{@code @EnableCloudSdk}、
 * 传统 XML）共用，确保日志格式一致。
 *
 * <p>启用时：{@code [CloudSdk] 开始加载 创蓝云 SDK vX.Y.Z ...}
 * <br>加载完成时：{@code [CloudSdk] 创蓝云 SDK 已加载完成 (numberEndpoint=..., smsEndpoint=..., connectTimeout=...ms)}
 *
 * <p>每次 ApplicationContext 创建 CloudApiClient 时都会触发一次日志输出（Spring 单例 Bean
 * 在同一 context 内只创建一次，所以默认情况下不会重复刷屏；多 context 场景如 parent-child
 * 会按 context 分别输出，便于追踪）。
 */
final class CloudSdkLoaderLogger {

    private static final Logger LOGGER = Logger.getLogger(CloudSdkLoaderLogger.class.getName());

    private CloudSdkLoaderLogger() {
    }

    /**
     * 在 CloudApiClient 构造开始前调用，打印 "开始加载" 日志。
     */
    static void logStart() {
        String version = resolveVersion();
        LOGGER.info("[CloudSdk] 开始加载 创蓝云 SDK"
                + (version != null ? " v" + version : "")
                + " ...");
    }

    /**
     * 在 CloudApiClient 构造完成后调用，打印 "加载完成" 日志，附带实际生效的关键配置，
     * 便于线上排查（不打印敏感凭证）。
     */
    static void logReady(CloudApiConfig config) {
        LOGGER.info("[CloudSdk] 创蓝云 SDK 已加载完成 "
                + "(numberEndpoint=" + nullSafe(config.getNumberEndpoint())
                + ", smsEndpoint=" + nullSafe(config.getSmsEndpoint())
                + ", intSmsEndpoint=" + nullSafe(config.getIntSmsEndpoint())
                + ", rcsSmsEndpoint=" + nullSafe(config.getRcsSmsEndpoint())
                + ", realNameEndpoint=" + nullSafe(config.getRealNameEndpoint())
                + ", businessEndpoint=" + nullSafe(config.getBusinessEndpoint())
                + ", connectTimeout=" + config.getConnectTimeout() + "ms"
                + ", readTimeout=" + config.getReadTimeout() + "ms)");
    }

    private static String resolveVersion() {
        Package pkg = CloudApiClient.class.getPackage();
        if (pkg != null) {
            String v = pkg.getImplementationVersion();
            if (v != null && !v.isEmpty()) {
                return v;
            }
        }
        return null;
    }

    private static String nullSafe(String s) {
        return s == null ? "<default>" : s;
    }
}
