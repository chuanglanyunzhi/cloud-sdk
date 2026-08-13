# Cloud SDK 发布到 Maven Central 指南

本文档提供将 cloud-sdk 发布到 Maven Central 公共仓库的完整操作步骤。

---

## 前置条件检查

- [x] GPG 已安装（版本 2.2.29）
- [ ] Sonatype JIRA 账号
- [ ] groupId 授权（com.chuanglan）
- [ ] GPG 密钥对已生成并上传
- [ ] Maven settings.xml 已配置

---

## 第一步：注册 Sonatype JIRA 账号并申请 groupId

### 1.1 注册账号

访问 https://issues.sonatype.org/secure/Signup!default.jspa 注册 Sonatype JIRA 账号。

**重要**：记住你的用户名和密码，后续配置 Maven settings.xml 需要用到。

---

### 1.2 创建 JIRA Issue 申请 groupId

登录后访问：https://issues.sonatype.org/secure/CreateIssue.jspa?issuetype=21&pid=10134

填写以下信息：

| 字段 | 填写内容 |
|------|---------|
| **Project** | Community Support - Open Source Project Repository Hosting (OSSRH) |
| **Issue Type** | New Project |
| **Summary** | Request for com.chuanglan groupId |
| **Group Id** | `com.chuanglan` |
| **Project URL** | 项目主页或 GitHub 地址 |
| **SCM URL** | `https://github.com/your-org/cloud-sdk.git` |
| **Description** | 简单描述项目用途，如："Java SDK for 253 Cloud Communication Services" |

**示例描述**：
```
This is the official Java SDK for 253 Cloud Communication Services (创蓝云通讯).
It provides unified API access for SMS, international SMS, video SMS, number services, 
real-name authentication, enterprise information query, and risk control.
```

---

### 1.3 验证域名所有权

#### 方案一：验证 chuanglan.com 域名（需要域名管理权限）

Sonatype 会要求你在域名 TXT 记录中添加验证内容，如：

```
类型: TXT
主机记录: @
记录值: OSSRH-12345
```

#### 方案二：使用 GitHub 组织域名（推荐，无需验证）

如果没有域名管理权限，建议使用反向域名：

```
Group Id: io.github.your-github-username
或
Group Id: com.github.your-github-org
```

**修改 pom.xml**：
```xml
<groupId>io.github.chuanglan</groupId>
<artifactId>cloud-sdk</artifactId>
```

---

### 1.4 等待审批

- 审批时间：通常 1-2 个工作日（工作时间）
- 审批通过后，Sonatype 会在 JIRA issue 中回复确认
- 确认后才能推送到 Maven Central

---

## 第二步：生成 GPG 密钥对

### 2.1 生成密钥

在命令行执行：

```bash
gpg --gen-key
```

按提示输入：
- **姓名**：你的名字或组织名（如 "Chuanglan Cloud SDK"）
- **邮箱**：你的邮箱（如 "sdk@chuanglan.com"）
- **密码**：设置一个密钥密码（**务必记住**，后续签名需要）

生成完成后会显示密钥 ID，类似：
```
pub   rsa3072 2026-08-13 [SC] [expires: 2028-08-12]
      ABCD1234ABCD1234ABCD1234ABCD1234ABCD1234
uid           Chuanglan Cloud SDK <sdk@chuanglan.com>
sub   rsa3072 2026-08-13 [E] [expires: 2028-08-12]
```

记住这个 40 位密钥 ID（`ABCD1234ABCD1234ABCD1234ABCD1234ABCD1234`）。

---

### 2.2 查看已生成的密钥

```bash
gpg --list-keys
```

---

### 2.3 上传公钥到密钥服务器

Maven Central 需要验证 GPG 签名，必须上传公钥到至少一个公钥服务器。

```bash
# 上传到 keys.openpgp.org
gpg --keyserver keys.openpgp.org --send-keys ABCD1234ABCD1234ABCD1234ABCD1234ABCD1234

# 同时上传到 keyserver.ubuntu.com（推荐）
gpg --keyserver keyserver.ubuntu.com --send-keys ABCD1234ABCD1234ABCD1234ABCD1234ABCD1234
```

将 `ABCD1234ABCD1234ABCD1234ABCD1234ABCD1234` 替换为你的实际密钥 ID。

**验证上传成功**：
访问 https://keys.openpgp.org/ 搜索你的邮箱，应该能查到公钥。

