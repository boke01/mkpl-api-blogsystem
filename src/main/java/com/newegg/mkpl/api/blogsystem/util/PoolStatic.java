package com.newegg.mkpl.api.blogsystem.util;

/**
 * 常量池
 * @author vz04
 * @date 8/8/2019 3:52 PM
 **/

public class PoolStatic {
    private PoolStatic() {}

    /**
     * 返回数据时的提示信息
     */
    public static final String GET_SUCCESS = "查询成功";
    public static final String GET_FAIL = "查询失败，请检查后重试";
    public static final String POST_SUCCESS = "添加成功";
    public static final String POST_FAIL = "添加失败，请检查后重试";
    public static final String PUT_SUCCESS = "修改成功";
    public static final String PUT_FAIL = "修改失败，请检查后重试";
    public static final String DELETE_SUCCESS = "删除成功";
    public static final String DELETE_FAIL = "删除失败，请检查后重试";
    public static final String HEADLINE_EXIST = "标题已存在";
    public static final String PICTURE_URL_ERROR = "图片路径错误";
    public static final String EMAIL_ERROR = "邮箱错误";
    public static final String ARTICLE_INEXISTENCE = "评论的文章不存在";
    public static final String NO_FILE = "没有发现文件";
    public static final String NOT_PICTURE = "上传的文件格式不正确";

    public static final String LOGIN_SUCCESS = "登录成功";
    public static final String ACCOUNT_ERROR = "账号错误";
    public static final String PASSWORD_ERROR = "密码错误";
    public static final String PLEASE_LOGIN = "请登录";
    public static final String LOGOUT = "退出登录";

    public static final Integer PAGE_SIZE = 10;

}
