package com.ypl.service;
/*
作者：yangp
创建时间：2020/7/1-17:33-2020
*/


import com.alibaba.dubbo.config.annotation.Reference;
import com.ypl.Result;
import com.ypl.User;
import com.ypl.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: OrderService
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/1 17:33
 */

@Service
public class OrderService {
    @Reference
    UserService userService;
    public void order(int userId){
        Result<User> userById = userService.getUserById(userId);
    }

}
