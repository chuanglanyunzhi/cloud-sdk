package com.chuanglan.cloudsdk.api.sms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

class SmsClientTest {

    private WireMockServer wireMockServer;
    private SmsClient client;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(0);
        wireMockServer.start();
        SmsConfig config = new SmsConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        client = new SmsClient(config);
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void testBatchSendSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/sms/v2/batchSend"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("DEV_7BW8WF4UIBM"))
                .withHeader("CheckSum", matching("[a-f0-9]+"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"F655A8D5B967440B8683DAD6FF8D230E\",\"data\":{\"successNum\":\"1\",\"failNum\":\"0\",\"msgId\":\"26052211411700902253000000000073\"}}")));

        SmsBatchSendRequest request = new SmsBatchSendRequest()
                .setProductType("market")
                .setPhoneNumbers("15800000000,15300000000")
                .setTemplateCode("1111111")
                .setTemplateParam("[{\"param1\":\"张三\"}]")
                .setSignName("【创蓝云智】");

        SmsBatchSendResponse response = client.batchSend("DEV_7BW8WF4UIBM", "AAABBBCCC", request, "trace_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("F655A8D5B967440B8683DAD6FF8D230E", response.getRequestId());
        assertNotNull(response.getData());
        assertEquals("1", response.getData().getSuccessNum());
        assertEquals("0", response.getData().getFailNum());
        assertEquals("26052211411700902253000000000073", response.getData().getMsgId());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/sms/v2/batchSend"))
                .withHeader("X-Custom-TraceId", equalTo("trace_001")));
    }

    @Test
    void testBatchSendMissingProductType() {
        SmsBatchSendRequest request = new SmsBatchSendRequest()
                .setPhoneNumbers("15800000000")
                .setTemplateCode("1111111");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.batchSend("DEV_7BW8WF4UIBM", "AAABBBCCC", request));
        assertEquals("ParameterMissing", exception.getCode());
    }

    @Test
    void testBatchSendServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/sms/v2/batchSend"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"InternalError\",\"msg\":\"server error\"}")));

        SmsBatchSendRequest request = new SmsBatchSendRequest()
                .setProductType("market")
                .setPhoneNumbers("15800000000")
                .setTemplateCode("1111111");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.batchSend("DEV_7BW8WF4UIBM", "AAABBBCCC", request));
        assertEquals("InternalError", exception.getCode());
    }

    @Test
    void testBatchSendRequiresAppId() {
        SmsBatchSendRequest request = new SmsBatchSendRequest()
                .setProductType("market")
                .setPhoneNumbers("15800000000")
                .setTemplateCode("1111111");
        assertThrows(IllegalArgumentException.class, () -> client.batchSend(null, "secret", request));
    }

    @Test
    void testBatchSendRequiresAppSecret() {
        SmsBatchSendRequest request = new SmsBatchSendRequest()
                .setProductType("market")
                .setPhoneNumbers("15800000000")
                .setTemplateCode("1111111");
        assertThrows(IllegalArgumentException.class, () -> client.batchSend("appid", null, request));
    }
}
