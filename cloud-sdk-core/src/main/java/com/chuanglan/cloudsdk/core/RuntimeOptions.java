package com.chuanglan.cloudsdk.core;

import java.time.Duration;

/**
 * 请求运行时选项，控制超时、重试、代理等参数。
 */
public class RuntimeOptions extends CloudSdkModel {

    public static final int DEFAULT_CALL_TIMEOUT_MS = 30000;

    @NameInMap("autoretry")
    private Boolean autoretry = true;

    @NameInMap("maxAttempts")
    private Integer maxAttempts = 3;

    @NameInMap("connectTimeout")
    private Integer connectTimeout = 10000;

    @NameInMap("readTimeout")
    private Integer readTimeout = 10000;

    @NameInMap("callTimeout")
    private Integer callTimeout = DEFAULT_CALL_TIMEOUT_MS;

    @NameInMap("backoffPolicy")
    private String backoffPolicy = "exponential";

    @NameInMap("backoffPeriod")
    private Integer backoffPeriod = 1000;

    @NameInMap("maxBackoff")
    private Integer maxBackoff = 20000;

    public boolean isAutoretry() {
        return autoretry != null && autoretry;
    }

    public int getMaxAttempts() {
        return maxAttempts != null ? maxAttempts : 3;
    }

    public Duration getConnectTimeout() {
        return Duration.ofMillis(connectTimeout != null ? connectTimeout : 10000);
    }

    public Duration getReadTimeout() {
        return Duration.ofMillis(readTimeout != null ? readTimeout : 10000);
    }

    public Duration getCallTimeout() {
        int value = callTimeout != null ? callTimeout : DEFAULT_CALL_TIMEOUT_MS;
        return value > 0 ? Duration.ofMillis(value) : null;
    }

    public int getBackoffPeriod() {
        return backoffPeriod != null ? backoffPeriod : 1000;
    }

    public int getMaxBackoff() {
        return maxBackoff != null ? maxBackoff : 20000;
    }

    public RuntimeOptions setAutoretry(Boolean autoretry) {
        this.autoretry = autoretry;
        return this;
    }

    public RuntimeOptions setMaxAttempts(Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
        return this;
    }

    public RuntimeOptions setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public RuntimeOptions setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public RuntimeOptions setCallTimeout(Integer callTimeout) {
        this.callTimeout = callTimeout;
        return this;
    }

    public RuntimeOptions setBackoffPolicy(String backoffPolicy) {
        this.backoffPolicy = backoffPolicy;
        return this;
    }

    public RuntimeOptions setBackoffPeriod(Integer backoffPeriod) {
        this.backoffPeriod = backoffPeriod;
        return this;
    }

    public RuntimeOptions setMaxBackoff(Integer maxBackoff) {
        this.maxBackoff = maxBackoff;
        return this;
    }
}
