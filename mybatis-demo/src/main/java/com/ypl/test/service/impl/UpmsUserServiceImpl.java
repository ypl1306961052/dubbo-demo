package com.ypl.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypl.test.entity.UpmsUser;
import com.ypl.test.mapper.UpmsUserMapper;
import com.ypl.test.service.IUpmsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
@Service
public class UpmsUserServiceImpl extends ServiceImpl<UpmsUserMapper, UpmsUser> implements IUpmsUserService {
    @Override
    public UpmsUser queryUserByUserName(String name) {
        QueryWrapper<UpmsUser> upmsUserRoleQueryWrapper = new QueryWrapper<>();
        upmsUserRoleQueryWrapper.eq("username", name);
        return getOne(upmsUserRoleQueryWrapper);
    }
}
