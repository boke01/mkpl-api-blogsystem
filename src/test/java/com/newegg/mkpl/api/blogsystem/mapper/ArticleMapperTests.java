package com.newegg.mkpl.api.blogsystem.mapper;

import com.newegg.mkpl.api.blogsystem.pojo.ArticleBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试类
 * @author vz04
 * @date 8/9/2019 9:27 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTests {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 添加文章
     *
     * @date 10:23 AM 8/9/2019
     */
    @Test
    public void postArticle() {
        ArticleBean article = new ArticleBean();
        article.setHeadline("测试标题");//标题重复也会报错
        article.setSynopsis("测试简介");
        article.setContent("测试内容");
        article.setPictureAddress("http");//这里中文会乱码
        Assert.assertSame("添加失败",1,articleMapper.postArticle(article));
    }

    /**
     * 用文章id获取文章
     * 当文章id在数据库中不存在时报错
     *
     * @date 9:39 AM 8/9/2019
     */
    @Test
    public void getArticle() {
        Assert.assertNotNull(articleMapper.getArticle(2));
    }


    /**
     * 修改文章
     * 如果文章不存在报错
     *
     * @date 10:40 AM 8/9/2019
     */
    @Test
    public void putArticle() {
        ArticleBean article = new ArticleBean();
        article.setArticleId(5);
        article.setHeadline("测试标题5");//标题如果重复与其他文章标题重复会报错
        article.setSynopsis("测试简介5");
        article.setContent("测试内容5");
        article.setPictureAddress("http5");//这里中文会乱码
        Assert.assertSame("修改失败",1,articleMapper.putArticle(article));
    }

    /**
     * 删除文章
     * 如果文章不存在报错
     * @date 10:53 AM 8/9/2019
     */
    @Test
    public void deleteArticle() {
        Assert.assertSame(1,articleMapper.deleteArticle(2));
    }

    /**
     * 获取用户用的文章列表
     *
     * @date 11:22 AM 8/9/2019
     */
    @Test
    public void getArticleListUser() {
        Assert.assertNotNull(articleMapper.getArticleListUser());
    }

    /**
     * 获取管理员用的文章列表
     *
     * @date 11:22 AM 8/9/2019
     */
    @Test
    public void getArticleListManage() {
        Assert.assertNotNull(articleMapper.getArticleListManage());
    }

    /**
     * 获取文章列表
     *
     * @date 11:22 AM 8/9/2019
     */
    @Test
    public void getArticleList() {
        Assert.assertNotNull(articleMapper.getArticleList());
    }

    /**
     * 查看标题是否存在
     *
     * @date 12:14 PM 8/9/2019
     */
    @Test
    public void getHeadline() {
        Assert.assertNull(articleMapper.getHeadline("标题"));
    }

    /**
     * 查看文章是否存在
     *
     * @date 1:22 PM 8/9/2019
     */
    @Test
    public void getArticleId() {
        Assert.assertNotNull(articleMapper.getArticleId(6));
    }

    /**
     * 增加浏览
     *
     * @date 1:38 PM 8/9/2019
     */
    @Test
    public void putReadingQuantity() {
        Assert.assertSame(1,articleMapper.putReadingQuantity(6));
    }

}
