package com.chuanglan.cloudsdk.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 显式开启创蓝云 SDK 装配。等价于直接引入 {@link CloudSdkAutoConfiguration}，
 * 主要给两类场景使用：
 *
 * <ul>
 *     <li>Spring Boot 用户希望显式控制装配（与 {@code cloudsdk.enabled=false} 配合使用）</li>
 *     <li>非 Spring Boot 的纯 Spring（含 XML 配置）应用，在 {@code @Configuration} 类上加此注解即可</li>
 * </ul>
 *
 * <p>用法示例：
 * <pre>{@code
 * @Configuration
 * @EnableCloudSdk
 * public class AppConfig {
 * }
 * }</pre>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CloudSdkAutoConfiguration.class)
public @interface EnableCloudSdk {
}
