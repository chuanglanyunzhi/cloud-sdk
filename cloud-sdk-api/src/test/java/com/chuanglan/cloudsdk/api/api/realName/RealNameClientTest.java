package com.chuanglan.cloudsdk.api.api.realName;

import com.chuanglan.cloudsdk.core.CloudSdkException;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

class RealNameClientTest {

    private WireMockServer wireMockServer;
    private RealNameClient client;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(0);
        wireMockServer.start();
        RealNameConfig config = new RealNameConfig()
                .setEndpoint("http://localhost:" + wireMockServer.port())
                .setApiEndpoint("http://localhost:" + wireMockServer.port());
        client = new RealNameClient(config);
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void testIdCardAuthSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/idcard/id-card-auth"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("DEV_7BW8WF4UIBM"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"F655A8D5B967440B8683DAD6FF8D230E\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"ORD001\",\"handleTime\":\"20240101120000\",\"province\":\"浙江\",\"city\":\"杭州\",\"country\":\"西湖区\",\"birthday\":\"19900101\",\"age\":\"34\",\"gender\":\"1\",\"remark\":\"一致\",\"result\":\"01\"}}")));

        IdCardAuthRequest request = new IdCardAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234");

        IdCardAuthResponse response = client.idCardAuth("DEV_7BW8WF4UIBM", "AAABBBCCC", request, "trace_realName_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("F655A8D5B967440B8683DAD6FF8D230E", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("ORD001", response.getData().getOrderNo());
        assertEquals("20240101120000", response.getData().getHandleTime());
        assertEquals("浙江", response.getData().getProvince());
        assertEquals("杭州", response.getData().getCity());
        assertEquals("西湖区", response.getData().getCountry());
        assertEquals("19900101", response.getData().getBirthday());
        assertEquals("34", response.getData().getAge());
        assertEquals("1", response.getData().getGender());
        assertEquals("一致", response.getData().getRemark());
        assertEquals("01", response.getData().getResult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/idcard/id-card-auth"))
                .withHeader("X-Custom-TraceId", equalTo("trace_realName_001")));
    }

    @Test
    void testIdCardAuthMissingName() {
        IdCardAuthRequest request = new IdCardAuthRequest()
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.idCardAuth("DEV_7BW8WF4UIBM", "AAABBBCCC", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testIdCardAuthMissingIdNum() {
        IdCardAuthRequest request = new IdCardAuthRequest()
                .setName("张三");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.idCardAuth("DEV_7BW8WF4UIBM", "AAABBBCCC", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testIdCardAuthServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/idcard/id-card-auth"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"InternalError\",\"msg\":\"server error\"}")));

        IdCardAuthRequest request = new IdCardAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.idCardAuth("DEV_7BW8WF4UIBM", "AAABBBCCC", request));
        assertEquals("InternalError", exception.getCode());
    }

    @Test
    void testIdCardAuthRequiresAppId() {
        IdCardAuthRequest request = new IdCardAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234");
        assertThrows(IllegalArgumentException.class, () -> client.idCardAuth(null, "secret", request));
    }

    @Test
    void testIdCardAuthRequiresAppSecret() {
        IdCardAuthRequest request = new IdCardAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234");
        assertThrows(IllegalArgumentException.class, () -> client.idCardAuth("appid", null, request));
    }

    @Test
    void testIdCardAuthV2Success() throws Exception {
        String expectedSign = expectedV2Sign("APP_ID", "SECRET_KEY", "430512198908131367", "代用名");

        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/idcard/id-card-auth/vs"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("代用名")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("430512198908131367")))
                .withRequestBody(matchingJsonPath("$.sign", equalTo(expectedSign)))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_V2_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"ORD_V2_001\",\"handleTime\":\"2026-06-26 14:06:49\",\"province\":\"江西省\",\"city\":\"抚州地区\",\"country\":\"金溪县\",\"birthday\":\"19930404\",\"age\":\"34\",\"gender\":\"1\",\"remark\":\"一致\",\"result\":\"01\"}}")));

        IdCardAuthV2Request request = new IdCardAuthV2Request()
                .setName("代用名")
                .setIdNum("430512198908131367");

        IdCardAuthResponse response = client.idCardAuthV2("APP_ID", "SECRET_KEY", request, "trace_v2_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_V2_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("ORD_V2_001", response.getData().getOrderNo());
        assertEquals("2026-06-26 14:06:49", response.getData().getHandleTime());
        assertEquals("江西省", response.getData().getProvince());
        assertEquals("抚州地区", response.getData().getCity());
        assertEquals("金溪县", response.getData().getCountry());
        assertEquals("19930404", response.getData().getBirthday());
        assertEquals("34", response.getData().getAge());
        assertEquals("1", response.getData().getGender());
        assertEquals("一致", response.getData().getRemark());
        assertEquals("01", response.getData().getResult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/idcard/id-card-auth/vs"))
                .withHeader("X-Custom-TraceId", equalTo("trace_v2_001")));
    }

    @Test
    void testIdCardAuthV2MissingName() {
        IdCardAuthV2Request request = new IdCardAuthV2Request()
                .setIdNum("430512198908131367");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.idCardAuthV2("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testIdCardAuthV2MissingIdNum() {
        IdCardAuthV2Request request = new IdCardAuthV2Request()
                .setName("代用名");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.idCardAuthV2("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testIdCardAuthV2ServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/idcard/id-card-auth/vs"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"请求非法，签名验证不通过\",\"requestId\":\"REQ_V2_ERR\",\"chargeStatus\":0}")));

        IdCardAuthV2Request request = new IdCardAuthV2Request()
                .setName("代用名")
                .setIdNum("430512198908131367");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.idCardAuthV2("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIdCardAuthV2RequiresAppSecret() {
        IdCardAuthV2Request request = new IdCardAuthV2Request()
                .setName("代用名")
                .setIdNum("430512198908131367");
        assertThrows(IllegalArgumentException.class, () -> client.idCardAuthV2("APP_ID", null, request));
    }

    @Test
    void testForeignIdCardAuthSuccess() throws Exception {
        String expectedSign = expectedForeignSign("APP_ID", "SECRET_KEY", "C5NFV8Z8G", "414", "WALDEMAR ANTON LELZ", "FRA");

        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/idcard/id-card-auth-foreign-sign"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("C5NFV8Z8G")))
                .withRequestBody(matchingJsonPath("$.name", equalTo("WALDEMAR ANTON LELZ")))
                .withRequestBody(matchingJsonPath("$.nation", equalTo("FRA")))
                .withRequestBody(matchingJsonPath("$.idType", equalTo("414")))
                .withRequestBody(matchingJsonPath("$.sign", equalTo(expectedSign)))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_FOREIGN_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"ORD_FOREIGN_001\",\"handleTime\":\"2026-06-26 14:18:10\",\"result\":\"01\",\"remark\":\"一致\",\"isValid\":\"1\"}}")));

        ForeignIdCardAuthRequest request = new ForeignIdCardAuthRequest()
                .setIdNum("C5NFV8Z8G")
                .setName("WALDEMAR ANTON LELZ")
                .setIdType("414")
                .setNation("FRA");

        ForeignIdCardAuthResponse response = client.foreignIdCardAuth("APP_ID", "SECRET_KEY", request, "trace_foreign_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_FOREIGN_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("ORD_FOREIGN_001", response.getData().getOrderNo());
        assertEquals("2026-06-26 14:18:10", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("一致", response.getData().getRemark());
        assertEquals("1", response.getData().getIsValid());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/idcard/id-card-auth-foreign-sign"))
                .withHeader("X-Custom-TraceId", equalTo("trace_foreign_001")));
    }

    @Test
    void testForeignIdCardAuthMissingIdNum() {
        ForeignIdCardAuthRequest request = new ForeignIdCardAuthRequest()
                .setName("WALDEMAR ANTON LELZ")
                .setIdType("414")
                .setNation("FRA");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdCardAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testForeignIdCardAuthMissingName() {
        ForeignIdCardAuthRequest request = new ForeignIdCardAuthRequest()
                .setIdNum("C5NFV8Z8G")
                .setIdType("414")
                .setNation("FRA");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdCardAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testForeignIdCardAuthMissingNation() {
        ForeignIdCardAuthRequest request = new ForeignIdCardAuthRequest()
                .setIdNum("C5NFV8Z8G")
                .setName("WALDEMAR ANTON LELZ")
                .setIdType("414");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdCardAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("nation"));
    }

    @Test
    void testForeignIdCardAuthMissingIdType() {
        ForeignIdCardAuthRequest request = new ForeignIdCardAuthRequest()
                .setIdNum("C5NFV8Z8G")
                .setName("WALDEMAR ANTON LELZ")
                .setNation("FRA");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdCardAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idType"));
    }

    @Test
    void testForeignIdCardAuthServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/idcard/id-card-auth-foreign-sign"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"请求非法，签名验证不通过\",\"requestId\":\"REQ_FOREIGN_ERR\",\"chargeStatus\":0}")));

        ForeignIdCardAuthRequest request = new ForeignIdCardAuthRequest()
                .setIdNum("C5NFV8Z8G")
                .setName("WALDEMAR ANTON LELZ")
                .setIdType("414")
                .setNation("FRA");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdCardAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testForeignIdCardAuthRequiresAppSecret() {
        ForeignIdCardAuthRequest request = new ForeignIdCardAuthRequest()
                .setIdNum("C5NFV8Z8G")
                .setName("WALDEMAR ANTON LELZ")
                .setIdType("414")
                .setNation("FRA");
        assertThrows(IllegalArgumentException.class, () -> client.foreignIdCardAuth("APP_ID", null, request));
    }

    @Test
    void testIdMatchSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/idmatch/idmatch-new"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.image", equalTo("base64_image_data")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.useThousandScale", equalTo("true")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"200000\",\"msg\":\"成功\",\"requestId\":\"REQ_MATCH_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"ORD_MATCH_001\",\"handleTime\":\"2026-04-14 10:32:16\",\"result\":\"01\",\"idcardResult\":\"01\",\"idcardMessage\":\"一致\",\"photoResult\":\"01\",\"photoMessage\":\"判断为同一人\",\"photoScore\":\"99\"}}")));

        IdMatchRequest request = new IdMatchRequest()
                .setImage("base64_image_data")
                .setIdNum("330102199001011234")
                .setName("张三")
                .setUseThousandScale(true);

        IdMatchResponse response = client.idMatch("APP_ID", "SECRET_KEY", request, "trace_match_001");

        assertTrue(response.isSuccess());
        assertEquals("成功", response.getMsg());
        assertEquals("REQ_MATCH_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("ORD_MATCH_001", response.getData().getOrderNo());
        assertEquals("2026-04-14 10:32:16", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("01", response.getData().getIdcardResult());
        assertEquals("一致", response.getData().getIdcardMessage());
        assertEquals("01", response.getData().getPhotoResult());
        assertEquals("判断为同一人", response.getData().getPhotoMessage());
        assertEquals("99", response.getData().getPhotoScore());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/idmatch/idmatch-new"))
                .withHeader("X-Custom-TraceId", equalTo("trace_match_001")));
    }

    @Test
    void testIdMatchMissingImage() {
        IdMatchRequest request = new IdMatchRequest()
                .setIdNum("330102199001011234")
                .setName("张三");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.idMatch("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("image"));
    }

    @Test
    void testIdMatchMissingIdNum() {
        IdMatchRequest request = new IdMatchRequest()
                .setImage("base64_image_data")
                .setName("张三");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.idMatch("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testIdMatchMissingName() {
        IdMatchRequest request = new IdMatchRequest()
                .setImage("base64_image_data")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.idMatch("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testIdMatchServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/idmatch/idmatch-new"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"190004\",\"msg\":\"invalid parameter:校验异常：图片内容或路径不能为空\",\"requestId\":\"REQ_MATCH_ERR\",\"chargeStatus\":0}")));

        IdMatchRequest request = new IdMatchRequest()
                .setImage("base64_image_data")
                .setIdNum("330102199001011234")
                .setName("张三");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.idMatch("APP_ID", "SECRET_KEY", request));
        assertEquals("190004", exception.getCode());
    }

    @Test
    void testForeignIdMatchSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/idmatch/idmatch-abroad"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.image", equalTo("/9j/4AAQSkZJRgABAQAAAQABAAD")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("USA371517081101")))
                .withRequestBody(matchingJsonPath("$.name", equalTo("BROCK,EUNICE")))
                .withRequestBody(matchingJsonPath("$.nation", equalTo("USA")))
                .withRequestBody(matchingJsonPath("$.type", equalTo("553")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_FOREIGN_MATCH_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"ORD_FOREIGN_MATCH_001\",\"handleTime\":\"2026-06-26 16:49:25\",\"result\":\"01\",\"isValid\":\"1\",\"remark\":\"一致\"}}")));

        ForeignIdMatchRequest request = new ForeignIdMatchRequest()
                .setImage("/9j/4AAQSkZJRgABAQAAAQABAAD")
                .setIdNum("USA371517081101")
                .setName("BROCK,EUNICE")
                .setNation("USA")
                .setType("553");

        ForeignIdMatchResponse response = client.foreignIdMatch("APP_ID", "SECRET_KEY", request, "trace_foreign_match_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_FOREIGN_MATCH_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("ORD_FOREIGN_MATCH_001", response.getData().getOrderNo());
        assertEquals("2026-06-26 16:49:25", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("1", response.getData().getIsValid());
        assertEquals("一致", response.getData().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/idmatch/idmatch-abroad"))
                .withHeader("X-Custom-TraceId", equalTo("trace_foreign_match_001")));
    }

    @Test
    void testForeignIdMatchMissingImage() {
        ForeignIdMatchRequest request = new ForeignIdMatchRequest()
                .setIdNum("USA371517081101")
                .setName("BROCK,EUNICE")
                .setNation("USA")
                .setType("553");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdMatch("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("image"));
    }

    @Test
    void testForeignIdMatchMissingIdNum() {
        ForeignIdMatchRequest request = new ForeignIdMatchRequest()
                .setImage("/9j/4AAQSkZJRgABAQAAAQABAAD")
                .setName("BROCK,EUNICE")
                .setNation("USA")
                .setType("553");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdMatch("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testForeignIdMatchMissingName() {
        ForeignIdMatchRequest request = new ForeignIdMatchRequest()
                .setImage("/9j/4AAQSkZJRgABAQAAAQABAAD")
                .setIdNum("USA371517081101")
                .setNation("USA")
                .setType("553");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdMatch("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testForeignIdMatchMissingNation() {
        ForeignIdMatchRequest request = new ForeignIdMatchRequest()
                .setImage("/9j/4AAQSkZJRgABAQAAAQABAAD")
                .setIdNum("USA371517081101")
                .setName("BROCK,EUNICE")
                .setType("553");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdMatch("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("nation"));
    }

    @Test
    void testForeignIdMatchMissingType() {
        ForeignIdMatchRequest request = new ForeignIdMatchRequest()
                .setImage("/9j/4AAQSkZJRgABAQAAAQABAAD")
                .setIdNum("USA371517081101")
                .setName("BROCK,EUNICE")
                .setNation("USA");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdMatch("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("type"));
    }

    @Test
    void testForeignIdMatchServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/idmatch/idmatch-abroad"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"190004\",\"msg\":\"invalid parameter\",\"requestId\":\"REQ_FOREIGN_MATCH_ERR\",\"chargeStatus\":0}")));

        ForeignIdMatchRequest request = new ForeignIdMatchRequest()
                .setImage("/9j/4AAQSkZJRgABAQAAAQABAAD")
                .setIdNum("USA371517081101")
                .setName("BROCK,EUNICE")
                .setNation("USA")
                .setType("553");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.foreignIdMatch("APP_ID", "SECRET_KEY", request));
        assertEquals("190004", exception.getCode());
    }

    @Test
    void testCarriersTwoAuthSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-two-auth"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"011649859552865265\",\"handleTime\":\"2022-04-13 22:19:12\",\"result\":\"01\",\"type\":\"1\",\"remark\":\"认证一致\"}}")));

        CarriersTwoAuthRequest request = new CarriersTwoAuthRequest()
                .setName("张三")
                .setMobile("13800138000");

        CarriersTwoAuthResponse response = client.carriersTwoAuth("APP_ID", "SECRET_KEY", request, "trace_carriers_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("011649859552865265", response.getData().getOrderNo());
        assertEquals("2022-04-13 22:19:12", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("1", response.getData().getType());
        assertEquals("认证一致", response.getData().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-two-auth"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_001")));
    }

    @Test
    void testCarriersTwoAuthMissingName() {
        CarriersTwoAuthRequest request = new CarriersTwoAuthRequest()
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersTwoAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testCarriersTwoAuthMissingMobile() {
        CarriersTwoAuthRequest request = new CarriersTwoAuthRequest()
                .setName("张三");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersTwoAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testCarriersTwoAuthServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-two-auth"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"190004\",\"msg\":\"invalid parameter:校验异常：手机号格式不正确\",\"requestId\":\"REQ_CARRIERS_ERR\",\"chargeStatus\":0}")));

        CarriersTwoAuthRequest request = new CarriersTwoAuthRequest()
                .setName("张三")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersTwoAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("190004", exception.getCode());
    }

    @Test
    void testCarriersTwoAuthIdNumSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-two-auth-idnum"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_IDNUM_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"011743662503100016\",\"handleTime\":\"2025-04-03 14:41:43\",\"result\":\"01\",\"remark\":\"认证一致\",\"type\":\"1\",\"gender\":\"2\",\"age\":\"30\"}}")));

        CarriersTwoAuthIdNumRequest request = new CarriersTwoAuthIdNumRequest()
                .setMobile("13800138000")
                .setIdNum("330102199001011234");

        CarriersTwoAuthIdNumResponse response = client.carriersTwoAuthIdNum("APP_ID", "SECRET_KEY", request, "trace_carriers_idnum_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_IDNUM_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("011743662503100016", response.getData().getOrderNo());
        assertEquals("2025-04-03 14:41:43", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("1", response.getData().getType());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("2", response.getData().getGender());
        assertEquals("30", response.getData().getAge());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-two-auth-idnum"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_idnum_001")));
    }

    @Test
    void testCarriersTwoAuthIdNumMissingMobile() {
        CarriersTwoAuthIdNumRequest request = new CarriersTwoAuthIdNumRequest()
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersTwoAuthIdNum("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testCarriersTwoAuthIdNumMissingIdNum() {
        CarriersTwoAuthIdNumRequest request = new CarriersTwoAuthIdNumRequest()
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersTwoAuthIdNum("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testCarriersTwoAuthIdNumServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-two-auth-idnum"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"190004\",\"msg\":\"invalid parameter:校验异常：手机号格式不正确\",\"requestId\":\"REQ_CARRIERS_IDNUM_ERR\",\"chargeStatus\":0}")));

        CarriersTwoAuthIdNumRequest request = new CarriersTwoAuthIdNumRequest()
                .setMobile("13800138000")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersTwoAuthIdNum("APP_ID", "SECRET_KEY", request));
        assertEquals("190004", exception.getCode());
    }

    @Test
    void testCarriersTwoAuthMd5Success() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-two-auth-md5"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("e10adc3949ba59abbe56e057f20f883e")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("e99a18c428cb38d5f260853678922e03")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_MD5_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"011650510527100048\",\"handleTime\":\"2022-04-21 11:08:47\",\"result\":\"01\",\"remark\":\"认证一致\",\"type\":\"1\"}}")));

        CarriersTwoAuthMd5Request request = new CarriersTwoAuthMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CarriersTwoAuthResponse response = client.carriersTwoAuthMd5("APP_ID", "SECRET_KEY", request, "trace_carriers_md5_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_MD5_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("011650510527100048", response.getData().getOrderNo());
        assertEquals("2022-04-21 11:08:47", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("1", response.getData().getType());
        assertEquals("认证一致", response.getData().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-two-auth-md5"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_md5_001")));
    }

    @Test
    void testCarriersTwoAuthMd5MissingName() {
        CarriersTwoAuthMd5Request request = new CarriersTwoAuthMd5Request()
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersTwoAuthMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testCarriersTwoAuthMd5MissingMobile() {
        CarriersTwoAuthMd5Request request = new CarriersTwoAuthMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersTwoAuthMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testCarriersTwoAuthMd5ServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-two-auth-md5"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_CARRIERS_MD5_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        CarriersTwoAuthMd5Request request = new CarriersTwoAuthMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersTwoAuthMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testCarriersAuthSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_AUTH_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"011743662503100017\",\"handleTime\":\"2025-04-03 14:41:43\",\"type\":\"1\",\"gender\":\"2\",\"age\":\"30\",\"result\":\"01\",\"remark\":\"认证一致\"}}")));

        CarriersAuthRequest request = new CarriersAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CarriersAuthResponse response = client.carriersAuth("APP_ID", "SECRET_KEY", request, "trace_carriers_auth_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_AUTH_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("011743662503100017", response.getData().getOrderNo());
        assertEquals("2025-04-03 14:41:43", response.getData().getHandleTime());
        assertEquals("1", response.getData().getType());
        assertEquals("2", response.getData().getGender());
        assertEquals("30", response.getData().getAge());
        assertEquals("01", response.getData().getResult());
        assertEquals("认证一致", response.getData().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-auth"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_auth_001")));
    }

    @Test
    void testCarriersAuthMissingName() {
        CarriersAuthRequest request = new CarriersAuthRequest()
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testCarriersAuthMissingIdNum() {
        CarriersAuthRequest request = new CarriersAuthRequest()
                .setName("张三")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testCarriersAuthMissingMobile() {
        CarriersAuthRequest request = new CarriersAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testCarriersAuthServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"190004\",\"msg\":\"invalid parameter:校验异常：手机号格式不正确\",\"requestId\":\"REQ_CARRIERS_AUTH_ERR\",\"chargeStatus\":0}")));

        CarriersAuthRequest request = new CarriersAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("190004", exception.getCode());
    }

    @Test
    void testCarriersAuthMd5Success() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-md5"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("e10adc3949ba59abbe56e057f20f883e")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("e99a18c428cb38d5f260853678922e03")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_AUTH_MD5_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"011650008483922698\",\"handleTime\":\"2022-04-15 15:41:23\",\"result\":\"01\",\"remark\":\"认证一致\",\"type\":\"1\"}}")));

        CarriersAuthMd5Request request = new CarriersAuthMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setIdNum("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CarriersAuthMd5Response response = client.carriersAuthMd5("APP_ID", "SECRET_KEY", request, "trace_carriers_auth_md5_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_AUTH_MD5_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("011650008483922698", response.getData().getOrderNo());
        assertEquals("2022-04-15 15:41:23", response.getData().getHandleTime());
        assertEquals("1", response.getData().getType());
        assertEquals("01", response.getData().getResult());
        assertEquals("认证一致", response.getData().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-auth-md5"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_auth_md5_001")));
    }

    @Test
    void testCarriersAuthMd5MissingName() {
        CarriersAuthMd5Request request = new CarriersAuthMd5Request()
                .setIdNum("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testCarriersAuthMd5MissingIdNum() {
        CarriersAuthMd5Request request = new CarriersAuthMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testCarriersAuthMd5MissingMobile() {
        CarriersAuthMd5Request request = new CarriersAuthMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setIdNum("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testCarriersAuthMd5ServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-md5"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_CARRIERS_AUTH_MD5_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        CarriersAuthMd5Request request = new CarriersAuthMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setIdNum("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testCarriersAuthDetailSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_DETAIL_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"011649859598865640\",\"handleTime\":\"2022-04-13 22:19:58\",\"result\":\"01\",\"remark\":\"认证一致\",\"type\":\"1\",\"gender\":\"2\",\"age\":\"24\"}}")));

        CarriersAuthRequest request = new CarriersAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CarriersAuthDetailResponse response = client.carriersAuthDetail("APP_ID", "SECRET_KEY", request, "trace_carriers_detail_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_DETAIL_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("011649859598865640", response.getData().getOrderNo());
        assertEquals("2022-04-13 22:19:58", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("1", response.getData().getType());
        assertEquals("2", response.getData().getGender());
        assertEquals("24", response.getData().getAge());
        assertNull(response.getData().getDetail());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_detail_001")));
    }

    @Test
    void testCarriersAuthDetailSuccessWithDetail() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_DETAIL_002\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"011649859598865641\",\"handleTime\":\"2022-04-13 22:20:10\",\"result\":\"02\",\"remark\":\"认证不一致\",\"type\":\"1\",\"gender\":\"2\",\"age\":\"24\",\"detail\":{\"code\":\"03\",\"remark\":\"手机号已实名，手机号和证件号一致，姓名不一致\"}}}")));

        CarriersAuthRequest request = new CarriersAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CarriersAuthDetailResponse response = client.carriersAuthDetail("APP_ID", "SECRET_KEY", request, "trace_carriers_detail_002");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_DETAIL_002", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("011649859598865641", response.getData().getOrderNo());
        assertEquals("2022-04-13 22:20:10", response.getData().getHandleTime());
        assertEquals("02", response.getData().getResult());
        assertEquals("认证不一致", response.getData().getRemark());
        assertEquals("1", response.getData().getType());
        assertEquals("2", response.getData().getGender());
        assertEquals("24", response.getData().getAge());
        assertNotNull(response.getData().getDetail());
        assertEquals("03", response.getData().getDetail().getCode());
        assertEquals("手机号已实名，手机号和证件号一致，姓名不一致", response.getData().getDetail().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_detail_002")));
    }

    @Test
    void testCarriersAuthDetailMissingName() {
        CarriersAuthRequest request = new CarriersAuthRequest()
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testCarriersAuthDetailMissingIdNum() {
        CarriersAuthRequest request = new CarriersAuthRequest()
                .setName("张三")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testCarriersAuthDetailMissingMobile() {
        CarriersAuthRequest request = new CarriersAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testCarriersAuthDetailServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_CARRIERS_DETAIL_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        CarriersAuthRequest request = new CarriersAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testCarriersAuthDetailMd5Success() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail-md5"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("e10adc3949ba59abbe56e057f20f883e")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("e99a18c428cb38d5f260853678922e03")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_DETAIL_MD5_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"011650510506100046\",\"handleTime\":\"2022-04-21 11:08:26\",\"result\":\"01\",\"remark\":\"认证一致\",\"type\":\"1\"}}")));

        CarriersAuthDetailMd5Request request = new CarriersAuthDetailMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setIdNum("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CarriersAuthDetailMd5Response response = client.carriersAuthDetailMd5("APP_ID", "SECRET_KEY", request, "trace_carriers_detail_md5_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_DETAIL_MD5_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("011650510506100046", response.getData().getOrderNo());
        assertEquals("2022-04-21 11:08:26", response.getData().getHandleTime());
        assertEquals("1", response.getData().getType());
        assertEquals("01", response.getData().getResult());
        assertEquals("认证一致", response.getData().getRemark());
        assertNull(response.getData().getDetail());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail-md5"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_detail_md5_001")));
    }

    @Test
    void testCarriersAuthDetailMd5SuccessWithDetail() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail-md5"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("e10adc3949ba59abbe56e057f20f883e")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("e99a18c428cb38d5f260853678922e03")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_DETAIL_MD5_002\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"011650510506100047\",\"handleTime\":\"2022-04-21 11:09:10\",\"result\":\"02\",\"remark\":\"认证不一致\",\"type\":\"1\",\"detail\":{\"code\":\"04\",\"remark\":\"手机号已实名，手机号和姓名一致，身份证不一致\"}}}")));

        CarriersAuthDetailMd5Request request = new CarriersAuthDetailMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setIdNum("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CarriersAuthDetailMd5Response response = client.carriersAuthDetailMd5("APP_ID", "SECRET_KEY", request, "trace_carriers_detail_md5_002");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_DETAIL_MD5_002", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("011650510506100047", response.getData().getOrderNo());
        assertEquals("2022-04-21 11:09:10", response.getData().getHandleTime());
        assertEquals("1", response.getData().getType());
        assertEquals("02", response.getData().getResult());
        assertEquals("认证不一致", response.getData().getRemark());
        assertNotNull(response.getData().getDetail());
        assertEquals("04", response.getData().getDetail().getCode());
        assertEquals("手机号已实名，手机号和姓名一致，身份证不一致", response.getData().getDetail().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail-md5"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_detail_md5_002")));
    }

    @Test
    void testCarriersAuthDetailMd5MissingName() {
        CarriersAuthDetailMd5Request request = new CarriersAuthDetailMd5Request()
                .setIdNum("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetailMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testCarriersAuthDetailMd5MissingIdNum() {
        CarriersAuthDetailMd5Request request = new CarriersAuthDetailMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetailMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testCarriersAuthDetailMd5MissingMobile() {
        CarriersAuthDetailMd5Request request = new CarriersAuthDetailMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setIdNum("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetailMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testCarriersAuthDetailMd5ServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail-md5"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_CARRIERS_DETAIL_MD5_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        CarriersAuthDetailMd5Request request = new CarriersAuthDetailMd5Request()
                .setName("e10adc3949ba59abbe56e057f20f883e")
                .setIdNum("8e8c6e9f1f6b7f9e2e5c1c6e3f5b4d2a")
                .setMobile("e99a18c428cb38d5f260853678922e03");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetailMd5("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testCarriersAuthDetailSha256Success() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail-sha256"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_DETAIL_SHA256_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"021669619646506904\",\"handleTime\":\"2022-12-06 15:14:06\",\"result\":\"01\",\"remark\":\"认证一致\",\"type\":\"1\"}}")));

        CarriersAuthDetailSha256Request request = new CarriersAuthDetailSha256Request()
                .setName("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")
                .setIdNum("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1")
                .setMobile("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6");

        CarriersAuthDetailSha256Response response = client.carriersAuthDetailSha256("APP_ID", "SECRET_KEY", request, "trace_carriers_detail_sha256_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_DETAIL_SHA256_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("021669619646506904", response.getData().getOrderNo());
        assertEquals("2022-12-06 15:14:06", response.getData().getHandleTime());
        assertEquals("1", response.getData().getType());
        assertEquals("01", response.getData().getResult());
        assertEquals("认证一致", response.getData().getRemark());
        assertNull(response.getData().getDetail());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail-sha256"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_detail_sha256_001")));
    }

    @Test
    void testCarriersAuthDetailSha256SuccessWithDetail() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail-sha256"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_DETAIL_SHA256_002\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"021669619646506905\",\"handleTime\":\"2022-12-06 15:14:10\",\"result\":\"02\",\"remark\":\"认证不一致\",\"type\":\"1\",\"detail\":{\"code\":\"03\",\"remark\":\"手机号已实名，手机号和证件号一致，姓名不一致\"}}}")));

        CarriersAuthDetailSha256Request request = new CarriersAuthDetailSha256Request()
                .setName("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")
                .setIdNum("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1")
                .setMobile("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6");

        CarriersAuthDetailSha256Response response = client.carriersAuthDetailSha256("APP_ID", "SECRET_KEY", request, "trace_carriers_detail_sha256_002");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_DETAIL_SHA256_002", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("021669619646506905", response.getData().getOrderNo());
        assertEquals("2022-12-06 15:14:10", response.getData().getHandleTime());
        assertEquals("1", response.getData().getType());
        assertEquals("02", response.getData().getResult());
        assertEquals("认证不一致", response.getData().getRemark());
        assertNotNull(response.getData().getDetail());
        assertEquals("03", response.getData().getDetail().getCode());
        assertEquals("手机号已实名，手机号和证件号一致，姓名不一致", response.getData().getDetail().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail-sha256"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_detail_sha256_002")));
    }

    @Test
    void testCarriersAuthDetailSha256MissingName() {
        CarriersAuthDetailSha256Request request = new CarriersAuthDetailSha256Request()
                .setIdNum("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1")
                .setMobile("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetailSha256("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testCarriersAuthDetailSha256MissingIdNum() {
        CarriersAuthDetailSha256Request request = new CarriersAuthDetailSha256Request()
                .setName("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")
                .setMobile("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetailSha256("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testCarriersAuthDetailSha256MissingMobile() {
        CarriersAuthDetailSha256Request request = new CarriersAuthDetailSha256Request()
                .setName("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")
                .setIdNum("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetailSha256("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testCarriersAuthDetailSha256ServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriers-auth-detail-sha256"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_CARRIERS_DETAIL_SHA256_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        CarriersAuthDetailSha256Request request = new CarriersAuthDetailSha256Request()
                .setName("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")
                .setIdNum("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1")
                .setMobile("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthDetailSha256("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testCarriersAuthSha256Success() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriersAuthSha256"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.chName", equalTo("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1")))
                .withRequestBody(matchingJsonPath("$.chTel", equalTo("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_CARRIERS_SHA256_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"fZBS1064590140277043200\",\"handleTime\":\"2025-04-16 17:01:08\",\"type\":\"2\",\"result\":\"01\",\"remark\":\"一致\"}}")));

        CarriersAuthSha256Request request = new CarriersAuthSha256Request()
                .setChName("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")
                .setIdNum("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1")
                .setChTel("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6");

        CarriersAuthSha256Response response = client.carriersAuthSha256("APP_ID", "SECRET_KEY", request, "trace_carriers_sha256_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_CARRIERS_SHA256_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("fZBS1064590140277043200", response.getData().getOrderNo());
        assertEquals("2025-04-16 17:01:08", response.getData().getHandleTime());
        assertEquals("2", response.getData().getType());
        assertEquals("01", response.getData().getResult());
        assertEquals("一致", response.getData().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/carriers/carriersAuthSha256"))
                .withHeader("X-Custom-TraceId", equalTo("trace_carriers_sha256_001")));
    }

    @Test
    void testCarriersAuthSha256MissingChName() {
        CarriersAuthSha256Request request = new CarriersAuthSha256Request()
                .setIdNum("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1")
                .setChTel("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthSha256("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("chName"));
    }

    @Test
    void testCarriersAuthSha256MissingIdNum() {
        CarriersAuthSha256Request request = new CarriersAuthSha256Request()
                .setChName("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")
                .setChTel("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthSha256("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testCarriersAuthSha256MissingChTel() {
        CarriersAuthSha256Request request = new CarriersAuthSha256Request()
                .setChName("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")
                .setIdNum("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthSha256("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("chTel"));
    }

    @Test
    void testCarriersAuthSha256ServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/carriers/carriersAuthSha256"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_CARRIERS_SHA256_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        CarriersAuthSha256Request request = new CarriersAuthSha256Request()
                .setChName("a8f5f167f44f4964e6c998dee027119c0584f4f7c0b61f9e5b8c0a9f97b3c5d1")
                .setIdNum("b9c3f8e5b4a2d1c6f7e0a8b5c4d3e2f1a6b7c8d9e0f1a2b3c4d5e6f7a8b9c0d1")
                .setChTel("c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.carriersAuthSha256("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardTwoAuthSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-two-auth"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240640\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\"}}")));

        BankCardTwoAuthRequest request = new BankCardTwoAuthRequest()
                .setName("张三")
                .setCardNo("6214830158106328");

        BankCardTwoAuthResponse response = client.bankCardTwoAuth("APP_ID", "SECRET_KEY", request, "trace_bank_card_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240640", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:38:35", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证一致", response.getData().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-two-auth"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_001")));
    }

    @Test
    void testBankCardTwoAuthMissingName() {
        BankCardTwoAuthRequest request = new BankCardTwoAuthRequest()
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardTwoAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardTwoAuthMissingCardNo() {
        BankCardTwoAuthRequest request = new BankCardTwoAuthRequest()
                .setName("张三");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardTwoAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardTwoAuthServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-two-auth"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardTwoAuthRequest request = new BankCardTwoAuthRequest()
                .setName("张三")
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardTwoAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardThreeAuthSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-three-auth"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_THREE_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240640\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        BankCardThreeAuthResponse response = client.bankCardThreeAuth("APP_ID", "SECRET_KEY", request, "trace_bank_card_three_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_THREE_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240640", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:38:35", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-three-auth"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_three_001")));
    }

    @Test
    void testBankCardThreeAuthMissingName() {
        BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardThreeAuthMissingIdNum() {
        BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
                .setName("张三")
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testBankCardThreeAuthMissingCardNo() {
        BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardThreeAuthServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-three-auth"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_THREE_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardThreeAuthTypeSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-type"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .withRequestBody(matchingJsonPath("$.idType", equalTo("20")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_THREE_TYPE_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240640\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardThreeAuthTypeRequest request = new BankCardThreeAuthTypeRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setIdType("20");

        BankCardThreeAuthTypeResponse response = client.bankCardThreeAuthType("APP_ID", "SECRET_KEY", request, "trace_bank_card_three_type_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_THREE_TYPE_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240640", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:38:35", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-type"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_three_type_001")));
    }

    @Test
    void testBankCardThreeAuthTypeWithoutIdTypeSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-type"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_THREE_TYPE_002\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240641\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardThreeAuthTypeRequest request = new BankCardThreeAuthTypeRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        BankCardThreeAuthTypeResponse response = client.bankCardThreeAuthType("APP_ID", "SECRET_KEY", request, "trace_bank_card_three_type_002");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_THREE_TYPE_002", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240641", response.getData().getOrderNo());
        assertEquals("01", response.getData().getResult());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-type"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_three_type_002")));
    }

    @Test
    void testBankCardThreeAuthTypeMissingName() {
        BankCardThreeAuthTypeRequest request = new BankCardThreeAuthTypeRequest()
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthType("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardThreeAuthTypeMissingIdNum() {
        BankCardThreeAuthTypeRequest request = new BankCardThreeAuthTypeRequest()
                .setName("张三")
                .setCardNo("6214830158106328")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthType("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testBankCardThreeAuthTypeMissingCardNo() {
        BankCardThreeAuthTypeRequest request = new BankCardThreeAuthTypeRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthType("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardThreeAuthTypeServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-type"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_THREE_TYPE_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardThreeAuthTypeRequest request = new BankCardThreeAuthTypeRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthType("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardThreeAuthDetailSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-detail"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_THREE_DETAIL_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240640\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        BankCardThreeAuthDetailResponse response = client.bankCardThreeAuthDetail("APP_ID", "SECRET_KEY", request, "trace_bank_card_three_detail_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_THREE_DETAIL_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240640", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:38:35", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-detail"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_three_detail_001")));
    }

    @Test
    void testBankCardThreeAuthDetailMissingName() {
        BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardThreeAuthDetailMissingIdNum() {
        BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
                .setName("张三")
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testBankCardThreeAuthDetailMissingCardNo() {
        BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardThreeAuthDetailServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-detail"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_THREE_DETAIL_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardThreeAuthPrecisionSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-precision"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .withRequestBody(matchingJsonPath("$.idType", equalTo("20")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_THREE_PRECISION_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240640\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardThreeAuthPrecisionRequest request = new BankCardThreeAuthPrecisionRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setIdType("20");

        BankCardThreeAuthPrecisionResponse response = client.bankCardThreeAuthPrecision("APP_ID", "SECRET_KEY", request, "trace_bank_card_three_precision_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_THREE_PRECISION_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240640", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:38:35", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-precision"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_three_precision_001")));
    }

    @Test
    void testBankCardThreeAuthPrecisionWithoutIdTypeSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-precision"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_THREE_PRECISION_002\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240641\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardThreeAuthPrecisionRequest request = new BankCardThreeAuthPrecisionRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        BankCardThreeAuthPrecisionResponse response = client.bankCardThreeAuthPrecision("APP_ID", "SECRET_KEY", request, "trace_bank_card_three_precision_002");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_THREE_PRECISION_002", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240641", response.getData().getOrderNo());
        assertEquals("01", response.getData().getResult());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-precision"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_three_precision_002")));
    }

    @Test
    void testBankCardThreeAuthPrecisionMissingName() {
        BankCardThreeAuthPrecisionRequest request = new BankCardThreeAuthPrecisionRequest()
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthPrecision("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardThreeAuthPrecisionMissingIdNum() {
        BankCardThreeAuthPrecisionRequest request = new BankCardThreeAuthPrecisionRequest()
                .setName("张三")
                .setCardNo("6214830158106328")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthPrecision("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testBankCardThreeAuthPrecisionMissingCardNo() {
        BankCardThreeAuthPrecisionRequest request = new BankCardThreeAuthPrecisionRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthPrecision("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardThreeAuthPrecisionServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-three-auth-precision"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_THREE_PRECISION_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardThreeAuthPrecisionRequest request = new BankCardThreeAuthPrecisionRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardThreeAuthPrecision("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardFourAuthSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_FOUR_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240640\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardFourAuthRequest request = new BankCardFourAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        BankCardFourAuthResponse response = client.bankCardFourAuth("APP_ID", "SECRET_KEY", request, "trace_bank_card_four_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_FOUR_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240640", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:38:35", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-auth"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_four_001")));
    }

    @Test
    void testBankCardFourAuthMissingName() {
        BankCardFourAuthRequest request = new BankCardFourAuthRequest()
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardFourAuthMissingIdNum() {
        BankCardFourAuthRequest request = new BankCardFourAuthRequest()
                .setName("张三")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testBankCardFourAuthMissingCardNo() {
        BankCardFourAuthRequest request = new BankCardFourAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardFourAuthMissingMobile() {
        BankCardFourAuthRequest request = new BankCardFourAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testBankCardFourAuthServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_FOUR_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardFourAuthRequest request = new BankCardFourAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardFourSecretSuccess() throws Exception {
        String expectedParam = expectedBankCardFourSecretParam("SECRET_KEY", "张三", "330102199001011234", "6214830158106328", "13800138000");

        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-secret"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.param", equalTo(expectedParam)))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_FOUR_SECRET_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240640\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardFourSecretRequest request = new BankCardFourSecretRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        BankCardFourSecretResponse response = client.bankCardFourSecret("APP_ID", "SECRET_KEY", request, "trace_bank_card_four_secret_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_FOUR_SECRET_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240640", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:38:35", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-auth-secret"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_four_secret_001")));
    }

    @Test
    void testBankCardFourSecretMissingName() {
        BankCardFourSecretRequest request = new BankCardFourSecretRequest()
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourSecret("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardFourSecretMissingIdNum() {
        BankCardFourSecretRequest request = new BankCardFourSecretRequest()
                .setName("张三")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourSecret("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testBankCardFourSecretMissingCardNo() {
        BankCardFourSecretRequest request = new BankCardFourSecretRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourSecret("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardFourSecretMissingMobile() {
        BankCardFourSecretRequest request = new BankCardFourSecretRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourSecret("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testBankCardFourSecretServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-secret"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_FOUR_SECRET_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardFourSecretRequest request = new BankCardFourSecretRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourSecret("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardFourSecretRequiresAppSecret() {
        BankCardFourSecretRequest request = new BankCardFourSecretRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");
        assertThrows(IllegalArgumentException.class, () -> client.bankCardFourSecret("APP_ID", null, request));
    }

    @Test
    void testBankCardFourAuthDetailSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-detail"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_FOUR_DETAIL_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240640\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardFourAuthDetailRequest request = new BankCardFourAuthDetailRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        BankCardFourAuthDetailResponse response = client.bankCardFourAuthDetail("APP_ID", "SECRET_KEY", request, "trace_bank_card_four_detail_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_FOUR_DETAIL_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240640", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:38:35", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-auth-detail"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_four_detail_001")));
    }

    @Test
    void testBankCardFourAuthDetailWithoutMobileSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-detail"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_FOUR_DETAIL_002\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240641\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardFourAuthDetailRequest request = new BankCardFourAuthDetailRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        BankCardFourAuthDetailResponse response = client.bankCardFourAuthDetail("APP_ID", "SECRET_KEY", request, "trace_bank_card_four_detail_002");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_FOUR_DETAIL_002", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240641", response.getData().getOrderNo());
        assertEquals("01", response.getData().getResult());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-auth-detail"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_four_detail_002")));
    }

    @Test
    void testBankCardFourAuthDetailMissingName() {
        BankCardFourAuthDetailRequest request = new BankCardFourAuthDetailRequest()
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardFourAuthDetailMissingIdNum() {
        BankCardFourAuthDetailRequest request = new BankCardFourAuthDetailRequest()
                .setName("张三")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testBankCardFourAuthDetailMissingCardNo() {
        BankCardFourAuthDetailRequest request = new BankCardFourAuthDetailRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardFourAuthDetailServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-detail"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_FOUR_DETAIL_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardFourAuthDetailRequest request = new BankCardFourAuthDetailRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthDetail("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardFourAuthTypeSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-type"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .withRequestBody(matchingJsonPath("$.idType", equalTo("20")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_FOUR_TYPE_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240640\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardFourAuthTypeRequest request = new BankCardFourAuthTypeRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000")
                .setIdType("20");

        BankCardFourAuthTypeResponse response = client.bankCardFourAuthType("APP_ID", "SECRET_KEY", request, "trace_bank_card_four_type_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_FOUR_TYPE_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240640", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:38:35", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-auth-type"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_four_type_001")));
    }

    @Test
    void testBankCardFourAuthTypeWithoutIdTypeSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-type"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_FOUR_TYPE_002\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240641\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardFourAuthTypeRequest request = new BankCardFourAuthTypeRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        BankCardFourAuthTypeResponse response = client.bankCardFourAuthType("APP_ID", "SECRET_KEY", request, "trace_bank_card_four_type_002");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_FOUR_TYPE_002", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240641", response.getData().getOrderNo());
        assertEquals("01", response.getData().getResult());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-auth-type"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_four_type_002")));
    }

    @Test
    void testBankCardFourAuthTypeMissingName() {
        BankCardFourAuthTypeRequest request = new BankCardFourAuthTypeRequest()
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthType("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardFourAuthTypeMissingIdNum() {
        BankCardFourAuthTypeRequest request = new BankCardFourAuthTypeRequest()
                .setName("张三")
                .setCardNo("6214830158106328")
                .setMobile("13800138000")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthType("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testBankCardFourAuthTypeMissingCardNo() {
        BankCardFourAuthTypeRequest request = new BankCardFourAuthTypeRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthType("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardFourAuthTypeMissingMobile() {
        BankCardFourAuthTypeRequest request = new BankCardFourAuthTypeRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthType("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testBankCardFourAuthTypeServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-type"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_FOUR_TYPE_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardFourAuthTypeRequest request = new BankCardFourAuthTypeRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthType("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardFourAuthPrecisionSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-precision"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .withRequestBody(matchingJsonPath("$.idType", equalTo("20")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_FOUR_PRECISION_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240640\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardFourAuthPrecisionRequest request = new BankCardFourAuthPrecisionRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000")
                .setIdType("20");

        BankCardFourAuthPrecisionResponse response = client.bankCardFourAuthPrecision("APP_ID", "SECRET_KEY", request, "trace_bank_card_four_precision_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_FOUR_PRECISION_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240640", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:38:35", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证一致", response.getData().getRemark());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-auth-precision"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_four_precision_001")));
    }

    @Test
    void testBankCardFourAuthPrecisionWithoutMobileSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-precision"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .withRequestBody(matchingJsonPath("$.idType", equalTo("20")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_FOUR_PRECISION_002\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222600670032240641\",\"handleTime\":\"2026-06-26 17:38:35\",\"result\":\"01\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证一致\",\"innerresult\":\"0101\"}}")));

        BankCardFourAuthPrecisionRequest request = new BankCardFourAuthPrecisionRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setIdType("20");

        BankCardFourAuthPrecisionResponse response = client.bankCardFourAuthPrecision("APP_ID", "SECRET_KEY", request, "trace_bank_card_four_precision_002");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_FOUR_PRECISION_002", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222600670032240641", response.getData().getOrderNo());
        assertEquals("01", response.getData().getResult());
        assertEquals("0101", response.getData().getInnerresult());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-auth-precision"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_four_precision_002")));
    }

    @Test
    void testBankCardFourAuthPrecisionMissingName() {
        BankCardFourAuthPrecisionRequest request = new BankCardFourAuthPrecisionRequest()
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthPrecision("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardFourAuthPrecisionMissingIdNum() {
        BankCardFourAuthPrecisionRequest request = new BankCardFourAuthPrecisionRequest()
                .setName("张三")
                .setCardNo("6214830158106328")
                .setMobile("13800138000")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthPrecision("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testBankCardFourAuthPrecisionMissingCardNo() {
        BankCardFourAuthPrecisionRequest request = new BankCardFourAuthPrecisionRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthPrecision("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardFourAuthPrecisionServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-auth-precision"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_FOUR_PRECISION_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardFourAuthPrecisionRequest request = new BankCardFourAuthPrecisionRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000")
                .setIdType("20");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFourAuthPrecision("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testBankCardFiveAuthSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-five-auth"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.name", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .withRequestBody(matchingJsonPath("$.cardNo", equalTo("6214830158106328")))
                .withRequestBody(matchingJsonPath("$.mobile", equalTo("13800138000")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_BANK_CARD_FIVE_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"orderNo\":\"PhcE1222601507819298816\",\"handleTime\":\"2026-06-26 17:41:54\",\"result\":\"01\",\"bankAccountType\":\"1\",\"bankName\":\"上海银行\",\"cardType\":\"首发纪念版IC卡\",\"cardCategory\":\"借记卡\",\"remark\":\"认证信息匹配\"}}")));

        BankCardFiveAuthRequest request = new BankCardFiveAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        BankCardFiveAuthResponse response = client.bankCardFiveAuth("APP_ID", "SECRET_KEY", request, "trace_bank_card_five_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_BANK_CARD_FIVE_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222601507819298816", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:41:54", response.getData().getHandleTime());
        assertEquals("01", response.getData().getResult());
        assertEquals("1", response.getData().getBankAccountType());
        assertEquals("上海银行", response.getData().getBankName());
        assertEquals("首发纪念版IC卡", response.getData().getCardType());
        assertEquals("借记卡", response.getData().getCardCategory());
        assertEquals("认证信息匹配", response.getData().getRemark());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/bankcard/card-five-auth"))
                .withHeader("X-Custom-TraceId", equalTo("trace_bank_card_five_001")));
    }

    @Test
    void testBankCardFiveAuthMissingName() {
        BankCardFiveAuthRequest request = new BankCardFiveAuthRequest()
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFiveAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    void testBankCardFiveAuthMissingIdNum() {
        BankCardFiveAuthRequest request = new BankCardFiveAuthRequest()
                .setName("张三")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFiveAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testBankCardFiveAuthMissingCardNo() {
        BankCardFiveAuthRequest request = new BankCardFiveAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFiveAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("cardNo"));
    }

    @Test
    void testBankCardFiveAuthMissingMobile() {
        BankCardFiveAuthRequest request = new BankCardFiveAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFiveAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("mobile"));
    }

    @Test
    void testBankCardFiveAuthServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/bankcard/card-five-auth"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_BANK_CARD_FIVE_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        BankCardFiveAuthRequest request = new BankCardFiveAuthRequest()
                .setName("张三")
                .setIdNum("330102199001011234")
                .setCardNo("6214830158106328")
                .setMobile("13800138000");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.bankCardFiveAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testIpGsdQuerySuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/ipgsdcx/ipgsd"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.ip", equalTo("218.1.221.132")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_IP_GSD_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"result\":\"01\",\"orderNo\":\"936a15e2-22ca-4501-980b-2d6fca61c79b\",\"handleTime\":\"2026-06-22 20:19:03\",\"ipAddr\":\"218.1.221.132\",\"country\":\"中国\",\"province\":\"上海\",\"city\":\"上海\",\"area\":\"徐汇\",\"line\":\"中国电信\"}}")));

        IpGsdQueryRequest request = new IpGsdQueryRequest()
                .setIp("218.1.221.132");

        IpGsdQueryResponse response = client.ipGsdQuery("APP_ID", "SECRET_KEY", request, "trace_ip_gsd_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_IP_GSD_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("01", response.getData().getResult());
        assertEquals("936a15e2-22ca-4501-980b-2d6fca61c79b", response.getData().getOrderNo());
        assertEquals("2026-06-22 20:19:03", response.getData().getHandleTime());
        assertEquals("218.1.221.132", response.getData().getIpAddr());
        assertEquals("中国", response.getData().getCountry());
        assertEquals("上海", response.getData().getProvince());
        assertEquals("上海", response.getData().getCity());
        assertEquals("徐汇", response.getData().getArea());
        assertEquals("中国电信", response.getData().getLine());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/ipgsdcx/ipgsd"))
                .withHeader("X-Custom-TraceId", equalTo("trace_ip_gsd_001")));
    }

    @Test
    void testIpGsdQueryMissingIp() {
        IpGsdQueryRequest request = new IpGsdQueryRequest();

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.ipGsdQuery("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("ip"));
    }

    @Test
    void testIpGsdQueryServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/ipgsdcx/ipgsd"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_IP_GSD_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        IpGsdQueryRequest request = new IpGsdQueryRequest()
                .setIp("218.1.221.132");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.ipGsdQuery("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    @Test
    void testEnterpriseFourAuthSuccess() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/gsxx/business-four-auth"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("AppID", equalTo("APP_ID"))
                .withHeader("CheckSum", matching("[A-F0-9]+"))
                .withRequestBody(matchingJsonPath("$.entName", equalTo("创蓝云智")))
                .withRequestBody(matchingJsonPath("$.legalPerName", equalTo("张三")))
                .withRequestBody(matchingJsonPath("$.creditCode", equalTo("91110105MA00XXXXXX")))
                .withRequestBody(matchingJsonPath("$.idNum", equalTo("330102199001011234")))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"code\":\"000000\",\"msg\":\"success\",\"requestId\":\"REQ_ENTERPRISE_FOUR_001\",\"chargeStatus\":1,\"chargeCount\":1,\"data\":{\"result\":\"02\",\"companyNameMatch\":\"1\",\"handleTime\":\"2026-06-26 17:42:44\",\"orderNo\":\"PhcE1222601718394331136\",\"creditCodeMatch\":\"1\",\"idNoMatch\":\"2\",\"remark\":\"不一致\",\"legalPerNameMatch\":\"2\"}}")));

        EnterpriseFourAuthRequest request = new EnterpriseFourAuthRequest()
                .setEntName("创蓝云智")
                .setLegalPerName("张三")
                .setCreditCode("91110105MA00XXXXXX")
                .setIdNum("330102199001011234");

        EnterpriseFourAuthResponse response = client.enterpriseFourAuth("APP_ID", "SECRET_KEY", request, "trace_enterprise_four_001");

        assertTrue(response.isSuccess());
        assertEquals("success", response.getMsg());
        assertEquals("REQ_ENTERPRISE_FOUR_001", response.getRequestId());
        assertEquals(Integer.valueOf(1), response.getChargeStatus());
        assertEquals(Integer.valueOf(1), response.getChargeCount());
        assertNotNull(response.getData());
        assertEquals("PhcE1222601718394331136", response.getData().getOrderNo());
        assertEquals("2026-06-26 17:42:44", response.getData().getHandleTime());
        assertEquals("02", response.getData().getResult());
        assertEquals("不一致", response.getData().getRemark());
        assertEquals("1", response.getData().getCompanyNameMatch());
        assertEquals("1", response.getData().getCreditCodeMatch());
        assertEquals("2", response.getData().getLegalPerNameMatch());
        assertEquals("2", response.getData().getIdNoMatch());

        wireMockServer.verify(postRequestedFor(urlEqualTo("/api/v2/auth/gsxx/business-four-auth"))
                .withHeader("X-Custom-TraceId", equalTo("trace_enterprise_four_001")));
    }

    @Test
    void testEnterpriseFourAuthMissingEntName() {
        EnterpriseFourAuthRequest request = new EnterpriseFourAuthRequest()
                .setLegalPerName("张三")
                .setCreditCode("91110105MA00XXXXXX")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.enterpriseFourAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("entName"));
    }

    @Test
    void testEnterpriseFourAuthMissingLegalPerName() {
        EnterpriseFourAuthRequest request = new EnterpriseFourAuthRequest()
                .setEntName("创蓝云智")
                .setCreditCode("91110105MA00XXXXXX")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.enterpriseFourAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("legalPerName"));
    }

    @Test
    void testEnterpriseFourAuthMissingCreditCode() {
        EnterpriseFourAuthRequest request = new EnterpriseFourAuthRequest()
                .setEntName("创蓝云智")
                .setLegalPerName("张三")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.enterpriseFourAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("creditCode"));
    }

    @Test
    void testEnterpriseFourAuthMissingIdNum() {
        EnterpriseFourAuthRequest request = new EnterpriseFourAuthRequest()
                .setEntName("创蓝云智")
                .setLegalPerName("张三")
                .setCreditCode("91110105MA00XXXXXX");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.enterpriseFourAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("ParameterMissing", exception.getCode());
        assertTrue(exception.getMessage().contains("idNum"));
    }

    @Test
    void testEnterpriseFourAuthServerError() {
        wireMockServer.stubFor(post(urlEqualTo("/api/v2/auth/gsxx/business-four-auth"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withBody("{\"code\":\"301000\",\"msg\":\"系统错误\",\"requestId\":\"REQ_ENTERPRISE_FOUR_ERR\",\"chargeStatus\":0,\"chargeCount\":0}")));

        EnterpriseFourAuthRequest request = new EnterpriseFourAuthRequest()
                .setEntName("创蓝云智")
                .setLegalPerName("张三")
                .setCreditCode("91110105MA00XXXXXX")
                .setIdNum("330102199001011234");

        CloudSdkException exception = assertThrows(CloudSdkException.class, () -> client.enterpriseFourAuth("APP_ID", "SECRET_KEY", request));
        assertEquals("301000", exception.getCode());
    }

    private String expectedBankCardFourSecretParam(String appSecret, String name, String idNum, String cardNo, String mobile) throws Exception {
        String raw = "name=" + name + "&idnum=" + idNum + "&cardnum=" + cardNo + "&mobilenum=" + mobile;
        String md5Hex = expectedMd5Hex(appSecret);
        String key = md5Hex.substring(0, 16);
        String iv = md5Hex.substring(16, 32);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE,
                new javax.crypto.spec.SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES"),
                new javax.crypto.spec.IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));
        byte[] encrypted = cipher.doFinal(raw.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    private String expectedMd5Hex(String input) throws Exception {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private String expectedV2Sign(String appId, String appSecret, String idNum, String name) throws Exception {
        String raw = "appId" + appId + "idNum" + idNum + "name" + name;
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(appSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA1"));
        return Base64.getEncoder().encodeToString(mac.doFinal(raw.getBytes(StandardCharsets.UTF_8)));
    }

    private String expectedForeignSign(String appId, String appSecret, String idNum, String idType, String name, String nation) throws Exception {
        String raw = "appId" + appId + "appKey" + appSecret + "idNum" + idNum + "idType" + idType + "name" + name + "nation" + nation;
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(appSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA1"));
        return Base64.getEncoder().encodeToString(mac.doFinal(raw.getBytes(StandardCharsets.UTF_8)));
    }
}
