package com.ypl.test.common.util.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.security.Principal;

/**
 * @Author: YK
 * @Version V1.0
 * @Description
 * @Date: 2020/5/20 9:48
 */
public class UserUtil {

    /**
     * 获取当前登录者对象
     */
    public static Principal getPrincipal(){
        try{
            Subject subject = SecurityUtils.getSubject();
            Principal principal = (Principal)subject.getPrincipal();
            if (principal != null){
                return principal;
            }
        }catch (UnavailableSecurityManagerException e) {

        }catch (InvalidSessionException e){

        }
        return null;
    }

    /**
     * 切换身份登录
     * @param newPrincipal
     */
    public static void runAs(Principal newPrincipal){
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        // 切换身份登录
        subject.runAs(new SimplePrincipalCollection(newPrincipal, realmName));
    }


    /**
     * 获取当前用户
     * @return 取不到返回 new User()
     */
//    public static UpmsUser getUser(){
//        try {
//            PrincipalCollection principals = getSubject().getPrincipals();
//            if(principals != null){
//                UpmsUser upmsUser = (UpmsUser) principals.getPrimaryPrincipal();
//                return upmsUser;
//            }else{
//                return null;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 获取授权主要对象
     */
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static Session getSession(){
        try{
            Session session = getSubject().getSession();
            if (session == null){
                session = getSubject().getSession();
            }
            if (session != null){
                return session;
            }
        }catch (InvalidSessionException e){

        }
        return null;
    }

}
