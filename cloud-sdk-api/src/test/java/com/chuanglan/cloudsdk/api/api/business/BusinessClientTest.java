package com.chuanglan.cloudsdk.api.api.business;

import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.CloudApiConfig;
import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

class BusinessClientTest {

    private WireMockServer wireMockServer;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(0);
        wireMockServer.start();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void testBusinessConfigDefaultEndpoint() {
        BusinessConfig config = new BusinessConfig();
        assertEquals("https://wsapi.253.com", config.endpoint);
    }

    @Test
    void testCloudApiClientWiresBusinessClient() {
        CloudApiConfig config = new CloudApiConfig()
                .setBusinessEndpoint("http://localhost:" + wireMockServer.port());
        CloudApiClient client = new CloudApiClient(config);
        assertNotNull(client.businessClient());
    }

    @Test
    void testBusinessClientExecutesRequest() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/business/demo"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(equalToJson("{\"name\":\"test\"}"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BUSINESS_001\"}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        TestableBusinessClient client = new TestableBusinessClient(config);

        BusinessCommonResponse response = client.invoke("APP_ID", "SECRET_KEY", "/api/v2/business/demo", "{\"name\":\"test\"}", "trace_business_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("REQ_BUSINESS_001", response.requestId);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/business/demo"))
                .withHeader("X-Custom-TraceId", equalTo("trace_business_001")));
    }

    @Test
    void testBusinessClientServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/business/demo"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BUSINESS_ERR\"}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        TestableBusinessClient client = new TestableBusinessClient(config);

        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.invoke("APP_ID", "SECRET_KEY", "/api/v2/business/demo", "{\"name\":\"test\"}", null));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIpAddressOriginV4Success() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/addressOriginV4"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.ip", equalTo("218.1.221.132")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":1,\"code\":\"000000\",\"data\":{\"msg\":\"success\",\"code\":200,\"data\":{\"location\":{\"continent\":\"亚洲\",\"elevation\":\"15\",\"country\":\"中国\",\"city\":\"上海\",\"area_code\":\"310115\",\"ip\":\"218.1.221.132\",\"isp\":\"电信\",\"latitude\":\"31.22249\",\"city_code\":\"021\",\"time_zone\":\"Asia/Shanghai\",\"zip_code\":\"200120\",\"country_code\":\"CN\",\"weather_station\":\"CHXX0116\",\"province\":\"上海\",\"street\":\"\",\"district\":\"浦东\",\"longitude\":\"121.5447\"}}},\"requestId\":\"tIYK1221157582366162944\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpAddressOriginV4Request request = new IpAddressOriginV4Request().setIp("218.1.221.132");
        IpAddressOriginV4Response response = client.ipAddressOriginV4("APP_ID", "SECRET_KEY", request, "trace_ip_v4_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("tIYK1221157582366162944", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals(Integer.valueOf(200), response.data.code);
        assertEquals("success", response.data.msg);
        assertNotNull(response.data.data);
        assertNotNull(response.data.data.location);
        assertEquals("218.1.221.132", response.data.data.location.ip);
        assertEquals("亚洲", response.data.data.location.continent);
        assertEquals("中国", response.data.data.location.country);
        assertEquals("CN", response.data.data.location.country_code);
        assertEquals("上海", response.data.data.location.province);
        assertEquals("上海", response.data.data.location.city);
        assertEquals("浦东", response.data.data.location.district);
        assertEquals("", response.data.data.location.street);
        assertEquals("310115", response.data.data.location.area_code);
        assertEquals("021", response.data.data.location.city_code);
        assertEquals("200120", response.data.data.location.zip_code);
        assertEquals("121.5447", response.data.data.location.longitude);
        assertEquals("31.22249", response.data.data.location.latitude);
        assertEquals("15", response.data.data.location.elevation);
        assertEquals("Asia/Shanghai", response.data.data.location.time_zone);
        assertEquals("CHXX0116", response.data.data.location.weather_station);
        assertEquals("电信", response.data.data.location.isp);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/ipgsdcx/addressOriginV4"))
                .withHeader("X-Custom-TraceId", equalTo("trace_ip_v4_001")));
    }

    @Test
    void testIpAddressOriginV4MissingIp() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpAddressOriginV4Request request = new IpAddressOriginV4Request();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipAddressOriginV4("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("ip"));
    }

    @Test
    void testIpAddressOriginV4ServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/addressOriginV4"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"REQ_IP_V4_ERR\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpAddressOriginV4Request request = new IpAddressOriginV4Request().setIp("218.1.221.132");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipAddressOriginV4("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIpAddressOriginV6Success() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/addressOriginV6"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.ip", equalTo("240e:0471:3610:6cec:ede4:e48b:72d4:d7e5")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":1,\"code\":\"000000\",\"data\":{\"msg\":\"success\",\"code\":200,\"data\":{\"location\":{\"continent\":\"亚洲\",\"elevation\":\"12\",\"country\":\"中国\",\"city\":\"温州\",\"area_code\":\"330381\",\"ip\":\"240e:0471:3610:6cec:ede4:e48b:72d4:d7e5\",\"isp\":\"电信\",\"latitude\":\"27.827523\",\"city_code\":\"0577\",\"time_zone\":\"Asia/Shanghai\",\"zip_code\":\"325000\",\"country_code\":\"CN\",\"weather_station\":\"CHXX0462\",\"province\":\"浙江\",\"street\":\"\",\"district\":\"瑞安\",\"longitude\":\"120.631025\"}}},\"requestId\":\"tIYK1221156677700927488\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpAddressOriginV6Request request = new IpAddressOriginV6Request().setIp("240e:0471:3610:6cec:ede4:e48b:72d4:d7e5");
        IpAddressOriginV6Response response = client.ipAddressOriginV6("APP_ID", "SECRET_KEY", request, "trace_ip_v6_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("tIYK1221156677700927488", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals(Integer.valueOf(200), response.data.code);
        assertEquals("success", response.data.msg);
        assertNotNull(response.data.data);
        assertNotNull(response.data.data.location);
        assertEquals("240e:0471:3610:6cec:ede4:e48b:72d4:d7e5", response.data.data.location.ip);
        assertEquals("亚洲", response.data.data.location.continent);
        assertEquals("中国", response.data.data.location.country);
        assertEquals("CN", response.data.data.location.country_code);
        assertEquals("浙江", response.data.data.location.province);
        assertEquals("温州", response.data.data.location.city);
        assertEquals("瑞安", response.data.data.location.district);
        assertEquals("", response.data.data.location.street);
        assertEquals("330381", response.data.data.location.area_code);
        assertEquals("0577", response.data.data.location.city_code);
        assertEquals("325000", response.data.data.location.zip_code);
        assertEquals("120.631025", response.data.data.location.longitude);
        assertEquals("27.827523", response.data.data.location.latitude);
        assertEquals("12", response.data.data.location.elevation);
        assertEquals("Asia/Shanghai", response.data.data.location.time_zone);
        assertEquals("CHXX0462", response.data.data.location.weather_station);
        assertEquals("电信", response.data.data.location.isp);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/ipgsdcx/addressOriginV6"))
                .withHeader("X-Custom-TraceId", equalTo("trace_ip_v6_001")));
    }

    @Test
    void testIpAddressOriginV6MissingIp() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpAddressOriginV6Request request = new IpAddressOriginV6Request();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipAddressOriginV6("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("ip"));
    }

    @Test
    void testIpAddressOriginV6ServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/addressOriginV6"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"REQ_IP_V6_ERR\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpAddressOriginV6Request request = new IpAddressOriginV6Request().setIp("240e:0471:3610:6cec:ede4:e48b:72d4:d7e5");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipAddressOriginV6("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIpRiskPortraitSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/riskPortrait"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.ip", equalTo("218.1.221.132")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":1,\"code\":\"000000\",\"data\":{\"msg\":\"success\",\"code\":200,\"data\":{\"risk\":{\"proxy\":\"是\",\"risk_level\":\"高\",\"risk_score\":93,\"mb_rate\":\"100.00%\",\"risk_tag\":[{\"last_time\":\"2026-06-19\",\"label\":\"suspectFakeMobile\",\"label_name\":\"疑似虚假号码\"},{\"last_time\":\"2026-06-19\",\"label\":\"webCrawler\",\"label_name\":\"网络爬虫\"}],\"real\":\"1%\"}}},\"requestId\":\"tIYK1221154995613057024\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpRiskPortraitRequest request = new IpRiskPortraitRequest().setIp("218.1.221.132");
        IpRiskPortraitResponse response = client.ipRiskPortrait("APP_ID", "SECRET_KEY", request, "trace_ip_risk_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("tIYK1221154995613057024", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals(Integer.valueOf(200), response.data.code);
        assertEquals("success", response.data.msg);
        assertNotNull(response.data.data);
        assertNotNull(response.data.data.risk);
        assertEquals("是", response.data.data.risk.proxy);
        assertEquals("高", response.data.data.risk.risk_level);
        assertEquals(Integer.valueOf(93), response.data.data.risk.risk_score);
        assertEquals("100.00%", response.data.data.risk.mb_rate);
        assertEquals("1%", response.data.data.risk.real);
        assertNotNull(response.data.data.risk.risk_tag);
        assertEquals(2, response.data.data.risk.risk_tag.size());
        assertEquals("suspectFakeMobile", response.data.data.risk.risk_tag.get(0).label);
        assertEquals("疑似虚假号码", response.data.data.risk.risk_tag.get(0).label_name);
        assertEquals("2026-06-19", response.data.data.risk.risk_tag.get(0).last_time);
        assertEquals("webCrawler", response.data.data.risk.risk_tag.get(1).label);
        assertEquals("网络爬虫", response.data.data.risk.risk_tag.get(1).label_name);
        assertEquals("2026-06-19", response.data.data.risk.risk_tag.get(1).last_time);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/ipgsdcx/riskPortrait"))
                .withHeader("X-Custom-TraceId", equalTo("trace_ip_risk_001")));
    }

    @Test
    void testIpRiskPortraitMissingIp() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpRiskPortraitRequest request = new IpRiskPortraitRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipRiskPortrait("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("ip"));
    }

    @Test
    void testIpRiskPortraitServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/riskPortrait"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"REQ_IP_RISK_ERR\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpRiskPortraitRequest request = new IpRiskPortraitRequest().setIp("218.1.221.132");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipRiskPortrait("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIpFacialRecognitionSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/facialRecognition"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.ip", equalTo("218.1.221.132")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":1,\"code\":\"000000\",\"data\":{\"msg\":\"success\",\"code\":200,\"data\":{\"isp\":\"电信\",\"mb_rate\":\"100.00%\",\"real\":\"54%\",\"asn\":\"AS4812\"}},\"requestId\":\"tIYK1221152784359211008\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpFacialRecognitionRequest request = new IpFacialRecognitionRequest().setIp("218.1.221.132");
        IpFacialRecognitionResponse response = client.ipFacialRecognition("APP_ID", "SECRET_KEY", request, "trace_ip_facial_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("tIYK1221152784359211008", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals(Integer.valueOf(200), response.data.code);
        assertEquals("success", response.data.msg);
        assertNotNull(response.data.data);
        assertEquals("电信", response.data.data.isp);
        assertEquals("AS4812", response.data.data.asn);
        assertEquals("100.00%", response.data.data.mb_rate);
        assertEquals("54%", response.data.data.real);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/ipgsdcx/facialRecognition"))
                .withHeader("X-Custom-TraceId", equalTo("trace_ip_facial_001")));
    }

    @Test
    void testIpFacialRecognitionMissingIp() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpFacialRecognitionRequest request = new IpFacialRecognitionRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipFacialRecognition("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("ip"));
    }

    @Test
    void testIpFacialRecognitionServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/facialRecognition"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"REQ_IP_FACIAL_ERR\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpFacialRecognitionRequest request = new IpFacialRecognitionRequest().setIp("218.1.221.132");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipFacialRecognition("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIpApplicationScenariosSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/applicationScenarios"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.ip", equalTo("218.1.221.132")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":1,\"code\":\"000000\",\"data\":{\"msg\":\"success\",\"code\":200,\"data\":{\"scenes\":{\"isp\":\"电信\",\"usage_type\":\"家庭宽带\",\"asn\":\"AS4134\"}}},\"requestId\":\"tIYK1221157582366162945\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpApplicationScenariosRequest request = new IpApplicationScenariosRequest().setIp("218.1.221.132");
        IpApplicationScenariosResponse response = client.ipApplicationScenarios("APP_ID", "SECRET_KEY", request, "trace_ip_scene_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("tIYK1221157582366162945", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals(Integer.valueOf(200), response.data.code);
        assertEquals("success", response.data.msg);
        assertNotNull(response.data.data);
        assertNotNull(response.data.data.scenes);
        assertEquals("电信", response.data.data.scenes.isp);
        assertEquals("家庭宽带", response.data.data.scenes.usage_type);
        assertEquals("AS4134", response.data.data.scenes.asn);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/ipgsdcx/applicationScenarios"))
                .withHeader("X-Custom-TraceId", equalTo("trace_ip_scene_001")));
    }

    @Test
    void testIpApplicationScenariosMissingIp() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpApplicationScenariosRequest request = new IpApplicationScenariosRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipApplicationScenarios("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("ip"));
    }

    @Test
    void testIpApplicationScenariosServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/applicationScenarios"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"REQ_IP_SCENE_ERR\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpApplicationScenariosRequest request = new IpApplicationScenariosRequest().setIp("218.1.221.132");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipApplicationScenarios("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIpProxyIdentificationSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/proxyIdentification"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.ip", equalTo("218.1.221.132")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":1,\"code\":\"000000\",\"data\":{\"msg\":\"success\",\"code\":200,\"data\":{\"proxy\":{\"proxy\":\"vpn\",\"proxy_time\":\"2026-06-21 07:06:33\",\"is_proxy\":\"是\"}}},\"requestId\":\"tIYK1221146576063676416\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpProxyIdentificationRequest request = new IpProxyIdentificationRequest().setIp("218.1.221.132");
        IpProxyIdentificationResponse response = client.ipProxyIdentification("APP_ID", "SECRET_KEY", request, "trace_ip_proxy_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("tIYK1221146576063676416", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals(Integer.valueOf(200), response.data.code);
        assertEquals("success", response.data.msg);
        assertNotNull(response.data.data);
        assertNotNull(response.data.data.proxy);
        assertEquals("vpn", response.data.data.proxy.proxy);
        assertEquals("2026-06-21 07:06:33", response.data.data.proxy.proxy_time);
        assertEquals("是", response.data.data.proxy.is_proxy);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/ipgsdcx/proxyIdentification"))
                .withHeader("X-Custom-TraceId", equalTo("trace_ip_proxy_001")));
    }

    @Test
    void testIpProxyIdentificationMissingIp() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpProxyIdentificationRequest request = new IpProxyIdentificationRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipProxyIdentification("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("ip"));
    }

    @Test
    void testIpProxyIdentificationServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/proxyIdentification"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"REQ_IP_PROXY_ERR\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpProxyIdentificationRequest request = new IpProxyIdentificationRequest().setIp("218.1.221.132");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipProxyIdentification("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testEnterpriseTwoElementsCheckSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/dynamic2/gsxx/twoElementsCheck"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.credit_code", equalTo("91110000123456789X")))
                .withRequestBody(matchingJsonPath("$.ent_name", equalTo("北京创蓝云智科技股份有限公司")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":\"1\",\"code\":\"200000\",\"data\":{\"ent_name_match\":\"1\",\"credit_code_match\":\"1\"},\"requestId\":\"2702703855033257988\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseTwoElementsCheckRequest request = new EnterpriseTwoElementsCheckRequest()
                .setCredit_code("91110000123456789X")
                .setEnt_name("北京创蓝云智科技股份有限公司");
        EnterpriseTwoElementsCheckResponse response = client.enterpriseTwoElementsCheck("APP_ID", "SECRET_KEY", request, "trace_enterprise_two_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("2702703855033257988", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals("1", response.chargeCount);
        assertNotNull(response.data);
        assertEquals("1", response.data.ent_name_match);
        assertEquals("1", response.data.credit_code_match);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/dynamic2/gsxx/twoElementsCheck"))
                .withHeader("X-Custom-TraceId", equalTo("trace_enterprise_two_001")));
    }

    @Test
    void testEnterpriseTwoElementsCheckMissingCreditCode() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseTwoElementsCheckRequest request = new EnterpriseTwoElementsCheckRequest().setEnt_name("北京创蓝云智科技股份有限公司");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseTwoElementsCheck("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("credit_code"));
    }

    @Test
    void testEnterpriseTwoElementsCheckMissingEntName() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseTwoElementsCheckRequest request = new EnterpriseTwoElementsCheckRequest().setCredit_code("91110000123456789X");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseTwoElementsCheck("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("ent_name"));
    }

    @Test
    void testEnterpriseTwoElementsCheckServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/dynamic2/gsxx/twoElementsCheck"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseTwoElementsCheckRequest request = new EnterpriseTwoElementsCheckRequest()
                .setCredit_code("91110000123456789X")
                .setEnt_name("北京创蓝云智科技股份有限公司");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseTwoElementsCheck("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testEnterpriseThreeAuthSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/business-three-auth"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.entName", equalTo("北京创蓝云智科技股份有限公司")))
                .withRequestBody(matchingJsonPath("$.legalPerName", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.creditCode", equalTo("91110000123456789X")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"code\":\"200000\",\"requestId\":\"3063006183620030483\",\"chargeStatus\":1,\"data\":{\"entNameMatch\":\"1\",\"creditCodeMatch\":\"1\",\"legalPerNameMatch\":\"1\"}}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseThreeAuthRequest request = new EnterpriseThreeAuthRequest()
                .setEntName("北京创蓝云智科技股份有限公司")
                .setLegalPerName("张三")
                .setCreditCode("91110000123456789X");
        EnterpriseThreeAuthResponse response = client.enterpriseThreeAuth("APP_ID", "SECRET_KEY", request, "trace_enterprise_three_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("3063006183620030483", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertNotNull(response.data);
        assertEquals("1", response.data.entNameMatch);
        assertEquals("1", response.data.creditCodeMatch);
        assertEquals("1", response.data.legalPerNameMatch);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/gsxx/business-three-auth"))
                .withHeader("X-Custom-TraceId", equalTo("trace_enterprise_three_001")));
    }

    @Test
    void testEnterpriseThreeAuthMissingEntName() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseThreeAuthRequest request = new EnterpriseThreeAuthRequest()
                .setLegalPerName("张三")
                .setCreditCode("91110000123456789X");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseThreeAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("entName"));
    }

    @Test
    void testEnterpriseThreeAuthMissingLegalPerName() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseThreeAuthRequest request = new EnterpriseThreeAuthRequest()
                .setEntName("北京创蓝云智科技股份有限公司")
                .setCreditCode("91110000123456789X");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseThreeAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("legalPerName"));
    }

    @Test
    void testEnterpriseThreeAuthMissingCreditCode() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseThreeAuthRequest request = new EnterpriseThreeAuthRequest()
                .setEntName("北京创蓝云智科技股份有限公司")
                .setLegalPerName("张三");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseThreeAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("creditCode"));
    }

    @Test
    void testEnterpriseThreeAuthServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/business-three-auth"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseThreeAuthRequest request = new EnterpriseThreeAuthRequest()
                .setEntName("北京创蓝云智科技股份有限公司")
                .setLegalPerName("张三")
                .setCreditCode("91110000123456789X");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseThreeAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testEnterpriseQuerySuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/enterpriseQuery"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.entName", equalTo("创蓝")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"code\":\"200000\",\"requestId\":\"4279011161960366774\",\"chargeStatus\":1,\"chargeCount\":\"1\",\"data\":[{\"entname\":\"xx科技有限责任公司\",\"creditCode\":\"91110xx66318H\"},{\"entname\":\"xx通讯技术有限公司\",\"creditCode\":\"91110xx66318H\"}]}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseQueryRequest request = new EnterpriseQueryRequest().setEntName("创蓝");
        EnterpriseQueryResponse response = client.enterpriseQuery("APP_ID", "SECRET_KEY", request, "trace_enterprise_query_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("4279011161960366774", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals("1", response.chargeCount);
        assertNotNull(response.data);
        assertEquals(2, response.data.size());
        assertEquals("xx科技有限责任公司", response.data.get(0).entname);
        assertEquals("91110xx66318H", response.data.get(0).creditCode);
        assertEquals("xx通讯技术有限公司", response.data.get(1).entname);
        assertEquals("91110xx66318H", response.data.get(1).creditCode);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/gsxx/enterpriseQuery"))
                .withHeader("X-Custom-TraceId", equalTo("trace_enterprise_query_001")));
    }

    @Test
    void testEnterpriseQueryMissingEntName() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseQueryRequest request = new EnterpriseQueryRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseQuery("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("entName"));
    }

    @Test
    void testEnterpriseQueryServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/enterpriseQuery"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseQueryRequest request = new EnterpriseQueryRequest().setEntName("创蓝");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseQuery("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testAbnormalOperationSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/abnormalOperation"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.creditcode", equalTo("91110000123456789X")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":\"1\",\"code\":\"200000\",\"data\":[{\"indate\":\"2015-07-27\",\"inorg\":\"应县市场监督管理局\",\"inreason\":\"未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的\",\"outdate\":\"2016-03-04\",\"outorg\":\"应县市场监督管理局\",\"outreason\":\"列入经营异常名录3年内且依照《经营异常名录管理办法》第六条规定被列入经营异常名录的企业，可以在补报未报年份的年度报告并公示后，申请移出\"},{\"indate\":\"2015-07-10\",\"inorg\":\"应县市场监督管理局\",\"inreason\":\"未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的\",\"outdate\":\"2016-03-04\",\"outorg\":\"应县市场监督管理局\",\"outreason\":\"列入经营异常名录3年内且依照《经营异常名录管理办法》第六条规定被列入经营异常名录的企业，可以在补报未报年份的年度报告并公示后，申请移出\"}],\"requestId\":\"fvId1168220961079795712\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        AbnormalOperationRequest request = new AbnormalOperationRequest().setCreditcode("91110000123456789X");
        AbnormalOperationResponse response = client.abnormalOperation("APP_ID", "SECRET_KEY", request, "trace_abnormal_operation_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("fvId1168220961079795712", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals("1", response.chargeCount);
        assertNotNull(response.data);
        assertEquals(2, response.data.size());
        assertEquals("2015-07-27", response.data.get(0).indate);
        assertEquals("应县市场监督管理局", response.data.get(0).inorg);
        assertEquals("未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告的", response.data.get(0).inreason);
        assertEquals("2016-03-04", response.data.get(0).outdate);
        assertEquals("应县市场监督管理局", response.data.get(0).outorg);
        assertEquals("列入经营异常名录3年内且依照《经营异常名录管理办法》第六条规定被列入经营异常名录的企业，可以在补报未报年份的年度报告并公示后，申请移出", response.data.get(0).outreason);
        assertEquals("2015-07-10", response.data.get(1).indate);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/gsxx/abnormalOperation"))
                .withHeader("X-Custom-TraceId", equalTo("trace_abnormal_operation_001")));
    }

    @Test
    void testAbnormalOperationEmptyRequest() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/abnormalOperation"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":\"1\",\"code\":\"200000\",\"data\":[],\"requestId\":\"fvId1168220961079795713\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        AbnormalOperationRequest request = new AbnormalOperationRequest();
        AbnormalOperationResponse response = client.abnormalOperation("APP_ID", "SECRET_KEY", request);

        assertTrue(response.isSuccess());
        assertNotNull(response.data);
        assertEquals(0, response.data.size());
    }

    @Test
    void testAbnormalOperationServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/abnormalOperation"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        AbnormalOperationRequest request = new AbnormalOperationRequest().setCreditcode("91110000123456789X");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.abnormalOperation("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testAdministrativeSanctionQuerySuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/administrativeSanctionQuery"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.entname", equalTo("内蒙古某化工有限公司")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":\"1\",\"code\":\"200000\",\"data\":[{\"pendecno\":\"（鄂托克旗）应急罚（2025）危化1-16号\",\"casetype\":\"违法行为类型\",\"pentype\":\"罚款\",\"illegfact\":\"主要违法事实\",\"content\":\"行政处罚内容\",\"penam\":\"\",\"confiscate\":\"\",\"penauth\":\"鄂托克旗应急管理局\",\"pendecissdate\":\"2025-12-16\",\"pubdate\":\"2025-12-18\",\"penbasis\":\"中华人民共和国安全生产法\",\"penresult\":\"\",\"penexest\":\"\",\"peneffdate\":\"2099-12-31\",\"pubenddate\":\"2026-03-18\",\"isUsed\":\"\"}],\"requestId\":\"fvId1167887003884429312\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        AdministrativeSanctionQueryRequest request = new AdministrativeSanctionQueryRequest().setEntname("内蒙古某化工有限公司");
        AdministrativeSanctionQueryResponse response = client.administrativeSanctionQuery("APP_ID", "SECRET_KEY", request, "trace_admin_sanction_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("fvId1167887003884429312", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals("1", response.chargeCount);
        assertNotNull(response.data);
        assertEquals(1, response.data.size());
        AdministrativeSanctionItem item = response.data.get(0);
        assertEquals("（鄂托克旗）应急罚（2025）危化1-16号", item.pendecno);
        assertEquals("违法行为类型", item.casetype);
        assertEquals("罚款", item.pentype);
        assertEquals("主要违法事实", item.illegfact);
        assertEquals("行政处罚内容", item.content);
        assertEquals("", item.penam);
        assertEquals("", item.confiscate);
        assertEquals("鄂托克旗应急管理局", item.penauth);
        assertEquals("2025-12-16", item.pendecissdate);
        assertEquals("2025-12-18", item.pubdate);
        assertEquals("中华人民共和国安全生产法", item.penbasis);
        assertEquals("", item.penresult);
        assertEquals("", item.penexest);
        assertEquals("2099-12-31", item.peneffdate);
        assertEquals("2026-03-18", item.pubenddate);
        assertEquals("", item.isUsed);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/gsxx/administrativeSanctionQuery"))
                .withHeader("X-Custom-TraceId", equalTo("trace_admin_sanction_001")));
    }

    @Test
    void testAdministrativeSanctionQueryEmptyRequest() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        AdministrativeSanctionQueryRequest request = new AdministrativeSanctionQueryRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.administrativeSanctionQuery("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("entname"));
    }

    @Test
    void testAdministrativeSanctionQueryServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/administrativeSanctionQuery"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        AdministrativeSanctionQueryRequest request = new AdministrativeSanctionQueryRequest().setUniscid("91110000123456789X");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.administrativeSanctionQuery("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testJusticeComplainSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/justiceComplain"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.entName", equalTo("上海创蓝文化传播有限公司")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":\"1\",\"code\":\"200000\",\"data\":{\"fyggents\":[{\"title\":\"\",\"court\":\"上海市松江区人民法院\",\"pname\":\"上海创蓝文化传播有限公司,北京新华浩淼文化科技有限公司\",\"gtype\":\"裁判\",\"sdate\":\"2020-10-11\"},{\"title\":\"\",\"court\":\"上海市松江区人民法院\",\"pname\":\"上海创蓝文化传播有限公司,杭州逗妮开心科技有限公司\",\"gtype\":\"裁判\",\"sdate\":\"2020-09-30\"}],\"fyggentsCount\":\"7\",\"ktggents\":[{\"caseno\":\"（2024）沪0117民初15259号\",\"title\":\"开庭公告\",\"court\":\"\",\"causename\":\"服务合同纠纷\",\"pname\":\"上海创蓝云智信息科技股份有限公司\",\"sdate\":\"2024-09-04\",\"ptype\":\"原告\"}],\"ktggentsCount\":\"27\"},\"requestId\":\"fvId1167863707545608192\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        JusticeComplainRequest request = new JusticeComplainRequest()
                .setEntName("上海创蓝文化传播有限公司")
                .setDataType("fygg")
                .setPageNum("1")
                .setPageSize("20");
        JusticeComplainResponse response = client.justiceComplain("APP_ID", "SECRET_KEY", request, "trace_justice_complain_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("fvId1167863707545608192", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals("1", response.chargeCount);
        assertNotNull(response.data);
        assertNotNull(response.data.fyggents);
        assertEquals(2, response.data.fyggents.size());
        assertEquals("", response.data.fyggents.get(0).title);
        assertEquals("上海市松江区人民法院", response.data.fyggents.get(0).court);
        assertEquals("上海创蓝文化传播有限公司,北京新华浩淼文化科技有限公司", response.data.fyggents.get(0).pname);
        assertEquals("裁判", response.data.fyggents.get(0).gtype);
        assertEquals("2020-10-11", response.data.fyggents.get(0).sdate);
        assertEquals("7", response.data.fyggentsCount);
        assertNotNull(response.data.ktggents);
        assertEquals(1, response.data.ktggents.size());
        assertEquals("（2024）沪0117民初15259号", response.data.ktggents.get(0).caseno);
        assertEquals("开庭公告", response.data.ktggents.get(0).title);
        assertEquals("", response.data.ktggents.get(0).court);
        assertEquals("服务合同纠纷", response.data.ktggents.get(0).causename);
        assertEquals("上海创蓝云智信息科技股份有限公司", response.data.ktggents.get(0).pname);
        assertEquals("2024-09-04", response.data.ktggents.get(0).sdate);
        assertEquals("原告", response.data.ktggents.get(0).ptype);
        assertEquals("27", response.data.ktggentsCount);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/gsxx/justiceComplain"))
                .withHeader("X-Custom-TraceId", equalTo("trace_justice_complain_001")));
    }

    @Test
    void testJusticeComplainMissingEntName() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        JusticeComplainRequest request = new JusticeComplainRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.justiceComplain("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("entName"));
    }

    @Test
    void testJusticeComplainServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/justiceComplain"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        JusticeComplainRequest request = new JusticeComplainRequest().setEntName("上海创蓝文化传播有限公司");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.justiceComplain("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIpHostInformationSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/hostInformation"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.ip", equalTo("218.1.221.132")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":1,\"code\":\"000000\",\"data\":{\"msg\":\"success\",\"code\":200,\"data\":{\"host_information\":{\"owner\":\"电信\",\"business\":\"枫林雅苑\",\"isp\":\"电信\",\"industry\":\"商务住宅;住宅区;别墅\"}}},\"requestId\":\"tIYK1221130560935936000\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpHostInformationRequest request = new IpHostInformationRequest().setIp("218.1.221.132");
        IpHostInformationResponse response = client.ipHostInformation("APP_ID", "SECRET_KEY", request, "trace_ip_host_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("tIYK1221130560935936000", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals(Integer.valueOf(200), response.data.code);
        assertEquals("success", response.data.msg);
        assertNotNull(response.data.data);
        assertNotNull(response.data.data.host_information);
        assertEquals("电信", response.data.data.host_information.owner);
        assertEquals("枫林雅苑", response.data.data.host_information.business);
        assertEquals("电信", response.data.data.host_information.isp);
        assertEquals("商务住宅;住宅区;别墅", response.data.data.host_information.industry);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/ipgsdcx/hostInformation"))
                .withHeader("X-Custom-TraceId", equalTo("trace_ip_host_001")));
    }

    @Test
    void testIpHostInformationMissingIp() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpHostInformationRequest request = new IpHostInformationRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipHostInformation("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("ip"));
    }

    @Test
    void testIpHostInformationServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ipgsdcx/hostInformation"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IpHostInformationRequest request = new IpHostInformationRequest().setIp("218.1.221.132");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.ipHostInformation("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testCompanyLevelSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/companyLevel"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.key", equalTo("上海创蓝文化传播有限公司")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":\"1\",\"code\":\"200000\",\"data\":{\"level\":\"中型\",\"type\":\"基于最新上市财报数据、工商年报数据及小微企业名录进行划型\"},\"requestId\":\"fvId1167832108548464640\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        CompanyLevelRequest request = new CompanyLevelRequest().setKey("上海创蓝文化传播有限公司");
        CompanyLevelResponse response = client.companyLevel("APP_ID", "SECRET_KEY", request, "trace_company_level_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("fvId1167832108548464640", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals("1", response.chargeCount);
        assertNotNull(response.data);
        assertEquals("中型", response.data.level);
        assertEquals("基于最新上市财报数据、工商年报数据及小微企业名录进行划型", response.data.type);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/gsxx/companyLevel"))
                .withHeader("X-Custom-TraceId", equalTo("trace_company_level_001")));
    }

    @Test
    void testCompanyLevelMissingKey() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        CompanyLevelRequest request = new CompanyLevelRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.companyLevel("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("key"));
    }

    @Test
    void testCompanyLevelServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/companyLevel"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        CompanyLevelRequest request = new CompanyLevelRequest().setKey("上海创蓝文化传播有限公司");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.companyLevel("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testEnterpriseSimpleSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/enterpriseSimple"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.entName", equalTo("上海创蓝文化传播有限公司")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":\"1\",\"code\":\"200000\",\"data\":{\"basic\":{\"entname\":\"上海创蓝文化传播有限公司\",\"entnameold\":\"\",\"creditcode\":\"91110000123456789X\",\"regno\":\"123456789\",\"frname\":\"张三\",\"esdate\":\"2011-04-19\",\"industrycocode\":\"\",\"industryconame\":\"其他科技推广服务业\",\"regcap\":\"1000\",\"regcapcur\":\"人民币元\",\"reccap\":\"1000\",\"regorg\":\"xx\",\"entstatus\":\"在营（开业）\",\"enttype\":\"股份有限公司\",\"opfrom\":\"2011-04-19\",\"opto\":\"长期\",\"regorgprovince\":\"xx\",\"regorgcity\":\"xx\",\"regorgdistrict\":\"xx\",\"email\":\"\",\"dom\":\"xxx\",\"abuitem\":\"xx\",\"ancheyear\":\"xx\",\"tel\":\"021-xx\",\"empnum\":\"1\",\"revdate\":\"\",\"candate\":\"\",\"apprdate\":\"xxxx-07-07\",\"domdistrict\":\"xx\",\"regorgcode\":\"xx\",\"enttypecode\":\"xx\",\"industryphycode\":\"M\",\"industryphyname\":\"科学xxxx技术服务业\",\"industrycoall\":\"7590其他xx推广服务业\",\"industryphyall\":\"M科学xx和技术服务业\"},\"shareholders\":[],\"filiations\":[{\"brname\":\"上海XXX\",\"brncreditcode\":\"xxx\",\"brregno\":\"xx\",\"brnregorg\":\"XX\",\"brnEsdate\":\"2013-01-15\",\"brnEntStatus\":\"注销\",\"brnEntStatusCode\":\"3\",\"brnProvinceCode\":\"xx\",\"brnProvinceName\":\"广东省\"}],\"alters\":[{\"altitem\":\"实收资本变更\",\"altbe\":\"10.000000\",\"altaf\":\"1000.000000\",\"altdate\":\"2012-01-16\"}]},\"requestId\":\"fvId1169292359135109120\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseSimpleRequest request = new EnterpriseSimpleRequest().setEntName("上海创蓝文化传播有限公司");
        EnterpriseSimpleResponse response = client.enterpriseSimple("APP_ID", "SECRET_KEY", request, "trace_enterprise_simple_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("fvId1169292359135109120", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals("1", response.chargeCount);
        assertNotNull(response.data);
        assertNotNull(response.data.basic);
        assertEquals("上海创蓝文化传播有限公司", response.data.basic.entname);
        assertEquals("91110000123456789X", response.data.basic.creditcode);
        assertEquals("123456789", response.data.basic.regno);
        assertEquals("张三", response.data.basic.frname);
        assertEquals("2011-04-19", response.data.basic.esdate);
        assertEquals("其他科技推广服务业", response.data.basic.industryconame);
        assertEquals("1000", response.data.basic.regcap);
        assertEquals("人民币元", response.data.basic.regcapcur);
        assertEquals("在营（开业）", response.data.basic.entstatus);
        assertEquals("股份有限公司", response.data.basic.enttype);
        assertEquals("长期", response.data.basic.opto);
        assertEquals("M", response.data.basic.industryphycode);
        assertEquals("科学xxxx技术服务业", response.data.basic.industryphyname);
        assertNotNull(response.data.shareholders);
        assertEquals(0, response.data.shareholders.size());
        assertNotNull(response.data.filiations);
        assertEquals(1, response.data.filiations.size());
        assertEquals("上海XXX", response.data.filiations.get(0).brname);
        assertEquals("xxx", response.data.filiations.get(0).brncreditcode);
        assertEquals("xx", response.data.filiations.get(0).brregno);
        assertEquals("XX", response.data.filiations.get(0).brnregorg);
        assertEquals("2013-01-15", response.data.filiations.get(0).brnEsdate);
        assertEquals("注销", response.data.filiations.get(0).brnEntStatus);
        assertEquals("3", response.data.filiations.get(0).brnEntStatusCode);
        assertEquals("xx", response.data.filiations.get(0).brnProvinceCode);
        assertEquals("广东省", response.data.filiations.get(0).brnProvinceName);
        assertNotNull(response.data.alters);
        assertEquals(1, response.data.alters.size());
        assertEquals("实收资本变更", response.data.alters.get(0).altitem);
        assertEquals("10.000000", response.data.alters.get(0).altbe);
        assertEquals("1000.000000", response.data.alters.get(0).altaf);
        assertEquals("2012-01-16", response.data.alters.get(0).altdate);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/gsxx/enterpriseSimple"))
                .withHeader("X-Custom-TraceId", equalTo("trace_enterprise_simple_001")));
    }

    @Test
    void testEnterpriseSimpleEmptyRequest() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseSimpleRequest request = new EnterpriseSimpleRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseSimple("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("entName"));
    }

    @Test
    void testEnterpriseSimpleServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/enterpriseSimple"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseSimpleRequest request = new EnterpriseSimpleRequest().setCreditCode("91110000123456789X");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseSimple("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testEnterpriseBiddingSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/enterpriseBidding"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.entname", equalTo("上海创蓝云智信息科技股份有限公司")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":\"1\",\"code\":\"200000\",\"data\":{\"DETAILS_BASIC\":[{\"bid\":\"279380115\",\"title\":\"2025年红旗欧洲智能网联平台-短信平台续费立项报告\",\"pronum\":\"IA-251110-0001-1\",\"bidnum\":\"\",\"tenderee\":\"中国第一汽车集团进出口有限公司\",\"bidindsclass\":\"\",\"region\":\"吉林\",\"totalamount\":\"0\",\"bidtype\":\"中标公告\",\"bidmethod\":\"\",\"pubdate\":\"2025-11-19\",\"content\":\"\"},{\"bid\":\"264183487\",\"title\":\"2025年联通智网科技股份有限公司客户车联网开放平台短信服务采购项目\",\"pronum\":\"\",\"bidnum\":\"\",\"tenderee\":\"联通智网科技股份有限公司\",\"bidindsclass\":\"\",\"region\":\"\",\"totalamount\":\"0\",\"bidtype\":\"中标公告\",\"bidmethod\":\"\",\"pubdate\":\"2025-07-24\",\"content\":\"\"}],\"BID_COUNT\":\"116\"},\"requestId\":\"fvId1168209653206851584\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseBiddingRequest request = new EnterpriseBiddingRequest()
                .setEntname("上海创蓝云智信息科技股份有限公司")
                .setPage("1")
                .setSize("20");
        EnterpriseBiddingResponse response = client.enterpriseBidding("APP_ID", "SECRET_KEY", request, "trace_bidding_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("fvId1168209653206851584", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals("1", response.chargeCount);
        assertNotNull(response.data);
        assertEquals("116", response.data.BID_COUNT);
        assertNotNull(response.data.DETAILS_BASIC);
        assertEquals(2, response.data.DETAILS_BASIC.size());
        assertEquals("279380115", response.data.DETAILS_BASIC.get(0).bid);
        assertEquals("2025年红旗欧洲智能网联平台-短信平台续费立项报告", response.data.DETAILS_BASIC.get(0).title);
        assertEquals("IA-251110-0001-1", response.data.DETAILS_BASIC.get(0).pronum);
        assertEquals("", response.data.DETAILS_BASIC.get(0).bidnum);
        assertEquals("中国第一汽车集团进出口有限公司", response.data.DETAILS_BASIC.get(0).tenderee);
        assertEquals("吉林", response.data.DETAILS_BASIC.get(0).region);
        assertEquals("0", response.data.DETAILS_BASIC.get(0).totalamount);
        assertEquals("中标公告", response.data.DETAILS_BASIC.get(0).bidtype);
        assertEquals("2025-11-19", response.data.DETAILS_BASIC.get(0).pubdate);
        assertEquals("264183487", response.data.DETAILS_BASIC.get(1).bid);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/gsxx/enterpriseBidding"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bidding_001")));
    }

    @Test
    void testEnterpriseBiddingMissingParams() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseBiddingRequest request = new EnterpriseBiddingRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseBidding("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("entname"));
    }

    @Test
    void testEnterpriseBiddingServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/enterpriseBidding"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseBiddingRequest request = new EnterpriseBiddingRequest().setEntname("上海创蓝云智信息科技股份有限公司");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseBidding("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testEnterpriseOwnTaxSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/enterpriseOwnTax"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.keyword", equalTo("应县蓝天管业有限公司")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":\"1\",\"code\":\"200000\",\"data\":{\"items\":[{\"taxIdNumber\":\"91140622058874536B\",\"newOwnTaxBalance\":\"0.0\",\"ownTaxAmount\":\"\",\"publishDate\":\"2025-10-28\",\"ownTaxBalance\":\"5524.49\",\"type\":\"地税\",\"personIdNumber\":\"142126*********314\",\"taxCategory\":\"城市维护建设税\",\"taxpayerType\":\"\",\"personIdName\":\"居民身份证\",\"name\":\"应县蓝天管业有限公司\",\"location\":\"\",\"department\":\"应县税务局\",\"regType\":\"\",\"legalpersonName\":\"**谦\"},{\"taxIdNumber\":\"91140622058874536B\",\"newOwnTaxBalance\":\"0.0\",\"ownTaxAmount\":\"\",\"publishDate\":\"2025-10-28\",\"ownTaxBalance\":\"657480.1\",\"type\":\"地税\",\"personIdNumber\":\"142126*********314\",\"taxCategory\":\"增值税\",\"taxpayerType\":\"\",\"personIdName\":\"居民身份证\",\"name\":\"应县蓝天管业有限公司\",\"location\":\"\",\"department\":\"应县税务局\",\"regType\":\"\",\"legalpersonName\":\"**谦\"}],\"total\":2},\"requestId\":\"fvId1168190516367695872\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseOwnTaxRequest request = new EnterpriseOwnTaxRequest()
                .setKeyword("应县蓝天管业有限公司")
                .setPageNum("1")
                .setPageSize("20");
        EnterpriseOwnTaxResponse response = client.enterpriseOwnTax("APP_ID", "SECRET_KEY", request, "trace_owntax_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("fvId1168190516367695872", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals("1", response.chargeCount);
        assertNotNull(response.data);
        assertEquals(Integer.valueOf(2), response.data.total);
        assertNotNull(response.data.items);
        assertEquals(2, response.data.items.size());
        assertEquals("91140622058874536B", response.data.items.get(0).taxIdNumber);
        assertEquals("0.0", response.data.items.get(0).newOwnTaxBalance);
        assertEquals("5524.49", response.data.items.get(0).ownTaxBalance);
        assertEquals("2025-10-28", response.data.items.get(0).publishDate);
        assertEquals("地税", response.data.items.get(0).type);
        assertEquals("城市维护建设税", response.data.items.get(0).taxCategory);
        assertEquals("居民身份证", response.data.items.get(0).personIdName);
        assertEquals("应县蓝天管业有限公司", response.data.items.get(0).name);
        assertEquals("应县税务局", response.data.items.get(0).department);
        assertEquals("**谦", response.data.items.get(0).legalpersonName);
        assertEquals("657480.1", response.data.items.get(1).ownTaxBalance);
        assertEquals("增值税", response.data.items.get(1).taxCategory);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/gsxx/enterpriseOwnTax"))
                .withHeader("X-Custom-TraceId", equalTo("trace_owntax_001")));
    }

    @Test
    void testEnterpriseOwnTaxMissingParams() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseOwnTaxRequest request = new EnterpriseOwnTaxRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseOwnTax("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("keyword"));
    }

    @Test
    void testEnterpriseOwnTaxServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/gsxx/enterpriseOwnTax"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        EnterpriseOwnTaxRequest request = new EnterpriseOwnTaxRequest().setKeyword("应县蓝天管业有限公司");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.enterpriseOwnTax("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testFaceCheckSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/witness/face-check"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.image", matching(".+")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":1,\"code\":\"000000\",\"data\":{\"faceId\":\"\",\"isLived\":\"1\",\"score\":98.5,\"msg\":\"活体\"},\"requestId\":\"YQis1222128184616292352\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        FaceCheckRequest request = new FaceCheckRequest().setImage("aW1hZ2VfYmFzZTY0X2RhdGE=");
        FaceCheckResponse response = client.faceCheck("APP_ID", "SECRET_KEY", request, "trace_face_check_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("YQis1222128184616292352", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals("", response.data.faceId);
        assertEquals("1", response.data.isLived);
        assertEquals(98.5f, response.data.score, 0.01f);
        assertEquals("活体", response.data.msg);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/witness/face-check"))
                .withHeader("X-Custom-TraceId", equalTo("trace_face_check_001")));
    }

    @Test
    void testFaceCheckMissingImage() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        FaceCheckRequest request = new FaceCheckRequest();
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.faceCheck("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("image"));
    }

    @Test
    void testFaceCheckServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/witness/face-check"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        FaceCheckRequest request = new FaceCheckRequest().setImage("aW1hZ2VfYmFzZTY0X2RhdGE=");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.faceCheck("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testLifeCheckSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/htjc/lifecheck"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.motions", equalTo("BLINK")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"msg\":\"success\",\"chargeCount\":1,\"code\":\"000000\",\"data\":{\"result\":{\"face_image_url\":\"https://img2.jumdata.com/lifecheck-face/20260630/86/3fdfbb5acbd9403d9ee247bb385fbcc0.jpg\",\"hack_score\":0.2769989266716422,\"motions\":{\"score\":0.3465524733126413,\"motion\":\"BLINK\",\"passed\":true},\"passed\":true,\"desc\":\"检测通过\"},\"request_id\":\"Dkos1224047181397446656\"},\"requestId\":\"Dkos1224047181397446656\",\"chargeStatus\":1}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        LifeCheckRequest request = new LifeCheckRequest()
                .setMotions("BLINK")
                .setUrl("https://example.com/video.mp4");
        LifeCheckResponse response = client.lifeCheck("APP_ID", "SECRET_KEY", request, "trace_lifecheck_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("Dkos1224047181397446656", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals("Dkos1224047181397446656", response.data.request_id);
        assertNotNull(response.data.result);
        assertEquals("https://img2.jumdata.com/lifecheck-face/20260630/86/3fdfbb5acbd9403d9ee247bb385fbcc0.jpg", response.data.result.face_image_url);
        assertEquals(0.2769989266716422, response.data.result.hack_score, 0.0001);
        assertTrue(response.data.result.passed);
        assertEquals("检测通过", response.data.result.desc);
        assertNotNull(response.data.result.motions);
        assertEquals(0.3465524733126413, response.data.result.motions.score, 0.0001);
        assertEquals("BLINK", response.data.result.motions.motion);
        assertTrue(response.data.result.motions.passed);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/htjc/lifecheck"))
                .withHeader("X-Custom-TraceId", equalTo("trace_lifecheck_001")));
    }

    @Test
    void testLifeCheckMissingMotions() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        LifeCheckRequest request = new LifeCheckRequest().setUrl("https://example.com/video.mp4");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.lifeCheck("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("motions"));
    }

    @Test
    void testLifeCheckMissingFileAndUrl() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        LifeCheckRequest request = new LifeCheckRequest().setMotions("BLINK");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.lifeCheck("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("file"));
    }

    @Test
    void testLifeCheckServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/htjc/lifecheck"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        LifeCheckRequest request = new LifeCheckRequest().setMotions("BLINK").setUrl("https://example.com/video.mp4");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.lifeCheck("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIdOcrFrontSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ocr/id-ocr-cl"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.ocrType", equalTo("0")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"chargeStatus\":1,\"msg\":\"成功\",\"data\":{\"tradeNo\":\"TRD001\",\"address\":\"北京市朝阳区\",\"birth\":\"19900101\",\"name\":\"张三\",\"cardNum\":\"110101199001011234\",\"sex\":\"男\",\"nation\":\"汉\",\"imageStatus\":\"normal\",\"direction\":\"0\"},\"code\":\"000000\",\"requestId\":\"REQ_OCR_001\"}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrRequest request = new IdOcrRequest()
                .setImage("aW1hZ2VfYmFzZTY0")
                .setImageType("BASE64")
                .setOcrType("0");
        IdOcrResponse response = client.idOcr("APP_ID", "SECRET_KEY", request, "trace_ocr_001");

        assertTrue(response.isSuccess());
        assertEquals("成功", response.msg);
        assertEquals("REQ_OCR_001", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertNotNull(response.data);
        assertEquals("TRD001", response.data.tradeNo);
        assertEquals("北京市朝阳区", response.data.address);
        assertEquals("19900101", response.data.birth);
        assertEquals("张三", response.data.name);
        assertEquals("110101199001011234", response.data.cardNum);
        assertEquals("男", response.data.sex);
        assertEquals("汉", response.data.nation);
        assertEquals("normal", response.data.imageStatus);
        assertEquals("0", response.data.direction);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/ocr/id-ocr-cl"))
                .withHeader("X-Custom-TraceId", equalTo("trace_ocr_001")));
    }

    @Test
    void testIdOcrBackSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ocr/id-ocr-cl"))
                .withHeader("Content-Type", containing("application/json"))
                .withRequestBody(matchingJsonPath("$.ocrType", equalTo("1")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"chargeStatus\":1,\"msg\":\"成功\",\"data\":{\"tradeNo\":\"TRD002\",\"issuingAuthority\":\"北京市公安局\",\"issuingDate\":\"20061008\",\"expiryDate\":\"20251008\",\"imageStatus\":\"normal\",\"direction\":\"0\"},\"code\":\"000000\",\"requestId\":\"REQ_OCR_002\"}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrRequest request = new IdOcrRequest()
                .setImage("https://example.com/idcard_back.jpg")
                .setImageType("URL")
                .setOcrType("1");
        IdOcrResponse response = client.idOcr("APP_ID", "SECRET_KEY", request);

        assertTrue(response.isSuccess());
        assertNotNull(response.data);
        assertEquals("TRD002", response.data.tradeNo);
        assertEquals("北京市公安局", response.data.issuingAuthority);
        assertEquals("20061008", response.data.issuingDate);
        assertEquals("20251008", response.data.expiryDate);
    }

    @Test
    void testIdOcrMissingImage() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrRequest request = new IdOcrRequest().setImageType("BASE64").setOcrType("0");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.idOcr("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("image"));
    }

    @Test
    void testIdOcrMissingImageType() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrRequest request = new IdOcrRequest().setImage("aW1hZ2U=").setOcrType("0");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.idOcr("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("imageType"));
    }

    @Test
    void testIdOcrMissingOcrType() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrRequest request = new IdOcrRequest().setImage("aW1hZ2U=").setImageType("BASE64");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.idOcr("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("ocrType"));
    }

    @Test
    void testIdOcrServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ocr/id-ocr-cl"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrRequest request = new IdOcrRequest().setImage("aW1hZ2U=").setImageType("BASE64").setOcrType("0");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.idOcr("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIdOcrV2FrontSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ocr/id-ocrV2"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.imageType", equalTo("BASE64")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"HcmM1107622401224069120\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"side\":\"front\",\"result\":{\"number\":\"\",\"address\":\"吉林省通榆县八区街团结委六组\",\"month\":\"8\",\"nation\":\"汉\",\"year\":\"2002\",\"sex\":\"男\",\"name\":\"白*\",\"day\":\"20\"}}}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrV2Request request = new IdOcrV2Request()
                .setImage("aW1hZ2VfYmFzZTY0")
                .setImageType("BASE64");
        IdOcrV2Response response = client.idOcrV2("APP_ID", "SECRET_KEY", request, "trace_ocrv2_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.msg);
        assertEquals("HcmM1107622401224069120", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals("front", response.data.side);
        assertNotNull(response.data.result);
        assertEquals("", response.data.result.number);
        assertEquals("吉林省通榆县八区街团结委六组", response.data.result.address);
        assertEquals("8", response.data.result.month);
        assertEquals("汉", response.data.result.nation);
        assertEquals("2002", response.data.result.year);
        assertEquals("男", response.data.result.sex);
        assertEquals("白*", response.data.result.name);
        assertEquals("20", response.data.result.day);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/ocr/id-ocrV2"))
                .withHeader("X-Custom-TraceId", equalTo("trace_ocrv2_001")));
    }

    @Test
    void testIdOcrV2BackSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ocr/id-ocrV2"))
                .withHeader("Content-Type", containing("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"HcmM1107626195328552960\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"side\":\"back\",\"result\":{\"authority\":\"平西路公安博\",\"timelimit\":\"20231205-20410305\"}}}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrV2Request request = new IdOcrV2Request()
                .setImage("https://example.com/idcard_back.jpg")
                .setImageType("URL");
        IdOcrV2Response response = client.idOcrV2("APP_ID", "SECRET_KEY", request);

        assertTrue(response.isSuccess());
        assertNotNull(response.data);
        assertEquals("back", response.data.side);
        assertNotNull(response.data.result);
        assertEquals("平西路公安博", response.data.result.authority);
        assertEquals("20231205-20410305", response.data.result.timelimit);
    }

    @Test
    void testIdOcrV2MissingImage() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrV2Request request = new IdOcrV2Request().setImageType("BASE64");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.idOcrV2("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("image"));
    }

    @Test
    void testIdOcrV2MissingImageType() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrV2Request request = new IdOcrV2Request().setImage("aW1hZ2U=");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.idOcrV2("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("imageType"));
    }

    @Test
    void testIdOcrV2ServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ocr/id-ocrV2"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        IdOcrV2Request request = new IdOcrV2Request().setImage("aW1hZ2U=").setImageType("BASE64");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.idOcrV2("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testVehicleLicenseSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ocr/vehicle-license"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.imageType", equalTo("BASE64")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"成功\",\"requestId\":\"iUPw1155886614683373568\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"brandModel\":\"奥迪牌FV6481LA**\",\"openingDate\":\"20210608\",\"usingProperties\":\"非营运\",\"engineNo\":\"C9*\",\"plateNo\":\"沪EX**\",\"possessor\":\"张**\",\"address\":\"上海市**\",\"registrationDate\":\"20200819\",\"vin\":\"LFV3B2FYXL3**\",\"vehicleType\":\"小型普通客车\",\"code\":\"0\",\"msg\":\"成功\",\"tradeNo\":\"iUPw1155886614683373568\"}}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        VehicleLicenseRequest request = new VehicleLicenseRequest()
                .setImage("aW1hZ2VfYmFzZTY0")
                .setImageType("BASE64");
        VehicleLicenseResponse response = client.vehicleLicense("APP_ID", "SECRET_KEY", request, "trace_vehicle_001");

        assertTrue(response.isSuccess());
        assertEquals("成功", response.msg);
        assertEquals("iUPw1155886614683373568", response.requestId);
        assertEquals(Integer.valueOf(1), response.chargeStatus);
        assertEquals(Integer.valueOf(1), response.chargeCount);
        assertNotNull(response.data);
        assertEquals("奥迪牌FV6481LA**", response.data.brandModel);
        assertEquals("20210608", response.data.openingDate);
        assertEquals("非营运", response.data.usingProperties);
        assertEquals("C9*", response.data.engineNo);
        assertEquals("沪EX**", response.data.plateNo);
        assertEquals("张**", response.data.possessor);
        assertEquals("上海市**", response.data.address);
        assertEquals("20200819", response.data.registrationDate);
        assertEquals("LFV3B2FYXL3**", response.data.vin);
        assertEquals("小型普通客车", response.data.vehicleType);
        assertEquals("0", response.data.code);
        assertEquals("成功", response.data.msg);
        assertEquals("iUPw1155886614683373568", response.data.tradeNo);

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/sdk/ocr/vehicle-license"))
                .withHeader("X-Custom-TraceId", equalTo("trace_vehicle_001")));
    }

    @Test
    void testVehicleLicenseMissingImage() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        VehicleLicenseRequest request = new VehicleLicenseRequest().setImageType("BASE64");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.vehicleLicense("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("image"));
    }

    @Test
    void testVehicleLicenseMissingImageType() {
        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        VehicleLicenseRequest request = new VehicleLicenseRequest().setImage("aW1hZ2U=");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.vehicleLicense("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("imageType"));
    }

    @Test
    void testVehicleLicenseServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/sdk/ocr/vehicle-license"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"msg\":\"系统错误\",\"chargeCount\":0,\"code\":\"301000\",\"requestId\":\"PhcE1222590326496894976\",\"chargeStatus\":0}")));

        BusinessConfig config = new BusinessConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port());
        BusinessClient client = new BusinessClient(config);

        VehicleLicenseRequest request = new VehicleLicenseRequest().setImage("aW1hZ2U=").setImageType("BASE64");
        CloudSdkException exception = assertThrows(CloudSdkException.class, () ->
                client.vehicleLicense("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }
}
