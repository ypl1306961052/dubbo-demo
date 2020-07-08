package com.ypl.test.mapper;

import com.ypl.test.entity.UpmsPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
public interface UpmsPermissionMapper extends BaseMapper<UpmsPermission> {

    List<UpmsPermission> queryPermissionByUserId(Long userId);

}
