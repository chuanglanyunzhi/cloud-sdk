package com.chuanglan.cloudsdk.core;

/**
 * 重试策略接口。
 */
public interface RetryPolicy {

    /**
     * 判断是否应对当前异常进行重试。
     *
     * @param throwable 捕获的异常
     * @param attempt   当前重试次数（从 1 开始）
     */
    boolean shouldRetry(Throwable throwable, int attempt);

    /**
     * 计算本次重试前的退避延迟（毫秒）。
     */
    long computeDelay(int attempt);

    /**
     * 最大重试次数。
     */
    int maxAttempts();
}
