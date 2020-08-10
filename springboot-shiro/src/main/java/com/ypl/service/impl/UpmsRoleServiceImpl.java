package com.ypl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.ypl.entity.UpmsRole;
import com.ypl.entity.UpmsUserRole;
import com.ypl.mapper.UpmsRoleMapper;
import com.ypl.service.IUpmsRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypl.service.IUpmsUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author ypl
 * @since 2020-07-31
 */
@Service
public class UpmsRoleServiceImpl extends ServiceImpl<UpmsRoleMapper, UpmsRole> implements IUpmsRoleService {

    @Autowired
    IUpmsUserRoleService iUpmsUserRoleService;
    @Override
    public List<UpmsRole> queryRoleByUser(Long userId) {
        QueryWrapper<UpmsUserRole> wrapper=new QueryWrapper<>();

         wrapper.ge("user_id", userId);
        List<UpmsUserRole> urList = iUpmsUserRoleService.list(wrapper);
        List<Integer> roleIds = urList.stream().map(UpmsUserRole::getRoleId).collect(Collectors.toList());
        QueryWrapper<UpmsRole> roleQueryWrapper=new QueryWrapper<>();
       roleQueryWrapper.in("role_id", roleIds);
        return this.list(roleQueryWrapper);
    }
}
