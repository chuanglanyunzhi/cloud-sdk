package com.chuanglan.cloudsdk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndpointResolverTest {

    @Test
    void testResolveRegistered() {
        EndpointResolver resolver = new EndpointResolver()
                .register("dysmsapi", "cn-hangzhou", "dysmsapi.aliyuncs.com")
                .register("dysmsapi", "cn-beijing", "dysmsapi-proxy.cn-beijing.aliyuncs.com");

        assertEquals("dysmsapi.aliyuncs.com", resolver.resolve("dysmsapi", "cn-hangzhou"));
        assertEquals("dysmsapi-proxy.cn-beijing.aliyuncs.com", resolver.resolve("dysmsapi", "cn-beijing"));
    }

    @Test
    void testResolveFallback() {
        EndpointResolver resolver = new EndpointResolver();
        assertEquals("ecs.aliyuncs.com", resolver.resolve("ecs", "cn-hangzhou"));
    }
}
