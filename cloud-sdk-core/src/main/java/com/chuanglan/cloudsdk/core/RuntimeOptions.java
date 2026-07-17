package com.chuanglan.cloudsdk.core;

import java.time.Duration;

/**
 * 请求运行时选项，控制超时、重试、代理等参数。
 */
public class RuntimeOptions extends CloudSdkModel {

    /**
     * 整个请求的最大时长（含 DNS、连接、TLS、传输、重试），超过即取消。
     * 防止服务端假死时请求永久挂起。
     */
    public static final int DEFAULT_CALL_TIMEOUT_MS = 30000;

    @NameInMap("autoretry")
    public Boolean autoretry = true;

    @NameInMap("maxAttempts")
    public Integer maxAttempts = 3;

    @NameInMap("connectTimeout")
    public Integer connectTimeout = 10000;

    @NameInMap("readTimeout")
    public Integer readTimeout = 10000;

    @NameInMap("callTimeout")
    public Integer callTimeout = DEFAULT_CALL_TIMEOUT_MS;

    @NameInMap("backoffPolicy")
    public String backoffPolicy = "exponential";

    @NameInMap("backoffPeriod")
    public Integer backoffPeriod = 1000;

    @NameInMap("maxBackoff")
    public Integer maxBackoff = 20000;

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
}
