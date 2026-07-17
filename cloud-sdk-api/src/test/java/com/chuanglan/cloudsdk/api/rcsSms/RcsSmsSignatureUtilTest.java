package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RcsSmsSignatureUtilTest {

    @Test
    void testGenerateNonceLength() {
        String nonce = RcsSmsSignatureUtil.generateNonce();
        assertEquals(32, nonce.length());
        assertTrue(nonce.matches("^[A-Za-z0-9]+$"));
    }

    @Test
    void testCurrentTimestampIsSeconds() {
        String ts = RcsSmsSignatureUtil.currentTimestamp();
        long now = System.currentTimeMillis() / 1000;
        assertTrue(Math.abs(Long.parseLong(ts) - now) < 5);
    }

    @Test
    void testChecksumIsHmacSha256LowerCase() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("appId", "APP_xxxx");
        params.put("nonce", "44SuukDa291gfN4dTSNQ07lxFzP68KPo");
        params.put("curTime", "1779367802");
        params.put("templateName", "hello");

        String checksum = RcsSmsSignatureUtil.checksum("AAABBBCCC", params);

        assertEquals(64, checksum.length());
        assertTrue(checksum.matches("^[0-9a-f]{64}$"));
        assertEquals("791793e63c89ff27c3601a5440aed63a59005907f6ff9f0a9425983a19e9db67", checksum);
    }

    @Test
    void testChecksumFormatsListAsJson() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("appId", "APP_xxxx");
        params.put("nonce", "44SuukDa291gfN4dTSNQ07lxFzP68KPo");
        params.put("curTime", "1779367802");
        params.put("list", Arrays.asList("+86138", "+86139"));

        String checksum = RcsSmsSignatureUtil.checksum("AAABBBCCC", params);

        assertEquals("0070c50bf03c1c99c242f8b57e2124a8783aa16fd3f87cf9dd602ccb88e00d13", checksum);
    }

    @Test
    void testChecksumExcludesBodyAndSignature() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("appId", "APP_xxxx");
        params.put("nonce", "44SuukDa291gfN4dTSNQ07lxFzP68KPo");
        params.put("curTime", "1779367802");
        params.put("templateName", "hello");

        String base = RcsSmsSignatureUtil.checksum("AAABBBCCC", params);

        params.put("body", "ignored-body");
        params.put("signature", "ignored-signature");
        String withExcluded = RcsSmsSignatureUtil.checksum("AAABBBCCC", params);

        assertEquals(base, withExcluded);
    }

    @Test
    void testChecksumRequiresAppSecret() {
        assertThrows(CloudSdkException.class, () -> RcsSmsSignatureUtil.checksum("", new HashMap<>()));
    }
}
