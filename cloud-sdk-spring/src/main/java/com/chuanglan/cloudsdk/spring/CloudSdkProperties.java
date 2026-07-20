package com.chuanglan.cloudsdk.spring;

import com.chuanglan.cloudsdk.api.CloudApiConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Spring Boot 配置绑定类，对应 {@code application.yml} / {@code application.properties} 中
 * 以 {@code cloudsdk.*} 为前缀的全部属性。
 *
 * <p>典型用法（{@code application.yml}）：
 * <pre>{@code
 * cloudsdk:
 *   endpoints:
 *     number: https://wskh.253.com
 *     sms: https://smssh.253.com
 *   timeouts:
 *     connect: 10000
 *     read: 10000
 * }</pre>
 *
 * <p>所有字段均可选；不配置时 SDK 使用 {@link CloudApiConfig} 内置默认值。
 * 凭证（appId/appSecret）需在每次 API 调用时显式传入，不在配置文件中管理。
 */
@ConfigurationProperties(prefix = "cloudsdk")
public class CloudSdkProperties {

    /**
     * 各业务线接入地址。未设置时使用 {@link CloudApiConfig} 内置默认值。
     */
    private Endpoints endpoints = new Endpoints();

    /**
     * 超时配置（毫秒）。
     */
    private Timeouts timeouts = new Timeouts();

    public Endpoints getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Endpoints endpoints) {
        this.endpoints = endpoints;
    }

    public Timeouts getTimeouts() {
        return timeouts;
    }

    public void setTimeouts(Timeouts timeouts) {
        this.timeouts = timeouts;
    }

    /**
     * 转换为 SDK 内部配置对象。未设置的字段保留 SDK 默认值。
     */
    public CloudApiConfig toCloudApiConfig() {
        CloudApiConfig config = new CloudApiConfig();
        if (endpoints.getNumber() != null) {
            config.setNumberEndpoint(endpoints.getNumber());
        }
        if (endpoints.getNumberCarrier() != null) {
            config.setNumberCarrierEndpoint(endpoints.getNumberCarrier());
        }
        if (endpoints.getRisk() != null) {
            config.setRiskEndpoint(endpoints.getRisk());
        }
        if (endpoints.getMnp() != null) {
            config.setMnpEndpoint(endpoints.getMnp());
        }
        if (endpoints.getSms() != null) {
            config.setSmsEndpoint(endpoints.getSms());
        }
        if (endpoints.getSmsApi() != null) {
            config.setSmsApiEndpoint(endpoints.getSmsApi());
        }
        if (endpoints.getIntSms() != null) {
            config.setIntSmsEndpoint(endpoints.getIntSms());
        }
        if (endpoints.getRcsSms() != null) {
            config.setRcsSmsEndpoint(endpoints.getRcsSms());
        }
        if (endpoints.getRealName() != null) {
            config.setRealNameEndpoint(endpoints.getRealName());
        }
        if (endpoints.getRealNameApi() != null) {
            config.setRealNameApiEndpoint(endpoints.getRealNameApi());
        }
        if (endpoints.getWool() != null) {
            config.setWoolEndpoint(endpoints.getWool());
        }
        if (endpoints.getBusiness() != null) {
            config.setBusinessEndpoint(endpoints.getBusiness());
        }
        if (timeouts.getConnect() != null) {
            config.setConnectTimeout(timeouts.getConnect());
        }
        if (timeouts.getRead() != null) {
            config.setReadTimeout(timeouts.getRead());
        }
        return config;
    }

    public static class Endpoints {
        /** 号码业务接入地址。 */
        private String number;
        /** 号码运营商业务接入地址。 */
        private String numberCarrier;
        /** 风控业务接入地址。 */
        private String risk;
        /** 携号转网业务接入地址。 */
        private String mnp;
        /** 短信业务接入地址。 */
        private String sms;
        /** 短信管理类接口接入地址。 */
        private String smsApi;
        /** 国际短信接入地址（上海/香港节点等）。 */
        private String intSms;
        /** 视频短信（RCS）接入地址。 */
        private String rcsSms;
        /** 实名认证业务接入地址。 */
        private String realName;
        /** 实名认证详细版 API 接入地址。 */
        private String realNameApi;
        /** 羊毛党检测接入地址。 */
        private String wool;
        /** 业务线接入地址。 */
        private String business;

        public String getNumber() { return number; }
        public void setNumber(String number) { this.number = number; }
        public String getNumberCarrier() { return numberCarrier; }
        public void setNumberCarrier(String numberCarrier) { this.numberCarrier = numberCarrier; }
        public String getRisk() { return risk; }
        public void setRisk(String risk) { this.risk = risk; }
        public String getMnp() { return mnp; }
        public void setMnp(String mnp) { this.mnp = mnp; }
        public String getSms() { return sms; }
        public void setSms(String sms) { this.sms = sms; }
        public String getSmsApi() { return smsApi; }
        public void setSmsApi(String smsApi) { this.smsApi = smsApi; }
        public String getIntSms() { return intSms; }
        public void setIntSms(String intSms) { this.intSms = intSms; }
        public String getRcsSms() { return rcsSms; }
        public void setRcsSms(String rcsSms) { this.rcsSms = rcsSms; }
        public String getRealName() { return realName; }
        public void setRealName(String realName) { this.realName = realName; }
        public String getRealNameApi() { return realNameApi; }
        public void setRealNameApi(String realNameApi) { this.realNameApi = realNameApi; }
        public String getWool() { return wool; }
        public void setWool(String wool) { this.wool = wool; }
        public String getBusiness() { return business; }
        public void setBusiness(String business) { this.business = business; }
    }

    public static class Timeouts {
        /** 连接超时（毫秒）。 */
        private Integer connect;
        /** 读取超时（毫秒）。 */
        private Integer read;

        public Integer getConnect() { return connect; }
        public void setConnect(Integer connect) { this.connect = connect; }
        public Integer getRead() { return read; }
        public void setRead(Integer read) { this.read = read; }
    }
}
