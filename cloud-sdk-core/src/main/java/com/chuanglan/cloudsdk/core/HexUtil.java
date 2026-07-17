package com.chuanglan.cloudsdk.core;

/**
 * 十六进制工具类。
 */
public final class HexUtil {

    private HexUtil() {
    }

    /**
     * 将字节数组转换为小写 16 进制字符串。
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
