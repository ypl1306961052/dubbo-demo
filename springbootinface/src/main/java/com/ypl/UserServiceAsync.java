package com.ypl;
/*
作者：yangp
创建时间：2020/7/1-18:08-2020
*/


import java.util.concurrent.CompletableFuture;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: UserServiceAysn
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/1 18:08
 */


public interface UserServiceAsync {
    CompletableFuture<Result<User>> getUserAsync(int userId);
}
