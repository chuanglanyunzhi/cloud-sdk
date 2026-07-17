package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.core.CloudSdkModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 更新账户地址请求。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RcsSmsAccountAddressUpdateRequest extends CloudSdkModel {

    /**
     * 地址信息。
     */
    public String address;

    /**
     * 联系人姓名。
     */
    public String contactName;

    /**
     * 联系人电话。
     */
    public String contactPhone;

    /**
     * 邮政编码。
     */
    public String postCode;

    public RcsSmsAccountAddressUpdateRequest setAddress(String address) {
        this.address = address;
        return this;
    }

    public RcsSmsAccountAddressUpdateRequest setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public RcsSmsAccountAddressUpdateRequest setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
        return this;
    }

    public RcsSmsAccountAddressUpdateRequest setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }
}
