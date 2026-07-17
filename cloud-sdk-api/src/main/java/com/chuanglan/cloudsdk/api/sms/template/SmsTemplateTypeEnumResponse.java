package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;

import java.util.List;

/**
 * 查询模板类型枚举响应。
 */
public class SmsTemplateTypeEnumResponse extends SmsCommonResponse {

    public Data data;

    public SmsTemplateTypeEnumResponse setData(Data data) {
        this.data = data;
        return this;
    }

    public static class Data {
        public List<TypeEnumItem> variableTypes;
        public List<TypeEnumItem> mobileTypes;
        public List<TypeEnumItem> urlTypes;
        public List<BusinessTypeItem> businessTypes;
    }

    public static class TypeEnumItem extends SmsCommonResponse {
        public String id;
        public String type;
    }

    public static class BusinessTypeItem extends SmsCommonResponse {
        public String id;
        public String type;
        public List<TypeEnumItem> details;
    }
}
