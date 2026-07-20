package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

class RcsSmsClientTest {

    private WireMockServer wireMockServer;
    private RcsSmsClient client;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(0);
        wireMockServer.start();
        RcsSmsConfig config = new RcsSmsConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        client = new RcsSmsClient(config);
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void testAddVideoTemplateSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/rcs/api/v2/template/addVideo"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_xxxx"))
                .withHeader("CheckSum", matching("[0-9a-f]{64}"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"202607150001\",\"data\":{\"templateId\":\"TPL_123\",\"status\":\"1\"}}")));

        RcsSmsTemplateAddRequest request = new RcsSmsTemplateAddRequest()
                .setTemplateName("营销视频模板")
                .setSign("创蓝")
                .setVideoUrl("https://example.com/video.mp4")
                .setCoverUrl("https://example.com/cover.jpg")
                .setContent("欢迎体验视频短信");

        RcsSmsTemplateAddResponse response = client.addVideoTemplate("APP_xxxx", "AAABBBCCC", request, "trace_rcs_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("202607150001", response.getRequestId());
        assertNotNull(response.getData());
        assertEquals("TPL_123", response.getData().getTemplateId());
        assertEquals("1", response.getData().getStatus());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/rcs/api/v2/template/addVideo"))
                .withHeader("X-Custom-TraceId", equalTo("trace_rcs_001")));
    }

    @Test
    void testSubmitVideoTemplateSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/rcs/api/v2/msg/submitVideoTemplate"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"202607150002\",\"data\":{\"messageId\":\"MSG_456\",\"total\":2,\"errorPhone\":[]}}")));

        RcsSmsTemplateSubmitRequest request = new RcsSmsTemplateSubmitRequest()
                .setTemplateId("TPL_123")
                .setPhoneNumbers(Arrays.asList("+8613800138000", "+8613800138001"))
                .setParams("{}")
                .setCallbackUrl("https://yourdomain.com/cb")
                .setOutId("out_001");

        RcsSmsTemplateSubmitResponse response = client.submitVideoTemplate("APP_xxxx", "AAABBBCCC", request);

        assertTrue(response.isSuccess());
        assertNotNull(response.getData());
        assertEquals("MSG_456", response.getData().getMessageId());
        assertEquals(Integer.valueOf(2), response.getData().getTotal());
        assertNotNull(response.getData().getErrorPhone());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/rcs/api/v2/msg/submitVideoTemplate"))
                .withRequestBody(containing("+8613800138000")));
    }

    @Test
    void testGetBalanceSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/rcs/api/internal/balance/getBalance"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"202607150003\",\"data\":{\"balance\":\"1234.56\",\"unit\":\"条\"}}")));

        RcsSmsBalanceResponse response = client.getBalance("APP_xxxx", "AAABBBCCC", new RcsSmsBalanceRequest().setProductType("rcs"));

        assertTrue(response.isSuccess());
        assertNotNull(response.getData());
        assertEquals("1234.56", response.getData().getBalance());
        assertEquals("条", response.getData().getUnit());
    }

    @Test
    void testServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/rcs/api/v2/template/addVideo"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"120504\",\"msg\":\"signature expired\"}")));

        RcsSmsTemplateAddRequest request = new RcsSmsTemplateAddRequest()
                .setTemplateName("test")
                .setSign("test")
                .setContent("test");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.addVideoTemplate("APP_xxxx", "AAABBBCCC", request));
        assertEquals("120504", exception.getCode());
    }

    @Test
    void testSubmitMissingTemplateId() {
        RcsSmsTemplateSubmitRequest request = new RcsSmsTemplateSubmitRequest()
                .setPhoneNumbers(Arrays.asList("+8613800138000"));

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.submitVideoTemplate("APP_xxxx", "AAABBBCCC", request));
        assertEquals("ParameterMissing", exception.getCode());
    }

    @Test
    void testClientUsesDefaultEndpoint() {
        assertDoesNotThrow(() -> new RcsSmsClient(new RcsSmsConfig()));
    }
}
