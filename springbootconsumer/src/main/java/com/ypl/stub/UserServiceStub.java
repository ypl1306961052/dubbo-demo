package com.ypl.stub;
/*
作者：yangp
创建时间：2020/7/1-17:39-2020
*/


import com.ypl.Result;
import com.ypl.User;
import com.ypl.UserService;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: UserServiceStub
 * @Package com.ypl.stub
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/1 17:39
 */


public class UserServiceStub implements UserService {

    private final UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Result<User> getUserById(int userId) {
        if(userId<0){
            return null;
        }
        return userService.getUserById(userId);
    }

    @Override
    public Result<Void> deleteUserById(int userId) {
        return null;
    }
}
