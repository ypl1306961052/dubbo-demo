package com.ypl.test.service;

import com.ypl.test.entity.UpmsRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
public interface IUpmsRoleService extends IService<UpmsRole> {
    List<UpmsRole> queryRolesByUserId(Long userId);
}
