package com.newegg.mkpl.api.blogsystem.util;

import java.util.regex.Pattern;

/**
 * 正则校验的工具类
 * @author vz04
 * @date 8/9/2019 3:30 PM
 **/
public class RegularUtil {

    /**
     * 判断字符串是不是url
     *
     * @date 3:39 PM 8/9/2019
     * @param url 要校验的url
     * @return true:是URL；false:不是URL
     */
    public static boolean isUrl(String url) {
//        String regex = "[0-9]{13}+(.JPEG|.jpeg|.JPG|.jpg|.png|.PNG)$";
        String regex = "^(http|www|ftp|)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?" +
                "(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*" +
                "(\\w*:)*(\\w*\\+)*(\\w*\\.)*" +
                "(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$";
        return Pattern.matches(regex, url);
    }

    /**
     * 判断字符串是否是Email
     *
     * @date 4:43 PM 8/9/2019
     * @param email 要验证的email
     * @return true:是Email；false:不是Email
     */
    public static boolean isEmail(String email) {
        String regex = "^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return Pattern.matches(regex,email);
    }

    /**
     * 判断是否是图片文件
     *
     * @date 9:21 AM 8/10/2019
     * @param fileName 文件名
     * @return true:是图片文件；false:不是图片文件
     */
    public static boolean isPicture(String fileName){
        String regex = ".+(.JPEG|.jpeg|.JPG|.jpg|.png)$";
        return Pattern.matches(regex,fileName);
    }
}
