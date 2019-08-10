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
    public void getArticle () {
        Pack article = articleService.getArticle(1);
        Assert.assertNotNull(article);
    }

    @Test
    public void putArticle() {

    }
}
