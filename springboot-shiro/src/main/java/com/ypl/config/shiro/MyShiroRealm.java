package com.ypl.config.shiro;
/*
作者：yangp
创建时间：2020/7/31-15:15-2020
*/


import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;
import com.ypl.entity.UpmsUser;
import com.ypl.service.IUpmsUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: MyShiroRealm
 * @Package com.ypl.config.shiro
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/31 15:15
 */

@Component
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    IUpmsUserService iUpmsUserService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String name = (String) principalCollection.getPrimaryPrincipal();


        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {

        Object principal = authenticationToken.getPrincipal();
        if(principal==null){
            return  null;
        }
        String name = authenticationToken.getPrincipal().toString();
        QueryChainWrapper<UpmsUser> userQueryWrapper = iUpmsUserService.query().ge("name", name);
        UpmsUser user = iUpmsUserService.getOne(userQueryWrapper);
        if(user==null){
            return null;
        }else {
            return new SimpleAuthenticationInfo(name,user.getPassword(),getName());
        }
    }
}
