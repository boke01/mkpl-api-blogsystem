package com.newegg.mkpl.api.blogsystem.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 保存文件的工具类
 *
 * @author vz04
 * @date 8/10/2019 9:31 AM
 **/
public class FileUtil {

    /**
     * 将文件保存到指定路径
     *
     * @param file 文件
     * @param path 保存路径
     * @return 文件名
     * @date 11:17 AM 8/10/2019
     */
    public static String savePicture(MultipartFile file, String path) throws IOException {
        File catalog = new File(System.getProperty("user.dir") + path);
        if (!catalog.exists()) {
            catalog.mkdirs();
        }
        Date date = new Date();
        long name = date.getTime();
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newFileName = name + "." + suffix;
        File newFile = new File(System.getProperty("user.dir") + path, newFileName);
        file.transferTo(newFile);
        if (newFile.exists()) {
            return newFile.getName();
        } else {
            return null;
        }
    }

    /**
     * 删除图片
     *
     * @param fileName 文件名
     * @return boolean
     * @date 10:38 AM 8/13/2019
     */
    public static boolean deletePicture(String fileName, String path) {
        File file = new File(System.getProperty("user.dir") + path + fileName);
        return file.isFile() && file.delete();
    }
}