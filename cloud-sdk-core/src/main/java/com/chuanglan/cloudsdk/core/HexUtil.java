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
    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] chars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            chars[i * 2] = HEX_DIGITS[v >>> 4];
            chars[i * 2 + 1] = HEX_DIGITS[v & 0x0F];
        }
        return new String(chars);
    }
}
