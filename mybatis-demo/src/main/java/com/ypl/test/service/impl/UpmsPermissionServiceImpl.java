package com.ypl.test.service.impl;

import com.ypl.test.entity.UpmsPermission;
import com.ypl.test.mapper.UpmsPermissionMapper;
import com.ypl.test.service.IUpmsPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
@Service
public class UpmsPermissionServiceImpl extends ServiceImpl<UpmsPermissionMapper, UpmsPermission> implements IUpmsPermissionService {

    @Override
    public List<UpmsPermission> queryPermissionByUserId(Long userId) {
        return this.baseMapper.queryPermissionByUserId(userId);
    }
}