---

### 2.4 导出密钥（可选，用于备份）

```bash
# 导出公钥
gpg --armor --export your-email@example.com > public-key.asc

# 导出私钥（务必安全保管）
gpg --armor --export-secret-keys your-email@example.com > private-key.asc
```

---

## 第三步：配置 Maven settings.xml

编辑 Maven 配置文件（通常在 `C:\Users\ChuangLan\.m2\settings.xml`，如不存在则创建）：

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                              http://maven.apache.org/xsd/settings-1.0.0.xsd">
    
    <!-- Sonatype JIRA 账号 -->
    <servers>
        <server>
            <id>ossrh</id>
            <username>your-sonatype-username</username>
            <password>your-sonatype-password</password>
        </server>
    </servers>
    
    <!-- GPG 密钥密码 -->
    <profiles>
        <profile>
            <id>ossrh</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <gpg.executable>gpg</gpg.executable>
                <gpg.passphrase>your-gpg-passphrase</gpg.passphrase>
            </properties>
        </profile>
    </profiles>
</settings>
```

**替换以下内容**：
- `your-sonatype-username`：Sonatype JIRA 用户名
- `your-sonatype-password`：Sonatype JIRA 密码
- `your-gpg-passphrase`：GPG 密钥密码

---

## 第四步：修改项目 pom.xml

需要在 pom.xml 中添加 Maven Central 要求的元数据和插件配置。

### 4.1 修改 distributionManagement

将 `cloud-sdk/pom.xml` 中的 `<distributionManagement>` 修改为：

```xml
<distributionManagement>
    <snapshotRepository>
        <id>ossrh</id>
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots</url>
    </snapshotRepository>
    <repository>
        <id>ossrh</id>
        <url>https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/</url>
    </repository>
</distributionManagement>
```

---

### 4.2 添加必要的元数据

在 `<project>` 标签下添加（如果缺失）：

```xml
<name>Cloud SDK</name>
<description>Java SDK for 253 Cloud Communication Services</description>
<url>https://github.com/your-org/cloud-sdk</url>

<licenses>
    <license>
        <name>Apache License, Version 2.0</name>
        <url>https://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
    </license>
</licenses>

<developers>
    <developer>
        <id>chuanglan</id>
        <name>Chuanglan Cloud Team</name>
        <email>sdk@chuanglan.com</email>
        <organization>Chuanglan</organization>
        <organizationUrl>https://www.chuanglan.com</organizationUrl>
    </developer>
</developers>

<scm>
    <connection>scm:git:git://github.com/your-org/cloud-sdk.git</connection>
    <developerConnection>scm:git:ssh://github.com:your-org/cloud-sdk.git</developerConnection>
    <url>https://github.com/your-org/cloud-sdk/tree/main</url>
</scm>
```

---

### 4.3 添加发布插件

在 `<build><plugins>` 中添加：

```xml
<!-- Nexus Staging 插件 -->
<plugin>
    <groupId>org.sonatype.plugins</groupId>
    <artifactId>nexus-staging-maven-plugin</artifactId>
    <version>1.6.13</version>
    <extensions>true</extensions>
    <configuration>
        <serverId>ossrh</serverId>
        <nexusUrl>https://s01.oss.sonatype.org/</nexusUrl>
        <autoReleaseAfterClose>true</autoReleaseAfterClose>
    </configuration>
</plugin>

<!-- 源码插件 -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-source-plugin</artifactId>
    <version>3.3.0</version>
    <executions>
        <execution>
            <id>attach-sources</id>
            <goals>
                <goal>jar-no-fork</goal>
            </goals>
        </execution>
    </executions>
</plugin>

<!-- Javadoc 插件 -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-javadoc-plugin</artifactId>
    <version>3.5.0</version>
    <executions>
        <execution>
            <id>attach-javadocs</id>
            <goals>
                <goal>jar</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <encoding>UTF-8</encoding>
        <charset>UTF-8</charset>
        <docencoding>UTF-8</docencoding>
        <failOnError>false</failOnError>
        <doclint>none</doclint>
    </configuration>
</plugin>

<!-- GPG 签名插件 -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-gpg-plugin</artifactId>
    <version>3.1.0</version>
    <executions>
        <execution>
            <id>sign-artifacts</id>
            <phase>verify</phase>
            <goals>
                <goal>sign</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

---

## 第五步：执行发布

### 5.1 清理并构建项目

