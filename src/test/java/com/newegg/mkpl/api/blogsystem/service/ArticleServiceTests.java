package com.newegg.mkpl.api.blogsystem.service;

import com.newegg.mkpl.api.blogsystem.pojo.ArticleBean;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试文章管理业务
 * @author vz04
 * @date 8/10/2019 8:10 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTests {
    @Autowired
    private ArticleService articleService;

    /**
     * 测试添加文章
     *
     * @date 8:52 AM 8/10/2019
     */
    @Test
    public void postArticle() {
        ArticleBean article = new ArticleBean();
        article.setHeadline("测试标题2");
        article.setSynopsis("测试简介2");
        article.setContent("测试内容2");
        article.setPictureAddress("http://127.0.0.1:8080/test.jpg");
        Pack pack = articleService.postArticle(article);
        Assert.assertNotNull(pack);
    }

    /**
     * 测试获取文章内容
     *
     * @date 8:59 AM 8/10/2019
     */
    @Test
    public void getArticle() {
        Pack article = articleService.getArticle(1);
        Assert.assertNotNull(article);
    }

    /**
     * 修改文章
     *
     * @date 9:09 AM 8/13/2019
     */
    @Test
    public void putArticle() {
        ArticleBean article = new ArticleBean();
        article.setArticleId(2);
        article.setHeadline("测试标题2");
        article.setSynopsis("测试简介2");
        article.setContent("测试内容2");
        article.setPictureAddress("http://127.0.0.1:8080/test.jpg");
        Pack pack = articleService.putArticle(article);
        System.out.println(pack);
        Assert.assertNotNull(pack);
    }

    /**
     * 删除文章与相关评论
     *
     * @date 9:19 AM 8/13/2019
     */
    @Test
    public void deleteArticle() {
        Pack pack = articleService.deleteArticle(2);
        System.out.println(pack);
        Assert.assertNotNull(pack);
    }

    /**
     * 获取用户使用的文章列表(分页包装)
     *
     * @date 8:50 AM 8/13/2019
     */
    @Test
    public void getArticleListUser() {
        Pack articleListUser = articleService.getArticleListUser(1);
        System.out.println(articleListUser.toString());
        Assert.assertNotNull(articleListUser);
    }

    /**
     * 获取管理用的文章列表d
     *
     * @date 9:21 AM 8/13/2019
     */
    @Test
    public void getArticleListManage() {
        Pack articleListManage = articleService.getArticleListManage(1);
        System.out.println(articleListManage);
        Assert.assertNotNull(articleListManage);
    }

    /**
     * 获取普通的文章列表
     *
     * @date 9:22 AM 8/13/2019
     */
    @Test
    public void getArticleList() {
        Pack articleList = articleService.getArticleList();
        System.out.println(articleList);
        Assert.assertNotNull(articleList);
    }

    /**
     * 增加阅读量
     *
     * @date 9:23 AM 8/13/2019
     */
    @Test
    public void putReadingQuantity() {
        Pack pack = articleService.putReadingQuantity(1);
        System.out.println(pack);
        Assert.assertNotNull(pack);
    }
}
