package com.ypl.test.mysql;

import com.ypl.test.entity.UpmsUser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/*
作者：yangp
创建时间：2020/7/21-14:13-2020
*/

public class DefaultParamConvertTest {
    DefaultParamConvert defaultParamConvert;

    @Before
    public void before() {
        defaultParamConvert = new DefaultParamConvert();
    }

    @Test
    public void convertMap() {

        String sql = "select * from ums_user where user_id=#{userId},sex=#{sex},password=#{sex}";
        Map<String,Object> params=new HashMap<>();
        params.put("userId",10);
        params.put("sex","男");
        params.put("password","123456");
        SqlConvertResult sqlConvertResult = defaultParamConvert.convertSql(sql, params);
        System.out.println(sqlConvertResult.getParams());
        System.out.println(sqlConvertResult.getSql());
    }

    @Test
    public void convertList() {
        String sql = "select * from ums_user where user_id=#{userId},sex=#{sex},password=#{sex}";
        List<Object> params=new ArrayList<>();
        params.add(10);
        params.add("男");
        params.add("123456");
        SqlConvertResult sqlConvertResult = defaultParamConvert.convertSql(sql, params);
        System.out.println(sqlConvertResult.getParams());
        System.out.println(sqlConvertResult.getSql());
    }

    @Test
    public void convertObject() {
        String sql = "select * from ums_user where user_id=#{userId},sex=#{sex},password=#{sex}";
        UpmsUser upmsUser=new UpmsUser();
        upmsUser.setUserId(10);
        upmsUser.setUsername("ypl");
        SqlConvertResult sqlConvertResult = defaultParamConvert.convertSql(sql, upmsUser);
        System.out.println(sqlConvertResult.getParams());
        System.out.println(sqlConvertResult.getSql());
    }
}