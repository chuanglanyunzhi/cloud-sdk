package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

class IntSmsClientTest {

    private WireMockServer wireMockServer;
    private IntSmsClient client;

    private String baseUrl() {
        return "http://localhost:" + wireMockServer.port();
    }

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(0);
        wireMockServer.start();
        IntSmsConfig config = new IntSmsConfig();
        client = new IntSmsClient(config);
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void testSubmitSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/intsms/v2/sms/submit"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_xxxx"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"20260527150000xxxx\",\"data\":{\"messageId\":\"754398108056510464\"}}")));

        IntSmsSubmitRequest request = new IntSmsSubmitRequest()
                .setProductType("notify")
                .setMessage("Your verification code is 123456")
                .setPhoneNumbers("+8613800138000,+8613800138001")
                .setSender("Brand")
                .setCallBackUrl("https://yourdomain.com/cb")
                .setValidityPeriod("+000000050000000R");

        IntSmsSubmitResponse response = client.submit("APP_xxxx", "AAABBBCCC", baseUrl(), request, "trace_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("20260527150000xxxx", response.requestId);
        assertNotNull(response.data);
        assertEquals("754398108056510464", response.data.messageId);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/intsms/v2/sms/submit"))
                .withHeader("X-Custom-TraceId", equalTo("trace_001")));
    }

    @Test
    void testSubmitBatchWithErrorPhone() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/intsms/v2/sms/submit"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"20260527150000xxxx\",\"data\":{\"messageId\":\"BATCH-20260424160000\",\"errorPhone\":[\"+8613800138999\"]}}")));

        IntSmsSubmitRequest request = new IntSmsSubmitRequest()
                .setProductType("marketing")
                .setMessage("Promotional message")
                .setPhoneNumbers("+8613800138000,+8613800138999");

        IntSmsSubmitResponse response = client.submit("APP_xxxx", "AAABBBCCC", baseUrl(), request);

        assertTrue(response.isSuccess());
        assertNotNull(response.data);
        assertEquals("BATCH-20260424160000", response.data.messageId);
        assertNotNull(response.data.errorPhone);
        assertEquals(1, response.data.errorPhone.size());
        assertEquals("+8613800138999", response.data.errorPhone.get(0));
    }

    @Test
    void testSubmitServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/intsms/v2/sms/submit"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"120504\",\"msg\":\"signature expired\"}")));

        IntSmsSubmitRequest request = new IntSmsSubmitRequest()
                .setProductType("notify")
                .setMessage("Your verification code is 123456")
                .setPhoneNumbers("+8613800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.submit("APP_xxxx", "AAABBBCCC", baseUrl(), request));
        assertEquals("120504", exception.getCode());
    }

    @Test
    void testSubmitMissingMessage() {
        IntSmsSubmitRequest request = new IntSmsSubmitRequest()
                .setProductType("notify")
                .setPhoneNumbers("+8613800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.submit("APP_xxxx", "AAABBBCCC", baseUrl(), request));
        assertEquals("ParameterMissing", exception.getCode());
    }

    @Test
    void testSubmitRequiresAppId() {
        IntSmsSubmitRequest request = new IntSmsSubmitRequest()
                .setProductType("notify")
                .setMessage("test")
                .setPhoneNumbers("+8613800138000");
        assertThrows(IllegalArgumentException.class, () -> client.submit(null, "secret", baseUrl(), request));
    }

    @Test
    void testSubmitRequiresAppSecret() {
        IntSmsSubmitRequest request = new IntSmsSubmitRequest()
                .setProductType("notify")
                .setMessage("test")
                .setPhoneNumbers("+8613800138000");
        assertThrows(IllegalArgumentException.class, () -> client.submit("appid", null, baseUrl(), request));
    }

    @Test
    void testSubmitRequiresEndpoint() {
        IntSmsSubmitRequest request = new IntSmsSubmitRequest()
                .setProductType("notify")
                .setMessage("test")
                .setPhoneNumbers("+8613800138000");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.submit("appid", "secret", null, request));
        assertEquals("ParameterMissing", exception.getCode());
    }
}
