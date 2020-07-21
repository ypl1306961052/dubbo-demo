package com.ypl.test.explan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.*;

/*
作者：yangp
创建时间：2020/7/20-17:22-2020
*/

@RunWith(JUnit4.class)
public class YplSqlSessionTest {

    @Test
    public void selectList() {
        YplExecutor yplExecutor=new YplExecutor();
        YplSqlSession yplSqlSession=new YplSqlSession(yplExecutor);
        List<Object> objects = yplSqlSession.selectList("select * from upms_user order by user_id desc limit 0,10");
        System.out.println(objects);
    }
}
