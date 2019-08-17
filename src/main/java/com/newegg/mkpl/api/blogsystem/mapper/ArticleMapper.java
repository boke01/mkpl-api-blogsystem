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
 *
 * @author vz04
 * @date 8/8/2019 4:45 PM
 **/
@Mapper
@Repository
public interface ArticleMapper {

    /**
     * 新增文章
     *
     * @param articleBean 文章数据
     * @return Integer
     * @date 10:42 AM 8/9/2019
     */
    Integer postArticle(ArticleBean articleBean);

    /**
     * 通过文章id获取文章内容
     *
     * @param articleId 文章id
     * @return ArticleBean
     * @date 8:52 AM 8/9/2019
     */
    ArticleBean getArticle(@Param("articleId") Integer articleId);

    /**
     * 修改文章
     *
     * @param articleBean 文章数据
     * @return Integer
     * @date 10:29 AM 8/9/2019
     */
    Integer putArticle(ArticleBean articleBean);

    /**
     * 删除文章
     *
     * @param articleId 文章id
     * @return Integer
     * @date 10:48 AM 8/9/2019
     */
    Integer deleteArticle(@Param("articleId") Integer articleId);

    /**
     * 获取用户使用的文章列表
     *
     * @return List<ArticleListUserBean>
     * @date 10:56 AM 8/9/2019
     */
    List<ArticleListUserBean> getArticleListUser();

    /**
     * 获取管理用的文章列表
     *
     * @return List<ArticleListManageBean>
     * @date 11:13 AM 8/9/2019
     */
    List<ArticleListManageBean> getArticleListManage();

    /**
     * 获取普通的文章列表
     *
     * @return List<ArticleListBean>
     * @date 11:20 AM 8/9/2019
     */
    List<ArticleListBean> getArticleList();

    /**
     * 查询标题是否存在(通过标题)
     *
     * @param headline 标题
     * @return Integer
     * @date 11:32 AM 8/9/2019
     */
    ArticleBean getHeadline(@Param("headline") String headline);

    /**
     * 查询文章是否存在（通过id）
     *
     * @param articleId 文章id
     * @return Integer
     * @date 1:17 PM 8/9/2019
     */
    Integer getArticleId(@Param("articleId") Integer articleId);

    /**
     * 增加阅读量
     *
     * @param articleId 文章id
     * @return Integer
     * @date 1:34 PM 8/9/2019
     */
    Integer putReadingQuantity(@Param("articleId") Integer articleId);

    /**
     * 获取图片路径
     *
     * @param articleId 文章id
     * @return String
     * @date 11:03 AM 8/13/2019
     */
    String getPictureUrl(@Param("articleId") Integer articleId);
}
