package com.newegg.mkpl.api.blogsystem.pojo;

/**
 * 评论列表-用户
 *
 * @author vz04
 * @date 8/9/2019 2:13 PM
 **/
public class CommentListBean {
    private String visitorName;
    private String content;

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentListBean{" +
                "visitorName='" + visitorName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
