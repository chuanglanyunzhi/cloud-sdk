package com.chuanglan.cloudsdk.api.intSms;

import com.chuanglan.cloudsdk.api.api.ApiCommonResponse;

/**
 * International SMS common response base class.
 */
public class IntSmsCommonResponse extends ApiCommonResponse {

    @Override
    public boolean isSuccess() {
        return "000000".equals(getCode());
    }
}
