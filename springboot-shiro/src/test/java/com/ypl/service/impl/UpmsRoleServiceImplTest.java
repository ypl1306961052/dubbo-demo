package com.ypl.service.impl;

import com.ypl.entity.UpmsRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/*
作者：yangp
创建时间：2020/7/31-15:35-2020
*/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UpmsRoleServiceImplTest {
@Autowired
    UpmsRoleServiceImpl upmsRoleService;
    @Test
    public void queryRoleByUser() {
        List<UpmsRole> upmsRoles = upmsRoleService.queryRoleByUser(-1L);
        assertEquals(0, upmsRoles.size());
    }
}