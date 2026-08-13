# Cloud SDK - 253 云通讯 Java SDK

253 云通讯服务 Java SDK，提供短信、国际短信、视频短信、号码服务、实名认证、企业信息查询、风控等全业务线能力的统一封装。

## 目录

- [特性](#特性)
- [快速开始](#快速开始)
  - [Maven 依赖](#maven-依赖)
  - [基础用法](#基础用法)
  - [使用 try-with-resources](#使用-try-with-resources)
  - [自定义配置](#自定义配置)
- [Spring Boot 集成](#spring-boot-集成)
- [核心 API](#核心-api)
  - [一、短信业务](#一短信业务)
    - [1.1 短信批量发送](#11-短信批量发送)
    - [1.2 资质管理](#12-资质管理)
    - [1.3 签名管理](#13-签名管理)
    - [1.4 模板管理](#14-模板管理)
  - [二、国际短信业务](#二国际短信业务)
    - [2.1 国际短信发送](#21-国际短信发送)
    - [2.2 国际短信账户余额查询](#22-国际短信账户余额查询)
    - [2.3 国际短信账户消耗查询](#23-国际短信账户消耗查询)
    - [2.4 国际短信发送价格查询](#24-国际短信发送价格查询)
  - [三、视频短信（RCS）业务](#三视频短信rcs业务)
    - [3.1 新增视频模板](#31-新增视频模板)
    - [3.2 查询视频模板](#32-查询视频模板)
    - [3.3 发送视频短信](#33-发送视频短信)
    - [3.4 拉取状态报告](#34-拉取状态报告)
    - [3.5 拉取上行回复](#35-拉取上行回复)
    - [3.6 新增签名](#36-新增签名)
  - [四、号码业务](#四号码业务)
    - [4.1 号码状态检测（批量）](#41-号码状态检测批量)
    - [4.2 手机号码归属地查询（升级版 V2）](#42-手机号码归属地查询升级版-v2)
  - [五、号码运营商业务](#五号码运营商业务)
    - [5.1 二次号查询](#51-二次号查询)
    - [5.2 号码实时基础版查询](#52-号码实时基础版查询)
    - [5.3 号码在网时长查询](#53-号码在网时长查询)
    - [5.4 号码在网状态查询](#54-号码在网状态查询)
  - [六、风控业务](#六风控业务)
    - [6.1 防骚扰黑名单查询](#61-防骚扰黑名单查询)
    - [6.2 羊毛党检测](#62-羊毛党检测)
  - [七、携号转网业务](#七携号转网业务)
    - [7.1 携号转网 V1 查询](#71-携号转网-v1-查询)
  - [八、实名认证业务](#八实名认证业务)
    - [8.1 身份证二要素核验](#81-身份证二要素核验)
    - [8.2 身份证二要素核验 V2（签名版）](#82-身份证二要素核验-v2签名版)
    - [8.3 涉外身份证校验](#83-涉外身份证校验)
    - [8.4 身份证人像比对 V2.0](#84-身份证人像比对-v20)
    - [8.5 涉外身份证核验（人像）](#85-涉外身份证核验人像)
    - [8.6 运营商二要素核验](#86-运营商二要素核验)
    - [8.7 运营商二要素（身份证版）核验](#87-运营商二要素身份证版核验)
    - [8.8 运营商二要素 MD5 核验](#88-运营商二要素-md5-核验)
    - [8.9 运营商三要素核验](#89-运营商三要素核验)
    - [8.10 运营商三要素 MD5 核验](#810-运营商三要素-md5-核验)
    - [8.11 运营商三要素详细版核验](#811-运营商三要素详细版核验)
    - [8.12 运营商三要素详细版 MD5 核验](#812-运营商三要素详细版-md5-核验)
    - [8.13 运营商三要素详细版 SHA256 核验](#813-运营商三要素详细版-sha256-核验)
    - [8.14 运营商三要素 SHA256 核验](#814-运营商三要素-sha256-核验)
    - [8.15 银行卡二要素标准版核验](#815-银行卡二要素标准版核验)
    - [8.16 银行卡三要素标准版核验](#816-银行卡三要素标准版核验)
    - [8.17 银行卡三要素多证件版核验](#817-银行卡三要素多证件版核验)
    - [8.18 银行卡三要素详细版核验](#818-银行卡三要素详细版核验)
    - [8.19 银行卡三要素精准版非身份证核验](#819-银行卡三要素精准版非身份证核验)
    - [8.20 银行卡四要素标准版核验](#820-银行卡四要素标准版核验)
    - [8.21 银行卡四要素简版加密核验](#821-银行卡四要素简版加密核验)
    - [8.22 银行卡四要素详细版核验](#822-银行卡四要素详细版核验)
    - [8.23 银行卡四要素多证件版核验](#823-银行卡四要素多证件版核验)
    - [8.24 银行卡四要素精准版非身份证核验](#824-银行卡四要素精准版非身份证核验)
    - [8.25 银行卡五要素标准版核验](#825-银行卡五要素标准版核验)
    - [8.26 IP 归属地查询](#826-ip-归属地查询)
    - [8.27 企业四要素核验](#827-企业四要素核验)
  - [九、业务信息查询](#九业务信息查询)
    - [9.1 IP 归属地查询 V4](#91-ip-归属地查询-v4)
    - [9.2 IP 归属地查询 V6](#92-ip-归属地查询-v6)
    - [9.3 IP 风险画像](#93-ip-风险画像)
    - [9.4 IP 真人识别](#94-ip-真人识别)
    - [9.5 IP 应用场景识别](#95-ip-应用场景识别)
    - [9.6 IP 代理识别](#96-ip-代理识别)
    - [9.7 IP 宿主信息](#97-ip-宿主信息)
    - [9.8 企业二要素核验](#98-企业二要素核验)
    - [9.9 企业三要素核验](#99-企业三要素核验)
    - [9.10 企业工商模糊查询](#910-企业工商模糊查询)
    - [9.11 企业工商信息查询（简项）](#911-企业工商信息查询简项)
    - [9.12 经营异常查询](#912-经营异常查询)
    - [9.13 工商行政处罚查询](#913-工商行政处罚查询)
    - [9.14 企业司法涉诉查询](#914-企业司法涉诉查询)
    - [9.15 企业大中小微划型服务](#915-企业大中小微划型服务)
    - [9.16 企业招投标查询（翻页）](#916-企业招投标查询翻页)
    - [9.17 企业欠税公告查询](#917-企业欠税公告查询)
  - [十、OCR 识别业务](#十ocr-识别业务)
    - [10.1 静态活体检测](#101-静态活体检测)
    - [10.2 动态活体检测](#102-动态活体检测)
    - [10.3 身份证 OCR 识别](#103-身份证-ocr-识别)
    - [10.4 身份证 OCR V2 识别（自动识别正反面）](#104-身份证-ocr-v2-识别自动识别正反面)
    - [10.5 行驶证 OCR 识别](#105-行驶证-ocr-识别)
  - [十一、获取业务线客户端](#十一获取业务线客户端)
    - [11.1 获取业务线客户端](#111-获取业务线客户端)
- [异常处理](#异常处理)
  - [CloudSdkException 字段](#clouddsdkexception-字段)
  - [异常处理示例](#异常处理示例)
  - [常见错误码](#常见错误码)
- [高级特性](#高级特性)
  - [链路追踪](#链路追踪)
  - [重试机制](#重试机制)
  - [资源管理](#资源管理)
- [完整示例](#完整示例)
  - [示例 1：短信批量发送](#示例-1短信批量发送)
  - [示例 2：号码状态检测](#示例-2号码状态检测)
  - [示例 3：身份证二要素核验](#示例-3身份证二要素核验)
  - [示例 4：银行卡四要素核验](#示例-4银行卡四要素核验)
  - [示例 5：企业工商信息查询](#示例-5企业工商信息查询)
  - [示例 6：Spring Boot 集成](#示例-6spring-boot-集成)
- [模块说明](#模块说明)
  - [cloud-sdk-core](#cloud-sdk-core)
  - [cloud-sdk-api](#cloud-sdk-api)
  - [cloud-sdk-spring](#cloud-sdk-spring)
- [业务线能力清单](#业务线能力清单)
  - [短信业务（SMS）](#短信业务sms)
  - [国际短信业务（IntSms）](#国际短信业务intsms)
  - [视频短信业务（RcsSms）](#视频短信业务rcssms)
  - [号码业务（Number）](#号码业务number)
  - [号码运营商业务（NumberCarrier）](#号码运营商业务numbercarrier)
  - [风控业务（Risk）](#风控业务risk)
  - [携号转网业务（Mnp）](#携号转网业务mnp)
  - [实名认证业务（RealName）](#实名认证业务realname)
  - [业务信息查询（Business）](#业务信息查询business)
- [更新日志](#更新日志)
- [常见问题](#常见问题)
- [贡献指南](#贡献指南)
- [许可证](#许可证)

## 特性

- **统一入口**：`CloudApiClient` 聚合所有业务 API，一次初始化，全业务可用
- **独立连接池**：短信业务独立连接池，避免批量发送时与其他业务竞争
- **链路追踪**：所有方法支持可选 `traceId` 参数，便于分布式链路追踪
- **自动重试**：内置指数退避重试机制（默认最大 3 次）
- **Spring 集成**：提供 Spring Boot 自动装配支持，开箱即用
- **资源管理**：实现 `AutoCloseable`，支持 try-with-resources 自动释放连接

## 快速开始

### Maven 依赖

```xml
<dependency>
    <groupId>com.chuanglan</groupId>
    <artifactId>cloud-sdk</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### 基础用法

```java
// 1. 创建客户端
CloudApiClient client = new CloudApiClient();

// 2. 调用 API（以短信批量发送为例）
SmsBatchSendRequest request = new SmsBatchSendRequest()
    .setPhone("13800138000,13900139000")
    .setMsg("【创蓝云】您的验证码是1234")
    .setReport(true);

SmsBatchSendResponse response = client.batchSend(appId, appSecret, request);
System.out.println("发送结果: " + response.getCode());

// 3. 释放资源
client.close();
```

### 使用 try-with-resources

```java
try (CloudApiClient client = new CloudApiClient()) {
    SmsBatchSendResponse response = client.batchSend(appId, appSecret, request);
    System.out.println("发送结果: " + response.getCode());
}
```

### 自定义配置

```java
CloudApiConfig config = new CloudApiConfig()
    .setSmsEndpoint("https://smssh.253.com")
    .setConnectTimeout(15000)  // 连接超时 15 秒
    .setReadTimeout(30000);    // 读取超时 30 秒

CloudApiClient client = new CloudApiClient(config);
```

## Spring Boot 集成

### 1. 添加依赖

```xml
<dependency>
    <groupId>com.chuanglan</groupId>
    <artifactId>cloud-sdk</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### 2. 注入使用

```java
@Service
public class SmsService {
    
    @Autowired
    private CloudApiClient cloudApiClient;
    
    public void sendSms(String phone, String content) {
        SmsBatchSendRequest request = new SmsBatchSendRequest()
            .setPhone(phone)
            .setMsg(content);
        
        SmsBatchSendResponse response = cloudApiClient.batchSend(appId, appSecret, request);
        // 处理响应...
    }
}
```

## 核心 API

### 一、短信业务

#### 1.1 短信批量发送

发送短信到指定手机号码（支持批量）。

**方法签名：**
```java
SmsBatchSendResponse batchSend(String appId, String appSecret, SmsBatchSendRequest request)
SmsBatchSendResponse batchSend(String appId, String appSecret, SmsBatchSendRequest request, String traceId)
```

**请求参数：**
- `appId` (String, 必填) - 应用 ID
- `appSecret` (String, 必填) - 应用密钥
- `request` (SmsBatchSendRequest, 必填) - 请求对象
  - `phone` (String, 必填) - 手机号码，多个号码用英文逗号分隔，如 "13800138000,13900139000"
  - `msg` (String, 必填) - 短信内容，需包含签名，如 "【创蓝云】您的验证码是1234"
  - `report` (Boolean, 可选) - 是否需要状态报告，默认 false
  - `extend` (String, 可选) - 扩展码
  - `uid` (String, 可选) - 用户自定义 ID，状态报告时会原样返回
- `traceId` (String, 可选) - 链路追踪 ID

**返回值：** `SmsBatchSendResponse`
- `code` (String) - 响应码，"0" 表示成功
- `msgId` (String) - 消息 ID
- `time` (String) - 响应时间
- `errorMsg` (String) - 错误描述

**示例：**
```java
SmsBatchSendRequest request = new SmsBatchSendRequest()
    .setPhone("13800138000,13900139000")
    .setMsg("【创蓝云】您的验证码是1234，5分钟内有效")
    .setReport(true)
    .setUid("order-12345");

SmsBatchSendResponse response = client.batchSend(appId, appSecret, request);
if ("0".equals(response.getCode())) {
    System.out.println("发送成功，消息ID: " + response.getMsgId());
} else {
    System.out.println("发送失败: " + response.getErrorMsg());
}
```

#### 1.2 资质管理

##### 新增资质
```java
SmsQualificationAddResponse addQualification(String appId, String appSecret, SmsQualificationAddRequest request)
SmsQualificationAddResponse addQualification(String appId, String appSecret, SmsQualificationAddRequest request, String traceId)
```

**请求参数：** `SmsQualificationAddRequest`
- `type` (Integer, 必填) - 资质类型：1-企业，2-个体工商户，3-其他
- `name` (String, 必填) - 企业名称
- `businessLicenseUrl` (String, 必填) - 营业执照 URL
- `authorizationUrl` (String, 可选) - 授权委托书 URL

##### 查询资质列表
```java
SmsQualificationListResponse listQualification(String appId, String appSecret, SmsQualificationListRequest request)
SmsQualificationListResponse listQualification(String appId, String appSecret, SmsQualificationListRequest request, String traceId)
```

**请求参数：** `SmsQualificationListRequest`
- `pageNum` (Integer, 可选) - 页码，默认 1
- `pageSize` (Integer, 可选) - 每页条数，默认 10

##### 更新资质
```java
SmsQualificationUpdateResponse updateQualification(String appId, String appSecret, SmsQualificationUpdateRequest request)
```

##### 删除资质
```java
SmsQualificationDeleteResponse deleteQualification(String appId, String appSecret, SmsQualificationDeleteRequest request)
```

**请求参数：** `SmsQualificationDeleteRequest`
- `qualificationId` (Long, 必填) - 资质 ID

#### 1.3 签名管理

##### 新增签名
```java
SmsSignatureAddResponse addSignature(String appId, String appSecret, SmsSignatureAddRequest request)
SmsSignatureAddResponse addSignature(String appId, String appSecret, SmsSignatureAddRequest request, String traceId)
```

**请求参数：** `SmsSignatureAddRequest`
- `signature` (String, 必填) - 签名内容，不含【】
- `qualificationId` (Long, 必填) - 关联的资质 ID
- `signatureType` (Integer, 必填) - 签名类型：1-自用，2-他用
- `remark` (String, 可选) - 备注说明

##### 查询签名详情
```java
SmsSignatureGetResponse getSignature(String appId, String appSecret, SmsSignatureGetRequest request)
```

**请求参数：** `SmsSignatureGetRequest`
- `signatureId` (Long, 必填) - 签名 ID

##### 查询签名列表
```java
SmsSignatureListResponse listSignature(String appId, String appSecret, SmsSignatureListRequest request)
```

**请求参数：** `SmsSignatureListRequest`
- `pageNum` (Integer, 可选) - 页码
- `pageSize` (Integer, 可选) - 每页条数

##### 查询签名运营商驳回原因
```java
SmsSignatureOperatorRejectReasonResponse getSignatureOperatorRejectReason(String appId, String appSecret, SmsSignatureOperatorRejectReasonRequest request)
```

##### 更新签名实名信息
```java
SmsSignatureRealNameUpdateResponse updateSignatureRealName(String appId, String appSecret, SmsSignatureRealNameUpdateRequest request)
```

##### 删除签名
```java
SmsSignatureDeleteResponse deleteSignature(String appId, String appSecret, SmsSignatureDeleteRequest request)
```

#### 1.4 模板管理

##### 新增模板
```java
SmsTemplateAddResponse addTemplate(String appId, String appSecret, SmsTemplateAddRequest request)
SmsTemplateAddResponse addTemplate(String appId, String appSecret, SmsTemplateAddRequest request, String traceId)
```

**请求参数：** `SmsTemplateAddRequest`
- `signatureId` (Long, 必填) - 关联的签名 ID
- `templateType` (Integer, 必填) - 模板类型：1-验证码，2-通知，3-营销
- `templateContent` (String, 必填) - 模板内容，变量用 {1}、{2} 表示
- `remark` (String, 可选) - 备注说明

##### 查询模板类型枚举
```java
SmsTemplateTypeEnumResponse queryTemplateTypeEnum(String appId, String appSecret, SmsTemplateTypeEnumRequest request)
```

##### 查询模板列表
```java
SmsTemplateListResponse listTemplate(String appId, String appSecret, SmsTemplateListRequest request)
```

**请求参数：** `SmsTemplateListRequest`
- `pageNum` (Integer, 可选) - 页码
- `pageSize` (Integer, 可选) - 每页条数
- `templateType` (Integer, 可选) - 模板类型筛选

##### 查询模板详情
```java
SmsTemplateGetResponse getTemplate(String appId, String appSecret, SmsTemplateGetRequest request)
```

**请求参数：** `SmsTemplateGetRequest`
- `templateId` (Long, 必填) - 模板 ID

##### 查询模板运营商驳回原因
```java
SmsTemplateOperatorRejectReasonResponse getTemplateOperatorRejectReason(String appId, String appSecret, SmsTemplateOperatorRejectReasonRequest request)
```

##### 更新模板
```java
SmsTemplateUpdateResponse updateTemplate(String appId, String appSecret, SmsTemplateUpdateRequest request)
```

##### 删除模板
```java
SmsTemplateDeleteResponse deleteTemplate(String appId, String appSecret, SmsTemplateDeleteRequest request)
```

**请求参数：** `SmsTemplateDeleteRequest`
- `templateId` (Long, 必填) - 模板 ID

### 二、国际短信业务

#### 2.1 国际短信发送

发送国际短信，支持多节点（上海、新加坡、印尼）。

**方法签名：**
```java
IntSmsSubmitResponse submitIntSms(String appId, String appSecret, IntSmsSubmitRequest request)
IntSmsSubmitResponse submitIntSms(String appId, String appSecret, IntSmsSubmitRequest request, String traceId)
IntSmsSubmitResponse submitIntSms(String appId, String appSecret, String endpoint, IntSmsSubmitRequest request)
IntSmsSubmitResponse submitIntSms(String appId, String appSecret, String endpoint, IntSmsSubmitRequest request, String traceId)
```

**请求参数：** `IntSmsSubmitRequest`
- `phone` (String, 必填) - 国际手机号，需包含国家码，如 "+8613800138000"
- `msg` (String, 必填) - 短信内容
- `senderId` (String, 可选) - 发送者 ID（部分国家支持）
- `extend` (String, 可选) - 扩展码
- `uid` (String, 可选) - 用户自定义 ID

**节点参数 `endpoint`（可选）：**
- `IntSmsConfig.SHANGHAI_ENDPOINT` - 上海节点（默认）：`https://intapi.tig253.com`
- `IntSmsConfig.SINGAPORE_ENDPOINT` - 新加坡节点：`https://sg-intapi.tig253.com`
- `IntSmsConfig.INDONESIA_ENDPOINT` - 印尼节点：`https://id-api.tig253.com`

**示例：**
```java
// 使用默认上海节点
IntSmsSubmitRequest request = new IntSmsSubmitRequest()
    .setPhone("+8613800138000")
    .setMsg("Your verification code is 1234");

IntSmsSubmitResponse response = client.submitIntSms(appId, appSecret, request);
```

```java
// 指定新加坡节点
IntSmsSubmitResponse response = client.submitIntSms(
    appId, 
    appSecret, 
    IntSmsConfig.SINGAPORE_ENDPOINT, 
    request
);
```

#### 2.2 国际短信账户余额查询

```java
IntSmsBalanceResponse queryIntSmsBalance(String appId, String appSecret, IntSmsBalanceRequest request)
IntSmsBalanceResponse queryIntSmsBalance(String appId, String appSecret, IntSmsBalanceRequest request, String traceId)
IntSmsBalanceResponse queryIntSmsBalance(String appId, String appSecret, String endpoint, IntSmsBalanceRequest request, String traceId)
```

**节点参数说明：**

国际短信账户余额查询支持多节点部署，可通过 `endpoint` 参数指定查询节点。可用节点常量定义在 `IntSmsConfig` 中：

- `IntSmsConfig.SHANGHAI_ENDPOINT = "https://intapi.tig253.com"` - 上海节点（默认）
- `IntSmsConfig.SINGAPORE_ENDPOINT = "https://sg-intapi.tig253.com"` - 新加坡节点
- `IntSmsConfig.INDONESIA_ENDPOINT = "https://id-api.tig253.com"` - 印度尼西亚节点

**使用示例：**

```java
// 使用默认上海节点
IntSmsBalanceRequest request = new IntSmsBalanceRequest();
IntSmsBalanceResponse response = client.queryIntSmsBalance(appId, appSecret, request);

// 指定新加坡节点
IntSmsBalanceResponse response = client.queryIntSmsBalance(
    appId, 
    appSecret, 
    IntSmsConfig.SINGAPORE_ENDPOINT, 
    request, 
    traceId
);
```

#### 2.3 国际短信账户消耗查询

```java
IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, IntSmsCostRequest request)
IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, IntSmsCostRequest request, String traceId)
IntSmsCostResponse queryIntSmsCost(String appId, String appSecret, String endpoint, IntSmsCostRequest request, String traceId)
```

**请求参数：** `IntSmsCostRequest`
- `startTime` (String, 必填) - 开始时间，格式：yyyy-MM-dd HH:mm:ss
- `endTime` (String, 必填) - 结束时间

**节点参数说明：**

国际短信账户消耗查询支持多节点部署，可通过 `endpoint` 参数指定查询节点。可用节点常量定义在 `IntSmsConfig` 中：

- `IntSmsConfig.SHANGHAI_ENDPOINT = "https://intapi.tig253.com"` - 上海节点（默认）
- `IntSmsConfig.SINGAPORE_ENDPOINT = "https://sg-intapi.tig253.com"` - 新加坡节点
- `IntSmsConfig.INDONESIA_ENDPOINT = "https://id-api.tig253.com"` - 印度尼西亚节点

**使用示例：**

```java
// 使用默认上海节点
IntSmsCostRequest request = new IntSmsCostRequest()
    .setStartTime("2024-01-01 00:00:00")
    .setEndTime("2024-01-31 23:59:59");
IntSmsCostResponse response = client.queryIntSmsCost(appId, appSecret, request);

// 指定印度尼西亚节点
IntSmsCostResponse response = client.queryIntSmsCost(
    appId, 
    appSecret, 
    IntSmsConfig.INDONESIA_ENDPOINT, 
    request, 
    traceId
);
```

#### 2.4 国际短信发送价格查询

```java
IntSmsPriceResponse queryIntSmsPrice(String appId, String appSecret, IntSmsPriceRequest request)
IntSmsPriceResponse queryIntSmsPrice(String appId, String appSecret, IntSmsPriceRequest request, String traceId)
```

**请求参数：** `IntSmsPriceRequest`
- `countryCode` (String, 必填) - 国家码，如 "86"（中国）、"1"（美国）

### 三、视频短信（RCS）业务

#### 3.1 新增视频模板

```java
RcsSmsTemplateAddResponse addVideoTemplate(String appId, String appSecret, RcsSmsTemplateAddRequest request)
RcsSmsTemplateAddResponse addVideoTemplate(String appId, String appSecret, RcsSmsTemplateAddRequest request, String traceId)
```

**请求参数：** `RcsSmsTemplateAddRequest`
- `templateName` (String, 必填) - 模板名称
- `templateContent` (String, 必填) - 模板内容
- `videoUrl` (String, 必填) - 视频文件 URL
- `imageUrl` (String, 可选) - 封面图片 URL

#### 3.2 查询视频模板

```java
RcsSmsTemplateFindResponse findVideoTemplate(String appId, String appSecret, RcsSmsTemplateFindRequest request)
RcsSmsTemplateFindResponse findVideoTemplate(String appId, String appSecret, RcsSmsTemplateFindRequest request, String traceId)
```

**请求参数：** `RcsSmsTemplateFindRequest`
- `templateId` (String, 必填) - 模板 ID

#### 3.3 发送视频短信

```java
RcsSmsTemplateSubmitResponse submitVideoTemplate(String appId, String appSecret, RcsSmsTemplateSubmitRequest request)
RcsSmsTemplateSubmitResponse submitVideoTemplate(String appId, String appSecret, RcsSmsTemplateSubmitRequest request, String traceId)
```

**请求参数：** `RcsSmsTemplateSubmitRequest`
- `submitNo` (String, 必填) - 提交号，客户端提供，作为客户端的提交标识，长度不超过 32 位
- `templateId` (String, 必填) - 模板 ID
- `phoneNumbers` (List<String>, 静态模板必填) - 手机号列表，用于静态模板发送
- `phoneNumberJson` (List<RcsSmsDynamicVar>, 动态模板必填) - 动态模板变量列表，用于动态模板发送

**注意：** `phoneNumbers` 和 `phoneNumberJson` 二者互斥，根据模板类型选择其一：
- 静态模板发送：使用 `phoneNumbers` 传入手机号列表
- 动态模板发送：使用 `phoneNumberJson` 传入带变量的手机号列表

**动态模板变量对象：** `RcsSmsDynamicVar`
- `phone` (String, 必填) - 手机号
- `v1` (String, 可选) - 变量值，对应模板中的 ${v1}
- `v2` (String, 可选) - 变量值，对应模板中的 ${v2}
- `v3` (String, 可选) - 变量值，对应模板中的 ${v3}
- `v4` (String, 可选) - 变量值，对应模板中的 ${v4}
- `v5` (String, 可选) - 变量值，对应模板中的 ${v5}

**使用示例：**

```java
// 静态模板发送
RcsSmsTemplateSubmitRequest staticRequest = new RcsSmsTemplateSubmitRequest()
    .setSubmitNo("SUBMIT20240101001")
    .setTemplateId("TPL_VIDEO_001")
    .setPhoneNumbers(Arrays.asList("13800138000", "13900139000"));

RcsSmsTemplateSubmitResponse response = client.submitVideoTemplate(appId, appSecret, staticRequest);

// 动态模板发送（带变量替换）
List<RcsSmsDynamicVar> dynamicVars = new ArrayList<>();
dynamicVars.add(new RcsSmsDynamicVar()
    .setPhone("13800138000")
    .setV1("张三")
    .setV2("1234"));
dynamicVars.add(new RcsSmsDynamicVar()
    .setPhone("13900139000")
    .setV1("李四")
    .setV2("5678"));

RcsSmsTemplateSubmitRequest dynamicRequest = new RcsSmsTemplateSubmitRequest()
    .setSubmitNo("SUBMIT20240101002")
    .setTemplateId("TPL_VIDEO_002")
    .setPhoneNumberJson(dynamicVars);

RcsSmsTemplateSubmitResponse response = client.submitVideoTemplate(appId, appSecret, dynamicRequest);
```

#### 3.4 拉取状态报告

```java
RcsSmsReportPullResponse pullReport(String appId, String appSecret, RcsSmsReportPullRequest request)
RcsSmsReportPullResponse pullReport(String appId, String appSecret, RcsSmsReportPullRequest request, String traceId)
```

#### 3.5 拉取上行回复

```java
RcsSmsReplyPullResponse pullReply(String appId, String appSecret, RcsSmsReplyPullRequest request)
RcsSmsReplyPullResponse pullReply(String appId, String appSecret, RcsSmsReplyPullRequest request, String traceId)
```

#### 3.6 新增签名

```java
RcsSmsSignAddResponse addSign(String appId, String appSecret, RcsSmsSignAddRequest request)
RcsSmsSignAddResponse addSign(String appId, String appSecret, RcsSmsSignAddRequest request, String traceId)
```

### 四、号码业务

#### 4.1 号码状态检测（批量）

检测手机号码的实时状态（空号、停机、在网等）。

**方法签名：**
```java
NumberStatusCheckResponse batchUcheck(String appId, String appSecret, NumberStatusCheckRequest request)
NumberStatusCheckResponse batchUcheck(String appId, String appSecret, NumberStatusCheckRequest request, String traceId)
```

**请求参数：** `NumberStatusCheckRequest`
- `mobiles` (String, 必填) - 手机号码列表，多个号码用英文逗号分隔，单次最多 5000 个
- `isReturnLocation` (Boolean, 可选) - 是否返回归属地信息，默认 false

**返回值：** `NumberStatusCheckResponse`
- `code` (String) - 响应码
- `data` (List<NumberStatusCheckData>) - 检测结果列表
  - `mobile` (String) - 手机号码
  - `status` (String) - 号码状态：0-实号，1-空号，2-停机，3-库无，4-沉默号
  - `province` (String) - 省份（当 isReturnLocation=true 时返回）
  - `city` (String) - 城市（当 isReturnLocation=true 时返回）
  - `carrier` (String) - 运营商：CMCC-移动，CUCC-联通，CTCC-电信

**示例：**
```java
NumberStatusCheckRequest request = new NumberStatusCheckRequest()
    .setMobiles("13800138000,13900139000")
    .setIsReturnLocation(true);

NumberStatusCheckResponse response = client.batchUcheck(appId, appSecret, request);
for (NumberStatusCheckData data : response.getData()) {
    System.out.println(data.getMobile() + " - " + data.getStatus());
}
```

#### 4.2 手机号码归属地查询（升级版 V2）

```java
NumberPhoneAttributionV2Response phoneAttributionV2(String appId, String appSecret, NumberPhoneAttributionV2Request request)
NumberPhoneAttributionV2Response phoneAttributionV2(String appId, String appSecret, NumberPhoneAttributionV2Request request, String traceId)
```

**请求参数：** `NumberPhoneAttributionV2Request`
- `mobile` (String, 必填) - 手机号码

**返回值：** `NumberPhoneAttributionV2Response`
- `province` (String) - 省份
- `city` (String) - 城市
- `carrier` (String) - 运营商
- `areaCode` (String) - 区号
- `postCode` (String) - 邮编

### 五、号码运营商业务

#### 5.1 二次号查询

查询号码是否为二次放号（即曾被他人使用后注销，又重新启用的号码）。

```java
NumberSecondHandResponse moresale(String appId, String appSecret, NumberSecondHandRequest request)
NumberSecondHandResponse moresale(String appId, String appSecret, NumberSecondHandRequest request, String traceId)
```

**请求参数：** `NumberSecondHandRequest`
- `mobile` (String, 必填) - 手机号码

**返回值：** `NumberSecondHandResponse`
- `result` (Integer) - 查询结果：0-非二次号，1-二次号，2-查询失败

#### 5.2 号码实时基础版查询

```java
NumberMobStatusBasicResponse mobStatusBasicQuery(String appId, String appSecret, NumberMobStatusBasicRequest request)
NumberMobStatusBasicResponse mobStatusBasicQuery(String appId, String appSecret, NumberMobStatusBasicRequest request, String traceId)
```

**请求参数：** `NumberMobStatusBasicRequest`
- `mobile` (String, 必填) - 手机号码

**返回值：** `NumberMobStatusBasicResponse`
- `status` (String) - 号码状态
- `statusDesc` (String) - 状态描述

#### 5.3 号码在网时长查询

```java
NumberOnlineDurationResponse onlineDurationQuery(String appId, String appSecret, NumberOnlineDurationRequest request)
NumberOnlineDurationResponse onlineDurationQuery(String appId, String appSecret, NumberOnlineDurationRequest request, String traceId)
```

**请求参数：** `NumberOnlineDurationRequest`
- `mobile` (String, 必填) - 手机号码

**返回值：** `NumberOnlineDurationResponse`
- `duration` (String) - 在网时长区间：1-0-3个月，2-3-6个月，3-6-12个月，4-12个月以上

#### 5.4 号码在网状态查询

```java
NumberNetStatusResponse netStatus(String appId, String appSecret, NumberNetStatusRequest request)
NumberNetStatusResponse netStatus(String appId, String appSecret, NumberNetStatusRequest request, String traceId)
```

**请求参数：** `NumberNetStatusRequest`
- `mobile` (String, 必填) - 手机号码

**返回值：** `NumberNetStatusResponse`
- `netStatus` (Integer) - 在网状态：0-不在网，1-在网

### 六、风控业务

#### 6.1 防骚扰黑名单查询

查询号码是否在防骚扰黑名单中。

```java
RiskAntiHarassmentResponse bforbid(String appId, String appSecret, RiskAntiHarassmentRequest request)
RiskAntiHarassmentResponse bforbid(String appId, String appSecret, RiskAntiHarassmentRequest request, String traceId)
```

**请求参数：** `RiskAntiHarassmentRequest`
- `mobile` (String, 必填) - 手机号码

**返回值：** `RiskAntiHarassmentResponse`
- `result` (Integer) - 查询结果：0-不在黑名单，1-在黑名单

#### 6.2 羊毛党检测

检测号码是否存在羊毛党风险。

```java
RiskWoolCheckResponse woolCheck(String appId, String appSecret, RiskWoolCheckRequest request)
RiskWoolCheckResponse woolCheck(String appId, String appSecret, RiskWoolCheckRequest request, String traceId)
```

**请求参数：** `RiskWoolCheckRequest`
- `mobile` (String, 必填) - 手机号码
- `ip` (String, 可选) - IP 地址（用于综合判断）
- `deviceId` (String, 可选) - 设备 ID

**返回值：** `RiskWoolCheckResponse`
- `riskLevel` (Integer) - 风险等级：0-无风险，1-低风险，2-中风险，3-高风险
- `riskDesc` (String) - 风险描述
- `riskTags` (List<String>) - 风险标签

### 七、携号转网业务

#### 7.1 携号转网 V1 查询

查询号码是否发生过携号转网及当前归属运营商。

```java
MnpCarriersSftpResponse carriersSftp(String appId, String appSecret, MnpCarriersSftpRequest request)
MnpCarriersSftpResponse carriersSftp(String appId, String appSecret, MnpCarriersSftpRequest request, String traceId)
```

**请求参数：** `MnpCarriersSftpRequest`
- `mobile` (String, 必填) - 手机号码

**返回值：** `MnpCarriersSftpResponse`
- `mobile` (String) - 手机号码
- `carrier` (String) - 当前运营商：CMCC-移动，CUCC-联通，CTCC-电信
- `originalCarrier` (String) - 初始运营商
- `isMnp` (Boolean) - 是否发生过携号转网

### 八、实名认证业务

#### 8.1 身份证二要素核验

验证姓名和身份证号是否匹配。

```java
IdCardAuthResponse idCardAuth(String appId, String appSecret, IdCardAuthRequest request)
IdCardAuthResponse idCardAuth(String appId, String appSecret, IdCardAuthRequest request, String traceId)
```

**请求参数：** `IdCardAuthRequest`
- `name` (String, 必填) - 姓名
- `idCard` (String, 必填) - 身份证号码

**返回值：** `IdCardAuthResponse`
- `result` (Integer) - 验证结果：1-一致，2-不一致，3-无此号，4-库无
- `desc` (String) - 结果描述
- `sex` (String) - 性别（result=1 时返回）
- `birthday` (String) - 出生日期（result=1 时返回）
- `address` (String) - 地址（result=1 时返回）

**示例：**
```java
IdCardAuthRequest request = new IdCardAuthRequest()
    .setName("张三")
    .setIdCard("110101199001011234");

IdCardAuthResponse response = client.idCardAuth(appId, appSecret, request);
if (response.getResult() == 1) {
    System.out.println("验证通过，性别：" + response.getSex());
} else {
    System.out.println("验证失败：" + response.getDesc());
}
```

#### 8.2 身份证二要素核验 V2（签名版）

```java
IdCardAuthResponse idCardAuthV2(String appId, String appSecret, IdCardAuthV2Request request)
IdCardAuthResponse idCardAuthV2(String appId, String appSecret, IdCardAuthV2Request request, String traceId)
```

#### 8.3 涉外身份证校验

验证港澳台及外籍证件。

```java
ForeignIdCardAuthResponse foreignIdCardAuth(String appId, String appSecret, ForeignIdCardAuthRequest request)
ForeignIdCardAuthResponse foreignIdCardAuth(String appId, String appSecret, ForeignIdCardAuthRequest request, String traceId)
```

**请求参数：** `ForeignIdCardAuthRequest`
- `name` (String, 必填) - 姓名
- `idCard` (String, 必填) - 证件号码
- `idCardType` (Integer, 必填) - 证件类型：1-港澳通行证，2-台湾通行证，3-护照

#### 8.4 身份证人像比对 V2.0

验证身份证信息并比对人脸照片。

```java
IdMatchResponse idMatch(String appId, String appSecret, IdMatchRequest request)
IdMatchResponse idMatch(String appId, String appSecret, IdMatchRequest request, String traceId)
```

**请求参数：** `IdMatchRequest`
- `name` (String, 必填) - 姓名
- `idCard` (String, 必填) - 身份证号码
- `photo` (String, 必填) - 人脸照片 Base64 编码

**返回值：** `IdMatchResponse`
- `result` (Integer) - 验证结果：1-一致，2-不一致
- `similarity` (Double) - 相似度分数，0-100

#### 8.5 涉外身份证核验（人像）

```java
ForeignIdMatchResponse foreignIdMatch(String appId, String appSecret, ForeignIdMatchRequest request)
ForeignIdMatchResponse foreignIdMatch(String appId, String appSecret, ForeignIdMatchRequest request, String traceId)
```

#### 8.6 运营商二要素核验

验证姓名和手机号是否匹配。

```java
CarriersTwoAuthResponse carriersTwoAuth(String appId, String appSecret, CarriersTwoAuthRequest request)
CarriersTwoAuthResponse carriersTwoAuth(String appId, String appSecret, CarriersTwoAuthRequest request, String traceId)
```

**请求参数：** `CarriersTwoAuthRequest`
- `name` (String, 必填) - 姓名
- `mobile` (String, 必填) - 手机号码

**返回值：** `CarriersTwoAuthResponse`
- `result` (Integer) - 验证结果：1-一致，2-不一致

#### 8.7 运营商二要素（身份证版）核验

验证身份证号和手机号是否匹配。

```java
CarriersTwoAuthIdNumResponse carriersTwoAuthIdNum(String appId, String appSecret, CarriersTwoAuthIdNumRequest request)
CarriersTwoAuthIdNumResponse carriersTwoAuthIdNum(String appId, String appSecret, CarriersTwoAuthIdNumRequest request, String traceId)
```

**请求参数：** `CarriersTwoAuthIdNumRequest`
- `idCard` (String, 必填) - 身份证号码
- `mobile` (String, 必填) - 手机号码

#### 8.8 运营商二要素 MD5 核验

使用 MD5 加密的姓名进行核验。

```java
CarriersTwoAuthResponse carriersTwoAuthMd5(String appId, String appSecret, CarriersTwoAuthMd5Request request)
```

**请求参数：** `CarriersTwoAuthMd5Request`
- `nameMd5` (String, 必填) - 姓名的 MD5 值
- `mobile` (String, 必填) - 手机号码

#### 8.9 运营商三要素核验

验证姓名、身份证号和手机号是否匹配。

```java
CarriersAuthResponse carriersAuth(String appId, String appSecret, CarriersAuthRequest request)
CarriersAuthResponse carriersAuth(String appId, String appSecret, CarriersAuthRequest request, String traceId)
```

**请求参数：** `CarriersAuthRequest`
- `name` (String, 必填) - 姓名
- `idCard` (String, 必填) - 身份证号码
- `mobile` (String, 必填) - 手机号码

**返回值：** `CarriersAuthResponse`
- `result` (Integer) - 验证结果：1-一致，2-不一致

#### 8.10 运营商三要素 MD5 核验

```java
CarriersAuthMd5Response carriersAuthMd5(String appId, String appSecret, CarriersAuthMd5Request request)
CarriersAuthMd5Response carriersAuthMd5(String appId, String appSecret, CarriersAuthMd5Request request, String traceId)
```

#### 8.11 运营商三要素详细版核验

返回更详细的核验信息。

```java
CarriersAuthDetailResponse carriersAuthDetail(String appId, String appSecret, CarriersAuthRequest request)
CarriersAuthDetailResponse carriersAuthDetail(String appId, String appSecret, CarriersAuthRequest request, String traceId)
```

**返回值：** `CarriersAuthDetailResponse`（继承 CarriersAuthResponse）
- `carrier` (String) - 运营商
- `province` (String) - 省份
- `city` (String) - 城市

#### 8.12 运营商三要素详细版 MD5 核验

```java
CarriersAuthDetailMd5Response carriersAuthDetailMd5(String appId, String appSecret, CarriersAuthDetailMd5Request request)
CarriersAuthDetailMd5Response carriersAuthDetailMd5(String appId, String appSecret, CarriersAuthDetailMd5Request request, String traceId)
```

#### 8.13 运营商三要素详细版 SHA256 核验

```java
CarriersAuthDetailSha256Response carriersAuthDetailSha256(String appId, String appSecret, CarriersAuthDetailSha256Request request)
CarriersAuthDetailSha256Response carriersAuthDetailSha256(String appId, String appSecret, CarriersAuthDetailSha256Request request, String traceId)
```

#### 8.14 运营商三要素 SHA256 核验

```java
CarriersAuthSha256Response carriersAuthSha256(String appId, String appSecret, CarriersAuthSha256Request request)
CarriersAuthSha256Response carriersAuthSha256(String appId, String appSecret, CarriersAuthSha256Request request, String traceId)
```

#### 8.15 银行卡二要素标准版核验

验证姓名和银行卡号是否匹配。

```java
BankCardTwoAuthResponse bankCardTwoAuth(String appId, String appSecret, BankCardTwoAuthRequest request)
BankCardTwoAuthResponse bankCardTwoAuth(String appId, String appSecret, BankCardTwoAuthRequest request, String traceId)
```

**请求参数：** `BankCardTwoAuthRequest`
- `name` (String, 必填) - 姓名
- `bankCard` (String, 必填) - 银行卡号

**返回值：** `BankCardTwoAuthResponse`
- `result` (Integer) - 验证结果：1-一致，2-不一致

#### 8.16 银行卡三要素标准版核验

验证姓名、身份证号和银行卡号是否匹配。

```java
BankCardThreeAuthResponse bankCardThreeAuth(String appId, String appSecret, BankCardThreeAuthRequest request)
BankCardThreeAuthResponse bankCardThreeAuth(String appId, String appSecret, BankCardThreeAuthRequest request, String traceId)
```

**请求参数：** `BankCardThreeAuthRequest`
- `name` (String, 必填) - 姓名
- `idCard` (String, 必填) - 身份证号码
- `bankCard` (String, 必填) - 银行卡号

**返回值：** `BankCardThreeAuthResponse`
- `result` (Integer) - 验证结果：1-一致，2-不一致

#### 8.17 银行卡三要素多证件版核验

支持多种证件类型。

```java
BankCardThreeAuthTypeResponse bankCardThreeAuthType(String appId, String appSecret, BankCardThreeAuthTypeRequest request)
BankCardThreeAuthTypeResponse bankCardThreeAuthType(String appId, String appSecret, BankCardThreeAuthTypeRequest request, String traceId)
```

**请求参数：** `BankCardThreeAuthTypeRequest`
- `name` (String, 必填) - 姓名
- `idCard` (String, 必填) - 证件号码
- `idCardType` (Integer, 必填) - 证件类型：1-身份证，2-护照，3-军官证等
- `bankCard` (String, 必填) - 银行卡号

#### 8.18 银行卡三要素详细版核验

返回银行卡详细信息。

```java
BankCardThreeAuthDetailResponse bankCardThreeAuthDetail(String appId, String appSecret, BankCardThreeAuthRequest request)
BankCardThreeAuthDetailResponse bankCardThreeAuthDetail(String appId, String appSecret, BankCardThreeAuthRequest request, String traceId)
```

**返回值：** `BankCardThreeAuthDetailResponse`（继承 BankCardThreeAuthResponse）
- `bankName` (String) - 银行名称
- `cardType` (String) - 卡类型：借记卡/贷记卡
- `province` (String) - 开户省份
- `city` (String) - 开户城市

#### 8.19 银行卡三要素精准版非身份证核验

```java
BankCardThreeAuthPrecisionResponse bankCardThreeAuthPrecision(String appId, String appSecret, BankCardThreeAuthPrecisionRequest request)
BankCardThreeAuthPrecisionResponse bankCardThreeAuthPrecision(String appId, String appSecret, BankCardThreeAuthPrecisionRequest request, String traceId)
```

#### 8.20 银行卡四要素标准版核验

验证姓名、身份证号、银行卡号和手机号是否匹配。

```java
BankCardFourAuthResponse bankCardFourAuth(String appId, String appSecret, BankCardFourAuthRequest request)
BankCardFourAuthResponse bankCardFourAuth(String appId, String appSecret, BankCardFourAuthRequest request, String traceId)
```

**请求参数：** `BankCardFourAuthRequest`
- `name` (String, 必填) - 姓名
- `idCard` (String, 必填) - 身份证号码
- `bankCard` (String, 必填) - 银行卡号
- `mobile` (String, 必填) - 银行预留手机号

**返回值：** `BankCardFourAuthResponse`
- `result` (Integer) - 验证结果：1-一致，2-不一致

**示例：**
```java
BankCardFourAuthRequest request = new BankCardFourAuthRequest()
    .setName("张三")
    .setIdCard("110101199001011234")
    .setBankCard("6222021234567890123")
    .setMobile("13800138000");

BankCardFourAuthResponse response = client.bankCardFourAuth(appId, appSecret, request);
if (response.getResult() == 1) {
    System.out.println("四要素验证通过");
} else {
    System.out.println("四要素验证失败");
}
```

#### 8.21 银行卡四要素简版加密核验

```java
BankCardFourSecretResponse bankCardFourSecret(String appId, String appSecret, BankCardFourSecretRequest request)
BankCardFourSecretResponse bankCardFourSecret(String appId, String appSecret, BankCardFourSecretRequest request, String traceId)
```

#### 8.22 银行卡四要素详细版核验

```java
BankCardFourAuthDetailResponse bankCardFourAuthDetail(String appId, String appSecret, BankCardFourAuthDetailRequest request)
BankCardFourAuthDetailResponse bankCardFourAuthDetail(String appId, String appSecret, BankCardFourAuthDetailRequest request, String traceId)
```

#### 8.23 银行卡四要素多证件版核验

```java
BankCardFourAuthTypeResponse bankCardFourAuthType(String appId, String appSecret, BankCardFourAuthTypeRequest request)
BankCardFourAuthTypeResponse bankCardFourAuthType(String appId, String appSecret, BankCardFourAuthTypeRequest request, String traceId)
```

#### 8.24 银行卡四要素精准版非身份证核验

```java
BankCardFourAuthPrecisionResponse bankCardFourAuthPrecision(String appId, String appSecret, BankCardFourAuthPrecisionRequest request)
BankCardFourAuthPrecisionResponse bankCardFourAuthPrecision(String appId, String appSecret, BankCardFourAuthPrecisionRequest request, String traceId)
```

#### 8.25 银行卡五要素标准版核验

验证姓名、身份证号、银行卡号、手机号和有效期/CVV2 是否匹配。

```java
BankCardFiveAuthResponse bankCardFiveAuth(String appId, String appSecret, BankCardFiveAuthRequest request)
BankCardFiveAuthResponse bankCardFiveAuth(String appId, String appSecret, BankCardFiveAuthRequest request, String traceId)
```

**请求参数：** `BankCardFiveAuthRequest`
- `name` (String, 必填) - 姓名
- `idCard` (String, 必填) - 身份证号码
- `bankCard` (String, 必填) - 银行卡号
- `mobile` (String, 必填) - 银行预留手机号
- `validDate` (String, 可选) - 有效期（信用卡）
- `cvv2` (String, 可选) - CVV2 码（信用卡）

#### 8.26 IP 归属地查询

```java
IpGsdQueryResponse ipGsdQuery(String appId, String appSecret, IpGsdQueryRequest request)
IpGsdQueryResponse ipGsdQuery(String appId, String appSecret, IpGsdQueryRequest request, String traceId)
```

**请求参数：** `IpGsdQueryRequest`
- `ip` (String, 必填) - IP 地址

**返回值：** `IpGsdQueryResponse`
- `country` (String) - 国家
- `province` (String) - 省份
- `city` (String) - 城市

#### 8.27 企业四要素核验

验证企业名称、统一社会信用代码、法人姓名和法人身份证号是否匹配。

```java
EnterpriseFourAuthResponse enterpriseFourAuth(String appId, String appSecret, EnterpriseFourAuthRequest request)
EnterpriseFourAuthResponse enterpriseFourAuth(String appId, String appSecret, EnterpriseFourAuthRequest request, String traceId)
```

**请求参数：** `EnterpriseFourAuthRequest`
- `entName` (String, 必填) - 企业名称
- `creditCode` (String, 必填) - 统一社会信用代码
- `legalPerName` (String, 必填) - 法人姓名
- `legalPerIdCard` (String, 必填) - 法人身份证号

**返回值：** `EnterpriseFourAuthResponse`
- `result` (Integer) - 验证结果：1-一致，2-不一致

### 九、业务信息查询

#### 9.1 IP 归属地查询 V4

查询 IPv4 地址的归属地信息。

```java
IpAddressOriginV4Response ipAddressOriginV4(String appId, String appSecret, IpAddressOriginV4Request request)
IpAddressOriginV4Response ipAddressOriginV4(String appId, String appSecret, IpAddressOriginV4Request request, String traceId)
```

**请求参数：** `IpAddressOriginV4Request`
- `ip` (String, 必填) - IPv4 地址

**返回值：** `IpAddressOriginV4Response`
- `country` (String) - 国家
- `province` (String) - 省份
- `city` (String) - 城市
- `isp` (String) - 运营商

#### 9.2 IP 归属地查询 V6

查询 IPv6 地址的归属地信息。

```java
IpAddressOriginV6Response ipAddressOriginV6(String appId, String appSecret, IpAddressOriginV6Request request)
IpAddressOriginV6Response ipAddressOriginV6(String appId, String appSecret, IpAddressOriginV6Request request, String traceId)
```

**请求参数：** `IpAddressOriginV6Request`
- `ip` (String, 必填) - IPv6 地址

#### 9.3 IP 风险画像

分析 IP 地址的风险特征。

```java
IpRiskPortraitResponse ipRiskPortrait(String appId, String appSecret, IpRiskPortraitRequest request)
IpRiskPortraitResponse ipRiskPortrait(String appId, String appSecret, IpRiskPortraitRequest request, String traceId)
```

**请求参数：** `IpRiskPortraitRequest`
- `ip` (String, 必填) - IP 地址

**返回值：** `IpRiskPortraitResponse`
- `riskLevel` (Integer) - 风险等级：0-无风险，1-低风险，2-中风险，3-高风险
- `riskTags` (List<String>) - 风险标签列表
- `isProxy` (Boolean) - 是否代理 IP
- `isDataCenter` (Boolean) - 是否数据中心 IP

#### 9.4 IP 真人识别

识别 IP 是否为真人使用。

```java
IpFacialRecognitionResponse ipFacialRecognition(String appId, String appSecret, IpFacialRecognitionRequest request)
IpFacialRecognitionResponse ipFacialRecognition(String appId, String appSecret, IpFacialRecognitionRequest request, String traceId)
```

**请求参数：** `IpFacialRecognitionRequest`
- `ip` (String, 必填) - IP 地址

**返回值：** `IpFacialRecognitionResponse`
- `isReal` (Boolean) - 是否真人
- `confidence` (Double) - 置信度，0-100

#### 9.5 IP 应用场景识别

识别 IP 的应用场景类型。

```java
IpApplicationScenariosResponse ipApplicationScenarios(String appId, String appSecret, IpApplicationScenariosRequest request)
IpApplicationScenariosResponse ipApplicationScenarios(String appId, String appSecret, IpApplicationScenariosRequest request, String traceId)
```

**请求参数：** `IpApplicationScenariosRequest`
- `ip` (String, 必填) - IP 地址

**返回值：** `IpApplicationScenariosResponse`
- `scenario` (String) - 场景类型：家庭宽带、企业专线、移动网络、IDC机房等

#### 9.6 IP 代理识别

识别 IP 是否为代理 IP。

```java
IpProxyIdentificationResponse ipProxyIdentification(String appId, String appSecret, IpProxyIdentificationRequest request)
IpProxyIdentificationResponse ipProxyIdentification(String appId, String appSecret, IpProxyIdentificationRequest request, String traceId)
```

**请求参数：** `IpProxyIdentificationRequest`
- `ip` (String, 必填) - IP 地址

**返回值：** `IpProxyIdentificationResponse`
- `isProxy` (Boolean) - 是否代理 IP
- `proxyType` (String) - 代理类型：透明代理、匿名代理、高匿代理等

#### 9.7 IP 宿主信息

查询 IP 的宿主服务器信息。

```java
IpHostInformationResponse ipHostInformation(String appId, String appSecret, IpHostInformationRequest request)
IpHostInformationResponse ipHostInformation(String appId, String appSecret, IpHostInformationRequest request, String traceId)
```

**请求参数：** `IpHostInformationRequest`
- `ip` (String, 必填) - IP 地址

**返回值：** `IpHostInformationResponse`
- `hostName` (String) - 主机名
- `asn` (String) - 自治系统号
- `organization` (String) - 所属组织

#### 9.8 企业二要素核验

验证企业名称和统一社会信用代码是否匹配。

```java
EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(String appId, String appSecret, EnterpriseTwoElementsCheckRequest request)
EnterpriseTwoElementsCheckResponse enterpriseTwoElementsCheck(String appId, String appSecret, EnterpriseTwoElementsCheckRequest request, String traceId)
```

**请求参数：** `EnterpriseTwoElementsCheckRequest`
- `entName` (String, 必填) - 企业名称
- `creditCode` (String, 必填) - 统一社会信用代码

**返回值：** `EnterpriseTwoElementsCheckResponse`
- `result` (Integer) - 验证结果：1-一致，2-不一致

#### 9.9 企业三要素核验

验证企业名称、统一社会信用代码和法人姓名是否匹配。

```java
EnterpriseThreeAuthResponse enterpriseThreeAuth(String appId, String appSecret, EnterpriseThreeAuthRequest request)
EnterpriseThreeAuthResponse enterpriseThreeAuth(String appId, String appSecret, EnterpriseThreeAuthRequest request, String traceId)
```

**请求参数：** `EnterpriseThreeAuthRequest`
- `entName` (String, 必填) - 企业名称
- `creditCode` (String, 必填) - 统一社会信用代码
- `legalPerName` (String, 必填) - 法人姓名

**返回值：** `EnterpriseThreeAuthResponse`
- `result` (Integer) - 验证结果：1-一致，2-不一致

#### 9.10 企业工商模糊查询

根据关键词模糊查询企业列表。

```java
EnterpriseQueryResponse enterpriseQuery(String appId, String appSecret, EnterpriseQueryRequest request)
EnterpriseQueryResponse enterpriseQuery(String appId, String appSecret, EnterpriseQueryRequest request, String traceId)
```

**请求参数：** `EnterpriseQueryRequest`
- `keyword` (String, 必填) - 查询关键词（企业名称或统一社会信用代码）
- `pageNum` (Integer, 可选) - 页码，默认 1
- `pageSize` (Integer, 可选) - 每页条数，默认 10

**返回值：** `EnterpriseQueryResponse`
- `total` (Integer) - 总记录数
- `data` (List<EnterpriseQueryData>) - 企业列表
  - `entName` (String) - 企业名称
  - `creditCode` (String) - 统一社会信用代码
  - `legalPerName` (String) - 法人姓名
  - `regStatus` (String) - 登记状态

#### 9.11 企业工商信息查询（简项）

查询企业的基本工商信息。

```java
EnterpriseSimpleResponse enterpriseSimple(String appId, String appSecret, EnterpriseSimpleRequest request)
EnterpriseSimpleResponse enterpriseSimple(String appId, String appSecret, EnterpriseSimpleRequest request, String traceId)
```

**请求参数：** `EnterpriseSimpleRequest`
- `keyword` (String, 必填) - 企业名称或统一社会信用代码

**返回值：** `EnterpriseSimpleResponse`
- `data` (EnterpriseSimpleData) - 企业信息
  - `basic` (EnterpriseSimpleBasic) - 基本信息
    - `entName` (String) - 企业名称
    - `creditCode` (String) - 统一社会信用代码
    - `legalPerName` (String) - 法人姓名
    - `regCapital` (String) - 注册资本
    - `regDate` (String) - 注册日期
    - `regStatus` (String) - 登记状态
    - `entType` (String) - 企业类型
    - `address` (String) - 注册地址
  - `shareholders` (List<EnterpriseSimpleShareholder>) - 股东信息
  - `alterations` (List<EnterpriseSimpleAlter>) - 变更记录
  - `filiations` (List<EnterpriseSimpleFiliation>) - 分支机构

#### 9.12 经营异常查询

查询企业是否存在经营异常记录。

```java
AbnormalOperationResponse abnormalOperation(String appId, String appSecret, AbnormalOperationRequest request)
AbnormalOperationResponse abnormalOperation(String appId, String appSecret, AbnormalOperationRequest request, String traceId)
```

**请求参数：** `AbnormalOperationRequest`
- `keyword` (String, 必填) - 企业名称或统一社会信用代码
- `pageNum` (Integer, 可选) - 页码
- `pageSize` (Integer, 可选) - 每页条数

**返回值：** `AbnormalOperationResponse`
- `total` (Integer) - 总记录数
- `data` (List<AbnormalOperationItem>) - 异常记录列表
  - `inReason` (String) - 列入原因
  - `inDate` (String) - 列入日期
  - `outReason` (String) - 移出原因
  - `outDate` (String) - 移出日期

#### 9.13 工商行政处罚查询

查询企业的行政处罚记录。

```java
AdministrativeSanctionQueryResponse administrativeSanctionQuery(String appId, String appSecret, AdministrativeSanctionQueryRequest request)
AdministrativeSanctionQueryResponse administrativeSanctionQuery(String appId, String appSecret, AdministrativeSanctionQueryRequest request, String traceId)
```

**请求参数：** `AdministrativeSanctionQueryRequest`
- `keyword` (String, 必填) - 企业名称或统一社会信用代码
- `pageNum` (Integer, 可选) - 页码
- `pageSize` (Integer, 可选) - 每页条数

**返回值：** `AdministrativeSanctionQueryResponse`
- `total` (Integer) - 总记录数
- `data` (List<AdministrativeSanctionItem>) - 处罚记录列表
  - `penaltyNo` (String) - 处罚文书号
  - `penaltyDate` (String) - 处罚日期
  - `penaltyReason` (String) - 处罚事由
  - `penaltyResult` (String) - 处罚结果

#### 9.14 企业司法涉诉查询

查询企业的司法诉讼记录。

```java
JusticeComplainResponse justiceComplain(String appId, String appSecret, JusticeComplainRequest request)
JusticeComplainResponse justiceComplain(String appId, String appSecret, JusticeComplainRequest request, String traceId)
```

**请求参数：** `JusticeComplainRequest`
- `keyword` (String, 必填) - 企业名称或统一社会信用代码
- `pageNum` (Integer, 可选) - 页码
- `pageSize` (Integer, 可选) - 每页条数

#### 9.15 企业大中小微划型服务

查询企业规模划型（大型、中型、小型、微型）。

```java
CompanyLevelResponse companyLevel(String appId, String appSecret, CompanyLevelRequest request)
CompanyLevelResponse companyLevel(String appId, String appSecret, CompanyLevelRequest request, String traceId)
```

**请求参数：** `CompanyLevelRequest`
- `keyword` (String, 必填) - 企业名称或统一社会信用代码

**返回值：** `CompanyLevelResponse`
- `data` (CompanyLevelData) - 划型信息
  - `level` (String) - 企业规模：大型、中型、小型、微型
  - `industry` (String) - 所属行业

#### 9.16 企业招投标查询（翻页）

查询企业的招投标记录。

```java
EnterpriseBiddingResponse enterpriseBidding(String appId, String appSecret, EnterpriseBiddingRequest request)
EnterpriseBiddingResponse enterpriseBidding(String appId, String appSecret, EnterpriseBiddingRequest request, String traceId)
```

**请求参数：** `EnterpriseBiddingRequest`
- `keyword` (String, 必填) - 企业名称或统一社会信用代码
- `pageNum` (Integer, 可选) - 页码
- `pageSize` (Integer, 可选) - 每页条数

**返回值：** `EnterpriseBiddingResponse`
- `total` (Integer) - 总记录数
- `data` (EnterpriseBiddingData) - 招投标数据
  - `items` (List<EnterpriseBiddingItem>) - 招投标记录列表
    - `projectName` (String) - 项目名称
    - `biddingDate` (String) - 投标日期
    - `winAmount` (String) - 中标金额
    - `winDate` (String) - 中标日期

#### 9.17 企业欠税公告查询

查询企业的欠税公告记录。

```java
EnterpriseOwnTaxResponse enterpriseOwnTax(String appId, String appSecret, EnterpriseOwnTaxRequest request)
EnterpriseOwnTaxResponse enterpriseOwnTax(String appId, String appSecret, EnterpriseOwnTaxRequest request, String traceId)
```

**请求参数：** `EnterpriseOwnTaxRequest`
- `keyword` (String, 必填) - 企业名称或统一社会信用代码
- `pageNum` (Integer, 可选) - 页码
- `pageSize` (Integer, 可选) - 每页条数

**返回值：** `EnterpriseOwnTaxResponse`
- `total` (Integer) - 总记录数
- `data` (EnterpriseOwnTaxData) - 欠税数据
  - `items` (List<EnterpriseOwnTaxItem>) - 欠税记录列表
    - `taxAmount` (String) - 欠税金额
    - `taxDate` (String) - 欠税日期
    - `taxType` (String) - 税种

### 十、OCR 识别业务

#### 10.1 静态活体检测

检测照片中的人脸是否为活体（非照片翻拍、视频翻拍等）。

```java
FaceCheckResponse faceCheck(String appId, String appSecret, FaceCheckRequest request)
FaceCheckResponse faceCheck(String appId, String appSecret, FaceCheckRequest request, String traceId)
```

**请求参数：** `FaceCheckRequest`
- `image` (String, 必填) - 人脸照片 Base64 编码

**返回值：** `FaceCheckResponse`
- `isLive` (Boolean) - 是否活体
- `confidence` (Double) - 置信度，0-100

#### 10.2 动态活体检测

通过连续多帧检测判断是否为真人。

```java
LifeCheckResponse lifeCheck(String appId, String appSecret, LifeCheckRequest request)
LifeCheckResponse lifeCheck(String appId, String appSecret, LifeCheckRequest request, String traceId)
```

**请求参数：** `LifeCheckRequest`
- `videoBase64` (String, 必填) - 视频文件 Base64 编码

**返回值：** `LifeCheckResponse`
- `isLive` (Boolean) - 是否活体
- `confidence` (Double) - 置信度

#### 10.3 身份证 OCR 识别

识别身份证正反面信息。

```java
IdOcrResponse idOcr(String appId, String appSecret, IdOcrRequest request)
IdOcrResponse idOcr(String appId, String appSecret, IdOcrRequest request, String traceId)
```

**请求参数：** `IdOcrRequest`
- `image` (String, 必填) - 身份证照片 Base64 编码
- `side` (String, 必填) - 正反面标识："front"-正面，"back"-反面

**返回值：** `IdOcrResponse`
- 正面返回：
  - `name` (String) - 姓名
  - `idCard` (String) - 身份证号
  - `sex` (String) - 性别
  - `nation` (String) - 民族
  - `birth` (String) - 出生日期
  - `address` (String) - 地址
- 反面返回：
  - `authority` (String) - 签发机关
  - `validDate` (String) - 有效期限

**示例：**
```java
// 识别身份证正面
IdOcrRequest request = new IdOcrRequest()
    .setImage(base64Image)
    .setSide("front");

IdOcrResponse response = client.idOcr(appId, appSecret, request);
System.out.println("姓名: " + response.getName());
System.out.println("身份证号: " + response.getIdCard());
```

#### 10.4 身份证 OCR V2 识别（自动识别正反面）

自动识别身份证正反面并提取信息。

```java
IdOcrV2Response idOcrV2(String appId, String appSecret, IdOcrV2Request request)
IdOcrV2Response idOcrV2(String appId, String appSecret, IdOcrV2Request request, String traceId)
```

**请求参数：** `IdOcrV2Request`
- `image` (String, 必填) - 身份证照片 Base64 编码（自动识别正反面）

**返回值：** `IdOcrV2Response`（包含正反面全部信息）
- `side` (String) - 实际识别的面："front" 或 "back"
- 其他字段同 IdOcrResponse

#### 10.5 行驶证 OCR 识别

识别机动车行驶证信息。

```java
VehicleLicenseResponse vehicleLicense(String appId, String appSecret, VehicleLicenseRequest request)
VehicleLicenseResponse vehicleLicense(String appId, String appSecret, VehicleLicenseRequest request, String traceId)
```

**请求参数：** `VehicleLicenseRequest`
- `image` (String, 必填) - 行驶证照片 Base64 编码

**返回值：** `VehicleLicenseResponse`
- `plateNo` (String) - 车牌号码
- `vehicleType` (String) - 车辆类型
- `owner` (String) - 所有人
- `address` (String) - 住址
- `useCharacter` (String) - 使用性质
- `model` (String) - 品牌型号
- `vin` (String) - 车辆识别代号
- `engineNo` (String) - 发动机号码
- `registerDate` (String) - 注册日期
- `issueDate` (String) - 发证日期

### 十一、获取业务线客户端

除了通过 `CloudApiClient` 直接调用业务方法外，还可以获取各业务线的专属客户端实例。

#### 11.1 获取业务线客户端

```java
BusinessClient businessClient()
```

**返回值：** `BusinessClient` - 业务线客户端实例

**使用场景：** 当需要大量调用业务线（Business）相关接口时，可以获取专属客户端，避免每次都通过 `CloudApiClient` 中转。

**示例：**
```java
CloudApiClient client = new CloudApiClient();
BusinessClient businessClient = client.businessClient();

// 直接通过业务线客户端调用
IpAddressOriginV4Response response = businessClient.ipAddressOriginV4(appId, appSecret, request);
```

**注意：** 通过 `businessClient()` 获取的客户端与 `CloudApiClient` 共享底层 HTTP 连接池，无需单独释放资源。

## 异常处理

SDK 中的业务异常统一封装为 `CloudSdkException`。

### CloudSdkException 字段

- `code` (String) - 业务错误码
- `message` (String) - 错误描述
- `statusCode` (int) - HTTP 状态码

### 异常处理示例

```java
try {
    SmsBatchSendResponse response = client.batchSend(appId, appSecret, request);
    if ("0".equals(response.getCode())) {
        System.out.println("发送成功");
    } else {
        System.out.println("业务失败: " + response.getErrorMsg());
    }
} catch (CloudSdkException e) {
    System.err.println("请求异常: " + e.getMessage());
    System.err.println("错误码: " + e.getCode());
    System.err.println("HTTP状态码: " + e.getStatusCode());
}
```

### 常见错误码

| 错误码 | 说明 | 处理建议 |
|--------|------|----------|
| `0` | 成功 | 正常处理 |
| `101` | 无此用户 | 检查 appId 和 appSecret |
| `102` | 密码错误 | 检查 appSecret |
| `103` | 提交过快（限流） | 降低请求频率或联系客服调整限流 |
| `104` | 系统忙 | 稍后重试 |
| `105` | 敏感短信 | 检查短信内容是否包含敏感词 |
| `106` | 余额不足 | 充值后重试 |
| `107` | 号码异常 | 检查手机号格式 |
| `108` | 签名不合法 | 检查短信签名 |

## 高级特性

### 链路追踪

所有 API 方法都支持可选的 `traceId` 参数，用于分布式链路追踪。

```java
String traceId = UUID.randomUUID().toString();

SmsBatchSendResponse response = client.batchSend(
    appId, 
    appSecret, 
    request, 
    traceId  // 链路追踪 ID
);

// traceId 会在日志和监控系统中串联整个调用链路
```

### 重试机制

SDK 内置自动重试机制：

- **默认最大重试次数**：3 次
- **重试策略**：指数退避（初始 1 秒，最大 5 秒）
- **重试场景**：网络超时、连接失败等可恢复错误
- **不重试场景**：业务错误（如余额不足、参数错误等）

每次重试会重新生成签名（刷新时间戳），确保签名有效性。

### 资源管理

`CloudApiClient` 实现了 `AutoCloseable` 接口，建议使用 try-with-resources 自动管理资源。

**不推荐（需要手动关闭）：**
```java
CloudApiClient client = new CloudApiClient();
try {
    // 使用 client
} finally {
    client.close();  // 手动释放资源
}
```

**推荐（自动关闭）：**
```java
try (CloudApiClient client = new CloudApiClient()) {
    // 使用 client
}  // 自动释放资源
```

**Spring 环境：**
```java
@Configuration
public class CloudSdkConfig {
    
    @Bean(destroyMethod = "close")
    public CloudApiClient cloudApiClient() {
        return new CloudApiClient();
    }
}
```

Spring 容器会在应用关闭时自动调用 `close()` 方法释放资源。

## 完整示例

### 示例 1：短信批量发送

```java
import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.sms.SmsBatchSendRequest;
import com.chuanglan.cloudsdk.api.sms.SmsBatchSendResponse;
import com.chuanglan.cloudsdk.core.CloudSdkException;

public class SmsSendExample {
    public static void main(String[] args) {
        String appId = "your_app_id";
        String appSecret = "your_app_secret";
        
        try (CloudApiClient client = new CloudApiClient()) {
            SmsBatchSendRequest request = new SmsBatchSendRequest()
                .setPhone("13800138000,13900139000")
                .setMsg("【创蓝云】您的验证码是123456，5分钟内有效")
                .setReport(true)
                .setUid("order-12345");
            
            SmsBatchSendResponse response = client.batchSend(appId, appSecret, request);
            
            if ("0".equals(response.getCode())) {
                System.out.println("发送成功，消息ID: " + response.getMsgId());
            } else {
                System.out.println("发送失败: " + response.getErrorMsg());
            }
        } catch (CloudSdkException e) {
            System.err.println("请求异常: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

### 示例 2：号码状态检测

```java
import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.api.number.NumberStatusCheckRequest;
import com.chuanglan.cloudsdk.api.api.number.NumberStatusCheckResponse;
import com.chuanglan.cloudsdk.core.CloudSdkException;

public class NumberCheckExample {
    public static void main(String[] args) {
        String appId = "your_app_id";
        String appSecret = "your_app_secret";
        
        try (CloudApiClient client = new CloudApiClient()) {
            NumberStatusCheckRequest request = new NumberStatusCheckRequest()
                .setMobiles("13800138000,13900139000")
                .setIsReturnLocation(true);
            
            NumberStatusCheckResponse response = client.batchUcheck(appId, appSecret, request);
            
            response.getData().forEach(data -> {
                System.out.println("号码: " + data.getMobile());
                System.out.println("状态: " + data.getStatus());
                System.out.println("归属地: " + data.getProvince() + " " + data.getCity());
                System.out.println("运营商: " + data.getCarrier());
                System.out.println("---");
            });
        } catch (CloudSdkException e) {
            System.err.println("请求异常: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

### 示例 3：身份证二要素核验

```java
import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.api.realName.IdCardAuthRequest;
import com.chuanglan.cloudsdk.api.api.realName.IdCardAuthResponse;
import com.chuanglan.cloudsdk.core.CloudSdkException;

public class IdCardAuthExample {
    public static void main(String[] args) {
        String appId = "your_app_id";
        String appSecret = "your_app_secret";
        
        try (CloudApiClient client = new CloudApiClient()) {
            IdCardAuthRequest request = new IdCardAuthRequest()
                .setName("张三")
                .setIdCard("110101199001011234");
            
            IdCardAuthResponse response = client.idCardAuth(appId, appSecret, request);
            
            if (response.getResult() == 1) {
                System.out.println("验证通过");
                System.out.println("性别: " + response.getSex());
                System.out.println("出生日期: " + response.getBirthday());
                System.out.println("地址: " + response.getAddress());
            } else {
                System.out.println("验证失败: " + response.getDesc());
            }
        } catch (CloudSdkException e) {
            System.err.println("请求异常: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

### 示例 4：银行卡四要素核验

```java
import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.api.realName.BankCardFourAuthRequest;
import com.chuanglan.cloudsdk.api.api.realName.BankCardFourAuthResponse;
import com.chuanglan.cloudsdk.core.CloudSdkException;

public class BankCardAuthExample {
    public static void main(String[] args) {
        String appId = "your_app_id";
        String appSecret = "your_app_secret";
        
        try (CloudApiClient client = new CloudApiClient()) {
            BankCardFourAuthRequest request = new BankCardFourAuthRequest()
                .setName("张三")
                .setIdCard("110101199001011234")
                .setBankCard("6222021234567890123")
                .setMobile("13800138000");
            
            BankCardFourAuthResponse response = client.bankCardFourAuth(appId, appSecret, request);
            
            if (response.getResult() == 1) {
                System.out.println("银行卡四要素验证通过");
            } else {
                System.out.println("银行卡四要素验证失败");
            }
        } catch (CloudSdkException e) {
            System.err.println("请求异常: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

### 示例 5：企业工商信息查询

```java
import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.api.business.EnterpriseSimpleRequest;
import com.chuanglan.cloudsdk.api.api.business.EnterpriseSimpleResponse;
import com.chuanglan.cloudsdk.core.CloudSdkException;

public class EnterpriseQueryExample {
    public static void main(String[] args) {
        String appId = "your_app_id";
        String appSecret = "your_app_secret";
        
        try (CloudApiClient client = new CloudApiClient()) {
            EnterpriseSimpleRequest request = new EnterpriseSimpleRequest()
                .setKeyword("创蓝云智");
            
            EnterpriseSimpleResponse response = client.enterpriseSimple(appId, appSecret, request);
            
            if (response.getData() != null) {
                var basic = response.getData().getBasic();
                System.out.println("企业名称: " + basic.getEntName());
                System.out.println("统一社会信用代码: " + basic.getCreditCode());
                System.out.println("法人姓名: " + basic.getLegalPerName());
                System.out.println("注册资本: " + basic.getRegCapital());
                System.out.println("注册日期: " + basic.getRegDate());
                System.out.println("登记状态: " + basic.getRegStatus());
                System.out.println("注册地址: " + basic.getAddress());
            }
        } catch (CloudSdkException e) {
            System.err.println("请求异常: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

### 示例 6：Spring Boot 集成

```java
// Service 类
import com.chuanglan.cloudsdk.api.CloudApiClient;
import com.chuanglan.cloudsdk.api.sms.SmsBatchSendRequest;
import com.chuanglan.cloudsdk.api.sms.SmsBatchSendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    
    @Autowired
    private CloudApiClient cloudApiClient;
    
    @Value("${sms.appId}")
    private String appId;
    
    @Value("${sms.appSecret}")
    private String appSecret;
    
    public boolean sendVerificationCode(String phone, String code) {
        try {
            SmsBatchSendRequest request = new SmsBatchSendRequest()
                .setPhone(phone)
                .setMsg("【创蓝云】您的验证码是" + code + "，5分钟内有效")
                .setReport(true);
            
            SmsBatchSendResponse response = cloudApiClient.batchSend(appId, appSecret, request);
            return "0".equals(response.getCode());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
```

## 项目结构

```
cloud-sdk/
├── cloud-sdk-parent/          # 父 POM，管理依赖版本
├── cloud-sdk-core/            # 核心运行时
│   ├── HttpTransport          # HTTP 传输层（基于 OkHttp）
│   ├── CloudSdkException      # 统一异常封装
│   └── CloudSdkModel          # 基础模型类
├── cloud-sdk-api/             # API 业务层
│   ├── CloudApiClient         # 统一客户端入口
│   ├── CloudApiConfig         # 统一配置类
│   ├── sms/                   # 短信业务
│   ├── intSms/                # 国际短信业务
│   ├── rcsSms/                # 视频短信业务
│   ├── api/
│   │   ├── number/            # 号码业务
│   │   ├── risk/              # 风控业务
│   │   ├── mnp/               # 携号转网业务
│   │   ├── realName/          # 实名认证业务
│   │   └── business/          # 业务信息查询
│   └── ...
└── cloud-sdk-spring/          # Spring Boot 自动装配
    ├── CloudSdkAutoConfiguration  # 自动配置类
    └── CloudSdkProperties         # 配置绑定类
```

## 模块说明

### cloud-sdk-core

核心运行时模块，提供：
- HTTP 传输层封装（基于 OkHttp 3.x）
- 连接池管理
- 异常统一封装
- 基础模型类

**依赖：**
```xml
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.9.3</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.2</version>
</dependency>
```

### cloud-sdk-api

API 业务层模块，提供：
- 各业务线 Client 实现
- Request/Response 模型类
- 签名算法实现
- 统一入口 `CloudApiClient`

**依赖：** cloud-sdk-core

### cloud-sdk-spring

Spring Boot 自动装配模块，提供：
- `@EnableAutoConfiguration` 支持
- `CloudApiClient` Bean 自动注册

**依赖：** cloud-sdk-api + Spring Boot（可选）

## API 总览

### 短信业务（SMS）

| API | 方法 | 说明 |
|-----|------|------|
| 短信批量发送 | `batchSend` | 发送短信到指定手机号 |
| 新增资质 | `addQualification` | 添加企业资质 |
| 查询资质列表 | `listQualification` | 分页查询资质列表 |
| 更新资质 | `updateQualification` | 更新已有资质 |
| 删除资质 | `deleteQualification` | 删除指定资质 |
| 新增签名 | `addSignature` | 添加短信签名 |
| 查询签名详情 | `getSignature` | 查询签名详细信息 |
| 查询签名列表 | `listSignature` | 分页查询签名列表 |
| 查询签名驳回原因 | `getSignatureOperatorRejectReason` | 查询运营商驳回原因 |
| 更新签名实名信息 | `updateSignatureRealName` | 更新签名实名信息 |
| 删除签名 | `deleteSignature` | 删除指定签名 |
| 新增模板 | `addTemplate` | 添加短信模板 |
| 查询模板类型枚举 | `queryTemplateTypeEnum` | 查询模板类型列表 |
| 查询模板列表 | `listTemplate` | 分页查询模板列表 |
| 查询模板详情 | `getTemplate` | 查询模板详细信息 |
| 查询模板驳回原因 | `getTemplateOperatorRejectReason` | 查询运营商驳回原因 |
| 更新模板 | `updateTemplate` | 更新已有模板 |
| 删除模板 | `deleteTemplate` | 删除指定模板 |

### 国际短信业务（IntSms）

| API | 方法 | 说明 |
|-----|------|------|
| 国际短信发送 | `submitIntSms` | 发送国际短信（支持多节点） |
| 账户余额查询 | `queryIntSmsBalance` | 查询国际短信账户余额 |
| 账户消耗查询 | `queryIntSmsCost` | 查询指定时间段消耗 |
| 发送价格查询 | `queryIntSmsPrice` | 查询国家/地区发送价格 |

### 视频短信业务（RcsSms）

| API | 方法 | 说明 |
|-----|------|------|
| 新增视频模板 | `addVideoTemplate` | 添加视频短信模板 |
| 查询视频模板 | `findVideoTemplate` | 查询模板详情 |
| 发送视频短信 | `submitVideoTemplate` | 发送视频短信 |
| 拉取状态报告 | `pullReport` | 拉取发送状态报告 |
| 拉取上行回复 | `pullReply` | 拉取用户回复 |
| 新增签名 | `addSign` | 添加视频短信签名 |

### 号码业务（Number）

| API | 方法 | 说明 |
|-----|------|------|
| 号码状态检测 | `batchUcheck` | 批量检测号码状态（空号、停机等） |
| 号码归属地查询 V2 | `phoneAttributionV2` | 查询号码归属地信息 |

### 号码运营商业务（NumberCarrier）

| API | 方法 | 说明 |
|-----|------|------|
| 二次号查询 | `moresale` | 查询是否为二次放号 |
| 号码实时基础版查询 | `mobStatusBasicQuery` | 查询号码实时状态 |
| 号码在网时长查询 | `onlineDurationQuery` | 查询在网时长区间 |
| 号码在网状态查询 | `netStatus` | 查询是否在网 |

### 风控业务（Risk）

| API | 方法 | 说明 |
|-----|------|------|
| 防骚扰黑名单查询 | `bforbid` | 查询号码是否在黑名单 |
| 羊毛党检测 | `woolCheck` | 检测号码羊毛党风险 |

### 携号转网业务（Mnp）

| API | 方法 | 说明 |
|-----|------|------|
| 携号转网 V1 查询 | `carriersSftp` | 查询号码是否携号转网 |

### 实名认证业务（RealName）

| API | 方法 | 说明 |
|-----|------|------|
| 身份证二要素核验 | `idCardAuth` | 验证姓名+身份证号 |
| 身份证二要素核验 V2 | `idCardAuthV2` | 签名版二要素核验 |
| 涉外身份证校验 | `foreignIdCardAuth` | 港澳台及外籍证件核验 |
| 身份证人像比对 V2.0 | `idMatch` | 身份证+人脸照片比对 |
| 涉外身份证核验（人像） | `foreignIdMatch` | 涉外证件+人脸比对 |
| 运营商二要素核验 | `carriersTwoAuth` | 姓名+手机号核验 |
| 运营商二要素（身份证版） | `carriersTwoAuthIdNum` | 身份证号+手机号核验 |
| 运营商二要素 MD5 核验 | `carriersTwoAuthMd5` | MD5 加密姓名核验 |
| 运营商三要素核验 | `carriersAuth` | 姓名+身份证号+手机号核验 |
| 运营商三要素 MD5 核验 | `carriersAuthMd5` | MD5 加密三要素核验 |
| 运营商三要素详细版核验 | `carriersAuthDetail` | 三要素核验（含归属地） |
| 运营商三要素详细版 MD5 | `carriersAuthDetailMd5` | MD5 详细版核验 |
| 运营商三要素详细版 SHA256 | `carriersAuthDetailSha256` | SHA256 详细版核验 |
| 运营商三要素 SHA256 核验 | `carriersAuthSha256` | SHA256 三要素核验 |
| 银行卡二要素标准版核验 | `bankCardTwoAuth` | 姓名+银行卡号核验 |
| 银行卡三要素标准版核验 | `bankCardThreeAuth` | 姓名+身份证号+银行卡号核验 |
| 银行卡三要素多证件版核验 | `bankCardThreeAuthType` | 支持多种证件类型 |
| 银行卡三要素详细版核验 | `bankCardThreeAuthDetail` | 含银行卡详细信息 |
| 银行卡三要素精准版核验 | `bankCardThreeAuthPrecision` | 精准版非身份证核验 |
| 银行卡四要素标准版核验 | `bankCardFourAuth` | 姓名+身份证号+银行卡号+手机号 |
| 银行卡四要素简版加密核验 | `bankCardFourSecret` | 加密版四要素核验 |
| 银行卡四要素详细版核验 | `bankCardFourAuthDetail` | 含银行卡详细信息 |
| 银行卡四要素多证件版核验 | `bankCardFourAuthType` | 支持多种证件类型 |
| 银行卡四要素精准版核验 | `bankCardFourAuthPrecision` | 精准版非身份证核验 |
| 银行卡五要素标准版核验 | `bankCardFiveAuth` | 含有效期/CVV2 核验 |
| IP 归属地查询 | `ipGsdQuery` | 查询 IP 归属地 |
| 企业四要素核验 | `enterpriseFourAuth` | 企业名称+信用代码+法人姓名+身份证号 |

### 业务信息查询（Business）

| API | 方法 | 说明 |
|-----|------|------|
| IP 归属地查询 V4 | `ipAddressOriginV4` | 查询 IPv4 归属地 |
| IP 归属地查询 V6 | `ipAddressOriginV6` | 查询 IPv6 归属地 |
| IP 风险画像 | `ipRiskPortrait` | 分析 IP 风险特征 |
| IP 真人识别 | `ipFacialRecognition` | 识别 IP 是否真人使用 |
| IP 应用场景识别 | `ipApplicationScenarios` | 识别 IP 应用场景类型 |
| IP 代理识别 | `ipProxyIdentification` | 识别是否代理 IP |
| IP 宿主信息 | `ipHostInformation` | 查询 IP 宿主服务器信息 |
| 企业二要素核验 | `enterpriseTwoElementsCheck` | 企业名称+信用代码核验 |
| 企业三要素核验 | `enterpriseThreeAuth` | 企业名称+信用代码+法人姓名 |
| 企业工商模糊查询 | `enterpriseQuery` | 根据关键词模糊查询企业 |
| 企业工商信息查询（简项） | `enterpriseSimple` | 查询企业基本工商信息 |
| 经营异常查询 | `abnormalOperation` | 查询企业经营异常记录 |
| 工商行政处罚查询 | `administrativeSanctionQuery` | 查询行政处罚记录 |
| 企业司法涉诉查询 | `justiceComplain` | 查询司法诉讼记录 |
| 企业大中小微划型服务 | `companyLevel` | 查询企业规模划型 |
| 企业招投标查询 | `enterpriseBidding` | 查询招投标记录 |
| 企业欠税公告查询 | `enterpriseOwnTax` | 查询欠税记录 |
| 静态活体检测 | `faceCheck` | 检测照片是否为活体 |
| 动态活体检测 | `lifeCheck` | 视频多帧活体检测 |
| 身份证 OCR 识别 | `idOcr` | 识别身份证正反面信息 |
| 身份证 OCR V2 识别 | `idOcrV2` | 自动识别正反面 |
| 行驶证 OCR 识别 | `vehicleLicense` | 识别行驶证信息 |

## 技术支持

- **官网**：https://www.253.com
- **文档中心**：https://doc.253.com
- **技术支持**：support@253.com
- **客服电话**：400-889-8080

## 版本历史

### v1.0.0-SNAPSHOT (2026-07-24)

**首次发布**
- 提供短信、国际短信、视频短信全业务能力
- 支持号码服务、实名认证、企业信息查询
- 提供风控、携号转网、OCR 识别等增值服务
- 内置自动重试、链路追踪、资源管理等特性
- Spring Boot 自动装配支持

## 许可证

本项目采用 [Apache License 2.0](LICENSE) 许可证。

## 常见问题 FAQ

### 1. 如何获取 appId 和 appSecret？

登录 253 云通讯管理后台（https://console.253.com），在"应用管理"中创建应用，即可获得 appId 和 appSecret。

### 2. 短信发送失败，提示余额不足？

请登录管理后台充值。短信服务采用预付费模式，需要先充值后使用。

### 3. 如何处理敏感词拦截？

如果短信内容包含敏感词被拦截（错误码 105），请：
1. 检查短信内容是否包含违禁词
2. 联系客服申请白名单（针对正常业务场景）
3. 修改短信内容避开敏感词

### 4. 如何提高发送成功率？

建议：
1. 使用已审核通过的签名和模板
2. 确保手机号码格式正确且在网
3. 避免在高峰时段大量发送
4. 控制发送频率，避免触发限流

### 5. 支持哪些 Java 版本？

SDK 基于 Java 8 开发，支持 Java 8 及以上版本。

### 6. 如何在 Spring Boot 中使用？

添加依赖后，即可通过 `@Autowired` 注入 `CloudApiClient` 使用。详见"Spring Boot 集成"章节。

### 7. 是否支持异步调用？

当前版本仅支持同步调用。如需异步，可以结合 `CompletableFuture` 或 Spring 的 `@Async` 实现。

### 8. 如何开启调试日志？

SDK 底层使用 SLF4J，可以通过日志框架（如 Logback）配置日志级别：

```xml
<!-- logback.xml -->
<logger name="com.chuanglan.cloudsdk" level="DEBUG"/>
```

### 9. 连接池配置是否可调？

当前版本使用内置的连接池配置。如有特殊需求，请联系技术支持。

### 10. 是否支持 HTTP 代理？

当前版本暂不支持 HTTP 代理配置。如有需求，请联系技术支持。

## 贡献指南

欢迎提交 Issue 和 Pull Request 来改进本项目。

### 提交 Issue

如果您发现 Bug 或有功能建议，请在 [GitHub Issues](https://github.com/chuanglan/cloud-sdk/issues) 中提交。

### 提交 Pull Request

1. Fork 本项目
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 创建 Pull Request

## 许可证

本项目采用 [Apache License 2.0](LICENSE) 许可证。

## 致谢

感谢以下开源项目：

- [OkHttp](https://github.com/square/okhttp) - HTTP 客户端
- [Jackson](https://github.com/FasterXML/jackson) - JSON 序列化
- [Spring Boot](https://spring.io/projects/spring-boot) - 自动装配支持

---

**© 2026 创蓝云智 253.com - 专业的企业通讯服务商**

