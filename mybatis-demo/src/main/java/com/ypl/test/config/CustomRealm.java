package com.ypl.test.config;
/*
作者：yangp
创建时间：2020/7/8-11:26-2020
*/


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ypl.test.entity.UpmsPermission;
import com.ypl.test.entity.UpmsRole;
import com.ypl.test.entity.UpmsUser;
import com.ypl.test.entity.UpmsUserRole;
import com.ypl.test.service.IUpmsPermissionService;
import com.ypl.test.service.IUpmsRoleService;
import com.ypl.test.service.IUpmsUserRoleService;
import com.ypl.test.service.IUpmsUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: CustomRealm
 * @Package com.ypl.test.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/8 11:26
 */

@Configuration
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    IUpmsRoleService roleService;
    @Autowired
    IUpmsPermissionService permissionService;
    @Autowired
    IUpmsUserService userService;

    /**
     * 获取权限信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name = (String) principalCollection.getPrimaryPrincipal();
        UpmsUser user = userService.queryUserByUserName(name);
        if (user == null) {
            return null;
        }
        List<UpmsRole> upmsRoles = roleService.queryRolesByUserId(Long.valueOf(user.getUserId()));
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(upmsRoles.stream().map(UpmsRole::getName).collect(Collectors.toSet()));
        List<UpmsPermission> upmsPermissions = permissionService.queryPermissionByUserId(Long.valueOf(user.getUserId()));
        authorizationInfo.setStringPermissions(upmsPermissions.stream().map(UpmsPermission::getUri).collect(Collectors.toSet()));
        return authorizationInfo;
    }

    /**
     * |
     * 获取身份信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName= (String) authenticationToken.getPrincipal();

        UpmsUser upmsUser = userService.queryUserByUserName(userName);

        if(upmsUser==null){
            throw new UnknownAccountException("账户不能存在");
        }
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(userName,upmsUser.getPassword(),getName());


        return authenticationInfo;
    }
}
