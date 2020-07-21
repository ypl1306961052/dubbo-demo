package com.ypl.test.mysql.util;

import com.ypl.test.entity.UpmsUser;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/*
作者：yangp
创建时间：2020/7/21-16:14-2020
*/

public class MapUtilTest {

    @Test
    public void objectConvertMap() {
        UpmsUser upmsUser=new UpmsUser();
        upmsUser.setSex(2);
        upmsUser.setUsername("ypl");
        Map<String, Object> map = MapUtil.objectConvertMap(upmsUser);
        System.out.println(map);
    }
}