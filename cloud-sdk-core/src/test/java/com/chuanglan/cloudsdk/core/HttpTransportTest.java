package com.chuanglan.cloudsdk.core;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

class HttpTransportTest {

    private WireMockServer wireMockServer;
    private HttpTransport transport;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(0);
        wireMockServer.start();
        transport = new HttpTransport();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    private String baseUrl() {
        return "http://localhost:" + wireMockServer.port();
    }

    @Test
    void testSendSuccess() {
        wireMockServer.stubFor(get(urlEqualTo("/ok"))
                .willReturn(aResponse().withStatus(200).withBody("{\"ok\":true}")));

        Request request = Request.builder()
                .method("GET")
                .url(baseUrl() + "/ok")
                .build();
        RuntimeOptions runtime = new RuntimeOptions();
        RetryPolicy retry = new ExponentialBackoffRetryPolicy(3, 100, 1000);

        SyncResponse response = transport.send(request, runtime, retry);
        assertEquals(200, response.getStatusCode());
        assertEquals("{\"ok\":true}", response.getBody());
    }

    @Test
    void testSendServerErrorRetriesThenFails() {
        wireMockServer.stubFor(get(urlEqualTo("/error"))
                .willReturn(aResponse().withStatus(500).withBody("{\"Code\":\"InternalError\"}")));

        Request request = Request.builder()
                .method("GET")
                .url(baseUrl() + "/error")
                .build();
        RuntimeOptions runtime = new RuntimeOptions();
        runtime.maxAttempts = 2;
        RetryPolicy retry = new ExponentialBackoffRetryPolicy(2, 10, 100);

        CloudSdkException exception = assertThrows(CloudSdkException.class,
                () -> transport.send(request, runtime, retry));
        assertEquals(500, exception.getStatusCode());
        assertEquals("InternalError", exception.getCode());
        wireMockServer.verify(2, getRequestedFor(urlEqualTo("/error")));
    }

    @Test
    void testSendAsync() throws Exception {
        wireMockServer.stubFor(get(urlEqualTo("/async"))
                .willReturn(aResponse().withStatus(200).withBody("{\"async\":true}")));

        Request request = Request.builder()
                .method("GET")
                .url(baseUrl() + "/async")
                .build();
        RuntimeOptions runtime = new RuntimeOptions();

        SyncResponse response = transport.sendAsync(request, runtime).get();
        assertEquals(200, response.getStatusCode());
        assertEquals("{\"async\":true}", response.getBody());
    }
}
