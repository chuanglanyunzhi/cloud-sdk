package com.chuanglan.cloudsdk.core;

import java.util.Map;

/**
 * 签名接口。
 */
public interface Signer {

    /**
     * 对请求进行签名，返回签名后的完整请求参数（通常把 Signature 追加到 query 中）。
     */
    Map<String, Object> sign(Request request, Credentials credentials) throws CloudSdkException;

    /**
     * 返回签名方法名，如 HMAC-SHA1。
     */
    String signatureMethod();
}
