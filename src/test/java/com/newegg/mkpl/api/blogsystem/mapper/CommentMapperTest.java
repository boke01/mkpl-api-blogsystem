package com.newegg.mkpl.api.blogsystem.mapper;

import com.newegg.mkpl.api.blogsystem.pojo.CommentBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author vz04
 * @date 8/9/2019 1:47 PM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 新增评论
     *
     * @date 2:30 PM 8/9/2019
     */
    @Test
    public void postComment() {
        CommentBean comment = new CommentBean();
        comment.setArticleId(1);
        comment.setVisitorName("test");
        comment.setEmail("123456@123.com");//不能有中文字符
        comment.setContent("test");
        System.out.println(comment.toString());
        Assert.assertSame(1,commentMapper.postComment(comment));
    }

    /**
     * 获取评论-给用户看
     *
     * @date 2:33 PM 8/9/2019

     */
    @Test
    public void getCommentList() {
        Assert.assertNotNull(commentMapper.getCommentList(1));
    }

    /**
     * 获取评论-给管理看
     *
     * @date 2:35 PM 8/9/2019
     */
    @Test
    public void getComment() {
        Assert.assertNotNull(commentMapper.getComment(1));
    }

    /**
     * 删除评论（通过评论id）
     *
     * @date 2:38 PM 8/9/2019
     */
    @Test
    public void deleteComment() {
        Assert.assertSame(1,commentMapper.deleteComment(1));
    }

    /**
     * 删除一篇文章的全部评论
     *
     * @date 2:40 PM 8/9/2019
     */
    @Test
    public void deleteCommentAll() {
        Assert.assertNotSame(-1,commentMapper.deleteCommentAll(1));
    }
}
