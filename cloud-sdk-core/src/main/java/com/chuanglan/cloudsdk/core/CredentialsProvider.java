package com.chuanglan.cloudsdk.core;

/**
 * 凭证提供者接口。
 */
public interface CredentialsProvider {

    Credentials getCredentials() throws CloudSdkException;
}
