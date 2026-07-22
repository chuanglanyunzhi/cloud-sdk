package com.chuanglan.cloudsdk.spring;

import java.lang.annotation.*;

/**
 * 加在 Spring Boot 启动类上，隐藏 cloud-sdk 日志中的敏感字段（手机号、身份证号、CheckSum 等）。
 *
 * <pre>{@code
 * @SpringBootApplication
 * @CloudSdkSafeLog
 * public class MyApplication {
 *     public static void main(String[] args) {
 *         SpringApplication.run(MyApplication.class, args);
 *     }
 * }
 * }</pre>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CloudSdkSafeLog {
}
