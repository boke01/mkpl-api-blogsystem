package com.newegg.mkpl.api.blogsystem.service;

import com.newegg.mkpl.api.blogsystem.pojo.CommentBean;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;

/**
 * 与评论相关的业务接口
 * @author vz04
 * @date 8/9/2019 2:49 PM
 **/
public interface CommentService {

    /**
     * 新增评论
     *
     * @date 8/9/2019
     * @param commentBean 评论数据
     * @return Pack
     * @throws RuntimeException RuntimeException
     */
    Pack postComment(CommentBean commentBean) throws RuntimeException;

    /**
     * 获取用户看的评论列表
     *
     * @date 3:05 PM 8/9/2019
     * @param articleId 文章id
     * @return Pack
     * @throws RuntimeException RuntimeException
     */
    Pack getCommentList(Integer articleId) throws RuntimeException;

    /**
     * 获取管理员看的评论列表
     *
     * @date 3:06 PM 8/9/2019
     * @param articleId 文章id
     * @param pageNum 页码
     * @return Pack
     * @throws RuntimeException RuntimeException
     */
    Pack getComment(Integer articleId, Integer pageNum) throws RuntimeException;

    /**
     * 删除评论（通过评论id）
     *
     * @date 3:08 PM 8/9/2019
     * @param commentId 评论id
     * @return Pack
     * @throws RuntimeException RuntimeException
     */
    Pack deleteComment(Integer commentId) throws RuntimeException;
}
