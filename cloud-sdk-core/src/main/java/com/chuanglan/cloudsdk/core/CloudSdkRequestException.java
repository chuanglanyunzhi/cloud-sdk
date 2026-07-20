package com.chuanglan.cloudsdk.core;

/**
 * HTTP/网络请求异常，携带 statusCode 和 requestId。
 *
 * <p>继承 {@link CloudSdkException}，现有 {@code catch(CloudSdkException)} 无需修改。
 * 需要区分网络异常和参数校验异常的调用方可精确 catch 本类。
 */
public class CloudSdkRequestException extends CloudSdkException {

    public CloudSdkRequestException(String code, String message, String requestId, int statusCode) {
        super(code, message, requestId, statusCode);
    }

    public CloudSdkRequestException(String code, String message, String requestId, int statusCode, Throwable cause) {
        super(code, message, requestId, statusCode, cause);
    }
}