```bash
cd /d/wangxun/workspace/cloud-sdk
mvn clean install
```

确保构建成功。

---

### 5.2 部署到 Maven Central

```bash
mvn clean deploy
```

这个命令会：
1. 编译代码
2. 运行测试
3. 生成 JAR、源码 JAR、Javadoc JAR
4. 使用 GPG 签名所有文件
5. 上传到 Sonatype OSSRH

**首次执行时可能需要输入 GPG 密钥密码**（如果 settings.xml 未配置）。

---

### 5.3 验证发布状态

1. 登录 https://s01.oss.sonatype.org/
2. 使用 Sonatype JIRA 账号登录
3. 点击左侧 "Staging Repositories"
4. 找到你的 staging repository（状态为 "open"）
5. 选中后点击 "Close" 按钮（触发验证）
6. 等待验证完成（约 5-10 分钟）
7. 验证通过后点击 "Release" 按钮

**如果配置了 `autoReleaseAfterClose=true`**，验证通过后会自动 release。

---

### 5.4 等待同步到 Maven Central

- Release 后，通常 10-30 分钟同步到 Maven Central
- 2-4 小时后可在 Maven Central 搜索到：https://search.maven.org/
- 完整的索引更新可能需要 24 小时

---

## 第六步：验证发布成功

### 6.1 搜索 Maven Central

访问 https://search.maven.org/ 搜索：
```
g:com.chuanglan a:cloud-sdk
```

或直接访问：
```
https://repo1.maven.org/maven2/com/chuanglan/cloud-sdk/1.0.0-SNAPSHOT/
```

---

### 6.2 在项目中测试

在其他项目的 pom.xml 中添加依赖：

```xml
<dependency>
    <groupId>com.chuanglan</groupId>
    <artifactId>cloud-sdk</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

执行 `mvn clean install` 验证是否能正确下载。

---

## 常见问题

### Q1: GPG 签名失败

**错误信息**：
```
gpg: signing failed: Inappropriate ioctl for device
```

**解决方法**：
```bash
export GPG_TTY=$(tty)
```

或在 `~/.bashrc` 中添加：
```bash
export GPG_TTY=$(tty)
```

---

### Q2: Javadoc 生成失败

**错误信息**：
```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-javadoc-plugin
```

**解决方法**：
已在插件配置中添加 `<failOnError>false</failOnError>` 和 `<doclint>none</doclint>`。

如仍失败，可临时跳过 Javadoc：
```bash
mvn clean deploy -Dmaven.javadoc.skip=true
```

---

### Q3: 401 Unauthorized

**错误信息**：
```
[ERROR] Failed to execute goal ... Return code is: 401, ReasonPhrase: Unauthorized
```

**原因**：settings.xml 中的 Sonatype 账号密码配置错误。

**解决方法**：
- 检查 `~/.m2/settings.xml` 中的 `<server><id>ossrh</id>` 配置
- 确认用户名密码正确
- 确认 groupId 已通过审批

---

### Q4: 首次发布需要多久？

- **Sonatype 审批**：1-2 个工作日
- **首次发布验证**：5-10 分钟
- **同步到 Maven Central**：10-30 分钟
- **搜索索引更新**：2-24 小时

---

### Q5: SNAPSHOT 版本如何发布？

SNAPSHOT 版本会自动发布到 snapshot 仓库，无需 Close/Release 操作。

用户需在 pom.xml 中添加 snapshot 仓库配置：

```xml
<repositories>
    <repository>
        <id>ossrh-snapshots</id>
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
```

---

## 后续版本发布

完成首次发布后，后续版本只需：

1. 修改 `pom.xml` 中的版本号
2. 执行 `mvn clean deploy`
3. 等待自动同步

无需再次申请 groupId 授权。

---

## 发布正式版本建议

当前版本是 `1.0.0-SNAPSHOT`，建议首次发布到 Maven Central 时使用正式版本号：

```xml
<version>1.0.0</version>
```

SNAPSHOT 版本主要用于开发阶段，正式发布应使用稳定版本号。

---

## 参考资料

- [Sonatype OSSRH Guide](https://central.sonatype.org/publish/publish-guide/)
- [Maven GPG Plugin](https://maven.apache.org/plugins/maven-gpg-plugin/)
- [Nexus Staging Plugin](https://github.com/sonatype/nexus-maven-plugins)

---

**文档更新时间**：2026/08/13
