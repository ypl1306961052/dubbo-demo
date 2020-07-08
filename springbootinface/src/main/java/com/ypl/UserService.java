package com.ypl;
/*
作者：yangp
创建时间：2020/6/30-17:39-2020
*/


import java.util.List;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: UserService
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/6/30 17:39
 */


public interface UserService {
    Result<User> getUserById(int userId);
    Result<Void> deleteUserById(int userId);
}
