package com.newegg.mkpl.api.blogsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newegg.mkpl.api.blogsystem.enums.StateEnum;
import com.newegg.mkpl.api.blogsystem.mapper.ArticleMapper;
import com.newegg.mkpl.api.blogsystem.mapper.CommentMapper;
import com.newegg.mkpl.api.blogsystem.pojo.ArticleBean;
import com.newegg.mkpl.api.blogsystem.pojo.ArticleListManageBean;
import com.newegg.mkpl.api.blogsystem.pojo.ArticleListUserBean;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;
import com.newegg.mkpl.api.blogsystem.service.ArticleService;
import com.newegg.mkpl.api.blogsystem.util.FileUtil;
import com.newegg.mkpl.api.blogsystem.util.PoolStatic;
import com.newegg.mkpl.api.blogsystem.util.RegularUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 文章相关的业务实现
 * @author vz04
 * @date 8/9/2019 3:11 PM
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Value("${upload.path}")
    private String path;

    /**
     * 新增文章
     *
     * @date 3:13 PM 8/9/2019
     * @param articleBean 文章数据
     * @return Pack
     */
    @Override
    public Pack postArticle(ArticleBean articleBean) throws RuntimeException {
        String url = articleBean.getPictureAddress();
        String headline = articleBean.getHeadline();
        if (!RegularUtil.isUrl(url)) {
            return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.PICTURE_URL_ERROR);
        }
        if (articleMapper.getHeadline(headline)!=null){
            return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.HEADLINE_EXIST);
        }
        Integer integer = articleMapper.postArticle(articleBean);
        if (integer == 1) {
             return new Pack().success(PoolStatic.POST_SUCCESS);
        }
        log.error("添加文章时出现错误：问题数据"+articleBean.toString());
        return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.POST_FAIL);
    }

    /**
     * 通过文章id获取文章内容
     *
     * @date 3:20 PM 8/9/2019
     * @param articleId 文章id
     * @return Pack
     */
    @Override
    public Pack getArticle(Integer articleId) throws RuntimeException {
        ArticleBean article = articleMapper.getArticle(articleId);
        if (article == null) {
            return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.GET_FAIL);
        }
        return new Pack().success(PoolStatic.GET_SUCCESS,article);
    }

    /**
     * 修改文章
     *
     * @date 3:21 PM 8/9/2019
     * @param articleBean 文章数据
     * @return Pack
     */
    @Override
    public Pack putArticle(ArticleBean articleBean) throws RuntimeException {
        String headline = articleBean.getHeadline();
        ArticleBean article = articleMapper.getHeadline(headline);
        if (!RegularUtil.isUrl(articleBean.getPictureAddress())) {
            return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.PICTURE_URL_ERROR);
        }
        if (article != null) {
            if (!articleBean.getArticleId().equals(article.getArticleId())) {
                return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.HEADLINE_EXIST);
            }
        }
        Integer integer = articleMapper.putArticle(articleBean);
        if (integer != 1) {
            return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.PUT_FAIL);
        }
        return new Pack().success(PoolStatic.PUT_SUCCESS);
    }

    /**
     * 删除文章
     *
     * @date 3:22 PM 8/9/2019
     * @param articleId 文章id
     * @return Pack
     */
    @Override
    public Pack deleteArticle(Integer articleId) throws RuntimeException {
        String pictureUrl = articleMapper.getPictureUrl(articleId);
        String fileName = pictureUrl.substring(pictureUrl.lastIndexOf("/")+1);
        boolean b = FileUtil.deletePicture(fileName, path);
        if (!b){
            return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.DELETE_FAIL);
        }
        Integer integer = articleMapper.deleteArticle(articleId);
        Integer integer1 = commentMapper.deleteCommentAll(articleId);
        if (integer != 1 || integer1 < 0) {
            return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.DELETE_FAIL);
        }
        return new Pack().success(PoolStatic.DELETE_SUCCESS);
    }

    /**
     * 获取用户使用的文章列表(分页包装)
     *
     * @date 3:22 PM 8/9/2019
     * @param pageNum 页码
     * @return Pack
     */
    @Override
    public Pack getArticleListUser(Integer pageNum) {
        PageHelper.startPage(pageNum,PoolStatic.PAGE_SIZE);
        List<ArticleListUserBean> articleListUser = articleMapper.getArticleListUser();
        PageInfo<ArticleListUserBean> articleListUserPageInfo = new PageInfo<>(articleListUser);
        return new Pack().success(PoolStatic.GET_SUCCESS,articleListUserPageInfo);
    }

    /**
     * 获取管理用的文章列表
     *
     * @date 3:24 PM 8/9/2019
     * @param pageNum 页码
     * @return Pack
     */
    @Override
    public Pack getArticleListManage(Integer pageNum) {
        PageHelper.startPage(pageNum,PoolStatic.PAGE_SIZE);
        List<ArticleListManageBean> articleListManage = articleMapper.getArticleListManage();
        PageInfo<ArticleListManageBean> articleListManagePageInfo = new PageInfo<>(articleListManage);
        return new Pack().success(PoolStatic.GET_SUCCESS,articleListManagePageInfo);
    }

    /**
     * 获取普通的文章列表
     *
     * @date 3:24 PM 8/9/2019
     * @return Pack
     */
    @Override
    public Pack getArticleList() {
        return new Pack().success(PoolStatic.GET_SUCCESS,articleMapper.getArticleList());
    }

    /**
     * 增加阅读量
     *
     * @date 3:25 PM 8/9/2019
     * @param articleId 文章id
     * @return Pack
     */
    @Override
    public Pack putReadingQuantity(Integer articleId) throws RuntimeException {
        Integer integer = articleMapper.putReadingQuantity(articleId);
        if (integer != 1){
            return new Pack().fail(StateEnum.FAIL.value(),PoolStatic.PUT_FAIL);
        }
        return new Pack().success(PoolStatic.PUT_SUCCESS);
    }
}
