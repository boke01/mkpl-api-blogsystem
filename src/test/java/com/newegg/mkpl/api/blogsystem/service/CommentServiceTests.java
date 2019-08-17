package com.newegg.mkpl.api.blogsystem.service;

import com.newegg.mkpl.api.blogsystem.pojo.CommentBean;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 测试评论管理的业务
 *
 * @author vz04
 * @date 8/10/2019 8:12 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTests {
    @Autowired
    private CommentService commentService;

    /**
     * 新增评论
     *
     * @date 11:22 AM 8/13/2019
     */
    @Test
    public void postComment() {
        CommentBean comment = new CommentBean();
        comment.setArticleId(2);
        comment.setVisitorName("test");
        comment.setEmail("123456@123.com");//不能有中文字符
        comment.setContent("test");
        Pack pack = commentService.postComment(comment);
        System.out.println(pack);
        Assert.assertNotNull(pack);
    }

    /**
     * 获取评论-给用户看
     *
     * @date d 8/13/2019
     */
    @Test
    public void getCommentList() {
        Pack commentList = commentService.getCommentList(2);
        System.out.println(commentList);
        Assert.assertNotNull(commentList);
    }

    /**
     * 获取评论-给管理看
     *
     * @date 11:26 AM 8/13/2019
     */
    @Test
    public void getComment() {
        Pack comment = commentService.getComment(2, 1);
        System.out.println(comment);
        Assert.assertNotNull(comment);
    }

    /**
     * 删除评论（通过评论id）
     *
     * @date 11:27 AM 8/13/2019
     */
    @Test
    public void deleteComment() {
        Pack pack = commentService.deleteComment(1);
        System.out.println(pack);
        Assert.assertNotNull(pack);
    }

}
