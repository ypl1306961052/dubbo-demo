package com.ypl.test.service;

import com.ypl.test.entity.UpmsPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
public interface IUpmsPermissionService extends IService<UpmsPermission> {
    List<UpmsPermission> queryPermissionByUserId(Long userId);
}
