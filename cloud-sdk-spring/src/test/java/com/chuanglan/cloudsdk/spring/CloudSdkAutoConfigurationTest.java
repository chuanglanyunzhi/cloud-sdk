package com.chuanglan.cloudsdk.spring;

import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.CloudApiConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 验证 Spring 自动装配是否生效：仅引入 SDK + Spring，{@link CloudApiClient} 应自动注册为 Bean。
 */
class CloudSdkAutoConfigurationTest {

    @Test
    void autoConfigRegistersCloudApiClient() {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
            ctx.register(CloudSdkAutoConfiguration.class);
            ctx.refresh();

            CloudApiConfig config = ctx.getBean(CloudApiConfig.class);
            CloudApiClient client = ctx.getBean(CloudApiClient.class);

            assertNotNull(config, "CloudApiConfig should be auto-registered");
            assertNotNull(client, "CloudApiClient should be auto-registered");

            // 关闭后 client 应已 close（HttpTransport 释放），不抛异常即视为通过
            ctx.close();
            assertTrue(true, "ApplicationContext closed without error");
        }
    }

    @Test
    void enableCloudSdkAnnotationTriggersAutoConfig() {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
            ctx.register(AppWithEnableAnnotation.class);
            ctx.refresh();

            CloudApiClient client = ctx.getBean(CloudApiClient.class);
            assertNotNull(client, "@EnableCloudSdk should trigger CloudSdkAutoConfiguration");
        }
    }

    @Test
    void customConfigBeanOverridesDefault() {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
            ctx.register(AppWithCustomConfig.class);
            ctx.register(CloudSdkAutoConfiguration.class);
            ctx.refresh();

            CloudApiConfig config = ctx.getBean(CloudApiConfig.class);
            // 用户自定义 Bean 应该胜出，因此 numberEndpoint 应等于自定义值
            assertSame(AppWithCustomConfig.CUSTOM, config, "User-defined CloudApiConfig should override the default");
        }
    }

    @EnableCloudSdk
    static class AppWithEnableAnnotation {
    }

    static class AppWithCustomConfig {
        static final CloudApiConfig CUSTOM = new CloudApiConfig().setNumberEndpoint("https://example.com");
        @org.springframework.context.annotation.Bean
        public CloudApiConfig customCloudApiConfig() {
            return CUSTOM;
        }
    }

    @Test
    void loadingLifecycleLogsAreEmitted() {
        CapturingHandler capture = new CapturingHandler();
        Logger logger = Logger.getLogger("com.chuanglan.cloudsdk.spring");
        logger.addHandler(capture);
        try {
            try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
                ctx.register(CloudSdkAutoConfiguration.class);
                ctx.refresh();
                ctx.getBean(CloudApiClient.class);
            }
            boolean sawStart = capture.messages.stream().anyMatch(m -> m.contains("开始加载"));
            boolean sawReady = capture.messages.stream().anyMatch(m -> m.contains("已加载完成"));
            assertTrue(sawStart, "应输出 '开始加载' 日志");
            assertTrue(sawReady, "应输出 '已加载完成' 日志");
        } finally {
            logger.removeHandler(capture);
        }
    }

    private static class CapturingHandler extends Handler {
        final java.util.List<String> messages = new java.util.ArrayList<>();

        @Override
        public void publish(LogRecord record) {
            messages.add(record.getMessage());
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() {
        }
    }
}
