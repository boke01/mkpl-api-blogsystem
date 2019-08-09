package com.newegg.mkpl.api.blogsystem.mapper;

import com.newegg.mkpl.api.blogsystem.pojo.CommentBean;
import com.newegg.mkpl.api.blogsystem.pojo.CommentListBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论相关的数据接口
 * @author vz04
 * @date 8/9/2019 1:23 PM
 **/
@Mapper
@Repository
public interface CommentMapper {

    /**
     * 新增评论
     *
     * @date 1:26 PM 8/9/2019
     * @param commentBean 评论数据
     * @return Integer
     */
    Integer postComment(CommentBean commentBean);

    /**
     * 评论列表用户
     *
     * @date 2:08 PM 8/9/2019
     * @param articleId 文章id
     * @return List<CommentListBean>
     */
    List<CommentListBean> getCommentList(@Param("articleId") Integer articleId);

    /**
     * 评论列表管理
     *
     * @date 2:08 PM 8/9/2019
     * @param articleId 文章id
     * @return List<CommentBean>
     */
    List<CommentBean> getComment(@Param("articleId") Integer articleId);

    /**
     * 删除评论（通过评论id）
     *
     * @date 2:11 PM 8/9/2019
     * @param commentId 评论id
     * @return Integer
     */
    Integer deleteComment(@Param("commentId") Integer commentId);

    /**
     * 删除一篇文章的全部评论
     *
     * @date 2:12 PM 8/9/2019
     * @param articleId 文章id
     * @return Integer
     */
    Integer deleteCommentAll(@Param("articleId") Integer articleId);
}
