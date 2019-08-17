package com.newegg.mkpl.api.blogsystem.pojo;

import java.sql.Timestamp;

/**
 * 给用户使用的文章列表
 *
 * @author vz04
 * @date 8/9/2019 11:10 AM
 **/
public class ArticleListUserBean {
    private Integer articleId;
    private String headline;
    private Integer readingQuantity;
    private String pictureAddress;
    private Timestamp lastEditDate;

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

    public Integer getReadingQuantity() {
        return readingQuantity;
    }

    public void setReadingQuantity(Integer readingQuantity) {
        this.readingQuantity = readingQuantity;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public Timestamp getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Timestamp lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    @Override
    public String toString() {
        return "ArticleListUserBean{" +
                "articleId=" + articleId +
                ", headline='" + headline + '\'' +
                ", readingQuantity=" + readingQuantity +
                ", pictureAddress='" + pictureAddress + '\'' +
                ", lastEditDate=" + lastEditDate +
                '}';
    }
}
