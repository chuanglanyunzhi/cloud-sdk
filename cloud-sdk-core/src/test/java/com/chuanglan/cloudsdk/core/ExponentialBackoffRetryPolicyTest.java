package com.chuanglan.cloudsdk.core;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class ExponentialBackoffRetryPolicyTest {

    @Test
    void testShouldRetryNetworkErrors() {
        RetryPolicy policy = new ExponentialBackoffRetryPolicy(3, 100, 1000);
        assertTrue(policy.shouldRetry(new IOException("connection reset"), 1));
        assertTrue(policy.shouldRetry(new TimeoutException("timeout"), 1));
    }

    @Test
    void testShouldNotRetryClientErrors() {
        RetryPolicy policy = new ExponentialBackoffRetryPolicy(3, 100, 1000);
        CloudSdkException clientError = new CloudSdkException("InvalidParameter", "bad", "req", 400);
        assertFalse(policy.shouldRetry(clientError, 1));
    }

    @Test
    void testShouldRetryServerErrors() {
        RetryPolicy policy = new ExponentialBackoffRetryPolicy(3, 100, 1000);
        CloudSdkException serverError = new CloudSdkException("InternalError", "fail", "req", 500);
        assertTrue(policy.shouldRetry(serverError, 1));
    }

    @Test
    void testMaxAttemptsRespected() {
        RetryPolicy policy = new ExponentialBackoffRetryPolicy(3, 100, 1000);
        assertFalse(policy.shouldRetry(new IOException(), 3));
    }

    @Test
    void testExponentialDelay() {
        RetryPolicy policy = new ExponentialBackoffRetryPolicy(5, 100, 1000);
        assertEquals(100, policy.computeDelay(1));
        assertEquals(200, policy.computeDelay(2));
        assertEquals(400, policy.computeDelay(3));
        assertEquals(800, policy.computeDelay(4));
        assertEquals(1000, policy.computeDelay(5));
    }
}
