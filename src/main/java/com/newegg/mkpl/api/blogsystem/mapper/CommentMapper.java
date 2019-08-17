package com.newegg.mkpl.api.blogsystem.mapper;

import com.newegg.mkpl.api.blogsystem.pojo.CommentBean;
import com.newegg.mkpl.api.blogsystem.pojo.CommentListBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论相关的数据接口
 *
 * @author vz04
 * @date 8/9/2019 1:23 PM
 **/
@Mapper
@Repository
public interface CommentMapper {

    /**
     * 新增评论
     *
     * @param commentBean 评论数据
     * @return Integer
     * @date 1:26 PM 8/9/2019
     */
    Integer postComment(CommentBean commentBean);

    /**
     * 评论列表用户
     *
     * @param articleId 文章id
     * @return List<CommentListBean>
     * @date 2:08 PM 8/9/2019
     */
    List<CommentListBean> getCommentList(@Param("articleId") Integer articleId);

    /**
     * 评论列表管理
     *
     * @param articleId 文章id
     * @return List<CommentBean>
     * @date 2:08 PM 8/9/2019
     */
    List<CommentBean> getComment(@Param("articleId") Integer articleId);

    /**
     * 删除评论（通过评论id）
     *
     * @param commentId 评论id
     * @return Integer
     * @date 2:11 PM 8/9/2019
     */
    Integer deleteComment(@Param("commentId") Integer commentId);

    /**
     * 删除一篇文章的全部评论
     *
     * @param articleId 文章id
     * @return Integer
     * @date 2:12 PM 8/9/2019
     */
    Integer deleteCommentAll(@Param("articleId") Integer articleId);
}
