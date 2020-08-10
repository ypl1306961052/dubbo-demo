package com.ypl.test.common.util.util;

/**
 * @Author: YK
 * @Version V1.0
 * @Description
 * @Date: 2020/6/3 14:04
 */
public enum RoleUtil {
    //专员
    commissioner("专员"),
    //参审
    otherReview("otherReview"),
    //主审
    mainReview("mainReview");

    private String role;
    private RoleUtil(String role){
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public static RoleUtil getRoleInfo(String role){
        for(RoleUtil obj : RoleUtil.values()){
            if(obj.getRole().equals(role)){
                return obj;
            }
        }
        return null;
    }
}
