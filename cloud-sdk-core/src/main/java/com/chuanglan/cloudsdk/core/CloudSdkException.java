package com.chuanglan.cloudsdk.core;

/**
 * 统一 SDK 运行时异常。
 */
public class CloudSdkException extends RuntimeException {

    private final String code;
    private final String requestId;
    private final int statusCode;

    public CloudSdkException(String code, String message, String requestId, int statusCode) {
        super(message);
        this.code = code;
        this.requestId = requestId;
        this.statusCode = statusCode;
    }

    public CloudSdkException(String code, String message, String requestId, int statusCode, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.requestId = requestId;
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public String getRequestId() {
        return requestId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "CloudSdkException{" +
                "code='" + code + '\'' +
                ", message='" + getMessage() + '\'' +
                ", requestId='" + requestId + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
