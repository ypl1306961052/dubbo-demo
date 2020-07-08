package com.ypl.test.service;

import com.ypl.test.entity.UpmsUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
public interface IUpmsUserService extends IService<UpmsUser> {
     UpmsUser queryUserByUserName(String name);


}
