package com.newegg.mkpl.api.blogsystem.controller;

import com.newegg.mkpl.api.blogsystem.pojo.CommentBean;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;
import com.newegg.mkpl.api.blogsystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 评论相关的api
 * @author vz04
 * @date 8/10/2019 3:10 PM
 **/
@CrossOrigin
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 新增评论
     *
     * @date 3:13 PM 8/10/2019
     * @param commentBean 字段：articleId visitorName email content
     * @return Pack
     */
    @PostMapping("/post/comment")
    public Pack postComment(@RequestBody CommentBean commentBean) {
        return commentService.postComment(commentBean);
    }

    /**
     * 获取用户看的评论列表
     *
     * @date 3:17 PM 8/10/2019
     * @param map 字段 articleId
     * @return Pack
     */
    @PostMapping("/get/comment-list")
    public Pack getCommentList(@RequestBody Map<String,Integer> map) {
        return commentService.getCommentList(map.get("articleId"));
    }

    /**
     * 获取管理员看的评论列表
     *
     * @date 3:21 PM 8/10/2019
     * @param map 字段 articleId, pageNum 页码
     * @return Pack
     */
    @PostMapping("/manage/get/comment")
    public Pack getComment(@RequestBody Map<String,Integer> map) {
        return commentService.getComment(map.get("articleId"),map.get("pageNum"));
    }

    /**
     * 删除评论
     *
     * @date 3:22 PM 8/10/2019
     * @param map 字段：commentId
     * @return Pack
     */
    @PostMapping("/manage/delete/comment")
    public Pack deleteComment(@RequestBody Map<String,Integer> map) {
        return commentService.deleteComment(map.get("commentId"));
    }
}
