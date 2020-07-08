package com.ypl.test.mapper;

import com.ypl.test.entity.UpmsRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
public interface UpmsRoleMapper extends BaseMapper<UpmsRole> {
    List<UpmsRole> queryRolesByUserId(Long userId);

}
