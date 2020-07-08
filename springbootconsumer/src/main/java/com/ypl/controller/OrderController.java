package com.ypl.controller;
/*
作者：yangp
创建时间：2020/7/1-17:35-2020
*/


import com.alibaba.dubbo.config.annotation.Reference;
import com.ypl.Result;
import com.ypl.User;
import com.ypl.UserService;
import com.ypl.UserServiceAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: OrderController
 * @Package com.ypl.controller
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/1 17:35
 */

@RestController
@RequestMapping("/order")
public class OrderController {
    @Reference(stub = "com.ypl.stub.UserServiceStub")
    UserService userService;
    @Reference(async = true, interfaceClass = UserServiceAsync.class, timeout = 10000)
    UserServiceAsync userServiceAsync;

    @GetMapping("/getUser")
    public Result<User> getUser(@RequestParam("userId") int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/getUserAsync")
    public Result<User> getUserAsync(@RequestParam("userId") int userId) {
        Result<User> result = null;
        CompletableFuture<Result<User>> userAsync = userServiceAsync.getUserAsync(userId);
        userAsync.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println(v);
            }


        });
        return null;
    }
}
