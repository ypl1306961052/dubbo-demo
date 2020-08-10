package com.ypl.service;

import com.ypl.entity.UpmsRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author ypl
 * @since 2020-07-31
 */
public interface IUpmsRoleService extends IService<UpmsRole> {
    public List<UpmsRole> queryRoleByUser(Long userId);
}
