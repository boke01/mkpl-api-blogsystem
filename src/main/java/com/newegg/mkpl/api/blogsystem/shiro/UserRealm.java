package com.newegg.mkpl.api.blogsystem.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Value;

/**
 * 自定义验证Realm
 *
 * @author vz04
 * @date 8/10/2019 12:32 PM
 **/

public class UserRealm extends AuthorizingRealm {
    @Value("${user.account}")
    String userAccount;

    @Value("${user.password}")
    String userPassword;

    /**
     * 授权逻辑
     *
     * @param principalCollection PrincipalCollection
     * @return AuthorizationInfo
     * @date 12:34 PM 8/10/2019
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证逻辑
     *
     * @param authenticationToken AuthenticationToken
     * @return AuthenticationInfo
     * @date 12:33 PM 8/10/2019
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if (token.getUsername() == null || !token.getUsername().equals(userAccount)) {
            return null;
        }
        return new SimpleAuthenticationInfo("", userPassword, "");
    }
}
