package com.chuanglan.cloudsdk.api.intSms;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import static org.junit.jupiter.api.Assertions.*;

class IntSmsSignatureUtilTest {

    @Test
    void testGenerateNonceLength() {
        String nonce = IntSmsSignatureUtil.generateNonce();
        assertEquals(32, nonce.length());
        assertTrue(nonce.matches("^[A-Za-z0-9]+$"));
    }

    @Test
    void testChecksumIsSha1UpperCase() throws Exception {
        String appSecret = "AAABBBCCC";
        String nonce = "44SuukDa291gfN4dTSNQ07lxFzP68KPo";
        String curTime = "1779367802";
        String checksum = IntSmsSignatureUtil.checksum(appSecret, nonce, curTime);

        assertEquals(40, checksum.length());
        assertTrue(checksum.matches("^[0-9A-F]{40}$"));

        String expected = sha1Hex(appSecret + nonce + curTime).toUpperCase();
        assertEquals(expected, checksum);
    }

    @Test
    void testCurrentTimestampIsSeconds() {
        String ts = IntSmsSignatureUtil.currentTimestamp();
        long now = System.currentTimeMillis() / 1000;
        assertTrue(Math.abs(Long.parseLong(ts) - now) < 5);
    }

    private String sha1Hex(String raw) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        return bytesToHex(md.digest(raw.getBytes(StandardCharsets.UTF_8)));
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
