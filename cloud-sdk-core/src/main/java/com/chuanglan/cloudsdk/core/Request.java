package com.chuanglan.cloudsdk.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一请求封装。
 *
 * <p>不可变对象。构造时对传入的 headers/query 做防御性拷贝并包装为不可变视图，
 * 避免外部修改 Map 引发并发问题（尤其是异步路径下）。
 */
public class Request {

    private final String method;
    private final String url;
    private final Map<String, String> headers;
    private final Map<String, Object> query;
    private final String body;

    public Request(String method, String url, Map<String, String> headers,
                   Map<String, Object> query, String body) {
        this.method = method;
        this.url = url;
        this.headers = freezeHeaders(headers);
        this.query = freezeQuery(query);
        this.body = body;
    }

    private static Map<String, String> freezeHeaders(Map<String, String> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new HashMap<>(source));
    }

    private static Map<String, Object> freezeQuery(Map<String, Object> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new HashMap<>(source));
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, Object> getQuery() {
        return query;
    }

    public String getBody() {
        return body;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String method;
        private String url;
        private Map<String, String> headers;
        private Map<String, Object> query;
        private String body;

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder query(Map<String, Object> query) {
            this.query = query;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Request build() {
            return new Request(method, url, headers, query, body);
        }
    }
}
