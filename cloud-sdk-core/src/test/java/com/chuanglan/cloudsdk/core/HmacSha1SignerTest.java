package com.chuanglan.cloudsdk.core;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HmacSha1SignerTest {

    @Test
    void testSignaturePresentAndDeterministicStructure() {
        Credentials credentials = new StaticCredentialsProvider("ak-test", "sk-test").getCredentials();
        Map<String, Object> query = new LinkedHashMap<>();
        query.put("PhoneNumbers", "13800138000");
        query.put("SignName", "测试签名");

        Request request = Request.builder()
                .method("POST")
                .url("https://dysmsapi.aliyuncs.com")
                .query(query)
                .build();

        Signer signer = new HmacSha1Signer();
        Map<String, Object> signed = signer.sign(request, credentials);

        assertNotNull(signed.get("Signature"));
        assertEquals("ak-test", signed.get("AccessKeyId"));
        assertEquals("HMAC-SHA1", signed.get("SignatureMethod"));
        assertEquals("1.0", signed.get("SignatureVersion"));
        assertNotNull(signed.get("Timestamp"));
        assertNotNull(signed.get("SignatureNonce"));
    }
}
