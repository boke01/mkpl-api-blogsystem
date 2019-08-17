package com.newegg.mkpl.api.blogsystem.pojo;

/**
 * 文章列表
 *
 * @author vz04
 * @date 8/9/2019 11:10 AM
 **/
public class ArticleListBean {
    private Integer articleId;
    private String headline;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Override
    public String toString() {
        return "ArticleListBean{" +
                "articleId=" + articleId +
                ", headline='" + headline + '\'' +
                '}';
    }
}
