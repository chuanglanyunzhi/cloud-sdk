package com.chuanglan.cloudsdk.api.rcsSms;

import com.chuanglan.cloudsdk.api.api.ApiCommonResponse;

/**
 * RCS SMS common response base class.
 */
public class RcsSmsCommonResponse extends ApiCommonResponse {

    @Override
    public boolean isSuccess() {
        return "000000".equals(getCode());
    }
}
