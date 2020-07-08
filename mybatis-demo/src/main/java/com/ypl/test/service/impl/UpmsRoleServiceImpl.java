package com.ypl.test.service.impl;

import com.ypl.test.entity.UpmsRole;
import com.ypl.test.mapper.UpmsRoleMapper;
import com.ypl.test.service.IUpmsRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
@Service
public class UpmsRoleServiceImpl extends ServiceImpl<UpmsRoleMapper, UpmsRole> implements IUpmsRoleService {

    @Override
    public List<UpmsRole> queryRolesByUserId(Long userId) {

        return this.baseMapper.queryRolesByUserId(userId);
    }
}
