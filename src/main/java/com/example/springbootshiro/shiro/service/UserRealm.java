package com.example.springbootshiro.shiro.service;


import com.example.springbootshiro.base.service.UserService;
import com.example.springbootshiro.shiro.domain.SysPermission;
import com.example.springbootshiro.shiro.domain.SysRole;
import com.example.springbootshiro.shiro.domain.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author carzy
 * @date 2018/08/03
 */
@Component
public class UserRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principalCollection.getPrimaryPrincipal();
        for(SysRole role:userInfo.getRoles()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p: role.getPermissions()){
                authorizationInfo.addStringPermission(p.getName());
            }
        }
        return authorizationInfo;
    }

    /**
     *  主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginName = (String) authenticationToken.getPrincipal();
        // 获取用户密码
        UserInfo user = this.userService.findUserByName(loginName);
        if (user == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", user);
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                //ByteSource.Util.bytes("salt"), salt=username+salt,采用明文访问时，不需要此句
                this.getName()
        );
        return authenticationInfo;
    }
}
