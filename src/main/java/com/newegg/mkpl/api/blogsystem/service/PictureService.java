package com.newegg.mkpl.api.blogsystem.service;

import com.newegg.mkpl.api.blogsystem.pojo.Pack;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传文件的业务处理
 * @author vz04
 * @date 8/10/2019 9:12 AM
 **/
public interface PictureService {


    /**
     * 添加图片的业务
     *
     * @date 9:13 AM 8/10/2019
     * @param file 图片文件
     * @return Pack
     * @throws RuntimeException RuntimeException
     * @throws IOException IOException
     */
    Pack postPicture(MultipartFile file) throws RuntimeException, IOException;
}
