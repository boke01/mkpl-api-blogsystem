package com.newegg.mkpl.api.blogsystem.controller;

import com.newegg.mkpl.api.blogsystem.enums.StateEnum;
import com.newegg.mkpl.api.blogsystem.pojo.Pack;
import com.newegg.mkpl.api.blogsystem.util.Md5Util;
import com.newegg.mkpl.api.blogsystem.util.PoolStatic;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 登录相关的api
 *
 * @author vz04
 * @date 8/10/2019 1:03 PM
 * access-allow-control-credentials
 **/
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/manage")
public class LoginController {

    /**
     * 登录
     *
     * @param map 字段：account password
     * @return Pack
     * @date 2:51 PM 8/10/2019
     */
    @PostMapping("/login")
    public Pack login(@RequestBody Map<String, String> map) {
        Subject subject = SecurityUtils.getSubject();
        String password = Md5Util.md5Encode(map.get("password"));
        UsernamePasswordToken token = new UsernamePasswordToken(map.get("account"), password);
        try {
            subject.login(token);
            return new Pack().success(PoolStatic.LOGIN_SUCCESS);
        } catch (UnknownAccountException e) {
            return new Pack().fail(StateEnum.FAIL.value(), PoolStatic.ACCOUNT_ERROR);
        } catch (IncorrectCredentialsException e) {
            return new Pack().fail(StateEnum.FAIL.value(), PoolStatic.PASSWORD_ERROR);
        }
    }

    /**
     * 退出登录
     *
     * @return Pack
     * @date 4:25 PM 8/10/2019
     */
    @PostMapping("/logout")
    public Pack logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Pack().success(PoolStatic.LOGOUT);
    }


}
