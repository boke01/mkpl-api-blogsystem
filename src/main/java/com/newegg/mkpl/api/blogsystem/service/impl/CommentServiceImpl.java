package com.newegg.mkpl.api.blogsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newegg.mkpl.api.blogsystem.enums.StateEnum;
import com.newegg.mkpl.api.blogsystem.mapper.ArticleMapper;
import com.newegg.mkpl.api.blogsystem.mapper.CommentMapper;
import com.newegg.mkpl.api.blogsystem.pojo.CommentBean;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;
import com.newegg.mkpl.api.blogsystem.service.CommentService;
import com.newegg.mkpl.api.blogsystem.util.PoolStatic;
import com.newegg.mkpl.api.blogsystem.util.RegularUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论相关的业务实现
 *
 * @author vz04
 * @date 8/9/2019 3:12 PM
 **/
@Service
public class CommentServiceImpl implements CommentService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 新增评论
     *
     * @param commentBean 评论数据
     * @return Pack
     * @date 4:33 PM 8/9/2019
     */
    @Override
    public Pack postComment(CommentBean commentBean) throws RuntimeException {
        Integer articleId = commentBean.getArticleId();
        String email = commentBean.getEmail();
        if (articleMapper.getArticleId(articleId) == null) {
            return new Pack().fail(StateEnum.FAIL.value(), PoolStatic.ARTICLE_INEXISTENCE);
        }
        if (!RegularUtil.isEmail(email)) {
            return new Pack().fail(StateEnum.FAIL.value(), PoolStatic.EMAIL_ERROR);
        }
        Integer integer = commentMapper.postComment(commentBean);
        if (integer != 1) {
            log.error("添加评论时出现错误：问题数据" + commentBean.toString());
            return new Pack().fail(StateEnum.FAIL.value(), PoolStatic.POST_FAIL);
        }
        return new Pack().success(PoolStatic.POST_SUCCESS);
    }

    /**
     * 获取评论列表-用户
     *
     * @param articleId 文章id
     * @return Pack
     * @date 4:34 PM 8/9/2019
     */
    @Override
    public Pack getCommentList(Integer articleId) throws RuntimeException {
        return new Pack().success(PoolStatic.GET_SUCCESS, commentMapper.getCommentList(articleId));
    }

    /**
     * 获取评论列表-管理
     *
     * @param articleId 文章id
     * @param pageNum   页码
     * @return Pack
     * @date 4:34 PM 8/9/2019
     */
    @Override
    public Pack getComment(Integer articleId, Integer pageNum) throws RuntimeException {
        PageHelper.startPage(pageNum, PoolStatic.PAGE_SIZE);
        List<CommentBean> comment = commentMapper.getComment(articleId);
        PageInfo<CommentBean> commentPageInfo = new PageInfo<>(comment);
        return new Pack().success(PoolStatic.GET_SUCCESS, commentPageInfo);
    }

    /**
     * 删除评论
     *
     * @param commentId 评论id
     * @return Pack
     * @date 4:35 PM 8/9/2019
     */
    @Override
    public Pack deleteComment(Integer commentId) throws RuntimeException {
        Integer integer = commentMapper.deleteComment(commentId);
        if (integer != 1) {
            return new Pack().fail(StateEnum.FAIL.value(), PoolStatic.DELETE_FAIL);
        }
        return new Pack().success(PoolStatic.DELETE_SUCCESS);
    }
}
