package com.chuanglan.cloudsdk.spring;

import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.CloudApiConfig;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * {@link CloudApiClient} 的 Spring {@link org.springframework.beans.factory.FactoryBean}，
 * 给传统 Spring XML 配置使用：
 *
 * <pre>{@code
 * <bean id="cloudApiClient" class="com.chuanglan.cloudsdk.spring.CloudSdkFactoryBean">
 *     <property name="config" ref="cloudApiConfig"/>
 * </bean>
 * }</pre>
 *
 * <p>{@link CloudApiClient} 本身是有状态资源（持有 OkHttp 连接池），单例即可。
 * 容器销毁时通过 {@link CloudApiClient#close()} 释放资源（由
 * {@code destroyMethod="close"} 在 BeanDefinition 中指定，或由 {@code DisposableBean} 触发）。
 */
public class CloudSdkFactoryBean extends AbstractFactoryBean<CloudApiClient> {

    private CloudApiConfig config;

    public CloudApiConfig getConfig() {
        return config;
    }

    public void setConfig(CloudApiConfig config) {
        this.config = config;
    }

    @Override
    public Class<?> getObjectType() {
        return CloudApiClient.class;
    }

    @Override
    protected CloudApiClient createInstance() {
        CloudSdkLoaderLogger.logStart();
        CloudApiClient client = (config == null) ? new CloudApiClient() : new CloudApiClient(config);
        CloudSdkLoaderLogger.logReady(config != null ? config : new CloudApiConfig());
        return client;
    }

    @Override
    protected void destroyInstance(CloudApiClient instance) {
        if (instance != null) {
            instance.close();
        }
    }
}
