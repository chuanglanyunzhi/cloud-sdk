package com.chuanglan.cloudsdk.core;

import java.time.Duration;

/**
 * 请求运行时选项，控制超时、重试、代理等参数。
 */
public class RuntimeOptions extends CloudSdkModel {

    @NameInMap("autoretry")
    public Boolean autoretry = true;

    @NameInMap("maxAttempts")
    public Integer maxAttempts = 3;

    @NameInMap("connectTimeout")
    public Integer connectTimeout = 10000;

    @NameInMap("readTimeout")
    public Integer readTimeout = 10000;

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

    public int getBackoffPeriod() {
        return backoffPeriod != null ? backoffPeriod : 1000;
    }

    public int getMaxBackoff() {
        return maxBackoff != null ? maxBackoff : 20000;
    }
}
