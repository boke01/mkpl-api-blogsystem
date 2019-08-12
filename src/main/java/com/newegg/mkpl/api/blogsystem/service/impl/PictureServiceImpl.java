package com.newegg.mkpl.api.blogsystem.service.impl;

import com.newegg.mkpl.api.blogsystem.enums.StateEnum;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;
import com.newegg.mkpl.api.blogsystem.service.PictureService;
import com.newegg.mkpl.api.blogsystem.util.PoolStatic;
import com.newegg.mkpl.api.blogsystem.util.RegularUtil;
import com.newegg.mkpl.api.blogsystem.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件相关的业务
 * @author vz04
 * @date 8/10/2019 9:15 AM
 **/
@Service
public class PictureServiceImpl implements PictureService {
    @Value("${upload.path}")
    String path;
    /**
     * 添加文件的业务
     *
     * @date 9:16 AM 8/10/2019
     * @param file 图片文件
     * @return Pack
     */
    @Override
    public Pack postPicture(MultipartFile file) throws RuntimeException, IOException {
        String fileName = file.getOriginalFilename();
        if (!RegularUtil.isPicture(fileName)){
            return new Pack().fail(StateEnum.FAIL.value(), PoolStatic.NOT_PICTURE);
        }
        String name = FileUtil.savePicture(file, path);
        String url = "/get/picture/"+name;
        if (name == null) {
            return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.POST_FAIL);
        }
        return new Pack().success(PoolStatic.POST_SUCCESS,url);
    }
}
