package com.ypl.biz;
/*
作者：yangp
创建时间：2020/7/2-9:32-2020
*/


import com.alibaba.dubbo.config.annotation.Service;
import com.ypl.Result;
import com.ypl.User;
import com.ypl.UserService;
import com.ypl.UserServiceAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: UserServiceAsuncImpl
 * @Package com.ypl.biz
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/2 9:32
 */

@Service(async = true,interfaceClass = UserServiceAsync.class)
@Component
public class UserServiceAsyncImpl implements UserServiceAsync {
    @Autowired
    UserService userService;

    @Override
    public CompletableFuture<Result<User>> getUserAsync(int userId) {
        System.out.println("dubbo操作线程:"+Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("异步操作线程:"+Thread.currentThread().getName());
            System.out.println("异步操作");
            return userService.getUserById(userId);
        });
    }
}
