package com.chuanglan.cloudsdk.api.sms.template;

import com.chuanglan.cloudsdk.api.sms.SmsCommonResponse;

import java.util.List;

/**
 * 查询模板类型枚举响应。
 */
public class SmsTemplateTypeEnumResponse extends SmsCommonResponse {

    private Data data;

    public SmsTemplateTypeEnumResponse setData(Data data) {
        this.data = data;
        return this;
    }

    public static class Data {
        private List<TypeEnumItem> variableTypes;
        private List<TypeEnumItem> mobileTypes;
        private List<TypeEnumItem> urlTypes;
        private List<BusinessTypeItem> businessTypes;

        public List<TypeEnumItem> getVariableTypes() {
            return this.variableTypes;
        }

        public List<TypeEnumItem> getMobileTypes() {
            return this.mobileTypes;
        }

        public List<TypeEnumItem> getUrlTypes() {
            return this.urlTypes;
        }

        public List<BusinessTypeItem> getBusinessTypes() {
            return this.businessTypes;
        }
    }

    public static class TypeEnumItem extends SmsCommonResponse {
        private String id;
        private String type;

        public String getId() {
            return this.id;
        }

        public String getType() {
            return this.type;
        }
    }

    public static class BusinessTypeItem extends SmsCommonResponse {
        private String id;
        private String type;
        private List<TypeEnumItem> details;

        public String getId() {
            return this.id;
        }

        public String getType() {
            return this.type;
        }

        public List<TypeEnumItem> getDetails() {
            return this.details;
        }
    }

    public Data getData() {
        return this.data;
    }
}
