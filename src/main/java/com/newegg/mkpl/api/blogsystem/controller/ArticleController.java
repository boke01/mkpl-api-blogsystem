package com.newegg.mkpl.api.blogsystem.controller;

import com.newegg.mkpl.api.blogsystem.pojo.ArticleBean;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;
import com.newegg.mkpl.api.blogsystem.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author vz04
 * @date 8/10/2019 2:19 PM
 **/
@CrossOrigin(origins = "http://localhost:4200" ,allowCredentials = "true")
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 新增文章
     *
     * @date 2:45 PM 8/10/2019
     * @param articleBean 字段：headline synopsis content pictureAddress
     * @return Pack
     */
    @PostMapping("/manage/post/article")
    public Pack postArticle(@RequestBody ArticleBean articleBean) {
        return articleService.postArticle(articleBean);
    }

    /**
     * 获取文章内容
     *
     * @date 2:50 PM 8/10/2019
     * @param map 字段：articleId
     * @return Pack
     */
    @PostMapping("/get/article")
    public Pack getArticle(@RequestBody Map<String,Integer> map) {
        return articleService.getArticle(map.get("articleId"));
    }

    /**
     * 修改文章
     *
     * @date 2:56 PM 8/10/2019
     * @param articleBean 字段：articleId headline synopsis content pictureAddress
     * @return Pack
     */
    @PostMapping("/manage/put/article")
    public Pack putArticle(@RequestBody ArticleBean articleBean) {
        return articleService.putArticle(articleBean);
    }

    /**
     * 删除文章
     *
     * @date 2:57 PM 8/10/2019
     * @param map 字段：articleId
     * @return Pack
     */
    @PostMapping("/manage/delete/article")
    public Pack deleteArticle(@RequestBody Map<String,Integer> map) {
        return articleService.deleteArticle(map.get("articleId"));
    }

    /**
     * 获取用户使用的文章列表
     *
     * @date 3:01 PM 8/10/2019
     * @param map 字段 pageNum 页码
     * @return Pack
     */
    @PostMapping("/get/article-list-user")
    public Pack getArticleListUser(@RequestBody Map<String,Integer> map) {
        return articleService.getArticleListUser(map.get("pageNum"));
    }

    /**
     * 获取管理用的文章列表
     *
     * @date 3:05 PM 8/10/2019
     * @param map 字段 pageNum 页码
     * @return Pack
     */
    @PostMapping("/manage/get/article-list-manage")
    public Pack getArticleListManage(@RequestBody Map<String,Integer> map) {
        return articleService.getArticleListManage(map.get("pageNum"));
    }

    /**
     * 获取普通的文章列表
     *
     * @date 3:06 PM 8/10/2019
     * @return Pack
     */
    @PostMapping("/manage/get/article-list")
    public Pack getArticleList() {
        return articleService.getArticleList();
    }

    /**
     * 增加阅读量
     *
     * @date 3:07 PM 8/10/2019
     * @param map 字段：articleId
     * @return Pack
     */
    @PostMapping("/manage/put/reading-quantity")
    public Pack putReadingQuantity(@RequestBody Map<String,Integer> map) {
        return articleService.putReadingQuantity(map.get("articleId"));
    }
}
