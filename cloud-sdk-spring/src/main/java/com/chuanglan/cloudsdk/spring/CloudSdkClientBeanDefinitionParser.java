package com.chuanglan.cloudsdk.spring;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * 解析 {@code <cloudsdk:client .../>} 元素，通过 {@link CloudSdkFactoryBean} 装配
 * {@link com.chuanglan.cloudsdk.api.CloudApiClient}。
 *
 * <p>属性：
 * <ul>
 *     <li>{@code config-ref}：引用 {@link com.chuanglan.cloudsdk.api.CloudApiConfig} Bean</li>
 *     <li>{@code id}：注册的 Bean 名称</li>
 * </ul>
 *
 * <p>未指定 {@code config-ref} 时使用默认配置（{@link com.chuanglan.cloudsdk.api.CloudApiClient#CloudApiClient()}）。
 */
public class CloudSdkClientBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return CloudSdkFactoryBean.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String configRef = element.getAttribute("config-ref");
        if (configRef != null && !configRef.isEmpty()) {
            builder.addPropertyReference("config", configRef);
        }
    }
}
