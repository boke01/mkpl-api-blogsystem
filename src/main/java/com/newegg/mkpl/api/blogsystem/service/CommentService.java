package com.newegg.mkpl.api.blogsystem.service;

import com.newegg.mkpl.api.blogsystem.pojo.CommentBean;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;

/**
 * 与评论相关的业务接口
 *
 * @author vz04
 * @date 8/9/2019 2:49 PM
 **/
public interface CommentService {

    /**
     * 新增评论
     *
     * @param commentBean 评论数据
     * @return Pack
     * @throws RuntimeException RuntimeException
     * @date 8/9/2019
     */
    Pack postComment(CommentBean commentBean) throws RuntimeException;

    /**
     * 获取用户看的评论列表
     *
     * @param articleId 文章id
     * @return Pack
     * @throws RuntimeException RuntimeException
     * @date 3:05 PM 8/9/2019
     */
    Pack getCommentList(Integer articleId) throws RuntimeException;

    /**
     * 获取管理员看的评论列表
     *
     * @param articleId 文章id
     * @param pageNum   页码
     * @return Pack
     * @throws RuntimeException RuntimeException
     * @date 3:06 PM 8/9/2019
     */
    Pack getComment(Integer articleId, Integer pageNum) throws RuntimeException;

    /**
     * 删除评论（通过评论id）
     *
     * @param commentId 评论id
     * @return Pack
     * @throws RuntimeException RuntimeException
     * @date 3:08 PM 8/9/2019
     */
    Pack deleteComment(Integer commentId) throws RuntimeException;
}
