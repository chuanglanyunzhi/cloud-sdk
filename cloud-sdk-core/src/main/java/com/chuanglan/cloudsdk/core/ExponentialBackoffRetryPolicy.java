package com.chuanglan.cloudsdk.core;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 指数退避重试策略。
 */
public class ExponentialBackoffRetryPolicy implements RetryPolicy {

    private final int maxAttempts;
    private final long baseDelayMs;
    private final long maxDelayMs;

    public ExponentialBackoffRetryPolicy(int maxAttempts, long baseDelayMs, long maxDelayMs) {
        this.maxAttempts = maxAttempts;
        this.baseDelayMs = baseDelayMs;
        this.maxDelayMs = maxDelayMs;
    }

    @Override
    public boolean shouldRetry(Throwable throwable, int attempt) {
        if (attempt >= maxAttempts) {
            return false;
        }
        if (throwable instanceof CloudSdkException) {
            int statusCode = ((CloudSdkException) throwable).getStatusCode();
            return statusCode >= 500 || statusCode == 0;
        }
        return throwable instanceof IOException || throwable instanceof TimeoutException;
    }

    @Override
    public long computeDelay(int attempt) {
        long delay = baseDelayMs * (1L << (attempt - 1));
        return Math.min(delay, maxDelayMs);
    }

    @Override
    public int maxAttempts() {
        return maxAttempts;
    }
}
