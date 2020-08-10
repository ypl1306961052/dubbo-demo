package com.ypl.service.impl;

import com.ypl.entity.UpmsUser;
import com.ypl.mapper.UpmsUserMapper;
import com.ypl.service.IUpmsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author ypl
 * @since 2020-07-31
 */
@Service
public class UpmsUserServiceImpl extends ServiceImpl<UpmsUserMapper, UpmsUser> implements IUpmsUserService {

}
