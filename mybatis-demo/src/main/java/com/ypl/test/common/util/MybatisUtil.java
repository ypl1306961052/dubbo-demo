package com.ypl.test.common.util;
/*
作者：yangp
创建时间：2020/7/15-17:19-2020
*/


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: MybatisUtil
 * @Package com.ypl.test.common.util
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/15 17:19
 */


public class MybatisUtil {
    public static SqlSession sqlSession(boolean isCommit) {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory(null);
        return sqlSessionFactory.openSession(isCommit);
    }

    public static SqlSessionFactory sqlSessionFactory(String env) {
        InputStream inputStream = null;
        SqlSessionFactory factory = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            if (StringUtils.isEmpty(env)) {

                factory = sqlSessionFactoryBuilder.build(inputStream);
            } else {
                factory = sqlSessionFactoryBuilder.build(inputStream, env);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return factory;
    }
}
