package com.newegg.mkpl.api.blogsystem.util;

import java.security.MessageDigest;

/**
 * Md5加密工具类
 *
 * @author vz04
 * @date 7/27/2019 9:13 AM
 **/

public class Md5Util {
     /**
     * 16进制的字符数组
     */
    private final static String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };



    /**
     * 将字符串加密成密文
     *
     * @date 5:13 PM 7/30/2019
     * @param source 需要加密的原字符串
     * @return String
     */
    public static String md5Encode(String source) {
        String result = null;
        try {
            result = source;
            // 获得MD5摘要对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 使用指定的字节数组更新摘要信息
            messageDigest.update(result.getBytes("UTF-8"));
            // messageDigest.digest()获得16位长度
            result = byteArrayToHexString(messageDigest.digest());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 转换字节数组为16进制字符串
     *
     * @date 5:15 PM 7/30/2019
     * @param bytes 字节数组
     * @return String
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte tem : bytes) {
            stringBuilder.append(byteToHexString(tem));
        }
        return stringBuilder.toString();
    }

    /**
     * 将byte转化成16进制对应的字符
     *
     * @date 5:16 PM 7/30/2019
     * @param b 要转换的byte
     * @return String
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

}
