package com.chuanglan.cloudsdk.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一响应封装。不可变对象，headers 做防御性拷贝。
 */
public class SyncResponse {

    private final int statusCode;
    private final Map<String, String> headers;
    private final String body;

    public SyncResponse(int statusCode, Map<String, String> headers, String body) {
        this.statusCode = statusCode;
        this.headers = (headers == null || headers.isEmpty())
                ? Collections.emptyMap()
                : Collections.unmodifiableMap(new HashMap<>(headers));
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
}
