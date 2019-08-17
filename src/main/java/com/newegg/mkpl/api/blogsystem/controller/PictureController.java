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

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

/**
 * 图片相关的api
 *
 * @author vz04
 * @date 8/10/2019 9:04 AM
 **/
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @Value("${upload.path}")
    private String uploadPath;

    /**
     * 上传图片的api
     *
     * @param file 图片
     * @return Pack
     * @date 9:18 AM 8/10/2019
     */
    @PostMapping("/manage/upload/picture")
    public Pack postPicture(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            return pictureService.postPicture(file);
        } else {
            return new Pack().fail(StateEnum.FAIL.value(), PoolStatic.NO_FILE);
        }
    }

    /**
     * 获取图片
     *
     * @param fileName 文件名称
     * @param response HttpServletResponse
     * @date 4:48 PM 8/10/2019
     */
    @GetMapping("/get/picture/{fileName}")
    public void getPicture(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        String path = System.getProperty("user.dir") + uploadPath + fileName;
        File file = new File(path);
        FileInputStream inFile = new FileInputStream(file);
        MultipartFile multi = new MockMultipartFile(fileName, inFile);
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String hande = "image/" + suffix;
        response.setContentType(hande);
        response.getOutputStream().write(multi.getBytes());
    }


}
