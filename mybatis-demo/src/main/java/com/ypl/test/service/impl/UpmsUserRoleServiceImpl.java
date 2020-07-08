package com.ypl.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypl.test.entity.UpmsUser;
import com.ypl.test.entity.UpmsUserRole;
import com.ypl.test.mapper.UpmsUserRoleMapper;
import com.ypl.test.service.IUpmsUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
@Service
public class UpmsUserRoleServiceImpl extends ServiceImpl<UpmsUserRoleMapper, UpmsUserRole> implements IUpmsUserRoleService {


}
