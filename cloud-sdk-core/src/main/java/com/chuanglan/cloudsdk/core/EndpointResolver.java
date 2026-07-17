package com.chuanglan.cloudsdk.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 端点解析器，将产品 + Region 映射到 Host。
 */
public class EndpointResolver {

    private final Map<String, Map<String, String>> endpointMap;
    private final String defaultHostTemplate;

    public EndpointResolver() {
        this("{product}.aliyuncs.com");
    }

    public EndpointResolver(String defaultHostTemplate) {
        this.endpointMap = new ConcurrentHashMap<>();
        this.defaultHostTemplate = defaultHostTemplate;
    }

    public EndpointResolver register(String product, String region, String host) {
        endpointMap.computeIfAbsent(product, k -> new ConcurrentHashMap<>()).put(region, host);
        return this;
    }

    public String resolve(String product, String region) {
        Map<String, String> regions = endpointMap.get(product);
        if (regions != null) {
            String host = regions.get(region);
            if (host != null) {
                return host;
            }
        }
        return defaultHostTemplate.replace("{product}", product);
    }
}
