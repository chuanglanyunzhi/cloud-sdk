package com.chuanglan.cloudsdk.spring;

import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.CloudApiConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot 自动装配入口。
 *
 * <p>当 classpath 上同时存在 {@link CloudApiClient} 与 Spring Boot 时自动生效：
 * <ul>
 *     <li>注册 {@link CloudSdkProperties}，读取 {@code cloudsdk.*} 配置</li>
 *     <li>注册 {@link CloudApiClient} Bean，随 ApplicationContext 关闭自动释放底层 OkHttp 连接池</li>
 * </ul>
 *
 * <p>典型用法：引入 {@code cloud-sdk-spring} 依赖后，无需任何手动配置即可在 Spring Bean 中
 * {@code @Autowired} 注入 {@link CloudApiClient}。
 *
 * <p>禁用方式（如需自定义装配）：
 * <pre>{@code
 * cloudsdk:
 *   enabled: false
 * }</pre>
 */
@Configuration(
        proxyBeanMethods = false
)
@ConditionalOnClass(CloudApiClient.class)
@ConditionalOnProperty(prefix = "cloudsdk", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(CloudSdkProperties.class)
public class CloudSdkAutoConfiguration {

    /**
     * 装配默认 {@link CloudApiConfig}：当用户未自定义时生效，属性来自 {@link CloudSdkProperties}。
     */
    @Bean
    @ConditionalOnMissingBean(CloudApiConfig.class)
    public CloudApiConfig cloudApiConfig(CloudSdkProperties properties) {
        return properties.toCloudApiConfig();
    }

    /**
     * 装配默认 {@link CloudApiClient}：实现 {@link org.springframework.beans.factory.DisposableBean}
     * 等价的 {@link AutoCloseable}，容器销毁时 Spring 会自动调用 {@link CloudApiClient#close()}
     * 释放底层 OkHttp 连接池与 Dispatcher 线程池，避免热部署/重启场景下的资源泄漏。
     *
     * <p>不显式指定 {@code destroyMethod}：Spring 对 {@link AutoCloseable} 会自动推断出 close()。
     *
     * <p>构造前后通过 {@link CloudSdkLoaderLogger} 打印开始加载 / 加载完成日志，
     * 便于线上确认 SDK 是否随项目启动。
     */
    @Bean
    @ConditionalOnMissingBean(CloudApiClient.class)
    public CloudApiClient cloudApiClient(CloudApiConfig config) {
        CloudSdkLoaderLogger.logStart();
        CloudApiClient client = new CloudApiClient(config);
        CloudSdkLoaderLogger.logReady(config);
        return client;
    }
}
