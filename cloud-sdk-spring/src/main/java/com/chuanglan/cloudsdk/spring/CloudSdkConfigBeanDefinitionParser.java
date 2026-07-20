package com.chuanglan.cloudsdk.spring;

import com.chuanglan.cloudsdk.api.CloudApiConfig;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * 解析 {@code <cloudsdk:config .../>} 元素，产出 {@link CloudApiConfig} Bean。
 *
 * <p>支持的所有属性：{@code number-endpoint / number-carrier-endpoint / risk-endpoint /
 * mnp-endpoint / sms-endpoint / sms-api-endpoint / int-sms-endpoint / rcs-sms-endpoint /
 * real-name-endpoint / real-name-api-endpoint / wool-endpoint / business-endpoint /
 * connect-timeout / read-timeout}，与 {@link CloudApiConfig} 字段一一对应。
 */
public class CloudSdkConfigBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return CloudApiConfig.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        setProp(builder, element, "number-endpoint", "numberEndpoint");
        setProp(builder, element, "number-carrier-endpoint", "numberCarrierEndpoint");
        setProp(builder, element, "risk-endpoint", "riskEndpoint");
        setProp(builder, element, "mnp-endpoint", "mnpEndpoint");
        setProp(builder, element, "sms-endpoint", "smsEndpoint");
        setProp(builder, element, "sms-api-endpoint", "smsApiEndpoint");
        setProp(builder, element, "int-sms-endpoint", "intSmsEndpoint");
        setProp(builder, element, "rcs-sms-endpoint", "rcsSmsEndpoint");
        setProp(builder, element, "real-name-endpoint", "realNameEndpoint");
        setProp(builder, element, "real-name-api-endpoint", "realNameApiEndpoint");
        setProp(builder, element, "wool-endpoint", "woolEndpoint");
        setProp(builder, element, "business-endpoint", "businessEndpoint");

        String connectTimeout = element.getAttribute("connect-timeout");
        if (connectTimeout != null && !connectTimeout.isEmpty()) {
            builder.addPropertyValue("connectTimeout", connectTimeout);
        }
        String readTimeout = element.getAttribute("read-timeout");
        if (readTimeout != null && !readTimeout.isEmpty()) {
            builder.addPropertyValue("readTimeout", readTimeout);
        }
    }

    private static void setProp(BeanDefinitionBuilder builder, Element element, String attr, String propName) {
        String value = element.getAttribute(attr);
        if (value != null && !value.isEmpty()) {
            builder.addPropertyValue(propName, value);
        }
    }
}
