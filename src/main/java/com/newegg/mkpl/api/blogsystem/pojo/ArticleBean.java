package com.newegg.mkpl.api.blogsystem.pojo;


import java.sql.Timestamp;

/**
 * 文章数据
 *
 * @author vz04
 * @date 8/8/2019 4:50 PM
 **/
public class ArticleBean {

    private Integer articleId;
    private String headline;
    private String synopsis;
    private String content;
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "ArticleBean{" +
                "articleId=" + articleId +
                ", headline='" + headline + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", content='" + content + '\'' +
                ", readingQuantity=" + readingQuantity +
                ", pictureAddress='" + pictureAddress + '\'' +
                ", lastEditDate=" + lastEditDate +
                '}';
    }
}
