package com.chuanglan.cloudsdk.api.api.mnp;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

class MnpClientTest {

    private WireMockServer wireMockServer;
    private MnpClient client;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(0);
        wireMockServer.start();
        MnpConfig config = new MnpConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        client = new MnpClient(config);
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void testCarriersSftpSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/sftp"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13767641540")))
                .withRequestBody(matchingJsonPath("$.type", equalTo("1")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"code\":\"000000\",\"data\":{\"batchNo\":\"iOvR1222600239535120384\",\"queryResult\":[{\"result\":\"0\",\"before\":\"1\",\"mobile\":\"13767641540\",\"after\":\"1\"}]},\"requestId\":\"iOvR1222600239535120384\",\"chargeStatus\":1}")));

        MnpCarriersSftpRequest request = new MnpCarriersSftpRequest()
                .setMobile("13767641540")
                .setType("1");

        MnpCarriersSftpResponse response = client.carriersSftp("APP_ID", "SECRET_KEY", request, "trace_mnp_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("000000", response.code);
        assertEquals("iOvR1222600239535120384", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertNotNull(response.data);
        assertEquals("iOvR1222600239535120384", response.data.batchNo);
        assertNotNull(response.data.queryResult);
        assertEquals(1, response.data.queryResult.size());
        assertEquals("0", response.data.queryResult.get(0).result);
        assertEquals("1", response.data.queryResult.get(0).before);
        assertEquals("13767641540", response.data.queryResult.get(0).mobile);
        assertEquals("1", response.data.queryResult.get(0).after);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/sftp"))
                .withHeader("X-Custom-TraceId", equalTo("trace_mnp_001")));
    }

    @Test
    void testCarriersSftpMissingMobile() {
        MnpCarriersSftpRequest request = new MnpCarriersSftpRequest()
                .setType("1");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersSftp("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testCarriersSftpServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/sftp"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        MnpCarriersSftpRequest request = new MnpCarriersSftpRequest()
                .setMobile("13767641540")
                .setType("1");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersSftp("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }
}
