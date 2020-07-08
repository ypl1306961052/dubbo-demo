package com.ypl.biz;
/*
作者：yangp
创建时间：2020/7/1-9:23-2020
*/


import com.alibaba.dubbo.config.annotation.Service;
import com.ypl.Result;
import com.ypl.User;
import com.ypl.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: UserServiceImpl
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/1 9:23
 */

@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList<>();

    static {
        for (int i = 10; i < 100; i++) {
            users.add(new User(i+"" , i));

        }
    }

    @Override
    public Result<User> getUserById(int userId) {

        return new Result<User>(0,"",findUserById(userId));

    }
    public User findUserById(int userId){
        for (User user : users) {
            if(user.getId()==userId){
                return user;
            }
        }
        return null;
    }

    @Override
    public Result<Void> deleteUserById(int userId) {
        return null;
    }
}
