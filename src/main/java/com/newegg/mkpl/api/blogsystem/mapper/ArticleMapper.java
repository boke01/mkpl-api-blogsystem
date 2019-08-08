package com.newegg.mkpl.api.blogsystem.mapper;

import com.newegg.mkpl.api.blogsystem.pojo.ArticleBean;


/**
 * 与文章相关的数据接口
 * @author vz04
 * @date 8/8/2019 4:45 PM
 **/

public interface ArticleMapper {

    ArticleBean getArticle(Integer articleId);
}
