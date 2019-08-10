package com.newegg.mkpl.api.blogsystem.mapper;

import com.newegg.mkpl.api.blogsystem.pojo.ArticleBean;
import com.newegg.mkpl.api.blogsystem.pojo.ArticleListBean;
import com.newegg.mkpl.api.blogsystem.pojo.ArticleListManageBean;
import com.newegg.mkpl.api.blogsystem.pojo.ArticleListUserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 与文章相关的数据接口
 * @author vz04
 * @date 8/8/2019 4:45 PM
 **/
@Mapper
@Repository
public interface ArticleMapper {

    /**
     * 新增文章
     *
     * @date 10:42 AM 8/9/2019
     * @param articleBean 文章数据
     * @return Integer
     */
    Integer postArticle(ArticleBean articleBean);

    /**
     * 通过文章id获取文章内容
     *
     * @date 8:52 AM 8/9/2019
     * @param articleId 文章id
     * @return ArticleBean
     */
    ArticleBean getArticle(@Param("articleId") Integer articleId);

    /**
     * 修改文章
     *
     * @date 10:29 AM 8/9/2019
     * @param articleBean 文章数据
     * @return Integer
     */
    Integer putArticle(ArticleBean articleBean);

    /**
     * 删除文章
     *
     * @date 10:48 AM 8/9/2019
     * @param articleId 文章id
     * @return Integer
     */
    Integer deleteArticle(@Param("articleId") Integer articleId);

    /**
     * 获取用户使用的文章列表
     *
     * @date 10:56 AM 8/9/2019
     * @return List<ArticleListUserBean>
     */
    List<ArticleListUserBean> getArticleListUser();

    /**
     * 获取管理用的文章列表
     *
     * @date 11:13 AM 8/9/2019
     * @return List<ArticleListManageBean>
     */
    List<ArticleListManageBean> getArticleListManage();

    /**
     * 获取普通的文章列表
     *
     * @date 11:20 AM 8/9/2019
     * @return List<ArticleListBean>
     */
    List<ArticleListBean> getArticleList();

    /**
     * 查询标题是否存在(通过标题)
     *
     * @date 11:32 AM 8/9/2019
     * @param headline 标题
     * @return Integer
     */
    ArticleBean getHeadline(@Param("headline") String headline);

    /**
     * 查询文章是否存在（通过id）
     *
     * @date 1:17 PM 8/9/2019
     * @param articleId 文章id
     * @return Integer
     */
    Integer getArticleId(@Param("articleId") Integer articleId);

    /**
     * 增加阅读量
     *
     * @date 1:34 PM 8/9/2019
     * @param articleId 文章id
     * @return Integer
     */
    Integer putReadingQuantity(@Param("articleId") Integer articleId);

}
