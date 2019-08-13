package com.newegg.mkpl.api.blogsystem.service;

import com.newegg.mkpl.api.blogsystem.pojo.ArticleBean;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;

/**
 * 与文章相关的业务接口
 * @author vz04
 * @date 8/9/2019 2:49 PM
 **/
public interface ArticleService {

    /**
     * 新增文章
     *
     * @date 2:54 PM 8/9/2019
     * @param articleBean 文章数据
     * @return Pack
     * @throws RuntimeException RuntimeException
     */
    Pack postArticle(ArticleBean articleBean) throws RuntimeException;

    /**
     * 获取文章内容
     *
     * @date 2:56 PM 8/9/2019
     * @param articleId 文章id
     * @return Pack
     * @throws RuntimeException RuntimeException
     */
    Pack getArticle(Integer articleId) throws RuntimeException;

    /**
     * 修改文章
     *
     * @date 8/9/2019
     * @param articleBean 文章数据
     * @return Pack
     * @throws RuntimeException RuntimeException
     */
    Pack putArticle(ArticleBean articleBean) throws RuntimeException;


    /**
     * 删除文章与相关评论
     *
     * @date 2:58 PM 8/9/2019
     * @param articleId 文章id
     * @return Pack
     * @throws RuntimeException RuntimeException
     */
    Pack deleteArticle(Integer articleId) throws RuntimeException;

    /**
     * 获取用户使用的文章列表
     *
     * @date 3:00 PM 8/9/2019
     * @param pageNum 需要的页数
     * @return Pack
     */
    Pack getArticleListUser(Integer pageNum);

    /**
     * 获取管理用的文章列表
     *
     * @date 8/9/2019
     * @param pageNum 需要的页数
     * @return Pack
     */
    Pack getArticleListManage(Integer pageNum);

    /**
     * 获取普通的文章列表
     *
     * @date 3:01 PM 8/9/2019
     * @return Pack
     */
    Pack getArticleList();

    /**
     * 增加阅读量
     *
     * @date 3:03 PM 8/9/2019
     * @param articleId 文章id
     * @return Pack
     * @throws RuntimeException RuntimeException
     */
    Pack putReadingQuantity(Integer articleId) throws RuntimeException;

}
