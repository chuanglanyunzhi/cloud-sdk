package com.chuanglan.cloudsdk.core;

import java.util.Collections;
import java.util.Map;

/**
 * 统一响应封装。
 */
public class SyncResponse {

    private final int statusCode;
    private final Map<String, String> headers;
    private final String body;

    public SyncResponse(int statusCode, Map<String, String> headers, String body) {
        this.statusCode = statusCode;
        this.headers = headers != null ? headers : Collections.emptyMap();
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
