package com.chuanglan.cloudsdk.api.sms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmsSignatureUtilTest {

    @Test
    void testGenerateNonceLength() {
        String nonce = SmsSignatureUtil.generateNonce();
        assertEquals(32, nonce.length());
        assertTrue(nonce.matches("^[A-Za-z0-9]+$"));
    }

    @Test
    void testChecksumMatchesDocumentExample() {
        String appSecret = "AAABBBCCC";
        String nonce = "44SuukDa291gfN4dTSNQ07lxFzP68KPo";
        String curTime = "1779367802";
        String checksum = SmsSignatureUtil.checksum(appSecret, nonce, curTime);
        assertEquals("ef4bdea23e75044c5bc69908ce98a862edae945cbce5570b9f63855a060b3200", checksum);
    }

    @Test
    void testCurrentTimestampIsSeconds() {
        String ts = SmsSignatureUtil.currentTimestamp();
        long now = System.currentTimeMillis() / 1000;
        assertTrue(Math.abs(Long.parseLong(ts) - now) < 5);
    }
}
