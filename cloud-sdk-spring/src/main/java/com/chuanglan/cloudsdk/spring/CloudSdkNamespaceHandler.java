package com.chuanglan.cloudsdk.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Spring XML 命名空间处理器：注册 {@code <cloudsdk:config/>} 与 {@code <cloudsdk:client/>}
 * 元素，让传统 XML 配置也能用一行装配 SDK：
 *
 * <pre>{@code
 * <beans xmlns="http://www.springframework.org/schema/beans"
 *        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 *        xmlns:cloudsdk="http://www.chuanglan.com/schema/cloudsdk"
 *        xsi:schemaLocation="
 *          http://www.springframework.org/schema/beans
 *          http://www.springframework.org/schema/beans/spring-beans.xsd
 *          http://www.chuanglan.com/schema/cloudsdk
 *          http://www.chuanglan.com/schema/cloudsdk/cloud-sdk-spring.xsd">
 *
 *     <cloudsdk:config id="cloudApiConfig"
 *                       number-endpoint="https://wskh.253.com"
 *                       sms-endpoint="https://smssh.253.com"
 *                       connect-timeout="10000"
 *                       read-timeout="10000"/>
 *     <cloudsdk:client id="cloudApiClient" config-ref="cloudApiConfig"/>
 * </beans>
 * }</pre>
 */
public class CloudSdkNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("config", new CloudSdkConfigBeanDefinitionParser());
        registerBeanDefinitionParser("client", new CloudSdkClientBeanDefinitionParser());
    }
}
