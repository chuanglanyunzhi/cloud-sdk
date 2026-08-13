# Cloud SDK API 完整参考

本文档列出了 `CloudApiClient` 中所有可调用的业务方法（共 96 个），每个方法都支持链路追踪（traceId 参数）。

---

## 目录

- [短信业务 (18 个方法)](#短信业务)
- [国际短信业务 (6 个方法)](#国际短信业务)
- [视频短信业务 (6 个方法)](#视频短信业务)
- [号码业务 (2 个方法)](#号码业务)
- [号码运营商业务 (4 个方法)](#号码运营商业务)
- [携号转网业务 (1 个方法)](#携号转网业务)
- [风控业务 (2 个方法)](#风控业务)
- [实名认证业务 (28 个方法)](#实名认证业务)
- [企业信息与 OCR 业务 (29 个方法)](#企业信息与-ocr-业务)

---

## 短信业务

### 1. batchSend - 批量发送短信

**方法签名**：
```java
SmsBatchSendResponse batchSend(String appId, String appSecret, SmsBatchSendRequest request)
SmsBatchSendResponse batchSend(String appId, String appSecret, SmsBatchSendRequest request, String traceId)
```

**使用示例**：
```java
SmsBatchSendRequest request = new SmsBatchSendRequest()
    .setProductType("notify")
    .setPhoneNumbers("13800138000,13900139000")
    .setTemplateCode("T12345")
    .setSignName("创蓝云")
    .setReport(true);

SmsBatchSendResponse response = client.batchSend(appId, appSecret, request);
if (response.isSuccess()) {
    System.out.println("msgId: " + response.getData().getMsgId());
}
```

---

### 2. addQualification - 添加资质

**方法签名**：
```java
SmsQualificationAddResponse addQualification(String appId, String appSecret, SmsQualificationAddRequest request)
SmsQualificationAddResponse addQualification(String appId, String appSecret, SmsQualificationAddRequest request, String traceId)
```

**使用示例**：
```java
SmsQualificationAddRequest request = new SmsQualificationAddRequest()
    .setQualificationType("1")  // 1=企业 2=个人
    .setCompanyName("创蓝科技有限公司")
    .setLicenseUrl("https://example.com/license.jpg");

SmsQualificationAddResponse response = client.addQualification(appId, appSecret, request);
```

---

### 3. listQualification - 查询资质列表

**方法签名**：
```java
SmsQualificationListResponse listQualification(String appId, String appSecret, SmsQualificationListRequest request)
SmsQualificationListResponse listQualification(String appId, String appSecret, SmsQualificationListRequest request, String traceId)
```

**使用示例**：
```java
SmsQualificationListRequest request = new SmsQualificationListRequest()
    .setPageNum(1)
    .setPageSize(20);

SmsQualificationListResponse response = client.listQualification(appId, appSecret, request);
for (QualificationItem item : response.getData().getList()) {
    System.out.println("资质ID: " + item.getQualificationId());
}
```

---

### 4. updateQualification - 更新资质

**方法签名**：
```java
SmsQualificationUpdateResponse updateQualification(String appId, String appSecret, SmsQualificationUpdateRequest request)
SmsQualificationUpdateResponse updateQualification(String appId, String appSecret, SmsQualificationUpdateRequest request, String traceId)
```

---

### 5. deleteQualification - 删除资质

**方法签名**：
```java
SmsQualificationDeleteResponse deleteQualification(String appId, String appSecret, SmsQualificationDeleteRequest request)
SmsQualificationDeleteResponse deleteQualification(String appId, String appSecret, SmsQualificationDeleteRequest request, String traceId)
```

---

### 6. addSignature - 添加签名

**方法签名**：
```java
SmsSignatureAddResponse addSignature(String appId, String appSecret, SmsSignatureAddRequest request)
SmsSignatureAddResponse addSignature(String appId, String appSecret, SmsSignatureAddRequest request, String traceId)
```

**使用示例**：
```java
SmsSignatureAddRequest request = new SmsSignatureAddRequest()
    .setSignName("创蓝云")
    .setSignType("1")           // 1=网站 2=APP 3=微信公众号 4=企业名称
    .setSignPurpose("1")        // 1=自用 2=他用
    .setRemark("官方签名");

SmsSignatureAddResponse response = client.addSignature(appId, appSecret, request);
```

---

### 7. getSignature - 查询签名详情

**方法签名**：
```java
SmsSignatureGetResponse getSignature(String appId, String appSecret, SmsSignatureGetRequest request)
SmsSignatureGetResponse getSignature(String appId, String appSecret, SmsSignatureGetRequest request, String traceId)
```

---

### 8. listSignature - 查询签名列表

**方法签名**：
```java
SmsSignatureListResponse listSignature(String appId, String appSecret, SmsSignatureListRequest request)
SmsSignatureListResponse listSignature(String appId, String appSecret, SmsSignatureListRequest request, String traceId)
```

**使用示例**：
```java
SmsSignatureListRequest request = new SmsSignatureListRequest()
    .setSignName("创蓝云")
    .setStatus("2")  // 1=待审核 2=已通过 3=已驳回
    .setPageNum(1)
    .setPageSize(20);

SmsSignatureListResponse response = client.listSignature(appId, appSecret, request);
```

---

### 9. getSignatureOperatorRejectReason - 查询签名运营商驳回原因

**方法签名**：
```java
SmsSignatureOperatorRejectReasonResponse getSignatureOperatorRejectReason(String appId, String appSecret, SmsSignatureOperatorRejectReasonRequest request)
SmsSignatureOperatorRejectReasonResponse getSignatureOperatorRejectReason(String appId, String appSecret, SmsSignatureOperatorRejectReasonRequest request, String traceId)
```

---

### 10. updateSignatureRealName - 更新签名实名信息

**方法签名**：
```java
SmsSignatureRealNameUpdateResponse updateSignatureRealName(String appId, String appSecret, SmsSignatureRealNameUpdateRequest request)
SmsSignatureRealNameUpdateResponse updateSignatureRealName(String appId, String appSecret, SmsSignatureRealNameUpdateRequest request, String traceId)
```

---

### 11. deleteSignature - 删除签名

**方法签名**：
```java
SmsSignatureDeleteResponse deleteSignature(String appId, String appSecret, SmsSignatureDeleteRequest request)
SmsSignatureDeleteResponse deleteSignature(String appId, String appSecret, SmsSignatureDeleteRequest request, String traceId)
```

---

### 12. addTemplate - 添加模板

**方法签名**：
```java
SmsTemplateAddResponse addTemplate(String appId, String appSecret, SmsTemplateAddRequest request)
SmsTemplateAddResponse addTemplate(String appId, String appSecret, SmsTemplateAddRequest request, String traceId)
```

**使用示例**：
```java
SmsTemplateAddRequest request = new SmsTemplateAddRequest()
    .setTemplateName("验证码模板")
    .setTemplateType("1")       // 1=验证码 2=通知 3=营销
    .setTemplateContent("您的验证码是{1}，{2}分钟内有效")
    .setSignName("创蓝云");

SmsTemplateAddResponse response = client.addTemplate(appId, appSecret, request);
```

---

### 13. queryTemplateTypeEnum - 查询模板类型枚举

**方法签名**：
```java
SmsTemplateTypeEnumResponse queryTemplateTypeEnum(String appId, String appSecret, SmsTemplateTypeEnumRequest request)
SmsTemplateTypeEnumResponse queryTemplateTypeEnum(String appId, String appSecret, SmsTemplateTypeEnumRequest request, String traceId)
```

---

### 14. listTemplate - 查询模板列表

**方法签名**：
```java
SmsTemplateListResponse listTemplate(String appId, String appSecret, SmsTemplateListRequest request)
SmsTemplateListResponse listTemplate(String appId, String appSecret, SmsTemplateListRequest request, String traceId)
```

---

### 15. getTemplate - 查询模板详情

**方法签名**：
```java
SmsTemplateGetResponse getTemplate(String appId, String appSecret, SmsTemplateGetRequest request)
SmsTemplateGetResponse getTemplate(String appId, String appSecret, SmsTemplateGetRequest request, String traceId)
```

---

### 16. getTemplateOperatorRejectReason - 查询模板运营商驳回原因

**方法签名**：
```java
SmsTemplateOperatorRejectReasonResponse getTemplateOperatorRejectReason(String appId, String appSecret, SmsTemplateOperatorRejectReasonRequest request)
SmsTemplateOperatorRejectReasonResponse getTemplateOperatorRejectReason(String appId, String appSecret, SmsTemplateOperatorRejectReasonRequest request, String traceId)
```

---

### 17. updateTemplate - 更新模板

**方法签名**：
```java
SmsTemplateUpdateResponse updateTemplate(String appId, String appSecret, SmsTemplateUpdateRequest request)
SmsTemplateUpdateResponse updateTemplate(String appId, String appSecret, SmsTemplateUpdateRequest request, String traceId)
```

---

### 18. deleteTemplate - 删除模板

**方法签名**：
```java
SmsTemplateDeleteResponse deleteTemplate(String appId, String appSecret, SmsTemplateDeleteRequest request)
SmsTemplateDeleteResponse deleteTemplate(String appId, String appSecret, SmsTemplateDeleteRequest request, String traceId)
```

---

## 国际短信业务

### 1. submitIntSms - 国际短信发送

**方法签名**：
```java
// 使用默认节点（上海）
IntSmsSubmitResponse submitIntSms(String appId, String appSecret, IntSmsSubmitRequest request)
IntSmsSubmitResponse submitIntSms(String appId, String appSecret, IntSmsSubmitRequest request, String traceId)

// 指定节点
IntSmsSubmitResponse submitIntSms(String appId, String appSecret, String endpoint, IntSmsSubmitRequest request)
IntSmsSubmitResponse submitIntSms(String appId, String appSecret, String endpoint, IntSmsSubmitRequest request, String traceId)
```

**使用示例**：
```java
IntSmsSubmitRequest request = new IntSmsSubmitRequest()
    .setPhone("+8613800138000,+85298765432")
    .setMsg("Your verification code is 1234")
    .setReport(true);

// 使用默认节点
IntSmsSubmitResponse response = client.submitIntSms(appId, appSecret, request);

// 或指定香港节点
response = client.submitIntSms(appId, appSecret, "https://hkintapi.253.com", request);
```

---

### 2. queryIntSmsBalance - 账户余额查询

**方法签名**：
```java
IntSmsBalanceResponse queryIntSmsBalance(String appId, String appSecret, IntSmsBalanceRequest request)
IntSmsBalanceResponse queryIntSmsBalance(String appId, String appSecret, IntSmsBalanceRequest request, String traceId)
IntSmsBalanceResponse queryIntSmsBalance(String appId, String appSecret, String endpoint, IntSmsBalanceRequest request, String traceId)
```

**使用示例**：
```java
IntSmsBalanceRequest request = new IntSmsBalanceRequest();
IntSmsBalanceResponse response = client.queryIntSmsBalance(appId, appSecret, request);
System.out.println("余额: " + response.getData().getBalance());
```

---

### 3. queryIntSmsCost - 账户消耗查询

**方法签名**：
```java
IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, IntSmsCostRequest request)
IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, IntSmsCostRequest request, String traceId)
IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, String endpoint, IntSmsCostRequest request)
IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, String endpoint, IntSmsCostRequest request, String traceId)
```

---

### 4. queryIntSmsPrice - 发送价格查询

**方法签名**：
```java
IntSmsPriceResponse queryIntSmsPrice(String appId, String appSecret, IntSmsPriceRequest request)
IntSmsPriceResponse queryIntSmsPrice(String appId, String appSecret, IntSmsPriceRequest request, String traceId)
IntSmsPriceResponse queryIntSmsPrice(String appId, String appSecret, String endpoint, IntSmsPriceRequest request, String traceId)
```

---

### 5. pullIntSmsReport - 状态报告拉取

**方法签名**：
```java
IntSmsReportPullResponse pullIntSmsReport(String appId, String appSecret, IntSmsReportPullRequest request)
IntSmsReportPullResponse pullIntSmsReport(String appId, String appSecret, IntSmsReportPullRequest request, String traceId)
```

**使用示例**：
```java
IntSmsReportPullRequest request = new IntSmsReportPullRequest()
    .setCount(100);

IntSmsReportPullResponse response = client.pullIntSmsReport(appId, appSecret, request);
for (IntSmsReportItem item : response.getData().getList()) {
    System.out.println("msgId: " + item.getMsgId() + ", status: " + item.getStatus());
}
```

---

### 6. pullIntSmsReply - 上行回复拉取

**方法签名**：
```java
IntSmsReplyPullResponse pullIntSmsReply(String appId, String appSecret, IntSmsReplyPullRequest request)
IntSmsReplyPullResponse pullIntSmsReply(String appId, String appSecret, IntSmsReplyPullRequest request, String traceId)
```

---

## 视频短信业务

### 1. addVideoTemplate - 添加视频模板

**方法签名**：
```java
RcsSmsTemplateAddResponse addVideoTemplate(String appId, String appSecret, RcsSmsTemplateAddRequest request)
RcsSmsTemplateAddResponse addVideoTemplate(String appId, String appSecret, RcsSmsTemplateAddRequest request, String traceId)
```

**使用示例**：
```java
RcsSmsTemplateAddRequest request = new RcsSmsTemplateAddRequest()
    .setTemplateName("营销视频")
    .setTemplateContent("视频内容描述")
    .setVideoUrl("https://example.com/video.mp4")
    .setSignName("创蓝云");

RcsSmsTemplateAddResponse response = client.addVideoTemplate(appId, appSecret, request);
```

---

### 2. findVideoTemplate - 查询视频模板

**方法签名**：
```java
RcsSmsTemplateFindResponse findVideoTemplate(String appId, String appSecret, RcsSmsTemplateFindRequest request)
RcsSmsTemplateFindResponse findVideoTemplate(String appId, String appSecret, RcsSmsTemplateFindRequest request, String traceId)
```

---

### 3. submitVideoTemplate - 发送视频短信

**方法签名**：
```java
RcsSmsTemplateSubmitResponse submitVideoTemplate(String appId, String appSecret, RcsSmsTemplateSubmitRequest request)
RcsSmsTemplateSubmitResponse submitVideoTemplate(String appId, String appSecret, RcsSmsTemplateSubmitRequest request, String traceId)
```

**使用示例**：
```java
RcsSmsTemplateSubmitRequest request = new RcsSmsTemplateSubmitRequest()
    .setPhoneNumbers("13800138000,13900139000")
    .setTemplateCode("VT12345")
    .setReport(true);

RcsSmsTemplateSubmitResponse response = client.submitVideoTemplate(appId, appSecret, request);
```

---

### 4. pullReport - 拉取状态报告

**方法签名**：
```java
RcsSmsReportPullResponse pullReport(String appId, String appSecret, RcsSmsReportPullRequest request)
RcsSmsReportPullResponse pullReport(String appId, String appSecret, RcsSmsReportPullRequest request, String traceId)
```

---

### 5. pullReply - 拉取上行回复

**方法签名**：
```java
RcsSmsReplyPullResponse pullReply(String appId, String appSecret, RcsSmsReplyPullRequest request)
RcsSmsReplyPullResponse pullReply(String appId, String appSecret, RcsSmsReplyPullRequest request, String traceId)
```

---

### 6. addSign - 添加签名

**方法签名**：
```java
RcsSmsSignAddResponse addSign(String appId, String appSecret, RcsSmsSignAddRequest request)
RcsSmsSignAddResponse addSign(String appId, String appSecret, RcsSmsSignAddRequest request, String traceId)
```

---

## 号码业务

### 1. batchUcheck - 号码状态检测（批量）

**方法签名**：
```java
NumberStatusCheckResponse batchUcheck(String appId, String appSecret, NumberStatusCheckRequest request)
NumberStatusCheckResponse batchUcheck(String appId, String appSecret, NumberStatusCheckRequest request, String traceId)
```

**使用示例**：
```java
NumberStatusCheckRequest request = new NumberStatusCheckRequest()
    .setMobiles("13800138000,13900139000");  // 最多 100 个

NumberStatusCheckResponse response = client.batchUcheck(appId, appSecret, request);
for (NumberStatusItem item : response.getData().getList()) {
    System.out.println("手机号: " + item.getMobile());
    System.out.println("状态: " + item.getStatus());  // 1=正常 0=停机/空号
}
```

---

### 2. phoneAttributionV2 - 手机号码归属地查询 V2

**方法签名**：
```java
NumberPhoneAttributionV2Response phoneAttributionV2(String appId, String appSecret, NumberPhoneAttributionV2Request request)
NumberPhoneAttributionV2Response phoneAttributionV2(String appId, String appSecret, NumberPhoneAttributionV2Request request, String traceId)
```

**使用示例**：
```java
NumberPhoneAttributionV2Request request = new NumberPhoneAttributionV2Request()
    .setMobile("13800138000");

NumberPhoneAttributionV2Response response = client.phoneAttributionV2(appId, appSecret, request);
System.out.println("省份: " + response.getData().getProvince());
System.out.println("城市: " + response.getData().getCity());
System.out.println("运营商: " + response.getData().getCarrier());
```

---

## 号码运营商业务

### 1. moresale - 二次号查询

**方法签名**：
```java
NumberSecondHandResponse moresale(String appId, String appSecret, NumberSecondHandRequest request)
NumberSecondHandResponse moresale(String appId, String appSecret, NumberSecondHandRequest request, String traceId)
```

**使用示例**：
```java
NumberSecondHandRequest request = new NumberSecondHandRequest()
    .setMobile("13800138000");

NumberSecondHandResponse response = client.moresale(appId, appSecret, request);
System.out.println("是否二次号: " + response.getData().getIsSecondHand());
```

---

### 2. mobStatusBasicQuery - 号码实时基础版查询

**方法签名**：
```java
NumberMobStatusBasicResponse mobStatusBasicQuery(String appId, String appSecret, NumberMobStatusBasicRequest request)
NumberMobStatusBasicResponse mobStatusBasicQuery(String appId, String appSecret, NumberMobStatusBasicRequest request, String traceId)
```

---

### 3. onlineDurationQuery - 号码在网时长查询

**方法签名**：
```java
NumberOnlineDurationResponse onlineDurationQuery(String appId, String appSecret, NumberOnlineDurationRequest request)
NumberOnlineDurationResponse onlineDurationQuery(String appId, String appSecret, NumberOnlineDurationRequest request, String traceId)
```

**使用示例**：
```java
NumberOnlineDurationRequest request = new NumberOnlineDurationRequest()
    .setMobile("13800138000");

NumberOnlineDurationResponse response = client.onlineDurationQuery(appId, appSecret, request);
System.out.println("在网时长: " + response.getData().getDuration());
```

---

### 4. netStatus - 号码在网状态查询

**方法签名**：
```java
NumberNetStatusResponse netStatus(String appId, String appSecret, NumberNetStatusRequest request)
NumberNetStatusResponse netStatus(String appId, String appSecret, NumberNetStatusRequest request, String traceId)
```

---

## 携号转网业务

### 1. carriersSftp - 携号转网查询

**方法签名**：
```java
MnpCarriersSftpResponse carriersSftp(String appId, String appSecret, MnpCarriersSftpRequest request)
MnpCarriersSftpResponse carriersSftp(String appId, String appSecret, MnpCarriersSftpRequest request, String traceId)
```

**使用示例**：
```java
MnpCarriersSftpRequest request = new MnpCarriersSftpRequest()
    .setMobile("13800138000");

MnpCarriersSftpResponse response = client.carriersSftp(appId, appSecret, request);
System.out.println("当前运营商: " + response.getData().getCurrentCarrier());
```

---

## 风控业务

### 1. bforbid - 防骚扰黑名单查询

**方法签名**：
```java
RiskAntiHarassmentResponse bforbid(String appId, String appSecret, RiskAntiHarassmentRequest request)
RiskAntiHarassmentResponse bforbid(String appId, String appSecret, RiskAntiHarassmentRequest request, String traceId)
```

**使用示例**：
```java
RiskAntiHarassmentRequest request = new RiskAntiHarassmentRequest()
    .setMobile("13800138000");

RiskAntiHarassmentResponse response = client.bforbid(appId, appSecret, request);
System.out.println("是否黑名单: " + response.getData().getIsForbid());
```

---

### 2. woolCheck - 羊毛党检测

**方法签名**：
```java
RiskWoolCheckResponse woolCheck(String appId, String appSecret, RiskWoolCheckRequest request)
RiskWoolCheckResponse woolCheck(String appId, String appSecret, RiskWoolCheckRequest request, String traceId)
```

**使用示例**：
```java
RiskWoolCheckRequest request = new RiskWoolCheckRequest()
    .setMobile("13800138000")
    .setIp("192.168.1.1")
    .setDeviceId("device-id-123");

RiskWoolCheckResponse response = client.woolCheck(appId, appSecret, request);
System.out.println("风险等级: " + response.getData().getRiskLevel());
```

---

## 实名认证业务

### 身份证认证（5 个方法）

#### 1. idCardAuth - 身份证二要素核验

**方法签名**：
```java
IdCardAuthResponse idCardAuth(String appId, String appSecret, IdCardAuthRequest request)
IdCardAuthResponse idCardAuth(String appId, String appSecret, IdCardAuthRequest request, String traceId)
```

**使用示例**：
```java
IdCardAuthRequest request = new IdCardAuthRequest()
    .setIdCard("110101199001011234")
    .setName("张三");

IdCardAuthResponse response = client.idCardAuth(appId, appSecret, request);
System.out.println("核验结果: " + response.getData().getResult());  // 1=一致 2=不一致
```

---

#### 2. idCardAuthV2 - 身份证二要素核验 V2（签名版）

**方法签名**：
```java
IdCardAuthResponse idCardAuthV2(String appId, String appSecret, IdCardAuthV2Request request)
IdCardAuthResponse idCardAuthV2(String appId, String appSecret, IdCardAuthV2Request request, String traceId)
```

---

#### 3. foreignIdCardAuth - 涉外身份证校验

**方法签名**：
```java
ForeignIdCardAuthResponse foreignIdCardAuth(String appId, String appSecret, ForeignIdCardAuthRequest request)
ForeignIdCardAuthResponse foreignIdCardAuth(String appId, String appSecret, ForeignIdCardAuthRequest request, String traceId)
```

---

#### 4. idMatch - 身份证人像比对 V2.0

**方法签名**：
```java
IdMatchResponse idMatch(String appId, String appSecret, IdMatchRequest request)
IdMatchResponse idMatch(String appId, String appSecret, IdMatchRequest request, String traceId)
```

**使用示例**：
```java
IdMatchRequest request = new IdMatchRequest()
    .setIdCard("110101199001011234")
    .setName("张三")
    .setImage("base64编码的人脸照片");

IdMatchResponse response = client.idMatch(appId, appSecret, request);
System.out.println("相似度: " + response.getData().getSimilarity());
```

---

#### 5. foreignIdMatch - 涉外身份证核验（人像）

**方法签名**：
```java
ForeignIdMatchResponse foreignIdMatch(String appId, String appSecret, ForeignIdMatchRequest request)
ForeignIdMatchResponse foreignIdMatch(String appId, String appSecret, ForeignIdMatchRequest request, String traceId)
```

---

### 运营商认证（9 个方法）

#### 6. carriersTwoAuth - 运营商二要素核验

**方法签名**：
```java
CarriersTwoAuthResponse carriersTwoAuth(String appId, String appSecret, CarriersTwoAuthRequest request)
CarriersTwoAuthResponse carriersTwoAuth(String appId, String appSecret, CarriersTwoAuthRequest request, String traceId)
```

**使用示例**：
```java
CarriersTwoAuthRequest request = new CarriersTwoAuthRequest()
    .setMobile("13800138000")
    .setName("张三");

CarriersTwoAuthResponse response = client.carriersTwoAuth(appId, appSecret, request);
System.out.println("核验结果: " + response.getData().getResult());
```

---

#### 7. carriersTwoAuthIdNum - 运营商二要素（身份证版）核验

**方法签名**：
```java
CarriersTwoAuthIdNumResponse carriersTwoAuthIdNum(String appId, String appSecret, CarriersTwoAuthIdNumRequest request)
CarriersTwoAuthIdNumResponse carriersTwoAuthIdNum(String appId, String appSecret, CarriersTwoAuthIdNumRequest request, String traceId)
```

---

#### 8. carriersTwoAuthMd5 - 运营商二要素 MD5 核验

**方法签名**：
```java
CarriersTwoAuthResponse carriersTwoAuthMd5(String appId, String appSecret, CarriersTwoAuthMd5Request request) throws Exception
```

**注意**：此方法不支持 traceId 重载。

---

#### 9. carriersAuth - 运营商三要素核验

**方法签名**：
```java
CarriersAuthResponse carriersAuth(String appId, String appSecret, CarriersAuthRequest request)
CarriersAuthResponse carriersAuth(String appId, String appSecret, CarriersAuthRequest request, String traceId)
```

**使用示例**：
```java
CarriersAuthRequest request = new CarriersAuthRequest()
    .setMobile("13800138000")
    .setIdCard("110101199001011234")
    .setName("张三");

CarriersAuthResponse response = client.carriersAuth(appId, appSecret, request);
System.out.println("核验结果: " + response.getData().getResult());
```

---

#### 10. carriersAuthMd5 - 运营商三要素 MD5 核验

**方法签名**：
```java
CarriersAuthMd5Response carriersAuthMd5(String appId, String appSecret, CarriersAuthMd5Request request)
CarriersAuthMd5Response carriersAuthMd5(String appId, String appSecret, CarriersAuthMd5Request request, String traceId)
```

---

#### 11. carriersAuthDetail - 运营商三要素详细版核验

**方法签名**：
```java
CarriersAuthDetailResponse carriersAuthDetail(String appId, String appSecret, CarriersAuthRequest request)
CarriersAuthDetailResponse carriersAuthDetail(String appId, String appSecret, CarriersAuthRequest request, String traceId)
```

---

#### 12. carriersAuthDetailMd5 - 运营商三要素详细版 MD5 核验

**方法签名**：
```java
CarriersAuthDetailMd5Response carriersAuthDetailMd5(String appId, String appSecret, CarriersAuthDetailMd5Request request)
CarriersAuthDetailMd5Response carriersAuthDetailMd5(String appId, String appSecret, CarriersAuthDetailMd5Request request, String traceId)
```

---

#### 13. carriersAuthDetailSha256 - 运营商三要素详细版 SHA256 核验

**方法签名**：
```java
CarriersAuthDetailSha256Response carriersAuthDetailSha256(String appId, String appSecret, CarriersAuthDetailSha256Request request)
CarriersAuthDetailSha256Response carriersAuthDetailSha256(String appId, String appSecret, CarriersAuthDetailSha256Request request, String traceId)
```

---

#### 14. carriersAuthSha256 - 运营商三要素 SHA256 核验

**方法签名**：
```java
CarriersAuthSha256Response carriersAuthSha256(String appId, String appSecret, CarriersAuthSha256Request request)
CarriersAuthSha256Response carriersAuthSha256(String appId, String appSecret, CarriersAuthSha256Request request, String traceId)
```

---

### 银行卡认证（12 个方法）

#### 15. bankCardTwoAuth - 银行卡二要素核验

**方法签名**：
```java
BankCardTwoAuthResponse bankCardTwoAuth(String appId, String appSecret, BankCardTwoAuthRequest request)
BankCardTwoAuthResponse bankCardTwoAuth(String appId, String appSecret, BankCardTwoAuthRequest request, String traceId)
```

**使用示例**：
```java
BankCardTwoAuthRequest request = new BankCardTwoAuthRequest()
    .setBankCard("6228480402564890018")
    .setName("张三");

BankCardTwoAuthResponse response = client.bankCardTwoAuth(appId, appSecret, request);
System.out.println("核验结果: " + response.getData().getResult());
```

---

#### 16. bankCardThreeAuth - 银行卡三要素标准版核验

**方法签名**：
```java
BankCardThreeAuthResponse bankCardThreeAuth(String appId, String appSecret, BankCardThreeAuthRequest request)
BankCardThreeAuthResponse bankCardThreeAuth(String appId, String appSecret, BankCardThreeAuthRequest request, String traceId)
```

**使用示例**：
```java
BankCardThreeAuthRequest request = new BankCardThreeAuthRequest()
    .setBankCard("6228480402564890018")
    .setIdCard("110101199001011234")
    .setName("张三");

BankCardThreeAuthResponse response = client.bankCardThreeAuth(appId, appSecret, request);
```

---

#### 17. bankCardThreeAuthType - 银行卡三要素多证件版核验

**方法签名**：
```java
BankCardThreeAuthTypeResponse bankCardThreeAuthType(String appId, String appSecret, BankCardThreeAuthTypeRequest request)
BankCardThreeAuthTypeResponse bankCardThreeAuthType(String appId, String appSecret, BankCardThreeAuthTypeRequest request, String traceId)
```

---

#### 18. bankCardThreeAuthDetail - 银行卡三要素详细版核验

**方法签名**：
```java
BankCardThreeAuthDetailResponse bankCardThreeAuthDetail(String appId, String appSecret, BankCardThreeAuthRequest request)
BankCardThreeAuthDetailResponse bankCardThreeAuthDetail(String appId, String appSecret, BankCardThreeAuthRequest request, String traceId)
```

---

#### 19. bankCardThreeAuthPrecision - 银行卡三要素精准版核验

**方法签名**：
```java
BankCardThreeAuthPrecisionResponse bankCardThreeAuthPrecision(String appId, String appSecret, BankCardThreeAuthPrecisionRequest request)
BankCardThreeAuthPrecisionResponse bankCardThreeAuthPrecision(String appId, String appSecret, BankCardThreeAuthPrecisionRequest request, String traceId)
```

---

#### 20. bankCardFourAuth - 银行卡四要素标准版核验

**方法签名**：
```java
BankCardFourAuthResponse bankCardFourAuth(String appId, String appSecret, BankCardFourAuthRequest request)
BankCardFourAuthResponse bankCardFourAuth(String appId, String appSecret, BankCardFourAuthRequest request, String traceId)
```

**使用示例**：
```java
BankCardFourAuthRequest request = new BankCardFourAuthRequest()
    .setBankCard("6228480402564890018")
    .setIdCard("110101199001011234")
    .setName("张三")
    .setMobile("13800138000");

BankCardFourAuthResponse response = client.bankCardFourAuth(appId, appSecret, request);
System.out.println("核验结果: " + response.getData().getResult());
System.out.println("银行名称: " + response.getData().getBankName());
```

---

#### 21. bankCardFourSecret - 银行卡四要素简版加密核验

**方法签名**：
```java
BankCardFourSecretResponse bankCardFourSecret(String appId, String appSecret, BankCardFourSecretRequest request)
BankCardFourSecretResponse bankCardFourSecret(String appId, String appSecret, BankCardFourSecretRequest request, String traceId)
```

---

#### 22. bankCardFourAuthDetail - 银行卡四要素详细版核验

**方法签名**：
```java
BankCardFourAuthDetailResponse bankCardFourAuthDetail(String appId, String appSecret, BankCardFourAuthDetailRequest request)
BankCardFourAuthDetailResponse bankCardFourAuthDetail(String appId, String appSecret, BankCardFourAuthDetailRequest request, String traceId)
```

---

#### 23. bankCardFourAuthType - 银行卡四要素多证件版核验

**方法签名**：
```java
BankCardFourAuthTypeResponse bankCardFourAuthType(String appId, String appSecret, BankCardFourAuthTypeRequest request)
BankCardFourAuthTypeResponse bankCardFourAuthType(String appId, String appSecret, BankCardFourAuthTypeRequest request, String traceId)
```

---

#### 24. bankCardFourAuthPrecision - 银行卡四要素精准版核验

**方法签名**：
```java
BankCardFourAuthPrecisionResponse bankCardFourAuthPrecision(String appId, String appSecret, BankCardFourAuthPrecisionRequest request)
BankCardFourAuthPrecisionResponse bankCardFourAuthPrecision(String appId, String appSecret, BankCardFourAuthPrecisionRequest request, String traceId)
```

---

#### 25. bankCardFiveAuth - 银行卡五要素标准版核验

**方法签名**：
```java
BankCardFiveAuthResponse bankCardFiveAuth(String appId, String appSecret, BankCardFiveAuthRequest request)
BankCardFiveAuthResponse bankCardFiveAuth(String appId, String appSecret, BankCardFiveAuthRequest request, String traceId)
```

---

### 其他认证（2 个方法）

#### 26. ipGsdQuery - IP 归属地查询

**方法签名**：
```java
IpGsdQueryResponse ipGsdQuery(String appId, String appSecret, IpGsdQueryRequest request)
IpGsdQueryResponse ipGsdQuery(String appId, String appSecret, IpGsdQueryRequest request, String traceId)
```

---

#### 27. enterpriseFourAuth - 企业四要素核验

**方法签名**：
```java
EnterpriseFourAuthResponse enterpriseFourAuth(String appId, String appSecret, EnterpriseFourAuthRequest request)
EnterpriseFourAuthResponse enterpriseFourAuth(String appId, String appSecret, EnterpriseFourAuthRequest request, String traceId)
```

**使用示例**：
```java
EnterpriseFourAuthRequest request = new EnterpriseFourAuthRequest()
    .setEnterpriseName("腾讯科技（深圳）有限公司")
    .setCreditCode("91440300715474943M")
    .setLegalPerson("马化腾")
    .setLegalIdCard("110101199001011234");

EnterpriseFourAuthResponse response = client.enterpriseFourAuth(appId, appSecret, request);
```

---

## 企业信息与 OCR 业务

### IP 类服务（7 个方法）

#### 1. ipAddressOriginV4 - IP 地址归属地查询（IPv4）

**方法签名**：
```java
IpAddressOriginV4Response ipAddressOriginV4(String appId, String appSecret, IpAddressOriginV4Request request)
IpAddressOriginV4Response ipAddressOriginV4(String appId, String appSecret, IpAddressOriginV4Request request, String traceId)
```

**使用示例**：
```java
IpAddressOriginV4Request request = new IpAddressOriginV4Request()
    .setIp("8.8.8.8");

IpAddressOriginV4Response response = client.ipAddressOriginV4(appId, appSecret, request);
System.out.println("国家: " + response.getData().getCountry());
System.out.println("省份: " + response.getData().getProvince());
```

---

#### 2. ipAddressOriginV6 - IP 地址归属地查询（IPv6）

**方法签名**：
```java
IpAddressOriginV6Response ipAddressOriginV6(String appId, String appSecret, IpAddressOriginV6Request request)
IpAddressOriginV6Response ipAddressOriginV6(String appId, String appSecret, IpAddressOriginV6Request request, String traceId)
```

---

#### 3. ipRiskPortrait - IP 风险画像查询

**方法签名**：
```java
IpRiskPortraitResponse ipRiskPortrait(String appId, String appSecret, IpRiskPortraitRequest request)
IpRiskPortraitResponse ipRiskPortrait(String appId, String appSecret, IpRiskPortraitRequest request, String traceId)
```

---

#### 4. ipFacialRecognition - IP 人脸识别检测

**方法签名**：
```java
IpFacialRecognitionResponse ipFacialRecognition(String appId, String appSecret, IpFacialRecognitionRequest request)
IpFacialRecognitionResponse ipFacialRecognition(String appId, String appSecret, IpFacialRecognitionRequest request, String traceId)
```

---

#### 5. ipApplicationScenarios - IP 应用场景识别

**方法签名**：
```java
IpApplicationScenariosResponse ipApplicationScenarios(String appId, String appSecret, IpApplicationScenariosRequest request)
IpApplicationScenariosResponse ipApplicationScenarios(String appId, String appSecret, IpApplicationScenariosRequest request, String traceId)
```

---

#### 6. ipProxyIdentification - IP 代理识别

**方法签名**：
```java
IpProxyIdentificationResponse ipProxyIdentification(String appId, String appSecret, IpProxyIdentificationRequest request)
IpProxyIdentificationResponse ipProxyIdentification(String appId, String appSecret, IpProxyIdentificationRequest request, String traceId)
```

---

#### 7. ipHostInformation - IP 主机信息查询

**方法签名**：
```java
IpHostInformationResponse ipHostInformation(String appId, String appSecret, IpHostInformationRequest request)
IpHostInformationResponse ipHostInformation(String appId, String appSecret, IpHostInformationRequest request, String traceId)
```

---

### 企业信息类服务（10 个方法）

#### 8. enterpriseTwoElementsCheck - 企业两要素核验

**方法签名**：
```java
EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(String appId, String appSecret, EnterpriseTwoElementsCheckRequest request)
EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(String appId, String appSecret, EnterpriseTwoElementsCheckRequest request, String traceId)
```

**使用示例**：
```java
EnterpriseTwoElementsCheckRequest request = new EnterpriseTwoElementsCheckRequest()
    .setEnterpriseName("腾讯科技（深圳）有限公司")
    .setCreditCode("91440300715474943M");

EnterpriseTwoElementsCheckResponse response = client.enterpriseTwoElementsCheck(appId, appSecret, request);
System.out.println("核验结果: " + response.getData().getResult());
```

---

#### 9. enterpriseThreeAuth - 企业三要素核验

**方法签名**：
```java
EnterpriseThreeAuthResponse enterpriseThreeAuth(String appId, String appSecret, EnterpriseThreeAuthRequest request)
EnterpriseThreeAuthResponse enterpriseThreeAuth(String appId, String appSecret, EnterpriseThreeAuthRequest request, String traceId)
```

---

#### 10. enterpriseQuery - 企业信息查询

**方法签名**：
```java
EnterpriseQueryResponse enterpriseQuery(String appId, String appSecret, EnterpriseQueryRequest request)
EnterpriseQueryResponse enterpriseQuery(String appId, String appSecret, EnterpriseQueryRequest request, String traceId)
```

**使用示例**：
```java
EnterpriseQueryRequest request = new EnterpriseQueryRequest()
    .setKeyword("腾讯科技");

EnterpriseQueryResponse response = client.enterpriseQuery(appId, appSecret, request);
System.out.println("企业名称: " + response.getData().getEnterpriseName());
System.out.println("法人: " + response.getData().getLegalPerson());
```

---

#### 11. enterpriseSimple - 企业简单查询

**方法签名**：
```java
EnterpriseSimpleResponse enterpriseSimple(String appId, String appSecret, EnterpriseSimpleRequest request)
EnterpriseSimpleResponse enterpriseSimple(String appId, String appSecret, EnterpriseSimpleRequest request, String traceId)
```

---

#### 12. abnormalOperation - 企业经营异常查询

**方法签名**：
```java
AbnormalOperationResponse abnormalOperation(String appId, String appSecret, AbnormalOperationRequest request)
AbnormalOperationResponse abnormalOperation(String appId, String appSecret, AbnormalOperationRequest request, String traceId)
```

---

#### 13. administrativeSanctionQuery - 行政处罚查询

**方法签名**：
```java
AdministrativeSanctionQueryResponse administrativeSanctionQuery(String appId, String appSecret, AdministrativeSanctionQueryRequest request)
AdministrativeSanctionQueryResponse administrativeSanctionQuery(String appId, String appSecret, AdministrativeSanctionQueryRequest request, String traceId)
```

---

#### 14. justiceComplain - 司法投诉查询

**方法签名**：
```java
JusticeComplainResponse justiceComplain(String appId, String appSecret, JusticeComplainRequest request)
JusticeComplainResponse justiceComplain(String appId, String appSecret, JusticeComplainRequest request, String traceId)
```

---

#### 15. companyLevel - 企业等级查询

**方法签名**：
```java
CompanyLevelResponse companyLevel(String appId, String appSecret, CompanyLevelRequest request)
CompanyLevelResponse companyLevel(String appId, String appSecret, CompanyLevelRequest request, String traceId)
```

---

#### 16. enterpriseBidding - 企业招投标查询

**方法签名**：
```java
EnterpriseBiddingResponse enterpriseBidding(String appId, String appSecret, EnterpriseBiddingRequest request)
EnterpriseBiddingResponse enterpriseBidding(String appId, String appSecret, EnterpriseBiddingRequest request, String traceId)
```

---

#### 17. enterpriseOwnTax - 企业税务查询

**方法签名**：
```java
EnterpriseOwnTaxResponse enterpriseOwnTax(String appId, String appSecret, EnterpriseOwnTaxRequest request)
EnterpriseOwnTaxResponse enterpriseOwnTax(String appId, String appSecret, EnterpriseOwnTaxRequest request, String traceId)
```

---

### 人脸/活体检测（2 个方法）

#### 18. faceCheck - 人脸检测

**方法签名**：
```java
FaceCheckResponse faceCheck(String appId, String appSecret, FaceCheckRequest request)
FaceCheckResponse faceCheck(String appId, String appSecret, FaceCheckRequest request, String traceId)
```

**使用示例**：
```java
FaceCheckRequest request = new FaceCheckRequest()
    .setImage("base64编码的人脸照片");

FaceCheckResponse response = client.faceCheck(appId, appSecret, request);
System.out.println("是否人脸: " + response.getData().getIsFace());
```

---

#### 19. lifeCheck - 活体检测

**方法签名**：
```java
LifeCheckResponse lifeCheck(String appId, String appSecret, LifeCheckRequest request)
LifeCheckResponse lifeCheck(String appId, String appSecret, LifeCheckRequest request, String traceId)
```

---

### OCR 识别服务（10 个方法）

#### 20. idOcr - 身份证 OCR 识别

**方法签名**：
```java
IdOcrResponse idOcr(String appId, String appSecret, IdOcrRequest request)
IdOcrResponse idOcr(String appId, String appSecret, IdOcrRequest request, String traceId)
```

**使用示例**：
```java
IdOcrRequest request = new IdOcrRequest()
    .setImage("base64编码的身份证图片")
    .setSide("front");  // front=正面 back=反面

IdOcrResponse response = client.idOcr(appId, appSecret, request);
System.out.println("姓名: " + response.getData().getName());
System.out.println("身份证号: " + response.getData().getIdCard());
```

---

#### 21. idOcrV2 - 身份证 OCR 识别 V2

**方法签名**：
```java
IdOcrV2Response idOcrV2(String appId, String appSecret, IdOcrV2Request request)
IdOcrV2Response idOcrV2(String appId, String appSecret, IdOcrV2Request request, String traceId)
```

---

#### 22. vehicleLicense - 行驶证 OCR 识别

**方法签名**：
```java
VehicleLicenseResponse vehicleLicense(String appId, String appSecret, VehicleLicenseRequest request)
VehicleLicenseResponse vehicleLicense(String appId, String appSecret, VehicleLicenseRequest request, String traceId)
```

---

#### 23. vehicleLicenseOcrV2 - 行驶证 OCR 识别 V2

**方法签名**：
```java
VehicleLicenseOcrV2Response vehicleLicenseOcrV2(String appId, String appSecret, VehicleLicenseOcrV2Request request)
VehicleLicenseOcrV2Response vehicleLicenseOcrV2(String appId, String appSecret, VehicleLicenseOcrV2Request request, String traceId)
```

---

#### 24. bankcard - 银行卡 OCR 识别

**方法签名**：
```java
BankcardResponse bankcard(String appId, String appSecret, BankcardRequest request)
BankcardResponse bankcard(String appId, String appSecret, BankcardRequest request, String traceId)
```

---

#### 25. drivingLicense - 驾驶证 OCR 识别

**方法签名**：
```java
DrivingLicenseResponse drivingLicense(String appId, String appSecret, DrivingLicenseRequest request)
DrivingLicenseResponse drivingLicense(String appId, String appSecret, DrivingLicenseRequest request, String traceId)
```

---

#### 26. drivingLicenseOcrV2 - 驾驶证 OCR 识别 V2

**方法签名**：
```java
DrivingLicenseOcrV2Response drivingLicenseOcrV2(String appId, String appSecret, DrivingLicenseOcrV2Request request)
DrivingLicenseOcrV2Response drivingLicenseOcrV2(String appId, String appSecret, DrivingLicenseOcrV2Request request, String traceId)
```

---

#### 27. vehiclePlateOcr - 车牌 OCR 识别

**方法签名**：
```java
VehiclePlateOcrResponse vehiclePlateOcr(String appId, String appSecret, VehiclePlateOcrRequest request)
VehiclePlateOcrResponse vehiclePlateOcr(String appId, String appSecret, VehiclePlateOcrRequest request, String traceId)
```

---

#### 28. businessLicense - 营业执照 OCR 识别

**方法签名**：
```java
BusinessLicenseResponse businessLicense(String appId, String appSecret, BusinessLicenseRequest request)
BusinessLicenseResponse businessLicense(String appId, String appSecret, BusinessLicenseRequest request, String traceId)
```

**使用示例**：
```java
BusinessLicenseRequest request = new BusinessLicenseRequest()
    .setImage("base64编码的营业执照图片");

BusinessLicenseResponse response = client.businessLicense(appId, appSecret, request);
System.out.println("企业名称: " + response.getData().getEnterpriseName());
System.out.println("统一社会信用代码: " + response.getData().getCreditCode());
```

---

#### 29. invoiceOcr - 发票 OCR 识别

**方法签名**：
```java
InvoiceOcrResponse invoiceOcr(String appId, String appSecret, InvoiceOcrRequest request)
InvoiceOcrResponse invoiceOcr(String appId, String appSecret, InvoiceOcrRequest request, String traceId)
```

---

## 链路追踪支持

所有业务方法都支持链路追踪，通过传入 `traceId` 参数即可：

```java
String traceId = UUID.randomUUID().toString();

// 不带 traceId
SmsBatchSendResponse response1 = client.batchSend(appId, appSecret, request);

// 带 traceId
SmsBatchSendResponse response2 = client.batchSend(appId, appSecret, request, traceId);
```

`traceId` 会添加到 HTTP 请求头 `X-Trace-Id`，用于分布式链路追踪和问题排查。

---

## 其他方法

### businessClient - 获取 BusinessClient 实例

**方法签名**：
```java
BusinessClient businessClient()
```

**说明**：获取底层 BusinessClient 实例，用于高级定制场景。

---

### close - 释放资源

**方法签名**：
```java
void close()
```

**说明**：关闭底层 HTTP 连接池和线程池，释放资源。建议使用 try-with-resources 自动管理。

```java
try (CloudApiClient client = new CloudApiClient()) {
    // 使用 client
} // 自动调用 close()
```

---

## 总结

- **总方法数**：96 个业务方法 + 2 个工具方法
- **业务线数**：9 个业务线
- **链路追踪**：所有业务方法都支持 traceId 参数
- **命名规范**：驼峰命名，动词开头，见名知意

**文档更新时间**：2026/08/13
