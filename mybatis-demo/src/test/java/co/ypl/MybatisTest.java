package co.ypl;
/*
作者：yangp
创建时间：2020/7/15-17:07-2020
*/


import com.github.pagehelper.PageHelper;
import com.ypl.test.common.util.MybatisUtil;
import com.ypl.test.entity.UpmsUser;
import com.ypl.test.mapper.UpmsUserMapper;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.apache.tomcat.jni.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: MybatisTest
 * @Package co.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/15 17:07
 */


public class MybatisTest {
    @Test
    public void Mybatis() throws IOException {
        SqlSession sqlSession = MybatisUtil.sqlSession(true);
//        UpmsUserMapper upmsUserMapper = sqlSession.getMapper(UpmsUserMapper.class);
//        List<UpmsUser> upmsUsers = upmsUserMapper.selectUsers();
//        System.out.println(upmsUsers);
        RowBounds rowBounds=new RowBounds(0,1);
//        PageHelper.offsetPage(0,10);
//        List<UpmsUser> upmsUser = sqlSession.selectList("com.ypl.test.mapper.UpmsUserMapper.selectUsers",null,rowBounds);
        UpmsUserMapper mapper = sqlSession.getMapper(UpmsUserMapper.class);
        List<UpmsUser> upmsUsers = mapper.selectUsers(rowBounds);
//        System.out.println(upmsUser);
        List<Object> objects = sqlSession.selectList("select * fom", "", User);

        System.out.println(upmsUsers);
    }
}
