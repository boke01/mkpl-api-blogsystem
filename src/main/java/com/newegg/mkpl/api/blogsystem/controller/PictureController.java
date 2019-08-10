package com.newegg.mkpl.api.blogsystem.controller;

import com.newegg.mkpl.api.blogsystem.enums.StateEnum;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;
import com.newegg.mkpl.api.blogsystem.service.PictureService;
import com.newegg.mkpl.api.blogsystem.util.PoolStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 图片相关的api
 * @author vz04
 * @date 8/10/2019 9:04 AM
 **/
@RestController
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @Value("${upload.path}")
    String path;

    /**
     * 上传图片的api
     *
     * @date 9:18 AM 8/10/2019
     * @param file 图片
     * @return Pack
     */
    @PostMapping("/manage/upload/picture")
    public Pack postPicture(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            return pictureService.postPicture(file);
        }else {
            return new Pack().fail(StateEnum.FAIL.value(), PoolStatic.NO_FILE);
        }
    }

    /**
     * 获取图片
     *
     * @date 4:48 PM 8/10/2019
     * @param fileName 文件名称
     * @param response HttpServletResponse
     * @return Pack
     */
    @GetMapping("/get/picture/{fileName}")
    public Pack getPicture(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        path = System.getProperty("user.dir") + path+fileName;
        File file = new File(path);
        FileInputStream in_file = new FileInputStream(file);
        MultipartFile multi = new MockMultipartFile(fileName,in_file);
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String hande = "image/"+suffix;
        response.setContentType(hande);
        response.getOutputStream().write(multi.getBytes());
        return new Pack().success("");
    }



}
